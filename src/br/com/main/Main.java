package br.com.main;

import java.util.Scanner;

import br.com.service.UserService;

public class Main {

	public static void main(String[] args) throws Exception {
		int opcao = 0;
		UserService userService = new UserService();
		

		while (opcao != 5){
			Scanner menu = new Scanner(System.in);
			System.out.print("|-----------------------------|\n");
			System.out.print("| Opção 1 - Novo Cadastro     |\n");
			System.out.print("| Opção 2 - Listar Usuarios   |\n");
			System.out.print("| Opção 3 - Atualizar Cadastro|\n");
			System.out.print("| Opção 4 - Deletar Cadastro  |\n");
			System.out.print("| Opção 5 - Sair              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("       Digite uma opção:         ");

			opcao = menu.nextInt();

			switch (opcao) {
			case 1:
				System.out.print("\nOpção Novo Cadastro Selecionado\n");
				System.out.print("\n");
				userService.save();
				break;

			case 2:
				System.out.print("\nOpção Listar Usuarios Selecionado\n");
				System.out.print("\n");
				userService.Listar();
				break;

			case 3:
				System.out.print("\nOpção Atualizar Cadastro Selecionado\n");
				System.out.print("\n");
				userService.alterar();
				break;
			
			case 4:
				System.out.print("\nOpção Deletar Cadastro Selecionado\n");
				System.out.print("\n");
				userService.excluir();
				break;
			
			case 5:
				System.out.print("\nFinalizado!");
				menu.close();
				break;
				
			default:
				System.out.print("\nOpção Inválida!\n");
				break;
			}
		} 
	}
}
