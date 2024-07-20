document.addEventListener('DOMContentLoaded', function() {
    var appointmentForm = document.getElementById('appointment-form');
    appointmentForm.addEventListener('submit', function(event) {
      event.preventDefault(); // Evitar el envío normal del formulario

      var sedeId = document.getElementById('sede').value;
      var especialidadId = document.getElementById('especialidad').value;

      var xhr = new XMLHttpRequest();
      xhr.open('GET', `/doctores?sedeId=${sedeId}&especialidadId=${especialidadId}`, true);
      xhr.setRequestHeader('Content-Type', 'application/json');

      xhr.onload = function() {
        if (xhr.status === 200) {
          var doctores = JSON.parse(xhr.responseText);
          var doctoresContainer = document.getElementById('doctores-container');
          doctoresContainer.innerHTML = ''; // Limpiar resultados anteriores

          doctores.forEach(function(doctor) {
            var doctorDiv = document.createElement('div');
            doctorDiv.className = 'col-md-12 col-lg-12';
            doctorDiv.innerHTML = `
              <div class="row">
                <div class="col-md-4 col-lg-4">
                  <div class="doctor-img-block">
                    <img src="images/team/${doctor.doctorId}.jpg" alt="" class="img-fluid w-80">
                    <h4 class="mt-4 mb-0"><a href="doctor-single.html">${doctor.nombDoc}</a></h4>
                    <p>${doctor.especialidad.nombEspe}</p>
                    <div class="divider my-4"></div>
                  </div>
                </div>
                <div class="col-md-8 col-lg-8">
                  <div class="horarios" id="horarios-${doctor.doctorId}"></div>
                </div>
              </div>
            `;
            doctoresContainer.appendChild(doctorDiv);

            var xhrHorarios = new XMLHttpRequest();
            xhrHorarios.open('GET', `/horarios?doctorId=${doctor.doctorId}`, true);
            xhrHorarios.onload = function() {
              if (xhrHorarios.status === 200) {
                var horariosGrouped = JSON.parse(xhrHorarios.responseText);
                var horariosDiv = document.getElementById(`horarios-${doctor.doctorId}`);

                var diasContainer = document.createElement('div');
                diasContainer.className = 'dias-container';

                for (var dia in horariosGrouped) {

                  var fecha = new Date(dia);
                  var diaButton = document.createElement('button');
                  diaButton.className = 'btn btn-round-full1';
                  diaButton.innerText = `${new Date(dia).toLocaleDateString('es-ES', { weekday: 'short', day: 'numeric', month: 'short' })}`;
                  diaButton.dataset.target = `horarios-${doctor.doctorId}-${dia}`;
                  diasContainer.appendChild(diaButton);

                  var diaDiv = document.createElement('div');
                  diaDiv.id = `horarios-${doctor.doctorId}-${dia}`;
                  diaDiv.className = 'horarios-dia';
                  diaDiv.style.display = 'none'; 

                  horariosGrouped[dia].forEach(function(horario) {
                    if (horario.disponible === true) { 
                var horarioButton = document.createElement('button');
                horarioButton.className = 'btn btn-round-full2';
                horarioButton.innerText = `${new Date(horario.fechaHora).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}`;
                horarioButton.addEventListener('click', function() {
                  showModal(doctor, horario);
                });
                diaDiv.appendChild(horarioButton);
              }
                  });

                  horariosDiv.appendChild(diaDiv);
                }

                horariosDiv.insertBefore(diasContainer, horariosDiv.firstChild); 

                var primerDia = Object.keys(horariosGrouped)[0];
                var primerDiaDiv = document.getElementById(`horarios-${doctor.doctorId}-${primerDia}`);
                if (primerDiaDiv) {
                  primerDiaDiv.style.display = 'block';
                  diasContainer.querySelector(`button[data-target="horarios-${doctor.doctorId}-${primerDia}"]`).classList.add('btn-selected');
                }

                // Agregar evento click para mostrar horarios por día
                diasContainer.addEventListener('click', function(e) {
                  if (e.target.tagName === 'BUTTON') {
                    var targetId = e.target.dataset.target;
                    var targetDia = document.getElementById(targetId);

                    // Ocultar todos los horarios
                    var allHorarios = horariosDiv.querySelectorAll('.horarios-dia');
                    allHorarios.forEach(function(horario) {
                      horario.style.display = 'none';
                    });

                    // Mostrar el horario del día seleccionado
                    targetDia.style.display = 'block';

                    var allButtons = diasContainer.querySelectorAll('button');
                    allButtons.forEach(function(button) {
                      button.classList.remove('btn-selected');
                    });

                    e.target.classList.add('btn-selected');
                  }
                });
              } else {
                console.error('Error al obtener horarios:', xhrHorarios.status, xhrHorarios.statusText);
              }
            };
            xhrHorarios.send();
          });

        } else {
          console.error('Error al obtener doctores:', xhr.status, xhr.statusText);
        }
      };

      xhr.send();
    });

    function showModal(doctor, horario) {
      var confirmButton = document.getElementById('confirmButton');
      var confirmModal = $('#confirmModal');
      
      confirmModal.modal('show');

      confirmButton.dataset.doctorId = doctor.doctorId;
      confirmButton.dataset.idHora = horario.idHora;


      confirmButton.onclick = function() {
        confirmModal.modal('hide');
        reservarCita(doctor, horario);
      };
    }

    function reservarCita(doctor, horario) {
      var doctorId = document.getElementById('confirmButton').dataset.doctorId;
      var idHora = document.getElementById('confirmButton').dataset.idHora;

      var xhr = new XMLHttpRequest();
      xhr.open('POST', '/cita/reservar', true);
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

      xhr.onload = function() {
        if (xhr.status === 200) {
          // Redirigir a la página de confirmación
          window.location.href = '/cita/confirmacion';
        } else {
          console.error('Error al reservar cita:', xhr.status, xhr.statusText);
        }
      };

      var data = `idHora=${idHora}&doctorId=${doctorId}`;

      xhr.send(data);
    }
  });