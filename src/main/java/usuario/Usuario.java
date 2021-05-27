package usuario;

import java.util.ArrayList;
import java.util.List;

import prenda.*;
import sugerencia.*;

public class Usuario{
	List<Guardaropa> guardaropas;
	List<SugerenciaGuardaropa> sugerenciasPendientes;
	
	public Usuario() {
		this.guardaropas = new ArrayList<Guardaropa>();
		this.sugerenciasPendientes = new ArrayList<SugerenciaGuardaropa>();
	}
	
	public void sugerenciaDePrendaParaAgregar(Usuario usuario, Prenda prenda) {
		SugerenciaGuardaropa sugerencia = new SugerenciaGuardaropa(prenda, EstadoSugerencia.PendienteAgregar); 
		sugerenciasPendientes.add(sugerencia);
	}
	
	public void sugerenciaDePrendaParaQuitar(Usuario usuario, Prenda prenda) {
		SugerenciaGuardaropa sugerencia = new SugerenciaGuardaropa(prenda, EstadoSugerencia.PendienteQuitar);
		sugerenciasPendientes.add(sugerencia);
	}
	
	
	public void agregarGuardaropa(Guardaropa guardaropa) {
		guardaropas.add(guardaropa);
	}

	public void crearGuardaropaSinCompartir() {
		Guardaropa nuevoGuardaropa = new Guardaropa(null);
		agregarGuardaropa(nuevoGuardaropa);
	}

	public void crearGuardaropaCompartido(Usuario usuario) {
		Guardaropa nuevoGuardaropa = new Guardaropa(null);
		nuevoGuardaropa.agregarUsuarioCompartido(usuario);
		agregarGuardaropa(nuevoGuardaropa);
	}
	
	public boolean compartenGuardaropa(Usuario usuario) {
		return guardaropas.stream().anyMatch(guardaropa -> guardaropa.estaCompartidoCon(usuario));
	}
	
	public boolean leFueSugeridaParaAgregar(Prenda prenda) {
		return sugerenciasPendientes.stream().anyMatch(sugerencia -> sugerencia.pendienteParaAgregar() );
	}

	public boolean leFueSugeridaParaQuitar(Prenda prenda) {
		return sugerenciasPendientes.stream().anyMatch(sugerencia -> sugerencia.pendienteParaQuitar() );
	}
	
	public List<SugerenciaGuardaropa> getSugerenciasPropuestas() {
		return this.sugerenciasPendientes;
	}
	
	public void aceptarPropuesta(SugerenciaGuardaropa sugerencia) {
		sugerencia.aceptarSugerencia();
	}
	
	public void rechazarPropuesta(SugerenciaGuardaropa sugerencia) {
		sugerencia.rechazarSugerencia();
	}
	
	public void deshacerCambioPropuesta(SugerenciaGuardaropa sugerencia) {
		if(sugerencia.getEstado() == EstadoSugerencia.Aceptada)
			rechazarPropuesta(sugerencia);
		else
			aceptarPropuesta(sugerencia);
	}
}
