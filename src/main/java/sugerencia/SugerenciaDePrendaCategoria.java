package sugerencia;

import java.util.List;

import prenda.CategoriaPrenda;
import prenda.Prenda;

public class SugerenciaDePrendaCategoria {
	CategoriaPrenda categoria;
	List<Prenda> prendas;
	String direccion;
	
	public SugerenciaDePrendaCategoria(CategoriaPrenda categoria, List<Prenda> prendas, String direccion) {
		this.categoria = categoria;
		this.prendas = prendas;
		this.direccion = direccion;
	}
}
