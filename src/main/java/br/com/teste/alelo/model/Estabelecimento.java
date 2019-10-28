package br.com.teste.alelo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Estabelecimento {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String razaoSocial;
    private String cozinha;
    private String endereco;
    private Integer avaliacao;
    
	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
