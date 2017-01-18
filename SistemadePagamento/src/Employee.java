import java.util.Scanner;

public class Employee {
	
	// ----------------  TEMPO  --------------
	
	//  Necessita de duas variáveis, uma para o dia do mês e um vetor de 7 posições para o dia da semana,
	//primeiramente inicia as duas chamando  "iniciar---" de cada uma,
	//avança o dia chamando a função "avancardia" colocando a variável do mes para receber o retorno
	//para consultar qual o dia do mês ou o dia da semana, somente é necessário chamar tais funções.
	
	public static int iniciarmes(int diadomes){ // Inicia o dia do mes para 1
		diadomes = 1;
		
		return diadomes;
	}
	public static int[] iniciarciclodosdias(int vetor[]){ // Inicia o dia da semana para segunda
		vetor[0] = 1;
		
		return vetor;
	}
	
	public static void ciclo(int vetor[]){ // Avanca o dia da semana
		int x;
		
		for(x=0;x<7;x++){
			if(vetor[x] == 1){
				if(x == 6){
					vetor[x] = 0;
					vetor[0] = 1;
				}else{
					vetor[x] = 0;
					vetor[x+1] = 1;	
				}
			break;
			}
		}
	}
	public static int ciclo2(int dia){
		if(dia == 30){
			dia = 1;
		}else{
			dia = dia+1;
		}
		
		return dia;
	}
	public static int avancardia(int vetor[], int diadomes){ // Avança o dia da semana e o dia do mês
		ciclo(vetor);
		diadomes = ciclo2(diadomes);
		
		return diadomes;
	}
	
	public static int diadasemana(int vetor[]){ // Retorna o dia da semana
		int x;
		
		for(x=0;x<7;x++){
			if(vetor[x] == 1)
			break;
		}
		return ++x;
	}
	public static int diadomes(int dia){ // Retorna o dia do mês
		return dia;
	}
	// -------------------------------------
	
	// ------------- ADIÇÃO DE EMPREGADO -------------
	
