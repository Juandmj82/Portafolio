// Función para mostrar alerta de acceso denegado
function accesoDenegado() {
    Swal.fire({
        icon: 'error', // Icono de tipo error
        title: 'Acceso denegado', // Título del mensaje
        text: 'Requieres permisos de administrador para esta acción', // Texto del mensaje
        confirmButtonColor: '#d33' // Color del botón de confirmación
    });
}

// Función para confirmar eliminación
function confirmarEliminacion(event) {
    event.preventDefault(); // Evita que se envíe el formulario automáticamente
    Swal.fire({
        title: "¿Estás seguro?", // Título de la alerta
        text: "Esta acción no se puede deshacer", // Texto descriptivo
        icon: "warning", // Icono de advertencia
        showCancelButton: true, // Muestra el botón de cancelar
        confirmButtonColor: "#d33", // Color del botón de confirmación
        cancelButtonColor: "#3085d6", // Color del botón de cancelar
        confirmButtonText: "Sí, eliminar", // Texto del botón de confirmación
        cancelButtonText: "Cancelar" // Texto del botón de cancelar
    }).then((result) => {
        if (result.isConfirmed) {
            event.target.submit(); // Si se confirma, se envía el formulario
        }
    });
    return false; // Retorna false para evitar comportamiento por defecto
}

// Validación del formulario de productos
function validarFormularioProducto() {
    const form = document.getElementById("productoForm"); // Obtiene el formulario
    if (!form) return; // Si no existe el formulario, se termina la función

    let isValid = true; // Variable para verificar validez general

    // Validar nombre (mínimo 3 caracteres)
    const nameInput = document.getElementById("name");
    if (nameInput && nameInput.value.trim().length < 3) {
        nameInput.classList.add("is-invalid"); // Marca el campo como inválido
        isValid = false; // Cambia el estado a inválido
    }

    // Validar precio (debe ser un número positivo)
    const precioInput = document.getElementById("precio");
    if (precioInput && (parseFloat(precioInput.value) <= 0 || isNaN(parseFloat(precioInput.value)))) {
        precioInput.classList.add("is-invalid"); // Marca el campo como inválido
        isValid = false;
    }

    // Validar stock (no debe ser negativo)
    const stockInput = document.getElementById("stock");
    if (stockInput && (parseInt(stockInput.value) < 0 || isNaN(parseInt(stockInput.value)))) {
        stockInput.classList.add("is-invalid"); // Marca el campo como inválido
        isValid = false;
    }

    return isValid; // Devuelve true si todo está bien, false si hay errores
}

// Muestra alertas al cargar la página
document.addEventListener("DOMContentLoaded", function () {
    // Mensaje de éxito (si existe)
    let successMessage = document.getElementById("successMessage");
    if (successMessage && successMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'success', // Icono de éxito
            title: 'Éxito', // Título del mensaje
            text: successMessage.value, // Texto con el mensaje recibido
            confirmButtonColor: '#3085d6'
        });
    }

    // Mensaje de error (si existe)
    let errorMessage = document.getElementById("errorMessage");
    if (errorMessage && errorMessage.value.trim() !== "") {
        Swal.fire({
            icon: 'error', // Icono de error
            title: 'Error', // Título del mensaje
            text: errorMessage.value, // Texto con el mensaje de error
            confirmButtonColor: '#d33'
        });

        // Si hay atributos con nombres de campos con errores
        if (errorMessage.hasAttribute("data-errors")) {
            const errorFields = JSON.parse(errorMessage.getAttribute("data-errors")); // Convierte la cadena JSON a arreglo
            errorFields.forEach(fieldId => {
                const field = document.getElementById(fieldId); // Obtiene cada campo con error
                if (field) field.classList.add("is-invalid"); // Agrega clase para mostrar error visual
            });
        }
    }

    // Configurar validación del formulario al momento de enviarse
    const form = document.getElementById("productoForm");
    if (form) {
        form.addEventListener("submit", function (event) {
            if (!validarFormularioProducto()) {
                event.preventDefault(); // Detiene el envío del formulario
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

        // Elimina la clase de error al comenzar a escribir en los campos
        form.querySelectorAll("input").forEach(input => {
            input.addEventListener("input", function() {
                this.classList.remove("is-invalid"); // Limpia la clase de error al editar
            });
        });
    }
});