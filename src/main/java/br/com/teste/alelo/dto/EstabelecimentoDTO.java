package br.com.teste.alelo.dto;

import java.time.LocalDateTime;

public class EstabelecimentoDTO {

	Long cnpj;
	String razaoSocial;
	String cozinha;
	Integer avaliacao;
	LocalDateTime dtCadastro;
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCozinha() {
		return cozinha;
	}
	public void setCozinha(String cozinha) {
		this.cozinha = cozinha;
	}
	public Integer getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
}
