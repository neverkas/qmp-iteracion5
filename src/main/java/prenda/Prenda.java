package prenda;

import java.awt.Color;

public class Prenda {
	private TipoPrenda tipo;
	private Material material;
	private Color colorPrimario;
	private Color colorSecundario;
	private Trama trama;
	
	public Prenda(TipoPrenda tipo, Material material, Color colorPrimario, Color colorSecundario, Trama trama) {
		this.tipo = tipo;
		this.material = material;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
		this.trama = trama;
	}

	public boolean esAptaParaEstaTemperatura(int temperatura) {
		return this.tipo.esAptaParaEstaTemperatura(temperatura);
	}

	public boolean perteneceCategoria(CategoriaPrenda categoria) {
		return this.tipo.perteneceCategoria(categoria);
	}
	
}
