package prenda;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Guardaropa {
	List<Prenda> prendas;
	List<Usuario> compartidoCon;
	ModoDeUso modoDeUso;
	
	public Guardaropa(ModoDeUso modoDeUso) {
		this.modoDeUso = modoDeUso;
		this.prendas = new ArrayList<Prenda>();
		this.compartidoCon = new ArrayList<Usuario>();
	}
	
	public int cantidadDePrendas() {
		return prendas.size();
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
}
