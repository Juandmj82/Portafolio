// Función para confirmar eliminación con SweetAlert2
function confirmarEliminacion(event) {
    event.preventDefault(); // Evita el envío inmediato del formulario

    Swal.fire({
        title: "¿Estás seguro?",
        text: "Esta acción no se puede deshacer",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#3085d6",
        confirmButtonText: "Sí, eliminar",
        cancelButtonText: "Cancelar"
    }).then((result) => {
        if (result.isConfirmed) {
            event.target.submit(); // Solo envía el formulario si el usuario confirma
        }
    });

    return false;
}

// Muestra alertas de éxito si hay un mensaje de éxito en la página
document.addEventListener("DOMContentLoaded", function () {
    let successMessage = document.getElementById("successMessage");
    if (successMessage && successMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'success',
            title: 'Éxito',
            text: successMessage.value,
            confirmButtonColor: '#3085d6'
        });
    }
});

// Muestra alertas de error si hay un mensaje de error en la página
document.addEventListener("DOMContentLoaded", function () {
    let errorMessage = document.getElementById("errorMessage");
    if (errorMessage && errorMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'error',
            title: 'Error en el formulario',
            text: errorMessage.value,
            confirmButtonColor: '#d33'
        });

        // Resaltar los campos con errores
        let fields = JSON.parse(errorMessage.getAttribute("data-errors"));
        fields.forEach(id => {
            let fieldElement = document.getElementById(id);
            if (fieldElement) {
                fieldElement.classList.add("is-invalid");
            }
        });
    }
});

// Validación del formulario antes del envío
document.addEventListener("DOMContentLoaded", function () {
    let form = document.getElementById("productoForm");

    form.addEventListener("submit", function (event) {
        let isValid = true;

        // Función auxiliar para validar campos
        function validarCampo(input, condicion) {
            if (condicion) {
                input.classList.add("is-invalid");
                isValid = false;
            } else {
                input.classList.remove("is-invalid");
            }
        }

        // Validar nombre (mínimo 3 caracteres, máximo 20)
        let nameInput = document.getElementById("name");
        validarCampo(nameInput, nameInput.value.trim().length < 3 || nameInput.value.trim().length > 20);

        // Validar precio (debe ser mayor que 0 y no vacío)
        let precioInput = document.getElementById("precio");
        validarCampo(precioInput, precioInput.value.trim() === "" || parseFloat(precioInput.value) <= 0);

        // Validar stock (debe ser mayor o igual a 0 y no vacío)
        let stockInput = document.getElementById("stock");
        validarCampo(stockInput, stockInput.value.trim() === "" || parseInt(stockInput.value) < 0);

        // Si hay errores, evitar el envío del formulario
        if (!isValid) {
            event.preventDefault();
            Swal.fire({
                icon: 'error',
                title: 'Error en el formulario',
                text: 'Corrige los errores antes de continuar.',
                confirmButtonColor: '#d33'
            });
        }
    });
});
