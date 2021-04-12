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
			System.out.print("| Op��o 1 - Novo Cadastro     |\n");
			System.out.print("| Op��o 2 - Listar Usuarios   |\n");
			System.out.print("| Op��o 3 - Atualizar Cadastro|\n");
			System.out.print("| Op��o 4 - Deletar Cadastro  |\n");
			System.out.print("| Op��o 5 - Sair              |\n");
			System.out.print("|-----------------------------|\n");
			System.out.print("       Digite uma op��o:         ");

			opcao = menu.nextInt();

			switch (opcao) {
			case 1:
				System.out.print("\nOp��o Novo Cadastro Selecionado\n");
				System.out.print("\n");
				userService.save();
				break;

			case 2:
				System.out.print("\nOp��o Listar Usuarios Selecionado\n");
				System.out.print("\n");
				userService.Listar();
				break;

			case 3:
				System.out.print("\nOp��o Atualizar Cadastro Selecionado\n");
				System.out.print("\n");
				userService.alterar();
				break;
			
			case 4:
				System.out.print("\nOp��o Deletar Cadastro Selecionado\n");
				System.out.print("\n");
				userService.excluir();
				break;
			
			case 5:
				System.out.print("\nFinalizado!");
				menu.close();
				break;
				
			default:
				System.out.print("\nOp��o Inv�lida!\n");
				break;
			}
		} 
	}
}
