function iniciarContador(tiempoRestante) {
    const countdown = setInterval(function () {
        document.getElementById("contador").textContent = tiempoRestante;
        tiempoRestante--;
        if (tiempoRestante < 0) {
            clearInterval(countdown);
            // Habilitar el botón de ingreso nuevamente
            document.getElementById("contador").textContent = "";
            document.getElementById("botonIngresar").disabled = false;
        }
    }, 1000);
    // Desactivar el botón de ingreso mientras el temporizador esté activo
    document.getElementById("botonIngresar").disabled = true;
}



