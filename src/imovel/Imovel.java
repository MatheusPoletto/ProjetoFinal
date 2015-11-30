package imovel;

import pessoa.Cliente;
import pessoa.Endereco;

public class Imovel {
	private Integer idImovel;
	private String metrosquadrados;
	private Double valorTotal;
	private Double valorMensal;
	private Integer mesesContrato;
	private Endereco endereco;
	private Cliente cliente;
	private String imagem1;
	private String imagem2;
	private String imagem3;
	private String descricao1;
	private String descricao2;
	private String descricao3;
	private String imagem4;
	private Integer possui;

	public Imovel(Integer idImovel, String metrosquadrados, Double valorTotal, Double valorMensal,
			Integer mesesContrato, Endereco endereco, Cliente cliente, String imagem1, String imagem2, String imagem3,
			String descricao1, String descricao2, String descricao3, String imagem4, Integer possui) {
		super();
		this.idImovel = idImovel;
		this.metrosquadrados = metrosquadrados;
		this.valorTotal = valorTotal;
		this.valorMensal = valorMensal;
		this.mesesContrato = mesesContrato;
		this.endereco = endereco;
		this.cliente = cliente;
		this.imagem1 = imagem1;
		this.imagem2 = imagem2;
		this.imagem3 = imagem3;
		this.descricao1 = descricao1;
		this.descricao2 = descricao2;
		this.descricao3 = descricao3;
		this.imagem4 = imagem4;
		this.possui = possui;
	}

	public Imovel() {
		super();
	}

	public String getImagem4() {
		return imagem4;
	}

	public void setImagem4(String imagem4) {
		this.imagem4 = imagem4;
	}

	public Integer getPossui() {
		return possui;
	}

	public void setPossui(Integer possui) {
		this.possui = possui;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idimovel) {
		this.idImovel = idimovel;
	}

	public String getMetrosquadrados() {
		return metrosquadrados;
	}

	public void setMetrosquadrados(String metrosquadrados) {
		this.metrosquadrados = metrosquadrados;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public Integer getMesesContrato() {
		return mesesContrato;
	}

	public void setMesesContrato(Integer mesesContrato) {
		this.mesesContrato = mesesContrato;
	}

	public String getImagem1() {
		return imagem1;
	}

	public void setImagem1(String imagem1) {
		this.imagem1 = imagem1;
	}

	public String getImagem2() {
		return imagem2;
	}

	public void setImagem2(String imagem2) {
		this.imagem2 = imagem2;
	}

	public String getImagem3() {
		return imagem3;
	}

	public void setImagem3(String imagem3) {
		this.imagem3 = imagem3;
	}

	public String getDescricao1() {
		return descricao1;
	}

	public void setDescricao1(String descricao1) {
		this.descricao1 = descricao1;
	}

	public String getDescricao2() {
		return descricao2;
	}

	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}

	public String getDescricao3() {
		return descricao3;
	}

	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}

}
