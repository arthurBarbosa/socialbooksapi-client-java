package com.abcode.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.abcode.socialbooks.client.LivrosClient;
import com.abcode.socialbooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient();
		
		List<Livro> listaLivros = cliente.listar();

		for (Livro livro : listaLivros) {
			System.out.println("Livro " + livro.getNome());

		}
		
		Livro livro = new Livro();
		livro.setNome("Git passo a passo");
		livro.setEditora("Abcode");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		
		livro.setPublicacao(publicacao.parse("06/01/2020"));
		livro.setResumo("este livro aborda tecnicas de desenvolvimento de API");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo " + localizacao);
	}
}
