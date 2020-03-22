package ads.pipoca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ads.pipoca.model.entity.Filme;
import ads.pipoca.model.entity.Genero;
import ads.pipoca.model.service.FilmeService;
import ads.pipoca.model.service.GeneroService;

/**
 * Servlet implementation class ManterFilmesController
 */
@WebServlet("/manter_filmes.do")
public class ManterFilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ArrayList<Genero> generos = listarGeneros();
			int id = inserirFilme();
			Filme filme = listarFilme(id);
			PrintWriter writer = response.getWriter();
			writer.print("<html><head><title>Filmes</title></head><body>");
			writer.print("<p>");
			writer.print(generos);
			writer.print("</p>");
			writer.print("<p>");
			writer.print("Id gerado: "+id);
			writer.print("</p>");
			writer.print("<p>");
			writer.print(filme);
			writer.print("</p>");
			writer.print("</body></html>");
			writer.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public Filme listarFilme(int id) throws IOException {
		Filme filme;
		FilmeService service = new FilmeService();
		filme = new Filme();
		filme = service.buscarFilme(id);
		return filme;
	}

	public ArrayList<Genero> listarGeneros() throws IOException {
		GeneroService genero;
		genero = new GeneroService();
		ArrayList<Genero> generos = genero.listarGeneros();
		return generos;
	}

	public int inserirFilme() throws IOException {
		Filme filme;
		Genero genero;
		FilmeService service = new FilmeService();

		filme = new Filme();
		filme.setTitulo("O Náufrago");
		filme.setDescricao("Chuck Noland (Tom Hanks) um inspetor da Federal Express (FedEx), "
				+ "multinacional encarregada de enviar cargas e correspondências, que tem por "
				+ "função checar vários escritórios da empresa pelo planeta. Porém, em uma de "
				+ "suas costumeiras viagens ocorre um acidente, que o deixa preso em uma ilha "
				+ "completamente deserta por 4 anos. Com sua noiva (Helen Hunt) e seus amigos "
				+ "imaginando que ele morrera no acidente, Chuck precisa lutar para sobreviver, "
				+ "tanto fisicamente quanto emocionalmente, a fim de que um dia consiga retornar " + "civilização.");
		filme.setDiretor("Robert Zemeckis");

		genero = new Genero();
		genero.setId(12);
		genero.setNome("Aventura");
		filme.setGenero(genero);

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			filme.setDataLancamento(formatter.parse("26/01/2001"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			filme.setDataLancamento(null);
		}

		filme.setPopularidade(100.25);
		filme.setPosterPath("img/naufrago.jpg");

		int id = service.inserirFilme(filme);
		return id;
	}

}
