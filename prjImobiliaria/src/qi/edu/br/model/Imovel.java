package qi.edu.br.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Imovel  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int idCliente;
	private int idFuncionario;
	private int idTipoImovel;
	private String nome;
	private int situacao;
	private String foto_capa;
	private double valor;
	private String descricao;
	private int ativo;
	private Date data_imovel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdTipoImovel() {
		return idTipoImovel;
	}
	public void setIdTipoImovel(int idTipoImovel) {
		this.idTipoImovel = idTipoImovel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao2) {
		this.situacao = situacao2;
	}
	public String getFoto_capa() {
		return foto_capa;
	}
	public void setFoto_capa(String foto_capa) {
		this.foto_capa = foto_capa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData_imovel() {
		return data_imovel;
	}
	public void setData_imovel(Date date) {
		this.data_imovel = date;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	
	

}
