// Función para mostrar alerta de acceso denegado
function accesoDenegado() {
    Swal.fire({
        icon: 'error',
        title: 'Acceso denegado',
        text: 'Requieres permisos de administrador para esta acción',
        confirmButtonColor: '#d33'
    });
}

// Función para confirmar eliminación
function confirmarEliminacion(event) {
    event.preventDefault();
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
            event.target.submit();
        }
    });
    return false;
}

// Validación del formulario de productos
function validarFormularioProducto() {
    const form = document.getElementById("productoForm");
    if (!form) return;

    let isValid = true;

    // Validar nombre (mínimo 3 caracteres)
    const nameInput = document.getElementById("name");
    if (nameInput && nameInput.value.trim().length < 3) {
        nameInput.classList.add("is-invalid");
        isValid = false;
    }

    // Validar precio (positivo)
    const precioInput = document.getElementById("precio");
    if (precioInput && (parseFloat(precioInput.value) <= 0 || isNaN(parseFloat(precioInput.value)))) {
        precioInput.classList.add("is-invalid");
        isValid = false;
    }

    // Validar stock (no negativo)
    const stockInput = document.getElementById("stock");
    if (stockInput && (parseInt(stockInput.value) < 0 || isNaN(parseInt(stockInput.value)))) {
        stockInput.classList.add("is-invalid");
        isValid = false;
    }

    return isValid;
}

// Muestra alertas al cargar la página
document.addEventListener("DOMContentLoaded", function () {
    // Mensaje de éxito
    let successMessage = document.getElementById("successMessage");
    if (successMessage && successMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'success',
            title: 'Éxito',
            text: successMessage.value,
            confirmButtonColor: '#3085d6'
        });
    }

    // Mensaje de error
    let errorMessage = document.getElementById("errorMessage");
    if (errorMessage && errorMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: errorMessage.value,
            confirmButtonColor: '#d33'
        });

        // Resaltar campos con errores si hay datos
        if (errorMessage.hasAttribute("data-errors")) {
            const errorFields = JSON.parse(errorMessage.getAttribute("data-errors"));
            errorFields.forEach(fieldId => {
                const field = document.getElementById(fieldId);
                if (field) field.classList.add("is-invalid");
            });
        }
    }

    // Configurar validación del formulario
    const form = document.getElementById("productoForm");
    if (form) {
        form.addEventListener("submit", function (event) {
            if (!validarFormularioProducto()) {
                event.preventDefault();
                Swal.fire({
                    icon: 'error',
                    title: 'Error en el formulario',
                    html: `
                        <div class="text-start">
                            <p>Por favor corrige los siguientes problemas:</p>
                            <ul>
                                <li>Nombre debe tener al menos 3 caracteres</li>
                                <li>Precio debe ser mayor a 0</li>
                                <li>Stock no puede ser negativo</li>
                            </ul>
                        </div>
                    `,
                    confirmButtonColor: '#d33'
                });
            }
        });

        // Limpiar validaciones al editar
        form.querySelectorAll("input").forEach(input => {
            input.addEventListener("input", function() {
                this.classList.remove("is-invalid");
            });
        });
    }
});