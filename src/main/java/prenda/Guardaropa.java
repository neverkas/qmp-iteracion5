package prenda;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Guardaropa {
	List<Prenda> prendas;
	List<Usuario> compartidoCon;
	ModoDeUso modoDeUso;
	
	public Guardaropa(ModoDeUso modoDeUso) {
		if(modoDeUso == null)
			this.modoDeUso = modoDeUso.DeEntrecasa;
		else
			this.modoDeUso = modoDeUso;
		
		this.prendas = new ArrayList<Prenda>();
		this.compartidoCon = new ArrayList<Usuario>();
	}

	public Guardaropa(ModoDeUso modoDeUso, Usuario usuario) {
		super();
		agregarUsuarioCompartido(usuario);
	}

	public int cantidadDePrendas() {
		return prendas.size();
	}
	
	public void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
	public void agregarUsuarioCompartido(Usuario usuario) {
		compartidoCon.add(usuario);
	}
	
	public boolean estaCompartidoCon(Usuario usuario) {
		return compartidoCon.contains(usuario);
	}
	
}
