package prenda;

import java.util.Collections;
import java.util.List;

import servicioClima.EstadoDeClima;
import servicioClima.ServicioClima;

public class Sugeridor {
	ServicioClima servicioClima;

  public Sugeridor(ServicioClima servicioClima){
    this.servicioClima = servicioClima;
  }
  
  public Atuendo obtenerSugerencia(List<Prenda> prendas){
  	EstadoDeClima estadoDeClima = servicioClima.obtenerClimaBuenosAires();
    int temperatura = estadoDeClima.getTemperatura();
    return new Atuendo(
    		prendaSugerida(CategoriaPrenda.PARTE_SUPERIOR, prendas, temperatura),
    		prendaSugerida(CategoriaPrenda.PARTE_INFERIOR, prendas, temperatura),
    		prendaSugerida(CategoriaPrenda.CALZADO, prendas, temperatura),
    		prendaSugerida(CategoriaPrenda.ACCESORIO, prendas, temperatura)
    );
  }
  
  public Prenda prendaSugerida(CategoriaPrenda categoria, List<Prenda> prendas, int temperatura){
    Collections.shuffle(prendas);
    return prendas.stream().
            filter(prenda -> prenda.perteneceCategoria(categoria) && prenda.esRecomendadaSegun(temperatura)).
            findAny().
            orElse(null);
  }
}
