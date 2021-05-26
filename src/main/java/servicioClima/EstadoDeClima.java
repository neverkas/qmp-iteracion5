package servicioClima;

public class EstadoDeClima {
  private int probabilidadPrecipitacion;
  private int temperatura;

	public EstadoDeClima(int temperatura, int probabilidadPrecipitacion){
      this.probabilidadPrecipitacion = probabilidadPrecipitacion;
      this.temperatura = temperatura;
  }
  
  public int getTemperatura() {
		return temperatura;
	}
  
  public int getProbabilidadPrecipitacion() {
  	return probabilidadPrecipitacion;
  }
    
  public int getTemperaturaEnCelsius() {
  	return temperatura - 32;
  }
  
}
