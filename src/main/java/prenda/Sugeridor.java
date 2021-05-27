package prenda;

import java.util.Collections;
import java.util.List;

import servicioClima.EstadoDeClima;
import servicioClima.ServicioClima;

import sugerencia.*;

public class Sugeridor {
	ServicioClima servicioClima;

  public Sugeridor(ServicioClima servicioClima){
    this.servicioClima = servicioClima;
  }
  
  public Atuendo obtenerSugerencia(List<Prenda> prendas, String direccion){
    return new Atuendo(
    		sugerenciaDePrendaCategoria(CategoriaPrenda.PARTE_SUPERIOR, prendas, direccion),
    		sugerenciaDePrendaCategoria(CategoriaPrenda.PARTE_INFERIOR, prendas, direccion),
    		sugerenciaDePrendaCategoria(CategoriaPrenda.CALZADO, prendas, direccion),
    		sugerenciaDePrendaCategoria(CategoriaPrenda.ACCESORIO, prendas, direccion)
    );
  }
    
  public Prenda sugerenciaDePrendaCategoria(CategoriaPrenda categoria, List<Prenda> prendas, String direccion){ 
  	//SugerenciaDePrendaCategoria sugerencia = new SugerenciaDePrendaCategoria(categoria, prendas, direccion);
  	
  	EstadoDeClima datosClima = servicioClima.obtenerEstadoDeClima(direccion);
  	int temperatura = datosClima.getTemperaturaEnCelsius();
    Collections.shuffle(prendas);
   
    return prendas.stream().
            filter(prenda -> prenda.perteneceCategoria(categoria) && prenda.esAptaParaEstaTemperatura(temperatura)).
            findAny().
            orElse(null);
  }
}
