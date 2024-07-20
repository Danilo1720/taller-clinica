package com.example.Clinica.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.Clinica.clases.Paciente;
import com.example.Clinica.clases.Usuario;
import com.example.Clinica.servicios.impl.PacienteServiceImpl;
import com.example.Clinica.servicios.impl.UsuarioServiceImpl;

import jakarta.servlet.http.HttpSession;



@Controller
public class AuthController {

    @Autowired
    private PacienteServiceImpl pacienteServiceImpl;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String correo, @RequestParam String password, HttpSession session) {
        Usuario usuario = usuarioServiceImpl.findByCorreo(correo);
        if (usuario != null && usuario.getContraUsu().equals(password)) {
            Paciente paciente = pacienteServiceImpl.findByUsuario(usuario);
            session.setAttribute("loggedInUser", usuario);
            session.setAttribute("loggedInPaciente", paciente);
            return "redirect:/cita?sede=1&especialidad=1";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String nombres, @RequestParam String apellidos, @RequestParam String correo,
                           @RequestParam String telefono, @RequestParam String fechaNacimiento, @RequestParam String password) {
        Usuario usuario = new Usuario();
        usuario.setCorreoUsu(correo);
        usuario.setContraUsu(password);
        usuario.setDescripUsu("Paciente");

        Paciente paciente = new Paciente();
        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        paciente.setCorreo(correo);
        paciente.setTelefono(telefono);
        paciente.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
        paciente.setUsuario(usuario);

        usuarioServiceImpl.save(usuario);
        pacienteServiceImpl.save(paciente);

        return "redirect:/login?registered";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}