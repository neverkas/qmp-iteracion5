package sugerencia;

import java.util.List;

import prenda.CategoriaPrenda;
import prenda.Guardaropa;
import prenda.Prenda;
import usuario.Usuario;

public class SugerenciaGuadaropa {
	Guardaropa guardaropa;
	Prenda prenda;
	Usuario usuario;
	
	public SugerenciaGuadaropa(Guardaropa guardaropa,Prenda prenda, Usuario usuario) {
		this.guardaropa = guardaropa;
		this.prenda = prenda;
		this.usuario = usuario;
	}	
}
