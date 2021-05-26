import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import servicioClima.AccuWeatherAPI;
import servicioClima.AccuWeatherAdapter;

class AccuWeatherAdapterTest {
	AccuWeatherAdapter accu;
	
	@BeforeEach
	void init() {
		accu = new AccuWeatherAdapter(new AccuWeatherAPI());
	}
	
	@Test
	void temperaturaEnBuenosAiresNuncaSuperaLos40Grados() {		
		assertFalse(accu.obtenerClimaBuenosAires().getTemperaturaEnCelsius() > 40);
	}
	
	@Test
	void precipitacionesNuncaSonNegativas() {
		assertFalse(accu.obtenerClimaBuenosAires().getProbabilidadPrecipitacion() < 0);
	}

}
