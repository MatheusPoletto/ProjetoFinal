package imovel;

import pessoa.Proprietario;

public class Aluguel extends Imovel{
	private Double valorMensal;
	private Integer mesesContrato;
	
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
	
	public Aluguel(Integer idimovel, String uf, String cidade, String bairro, String rua, Integer numero,
			Proprietario proprietario) {
		super(idimovel, uf, cidade, bairro, rua, numero, proprietario);
	}

}
