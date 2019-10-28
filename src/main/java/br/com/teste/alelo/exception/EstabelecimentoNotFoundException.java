package br.com.teste.alelo.exception;

public class EstabelecimentoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4409885591269428794L;

	public EstabelecimentoNotFoundException(Long id){
	
		super("Estabelecimento " + id + " não encontrado");	
		
	}
}
