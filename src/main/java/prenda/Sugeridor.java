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
    		sugerenciaPrendaCategoria(CategoriaPrenda.PARTE_SUPERIOR, prendas, direccion),
    		sugerenciaPrendaCategoria(CategoriaPrenda.PARTE_INFERIOR, prendas, direccion),
    		sugerenciaPrendaCategoria(CategoriaPrenda.CALZADO, prendas, direccion),
    		sugerenciaPrendaCategoria(CategoriaPrenda.ACCESORIO, prendas, direccion)
    );
  }
    
  public Prenda sugerenciaPrendaCategoria(CategoriaPrenda categoria, List<Prenda> prendas, String direccion){ 
  	//SugerenciaPrendaCategoria sugerencia = new SugerenciaPrendaCategoria(categoria, prendas, direccion);
  	
  	EstadoDeClima datosClima = servicioClima.obtenerEstadoDeClima(direccion);
  	int temperatura = datosClima.getTemperaturaEnCelsius();
    Collections.shuffle(prendas);
   
    return prendas.stream().
            filter(prenda -> prenda.perteneceCategoria(categoria) && prenda.esAptaParaEstaTemperatura(temperatura)).
            findAny().
            orElse(null);
  }
}
