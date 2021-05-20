package prenda;

import sastre.Sastre;

public class Uniforme {
	private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  private Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }
  
  public Uniforme fabricarUniforme(Sastre sastre) {
  	return sastre.crearUniforme();
  }
}
