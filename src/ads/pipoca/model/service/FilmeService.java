package ads.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;

import ads.pipoca.model.dao.FilmeDAO;
import ads.pipoca.model.entity.Filme;

public class FilmeService {

	public int inserirFilme(Filme filme) throws IOException {
		FilmeDAO dao = new FilmeDAO();
		return dao.inserirFilme(filme);
	}

	public Filme buscarFilme(int id) throws IOException {
		FilmeDAO dao = new FilmeDAO();
		return dao.buscarFilme(id);
	}
	
	public void excluirFilme(int id) throws IOException {
		FilmeDAO dao = new FilmeDAO();
		dao.excluirFilme(id);
	}
	public String alterarFilme(Filme filme) throws IOException {
		FilmeDAO dao = new FilmeDAO();
		return dao.alterarFilme(filme);
	}
	public ArrayList<Filme> listarFilmes() throws IOException {
		FilmeDAO dao = new FilmeDAO();
		return dao.listarFilmes();
	}
}
