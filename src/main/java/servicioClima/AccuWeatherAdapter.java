package servicioClima;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccuWeatherAdapter implements ServicioClima{
	private AccuWeatherAPI api;
	
	public AccuWeatherAdapter(AccuWeatherAPI api) {
		this.api = api;
	}
  
  private List<Map<String, Object>> obtenerClimaDe(String ciudad){
      AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();
      return api.getWeather(ciudad);
  }
  
  private int getProbabilidadPrecipitacion(List<Map<String, Object>> climaCiudad){
    return (int) climaCiudad.get(0).get("PrecipitationProbability"); 
  }

  private int getTemperaturaEnFahrenheit(List<Map<String, Object>> climaCiudad){
    HashMap<String, Object> datosClima = (HashMap<String, Object>) climaCiudad.get(0).get("Temperature");
    return (int) datosClima.get("Value");
  }
  
	@Override
	public EstadoDeClima obtenerEstadoDeClima(String ciudad) {
    List<Map<String, Object>> datosDelClima = this.obtenerClimaDe(ciudad);
    
    int temperatura = getTemperaturaEnFahrenheit(datosDelClima);
    int probabilidadPrecipitaciones = getProbabilidadPrecipitacion(datosDelClima);
    
    return new EstadoDeClima(temperatura, probabilidadPrecipitaciones);		
	}

	@Override
	public EstadoDeClima obtenerClimaBuenosAires() {
		return this.obtenerEstadoDeClima("Buenos Aires, Argentina");		
	}
}
