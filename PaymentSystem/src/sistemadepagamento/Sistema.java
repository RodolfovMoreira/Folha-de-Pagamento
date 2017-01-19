package sistemadepagamento;

import java.util.Scanner;

public class Sistema {
	
	//--------------------- Adi��o de Funcion�rio --------------------------
	public static void inserirNome(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o nome do empregado: ");
		fulano.nome = input.nextLine();
		System.out.println(" ");
	}
	public static void inserirEndereco(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o endere�o do empregado: ");
		fulano.adress = input.nextLine();
		System.out.println(" ");
	}
	public static void inserirTipo(Empregado fulano){
	
		Scanner input = new Scanner(System.in);
		System.out.print("Selecione o tipo de funcion�rio:\n\t1- Assalariado | 2- Horista | 3- Comissionado\n Funcion�rio tipo: ");
		fulano.type = input.nextInt();
		System.out.println(" ");
	}
	public static void inserirSalario(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o sal�rio do empregado: ");
		fulano.salario = input.nextDouble();
		System.out.println(" ");
	}

	public static int posicaoNovoFuncionario(Empregado[] trabalhadores){
		
		int aux;
		
		for(aux=0;aux<20;aux++){
			if(trabalhadores[aux] == null){
				break;
			}else if(aux == 19){
				System.out.println("Capacidade m�xima de funcion�rios atingida! "
						+ "Por favor, fa�a o upgrade para a vers�o premium ou delete algum funcion�rio.");
				aux = 30;
				break;
			}
		}
		return aux;
	}
	public static void adicionarFuncionario(Empregado[] trabalhadores){
		
		int posicao = posicaoNovoFuncionario(trabalhadores);
		Empregado fulano = new Empregado();
		
		if(posicao == 30){
			System.out.println("N�o foi poss�vel cadastrar o funcion�rio!");
		}else{
			inserirNome(fulano);
			inserirEndereco(fulano);
			inserirTipo(fulano);
			inserirSalario(fulano);
			
			trabalhadores[posicao] = fulano;
			System.out.println("\nFuncion�rio cadastrado com sucesso !\n\n");
		}
	}
	
	public static void listarFuncionarios(Empregado[] trabalhadores){
		
		int aux;
		Empregado fulano = new Empregado();
		
		System.out.println("Lista de funcion�rios atuais: \n");
		
		for(aux = 0; aux<20; aux++){
			if(trabalhadores[aux] != null){
				fulano = trabalhadores[aux];
				System.out.println("ID: " + aux + " Nome: " + fulano.nome + " Endere�o: " + fulano.adress + " Tipo: " + fulano.type + " Sal�rio: " + fulano.salario);
			}
		}
	}
	// ---------------------------------------------------------------------
	
	//------------------ Remo��o de Funcion�rio ----------------------------
	
	public static void listarIDs(Empregado[] trabalhadores){
		
		int aux;
		Empregado fulano = new Empregado();
		
		System.out.println("Lista de ID's: \n");
		
		for(aux = 0; aux<20; aux++){
			if(trabalhadores[aux] != null){
				fulano = trabalhadores[aux];
				System.out.println("ID: " + aux + " Nome: " + fulano.nome);
			}
		}
	}
	public static void deletarFuncionario(Empregado[] trabalhadores){
		
		Scanner input = new Scanner(System.in);
		int id;
		
		listarIDs(trabalhadores);
		System.out.println("Digite a ID do funcion�rio: ");
		
		id = input.nextInt();
		
		trabalhadores[id] = null;
		System.out.println("Funcion�rio removido.\n");
	}
	// ---------------------------------------------------------------------
	
	
	
	public static void main(String[] args) {
		
		Empregado[] trabalhadores = new Empregado[20]; //Empty vector of objects - NULL by DEFAULT
		
		//---------------------- INTERFACE ---------------------------
		int comando = 1;
		Scanner input = new Scanner(System.in);
		
		
		while(comando != 0){
			
			System.out.println("Seja bem vindo!\nSelecione uma das op��es abaixo:\n\n"
					+ "1- Adi��o de empregados\n"          // feito           
					+ "2- Remo��o de empregados\n"		   // feito
					+ "3- Lan�ar cart�o de ponto\n"
					+ "4- Lan�ar resultado de venda\n"
					+ "5- Lan�ar taxa de servi�o\n"
					+ "6- Alterar detalher de empregado\n"
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"
					+ "9- Agenda de pagamento\n"
					+ "10- Cria��o de novas agendas\n"
					+ "11- Listar dos empregados\n"         // feito    
					+ "0 - Para sair do programa\n\n");
			
			comando = input.nextInt();
			
			if(comando == 0){
				System.out.println("Obrigado por utilizar o Sistema !");
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Sistema de adi��o de empregado - \n");
					adicionarFuncionario(trabalhadores);
					break;
				
				case 2:
					System.out.println("Remo��o de empregados-\n");
					deletarFuncionario(trabalhadores);
					break;
					
				case 3:
					System.out.println("Lan�ar cart�o de ponto");
					break;
				
				case 4:
					System.out.println("Lan�ar resultado de venda");
					break;
					
				case 5:
					System.out.println("Lan�ar taxa de venda");
					break;
				
				case 6:
					System.out.println("Alterar detalhes de um empregado");
					break;
					
				case 7:
					System.out.println("Rodar folha de pagamento");
					break;
					
				case 8:
					System.out.println("Undo/Redo");
					break;
					
				case 9:
					System.out.println("Agenda de Pagamento");
					break;
					
				case 10:
					System.out.println("Cria��o de novas agendas");
					break;
					
				case 11:
					listarFuncionarios(trabalhadores);
					break;
				
				default:
					System.out.println("Por favor, insira um comando v�lido!");
					break;

			}
		}
		
		// -----------------------------------------------------------------------------------------
	}
}
