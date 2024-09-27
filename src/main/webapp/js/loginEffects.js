document.addEventListener("DOMContentLoaded", function () {
    // Selecciona la tarjeta y el icono de usuario
    const card = document.querySelector(".card");
    const userIcon = document.querySelector(".img-fluid");
    
    // Agrega las clases de animación una vez que el DOM ha cargado
    if (card) {
        // Retraso para la animación de la tarjeta
        setTimeout(() => {
            card.classList.add("show");
        }, 300); // 300ms para que la tarjeta aparezca suavemente
    }
    
    if (userIcon) {
        // Retraso para la animación del ícono de usuario
        setTimeout(() => {
            userIcon.classList.add("show");
        }, 600); // 600ms para que el ícono aparezca después de la tarjeta
    }

    // Control de bloqueo y contador
    const contadorElem = document.getElementById("contador");
    let tiempoRestante = 30;

    if (contadorElem) {
        iniciarContador(tiempoRestante);
    }

    // Función para iniciar el contador de bloqueo
    function iniciarContador(tiempo) {
        const botonIngresar = document.getElementById("botonIngresar");
        const intervalo = setInterval(() => {
            tiempo--;
            contadorElem.textContent = tiempo;

            if (tiempo <= 0) {
                clearInterval(intervalo);
                contadorElem.textContent = "0";
                if (botonIngresar) {
                    botonIngresar.disabled = false;
                }
            }
        }, 1000);
    }
});
