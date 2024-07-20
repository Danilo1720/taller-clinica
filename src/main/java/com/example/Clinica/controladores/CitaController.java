package com.example.Clinica.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Clinica.clases.Cita;
import com.example.Clinica.clases.Doctor;
import com.example.Clinica.clases.DoctorDTO;
import com.example.Clinica.clases.Especialidad;
import com.example.Clinica.clases.EspecialidadDTO;
import com.example.Clinica.clases.Horario;
import com.example.Clinica.clases.HorarioDTO;
import com.example.Clinica.clases.Paciente;
import com.example.Clinica.clases.Sede;
import com.example.Clinica.clases.SedeDTO;
import com.example.Clinica.clases.Usuario;
import com.example.Clinica.servicios.impl.CitaServiceImpl;
import com.example.Clinica.servicios.impl.DoctorServiceImpl;
import com.example.Clinica.servicios.impl.EspecialidadServiceImpl;
import com.example.Clinica.servicios.impl.HorarioServiceImpl;
import com.example.Clinica.servicios.impl.PacienteServiceImpl;
import com.example.Clinica.servicios.impl.SedeServiceImpl;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CitaController {

    @Autowired
    private SedeServiceImpl sedeServiceImpl;

    @Autowired
    private EspecialidadServiceImpl especialidadServiceImpl;

    @Autowired
    private DoctorServiceImpl doctorServiceImpl;

     @Autowired
    private HorarioServiceImpl horarioServiceImpl;

    @Autowired
    private CitaServiceImpl citaServiceImpl;

    @Autowired
    private PacienteServiceImpl pacienteServiceImpl;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("sedes", sedeServiceImpl.getAllSedes());
        model.addAttribute("especialidades", especialidadServiceImpl.getAllEspecialidades());
        return "index";
    }

    @GetMapping("/cita")
    public String showCitaPage(@RequestParam("sede") Long sedeId,
                               @RequestParam("especialidad") Long especialidadId,
                               Model model, HttpSession session) {
        Usuario loggedInUser = (Usuario) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        Sede sede = sedeServiceImpl.getSedeById(sedeId);
        Especialidad especialidad = especialidadServiceImpl.getEspecialidadById(especialidadId);
        List<Sede> sedes = sedeServiceImpl.getAllSedes();
        List<Especialidad> especialidades = especialidadServiceImpl.getAllEspecialidades();
                                
        model.addAttribute("sede", sede);
        model.addAttribute("especialidad", especialidad);
        model.addAttribute("sedes", sedes);
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("selectedSedeId", sedeId);
        model.addAttribute("selectedEspecialidadId", especialidadId);
        
        return "paciente/cita"; // nombre de tu archivo HTML de la página de cita
    }

    @GetMapping("/doctores")
    @ResponseBody
    public List<DoctorDTO> getDoctoresBySedeAndEspecialidad(@RequestParam Long sedeId, @RequestParam Long especialidadId) {
    List<Doctor> doctores = doctorServiceImpl.getDoctoresBySedeAndEspecialidad(sedeId, especialidadId);
    List<DoctorDTO> doctorDTOs = new ArrayList<>();

    for (Doctor doctor : doctores) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setDoctorId(doctor.getDoctorId());
        doctorDTO.setNombDoc(doctor.getNombDoc());

        // Crear SedeDTO y EspecialidadDTO
        SedeDTO sedeDTO = new SedeDTO();
        sedeDTO.setSedeId(doctor.getSede().getSedeId());
        sedeDTO.setNombSede(doctor.getSede().getNombSede());

        EspecialidadDTO especialidadDTO = new EspecialidadDTO();
        especialidadDTO.setEspecialidadId(doctor.getEspecialidad().getEspecialidadId());
        especialidadDTO.setNombEspe(doctor.getEspecialidad().getNombEspe());

        doctorDTO.setSede(sedeDTO);
        doctorDTO.setEspecialidad(especialidadDTO);

        // Asignar los horarios como HorarioDTOs (deberás ajustar esto según tus modelos)
        List<HorarioDTO> horariosDTO = doctor.getHorarios().stream()
                .map(horario -> new HorarioDTO(horario.getIdHora(), horario.getDisponible(), horario.getFechaHora()))
                .collect(Collectors.toList());

        doctorDTO.setHorarios(horariosDTO);
        doctorDTOs.add(doctorDTO);
    }

    return doctorDTOs;
}

    @GetMapping("/horarios")
    @ResponseBody
    public Map<String, List<HorarioDTO>> getHorarios(@RequestParam Long doctorId) {
        List<Horario> horarios = horarioServiceImpl.getHorariosByDoctorId(doctorId);
        return horarios.stream()
                .map(horario -> new HorarioDTO(horario.getIdHora(), horario.getDisponible(), horario.getFechaHora()))
                .collect(Collectors.groupingBy(horarioDTO -> horarioDTO.getFechaHora().toLocalDate().toString()));
    }

    @PostMapping("/cita/reservar")
    @ResponseBody
    public ResponseEntity<String> reservarCita(@RequestParam Long idHora, HttpSession session) {
        try {
            Usuario loggedInUser = (Usuario) session.getAttribute("loggedInUser");
            if (loggedInUser == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No está autorizado");
            }

            Paciente paciente = pacienteServiceImpl.findByUsuario(loggedInUser);
            Horario horario = horarioServiceImpl.findHorarioById(idHora);

            if (paciente != null && horario != null) {
                Cita cita = new Cita();
                cita.setPaciente(paciente);
                cita.setHorario(horario);
                citaServiceImpl.save(cita);

                // Actualizar el estado del horario a no disponible
                horario.setDisponible(false);
                horarioServiceImpl.saveHorario(horario);
                return ResponseEntity.ok("Cita reservada exitosamente");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de cita inválidos");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al reservar cita");
        }
    }

    @GetMapping("/cita/confirmacion")
    public String confirmacionCita(Model model) {
        model.addAttribute("message", "La cita ha sido reservada exitosamente.");
        return "paciente/confirmacion";
    }

    @GetMapping("/reservas")
    public String verReservaciones(Model model){
        
        return "paciente/reservas";
    }

    @GetMapping("/listar")
    @ResponseBody
    public Map<String, Object> listar(HttpSession session) {
        Usuario loggedInUser = (Usuario) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return new HashMap<>(); // No está autenticado
        }

        String correo = loggedInUser.getCorreoUsu();
        List<Cita> citas = citaServiceImpl.obtenerCitasPorCorreoPaciente(correo);
        List<Map<String, Object>> citasDTO = citas.stream().map(cita -> {
            Map<String, Object> citaMap = new HashMap<>();
            citaMap.put("fecha", cita.getHorario().getFechaHora().toLocalDate());
            citaMap.put("hora", cita.getHorario().getFechaHora().toLocalTime());
            citaMap.put("doctor", cita.getHorario().getDoctor().getNombDoc());
            citaMap.put("sede", cita.getHorario().getDoctor().getSede().getNombSede());
            citaMap.put("especialidad", cita.getHorario().getDoctor().getEspecialidad().getNombEspe());
            return citaMap;
        }).collect(Collectors.toList());
    
        Map<String, Object> response = new HashMap<>();
        response.put("data", citasDTO);
        return response;
    }

}