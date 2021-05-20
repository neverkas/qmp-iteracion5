package prenda;


public class TipoPrenda {
  private CategoriaPrenda categoria;
	private int temperaturaMaxima;
  
  public TipoPrenda(CategoriaPrenda categoria, int temperaturaMaxima) {
    this.categoria = categoria;
		this.temperaturaMaxima = temperaturaMaxima;    
  }

	public boolean esRecomendadaSegun(int temperatura) {
		return this.temperaturaMaxima > temperatura;
	}

	public boolean perteneceCategoria(CategoriaPrenda categoria) {
		return this.categoria == categoria;
	}
}