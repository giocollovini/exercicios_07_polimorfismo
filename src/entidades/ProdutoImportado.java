package entidades;

public class ProdutoImportado extends Produto{
	
	private double taxaAlfandegaria;

	public ProdutoImportado(String nome, Double preco, double taxaAlfandegaria) {
		super(nome, preco);
		this.taxaAlfandegaria = taxaAlfandegaria;
	}
	
		
	public double getTaxaAlfandegaria() {
		return taxaAlfandegaria;
	}


	public void setTaxaAlfandegaria(double taxaAlfandegaria) {
		this.taxaAlfandegaria = taxaAlfandegaria;
	}


	public double precoTotal() {
		return super.getPreco() + taxaAlfandegaria; 
		
	}
	
	@Override
	public String etiquetaPreco() {
		return super.getNome()
				+ " $ "
				+ String.format("%.2f", precoTotal())
				+ " (Etiqueta de Preço: $ " 
				+ String.format("%.2f", taxaAlfandegaria)
				+ ")";
	}

}
