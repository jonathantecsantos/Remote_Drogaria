package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			estado = new Estado();
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados!");
			erro.printStackTrace();
		}
	}

	// Pegando evento da visão
	public void excluir(ActionEvent evento) {

		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			Messages.addGlobalInfo("Estado removido com sucesso!");
			estados = estadoDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
			erro.printStackTrace();
		}
	}
	public void editar (ActionEvent evento){
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	}

	public void novo() {
		estado = new Estado();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
