package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Ignore
	@Test
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getNome() + " - " + estado.getSigla());
		}
	}

	@Ignore
	@Test
	public void buscar() {
		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		System.out.println(estado.getNome() + " - " + estado.getSigla());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			estadoDAO.excluir(estado);
		}
	}

	@Test
	public void editar(){
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		estado.setSigla("XX");
		estadoDAO.editar(estado);
		
		
	}
}
