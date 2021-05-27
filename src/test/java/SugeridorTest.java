import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import prenda.Atuendo;
import prenda.CategoriaPrenda;
import prenda.Material;
import prenda.Prenda;
import prenda.Sugeridor;
import prenda.TipoPrenda;
import prenda.Trama;
import servicioClima.AccuWeatherAPI;
import servicioClima.AccuWeatherAdapter;
import servicioClima.EstadoDeClima;

class SugeridorTest {

	AccuWeatherAdapter accu;
	
	@BeforeEach
	void init() {
		accu = new AccuWeatherAdapter(new AccuWeatherAPI());
	}
	
	@Test
	void NoSiempreSeRecomiendaRopaDeVerano() {
		Sugeridor sugeridor = new Sugeridor(accu);
		Atuendo atuendoSugerido = sugeridor.obtenerSugerencia(prendasVarias(), "Buenos Aires, Argentina");
		
		assertFalse(atuendoSugerido == ropaDeVeranoSugerida());
	}
	
	@Test
	void sugeridorSugiereSegunLaTemperaturaDelLugar() {
		Sugeridor sugeridor = new Sugeridor(accu);
		Prenda prendaElegida = sugeridor.sugerenciaPrendaCategoria(CategoriaPrenda.PARTE_SUPERIOR, prendasVarias(), "Buenos Aires, Argentina");
				
		assertTrue(prendaElegida.esAptaParaEstaTemperatura(temperaturaActualEnBuenosAires()));
	}
	
	@Test
	void sugeridorSugierePrendasDeLaCategoriaPedida() {
		Sugeridor sugeridor = new Sugeridor(accu);
		Prenda prendaElegida = sugeridor.sugerenciaPrendaCategoria(CategoriaPrenda.PARTE_SUPERIOR, prendasVarias(), "Buenos Aires, Argentina");
		
		assertTrue(prendaElegida.perteneceCategoria(CategoriaPrenda.PARTE_SUPERIOR));
	}

	@Test
	void sugeridorNoSugierePrendaDeUnaCategoriaQueNoSePidio() {
		Sugeridor sugeridor = new Sugeridor(accu);
		Prenda prendaElegida = sugeridor.sugerenciaPrendaCategoria(CategoriaPrenda.PARTE_SUPERIOR, prendasVarias(), "Buenos Aires, Argentina");
		
		assertFalse(prendaElegida.perteneceCategoria(CategoriaPrenda.ACCESORIO));
	}

	
	int temperaturaActualEnBuenosAires() {
		EstadoDeClima climaBuenosAires = accu.obtenerClimaBuenosAires();
		
		return climaBuenosAires.getTemperaturaEnCelsius();
	}
	
	List<Prenda> prendasVarias(){
		List<Prenda> prendas = new ArrayList<Prenda>();
		prendas.add(new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 30), Material.CUERO, new Color(255,255,255), null, Trama.LISA));
		prendas.add(new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_INFERIOR, 30), Material.ALGODON, new Color(255,255,255), null, Trama.LISA));
		prendas.add(new Prenda(new TipoPrenda(CategoriaPrenda.CALZADO, 30), null, new Color(255,255,255), null, null));
		prendas.add(new Prenda(new TipoPrenda(CategoriaPrenda.ACCESORIO, 30), null, new Color(255,255,255), null, null));
		return prendas;
	}

	Atuendo ropaDeVeranoSugerida() {
		return new Atuendo(
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 30), Material.ALGODON, new Color(255,255,255), null, Trama.LISA),
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_INFERIOR, 30), Material.ALGODON, new Color(255,255,255), null, Trama.LISA),
				new Prenda(new TipoPrenda(CategoriaPrenda.CALZADO, 30), null, new Color(0,0,0), null, null),
				new Prenda(new TipoPrenda(CategoriaPrenda.ACCESORIO, 30), null, new Color(0,0,0), null, null)
				);
	}
	Atuendo ropaDeInvernoSugerida() {
		return new Atuendo(
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_SUPERIOR, 30), Material.CUERO, new Color(0,0,0), null, Trama.RAYADA),
				new Prenda(new TipoPrenda(CategoriaPrenda.PARTE_INFERIOR, 30), Material.CUERO, new Color(0,0,0), null, Trama.RAYADA),
				new Prenda(new TipoPrenda(CategoriaPrenda.CALZADO, 30), null, new Color(0,0,0), null, null),
				new Prenda(new TipoPrenda(CategoriaPrenda.ACCESORIO, 30), null, new Color(0,0,0), null, null)
				);
	}	
}
