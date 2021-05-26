package prenda;

// TODO: Revisar perteneceCategoria

public class TipoPrenda {
  private CategoriaPrenda categoria;
	private int temperaturaMaximaRecomendada;
  
  public TipoPrenda(CategoriaPrenda categoria, int temperaturaMaxima) {
    this.categoria = categoria;
		this.temperaturaMaximaRecomendada = temperaturaMaxima;    
  }

	public boolean esAptaParaEstaTemperatura(int temperatura) {
		return this.temperaturaMaximaRecomendada > temperatura;
	}

	public boolean perteneceCategoria(CategoriaPrenda categoria) {
		return this.categoria == categoria;
	}
}