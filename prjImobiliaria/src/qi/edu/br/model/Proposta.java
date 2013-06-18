package qi.edu.br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "proposta")
public class Proposta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int idImovel;
	@Column
	private double valorVenda;
	@Column
	private double valorProposto;
	@Column
	private boolean tipo;
	@Column
	private String contatoCliente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdImovel() {
		return idImovel;
	}
	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public double getValorProposto() {
		return valorProposto;
	}
	public void setValorProposto(double valorProposto) {
		this.valorProposto = valorProposto;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public String getContatoCliente() {
		return contatoCliente;
	}
	public void setContatoCliente(String contatoCliente) {
		this.contatoCliente = contatoCliente;
	}
	
	
}
