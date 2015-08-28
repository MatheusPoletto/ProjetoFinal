package model;

import java.time.LocalDate;

public class Historico {
	
	private Integer idhistorico;
	private LocalDate data;
	
	private Imovel imovel;
	private TipoOcorrencia TipoOcorrencia;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Historico(Integer idhistorico, LocalDate data, Imovel imovel,
			model.TipoOcorrencia tipoOcorrencia) {
		super();
		this.idhistorico = idhistorico;
		this.data = data;
		this.imovel = imovel;
		TipoOcorrencia = tipoOcorrencia;
	}
	
	
	
	public Integer getIdhistorico() {
		return idhistorico;
	}
	public void setIdhistorico(Integer idhistorico) {
		this.idhistorico = idhistorico;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public TipoOcorrencia getTipoOcorrencia() {
		return TipoOcorrencia;
	}
	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		TipoOcorrencia = tipoOcorrencia;
	}
	
	
	
	
	

}
