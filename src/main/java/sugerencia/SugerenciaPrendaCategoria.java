package sugerencia;

import java.util.Collections;
import java.util.List;

import prenda.CategoriaPrenda;
import prenda.Prenda;

public class SugerenciaPrendaCategoria {
	CategoriaPrenda categoria;
	List<Prenda> prendas;
	String direccion;
	
	public SugerenciaPrendaCategoria(CategoriaPrenda categoria, List<Prenda> prendas, String direccion) {
		this.categoria = categoria;
		this.prendas = prendas;
		this.direccion = direccion;
	}
	
}
