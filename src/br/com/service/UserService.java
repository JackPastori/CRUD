package br.com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Farmacia.Usuario;
import br.com.DataAcessObject.DAO;

public class UserService {
	public void save() {
		DAO dao = new DAO();

		System.out.println("Cadastre o usuario!");
		Scanner leitor = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("Digite o Nome:");
		usuario.setNome(leitor.nextLine());

		System.out.println("Digite o E-mail:");
		usuario.setEmail(leitor.nextLine());

		System.out.println("Digite o Senha:");
		usuario.setSenha(leitor.nextLine());

		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		usuario.setDataDeCadastro(formatador.format(data));

		dao.save(usuario);
		
		System.out.println("Usuario incluido com sucesso!\n");
	}

	public void alterar() throws Exception {
		DAO dao = new DAO();

		Scanner leitor = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("Digite o id:");
		usuario.setId(Integer.valueOf(leitor.nextLine()));

		System.out.println("Digite o Nome:");
		usuario.setNome(leitor.nextLine());

		System.out.println("Digite o E-mail:");
		usuario.setEmail(leitor.nextLine());

		System.out.println("Digite o Senha:");
		usuario.setSenha(leitor.nextLine());

		dao.alterar(usuario);
		
		System.out.println("Usuario alterado com sucesso!\n");
	}

	public void excluir() throws Exception {
		DAO dao = new DAO();

		Scanner leitor = new Scanner(System.in);
		Usuario usuario = new Usuario();

		System.out.println("\nDigite o id:");
		usuario.setId(Integer.valueOf(leitor.nextLine()));
		System.out.println("\n");
		dao.excluir(usuario);
		
		System.out.println("Usuario deletado com sucesso!\n");
	}

	public void Listar() {
		DAO dao = new DAO();
		
		System.out.println("Lista de usuarios\n");
		List<Usuario> usuarios = dao.getFarmacias();
				
		for (Usuario usuario : usuarios) {
			System.out.println("\nID:" + usuario.getId() + "\n");
			System.out.println("Nome:" + usuario.getNome() + "\n");
			System.out.println("Email:" + usuario.getEmail() + "\n");
			System.out.println("Senha:" + usuario.getSenha() + "\n");
			System.out.println("-------------------");
		}
	}
}