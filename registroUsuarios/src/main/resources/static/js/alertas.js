// alertas.js
window.RegistroAlertas = {
    registroExitoso: function() {
        Swal.fire({
            title: '¡Registro Exitoso!',
            text: 'El usuario ha sido registrado correctamente.',
            icon: 'success',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#007bff' // Color del botón "Aceptar"
        }).then((result) => {
            if (result.isConfirmed) {
                console.log("Redirigiendo a /usuarios");
                window.location.href = '/usuarios';
            }
        });
    },
    actualizacionExitosa: function() {
        Swal.fire({
            title: '¡Actualización Exitosa!',
            text: 'El usuario ha sido actualizado correctamente.',
            icon: 'success',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#007bff' // Color del botón "Aceptar"
        }).then((result) => {
            if (result.isConfirmed) {
                console.log("Redirigiendo a /usuarios");
                window.location.href = '/usuarios';
            }
        });
    },
    confirmarEliminacion: function(userId, callback) {
        Swal.fire({
            title: '¿Estás seguro?',
            text: 'Esta acción no se puede deshacer.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                callback(userId); // Llama a la función de eliminación pasando el ID del usuario
            }
        });
    },
    eliminacionExitosa: function() {
        Swal.fire({
            title: '¡Eliminación Exitosa!',
            text: 'El usuario ha sido eliminado correctamente.',
            icon: 'success',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#007bff' // Color del botón "Aceptar"
        }).then((result) => {
            if (result.isConfirmed) {
                console.log("Redirigiendo a /usuarios");
                window.location.href = '/usuarios';
            }
        });
    }


};
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const password = document.getElementById("contrasena");
    const confirmPassword = document.getElementById("confirmarContrasena");
    const errorConfirmacion = document.getElementById("errorConfirmacion");

    form.addEventListener("submit", function (event) {
        if (password.value !== confirmPassword.value) {
            event.preventDefault(); // Evita que se envíe el formulario
            errorConfirmacion.textContent = "Las contraseñas no coinciden.";
            errorConfirmacion.style.color = "red";

            // Muestra una alerta con SweetAlert2
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "Las contraseñas no coinciden.",
                confirmButtonColor: "#d33"
            });
        } else {
            errorConfirmacion.textContent = ""; // Limpia el mensaje si las contraseñas coinciden
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const password = document.getElementById("contrasena");
    const confirmPassword = document.getElementById("confirmarContrasena");
    const errorConfirmacion = document.getElementById("errorConfirmacion");

    form.addEventListener("submit", function (event) {
        if (password.value !== confirmPassword.value) {
            event.preventDefault(); // Detiene el envío
            errorConfirmacion.textContent = "Las contraseñas no coinciden.";
            errorConfirmacion.style.color = "red";

            // Alerta con SweetAlert2
            Swal.fire({
                icon: "error",
                title: "Error",
                text: "Las contraseñas no coinciden.",
                confirmButtonColor: "#d33"
            });
        } else {
            errorConfirmacion.textContent = ""; // Limpia el mensaje si las contraseñas coinciden
        }
    });
});

