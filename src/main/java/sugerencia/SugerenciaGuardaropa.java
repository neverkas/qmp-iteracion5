package sugerencia;

import java.util.List;

import prenda.CategoriaPrenda;
import prenda.Guardaropa;
import prenda.Prenda;
import usuario.Usuario;

public class SugerenciaGuardaropa {
	Prenda prenda;
	EstadoSugerencia estadoSugerencia;
	
	public SugerenciaGuardaropa(Prenda prenda, EstadoSugerencia estadoSugerencia) {
		this.prenda = prenda;
		this.estadoSugerencia = estadoSugerencia;
	}	
	
	public boolean pendienteParaAgregar() {
		return estadoSugerencia.equals(EstadoSugerencia.PendienteAgregar);
	}

	public boolean pendienteParaQuitar() {
		return estadoSugerencia.equals(EstadoSugerencia.PendienteQuitar);
	}

	public Prenda getPrendaSugerida() {
		return this.prenda;
	}
	
	public EstadoSugerencia getEstado() {
		return this.estadoSugerencia;
	}
	
	public void aceptarSugerencia() {
		this.estadoSugerencia = EstadoSugerencia.Aceptada;
	}
	
	public void rechazarSugerencia() {
		this.estadoSugerencia = EstadoSugerencia.Rechazada;
	}

}


