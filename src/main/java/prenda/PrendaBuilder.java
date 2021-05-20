package prenda;

import java.awt.Color;

public class PrendaBuilder {
  private TipoPrenda tipo;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama;

  public PrendaBuilder(TipoPrenda tipoPrenda) {
    tipo = tipoPrenda;
  }

  public void elegirMaterial(Material material) {
    this.material = material;
  }

  public void elegirColorPrimario(Color color) {
    this.colorPrimario = color;
  }

  public void elegirColorSecundario(Color color) {
    this.colorSecundario = color;
  }

  public void elegirTrama(Trama trama) {
    if (trama != null)  
    	this.trama = trama;
    else  
    	this.trama = Trama.LISA;
  }

  public Prenda crearPrenda() {
    return new Prenda(tipo, material, colorPrimario, colorSecundario, trama);
  }
}
