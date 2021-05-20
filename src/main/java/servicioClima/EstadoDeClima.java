package servicioClima;

public class EstadoDeClima {
  int probabilidadPrecipitacion;
  int temperatura;

  public EstadoDeClima(int temperatura, int probabilidadPrecipitacion){
      this.probabilidadPrecipitacion = probabilidadPrecipitacion;
      this.temperatura = temperatura;
  }
}
