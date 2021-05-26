package servicioClima;

public interface ServicioClima {
    public EstadoDeClima obtenerClimaBuenosAires();
    public EstadoDeClima obtenerEstadoDeClima(String ciudad);
}
