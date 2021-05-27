package usuario;

import java.util.ArrayList;
import java.util.List;

import prenda.*;
import sugerencia.*;

public class Usuario{
	List<Guardaropa> guardaropas;
	List<SugerenciaGuadaropa> sugerenciasPendientesParaAgregar;
	List<SugerenciaGuadaropa> sugerenciasPendientesParaQuitar;
	
	private Usuario() {
		this.guardaropas = new ArrayList<Guardaropa>();
	}
	
	public void sugerenciaDePrendaParaAgregar(Guardaropa guardaropa,Prenda prenda) {
		SugerenciaGuadaropa sugerencia = new SugerenciaGuadaropa(guardaropa, prenda); 
		sugerenciasPendientesParaAgregar.add(sugerencia);
	}
	
	
	public void sugerenciaDePrendaParaQuitar(Guardaropa guardaropa,Prenda prenda) {
		SugerenciaGuadaropa sugerencia = new SugerenciaGuadaropa(guardaropa, prenda);
		sugerenciasPendientesParaQuitar.add(sugerencia);
	}
}