	public static void inserirnome(String empregados[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o nome do empregado: ");
		String nomedoempregado = input.nextLine();
		
		for(aux = 0; aux<20; aux++){
			if(empregados[aux] == null){
				empregados[aux] = nomedoempregado;
				System.out.println("Empregado cadastrado com sucesso!\n\n");
				break;
			}else if(aux == 19){
				System.out.println("Limite máximo de empregados atingido ! "
						+ "Compre a versão PREMIUM para ter acesso a empregados ilimitados\n"
						+ "Ou delete algum empregado.\n\n");
				break;
			}
		}
	}
	public static void inserirendereco(String endereco[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o endereço do empregado: ");
		String enderecodoempregado = input.nextLine();
		
		for(aux = 0; aux<20; aux++){
			if(endereco[aux] == null){
				endereco[aux] = enderecodoempregado;
				System.out.println("Endereço cadastrado com sucesso!\n\n");
				break;
			}else if(aux == 19){
				System.out.println("Limite máximo de endereços atingido ! "
						+ "Compre a versão PREMIUM para ter acesso ilimitado\n"
						+ "Ou delete algum empregado.\n\n");
				break;
			}
		}
		
	}
	public static void inserirtipo(int tipos[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		System.out.print("Selecione o tipo de funcionário:\n1- Assalariado | 2- Horista | 3- Comissionado\n Funcionário tipo: ");
		
		int tipodigitado = input.nextInt();
		
		for(aux = 0; aux<20; aux++){
			if(tipos[aux] == 0){
				tipos[aux] = tipodigitado;
				System.out.println("Tipo cadastrado com sucesso!\n\n");
				break;
			}else if(aux == 19){
				System.out.println("Limite máximo de tipos atingido ! "
						+ "Compre a versão PREMIUM para ter acesso ilimitado\n"
						+ "Ou delete algum empregado.\n\n");
				break;
			}
		}
		
	}
	public static void inserirsalario(double salariobase[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		System.out.print("Insira o salário base do funcionário: ");
		
		double salario = input.nextDouble();
		
		for(aux = 0; aux<20; aux++){
			if(salariobase[aux] == 0.0){
				salariobase[aux] = salario;
				System.out.println("Salário cadastrado com sucesso!\n\n");
				break;
			}else if(aux == 19){
				System.out.println("Limite máximo de salários atingido ! "
						+ "Compre a versão PREMIUM para ter acesso ilimitado\n"
						+ "Ou delete algum empregado.\n\n");
				break;
			}
		}
	}
	
	public static void adicionarfuncionario(String empregados[], String endereco[], int tipos[], double salario[]){
		inserirnome(empregados);
		inserirendereco(endereco);
		inserirtipo(tipos);
		inserirsalario(salario);
		
		System.out.println("Empregado cadastrado com sucesso !\n\n\n");
	}
	
	public static void listarfuncionarios(String empregados[], String endereco[], int tipos[], double salario[]){
		
		int aux;
		
		for(aux=0;aux<20;aux++){
			if(empregados[aux] == null){
				System.out.println(aux + " Empregados cadastrados.");
				break;
			}else{
				System.out.println(aux + ". " + empregados[aux] + " | Endereço: " + endereco[aux] + " | Tipo: " + tipos[aux] + " | Salário base: " + salario[aux]);
			}
		}
	}
	//-----------------------------------------------
	
	

	public static void main(String[] args) {
		//-------------------------------------- DECLARAÇÕES ---------------------------------------------------
		
		// -- Variáveis do Tempo -- 
		int semana[] = new int[7];
		int dmes = 0;
		int conferemes, conferesemana;
		
		semana = iniciarciclodosdias(semana);
		dmes = iniciarmes(dmes);
		//-----------------------------
		
		//---------- Atributos -----------
		
		String empregados[] = new String[20]; 
		String endereco[] = new String[20];
		int tipodeempregado[] = new int[20]; // Comissionado/Assalariado/Horista
		double salariobase[] = new double[20]; 
		
		// -------------------------------
		
		
		// ------------------------------------------------------------------------------------------------------
		
		int comando = 1;
		Scanner input = new Scanner(System.in);
		
		
		while(comando != 0){
			
			System.out.println("Seja bem vindo!\nSelecione uma das opções abaixo:\n\n"
					+ "1- Adição de empregados\n"                      //feito
					+ "2- Remoção de empregados\n"
					+ "3- Lançar cartão de ponto\n"
					+ "4- Lançar resultado de venda\n"
					+ "5- Lançar taxa de serviço\n"
					+ "6- Alterar detalher de empregado\n"
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"
					+ "9- Agenda de pagamento\n"
					+ "10- Criação de novas agendas\n"
					+ "11- Listar dos empregados\n"                    // feito
					+ "0 - Para sair do programa\n\n");
			
			comando = input.nextInt();
			
			if(comando == 0){
				System.out.println("Obrigado por utilizar o Sistema !");
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Sistema de adição de empregado:");
					adicionarfuncionario(empregados,endereco,tipodeempregado,salariobase);
					break;
				
				case 2:
					System.out.println("Remoção de empregados");
					break;
					
				case 3:
					System.out.println("Lançar cartão de ponto");
					break;
				
				case 4:
					System.out.println("Lançar resultado de venda");
					break;
					
				case 5:
					System.out.println("Lançar taxa de venda");
					break;
				
				case 6:
					System.out.println("Alterar detalhes de um empregado");
					break;
					
				case 7:
					System.out.println("Rodar folha de pagamento");
					
					dmes = avancardia(semana,dmes);
					break;
					
				case 8:
					System.out.println("Undo/Redo");
					break;
					
				case 9:
					System.out.println("Agenda de Pagamento");
					break;
					
				case 10:
					System.out.println("Criação de novas agendas");
					break;
					
				case 11:
					System.out.println("Listagem dos empregados:\n");
					
					listarfuncionarios(empregados, endereco, tipodeempregado, salariobase);
					
					System.out.println("\n");
				
				default:
					System.out.println("Por favor, insira um comando válido!");
					break;
			}
			
		}
	}

}
