package prenda;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Guardaropa {
	String tipo;
	List<Prenda> prendas;
	List<Usuario> compartidoCon;
	
	private Guardaropa() {
		this.prendas = new ArrayList<Prenda>();
		this.compartidoCon = new ArrayList<Usuario>();
	}
	
}
