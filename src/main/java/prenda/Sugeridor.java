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
  
  public Atuendo obtenerSugerencia(List<Prenda> prendas, String direccion){
    return new Atuendo(
    		prendaSugerida(CategoriaPrenda.PARTE_SUPERIOR, prendas, direccion),
    		prendaSugerida(CategoriaPrenda.PARTE_INFERIOR, prendas, direccion),
    		prendaSugerida(CategoriaPrenda.CALZADO, prendas, direccion),
    		prendaSugerida(CategoriaPrenda.ACCESORIO, prendas, direccion)
    );
  }
  
  public Prenda prendaSugerida(CategoriaPrenda categoria, List<Prenda> prendas, String direccion){
  	EstadoDeClima datosClima = servicioClima.obtenerEstadoDeClima(direccion);
  	int temperatura = datosClima.getTemperaturaEnCelsius();
    Collections.shuffle(prendas);
   
    return prendas.stream().
            filter(prenda -> prenda.perteneceCategoria(categoria) && prenda.esAptaParaEstaTemperatura(temperatura)).
            findAny().
            orElse(null);
  }
}
