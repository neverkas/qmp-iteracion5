package prenda;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Guardaropa {
	List<Prenda> prendas;
	List<Usuario> compartidoCon;
	ModoDeUso modoDeUso;
	
	private Guardaropa(ModoDeUso modoDeUso) {
		this.modoDeUso = modoDeUso;
		this.prendas = new ArrayList<Prenda>();
		this.compartidoCon = new ArrayList<Usuario>();
	}
	
}
