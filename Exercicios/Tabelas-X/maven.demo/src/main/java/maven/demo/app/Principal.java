package maven.demo.app;

import java.util.List;
import java.util.Scanner;

import maven.demo.dao.UsuarioDAO;
import maven.demo.model.Usuario;

public class Principal {
	private static UsuarioDAO uDAO = new UsuarioDAO();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			
			System.out.println("\n(1) Listar\n(2) Inserir\n(3) Excluir\n(4) Atualizar\n(5) Sair\n");
			System.out.print("? ");
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
				case 1:
					listUsers();
					break;
					
				case 2:
					if(insertUser(sc)) System.out.println("Usuario inserido com sucesso!");
					else System.out.println("Usuario não foi inserido adequadamente...");
					break;
				
				case 3:
					if(deleteUser(sc)) System.out.println("Usuario removido com sucesso!");
					else System.out.println("Usuario não foi removido adequadamente...");
					break;
					
				case 4:
					if(updateUser(sc)) System.out.println("Usuario atualizado com sucesso!");
					else System.out.println("Usuario não foi atualizado adequadamente...");
					break;
					
				case 5:
					System.out.println("Finalizando...");
					uDAO.close();
					break;
			}
			
		} while(op != 5);
		sc.close();
		System.out.println("Finalizado");
	}
	
	public static boolean updateUser(Scanner sc) {
		String login = "",
			   senha = "";
		char sexo = '\0';
		int codigo = 0;

		System.out.println("Especificações do usuário: ");
		System.out.print("Código: ");
		codigo = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		System.out.print("Login: ");
		login = sc.nextLine();
		System.out.println();

		System.out.print("Senha: ");
		senha = sc.nextLine();
		System.out.println();

		System.out.print("Sexo: ");
		sexo = sc.nextLine().toUpperCase().charAt(0);
		System.out.println();
		boolean res = uDAO.update(new Usuario(codigo, login, senha, sexo));
		return res;
	}
	
	public static boolean deleteUser(Scanner sc) {
		System.out.print("Código do usuário: ");
		int op = Integer.parseInt(sc.nextLine());
		boolean res = uDAO.delete(op);
		return res;
	}
	
	public static void listUsers() {
		List<Usuario> l = uDAO.get("codigo");
		for(Usuario u : l) {
			System.out.println(u.toString());
		}
	}
	
	public static boolean insertUser(Scanner sc) {
		String login = "",
			   senha = "";
		char sexo = '\0';

		System.out.println("Especificações do usuário: ");
		System.out.print("Login: ");
		login = sc.nextLine();
		System.out.println();

		System.out.print("Senha: ");
		senha = sc.nextLine();
		System.out.println();

		System.out.print("Sexo: ");
		sexo = sc.nextLine().toUpperCase().charAt(0);
		System.out.println();
		
		Usuario u = new Usuario(Usuario.getNextCode(), login, senha, sexo);
		Usuario.increment();
		boolean res = uDAO.insert(u);
		return res;
	}	
	
}
