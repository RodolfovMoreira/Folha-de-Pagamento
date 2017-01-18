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
		String nomedoempregado = input.next();
		
		for(aux = 0; aux<20; aux++){
			if(empregados[aux] == null){
				empregados[aux] = nomedoempregado;
				System.out.println("Empregado cadastrado com sucesso!\n\n");
			}else if(aux == 19){
				System.out.println("Limite máximo de empregados atingido ! "
						+ "Compre a versão PREMIUM para ter acesso a empregados ilimitados\n"
						+ "Ou delete algum empregado.\n\n");
			}
		}
	}
	public static void inserirendereço(String endereco[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o endereço do empregado: ");
		String enderecodoempregado = input.next();
		
		for(aux = 0; aux<20; aux++){
			if(endereco[aux] == null){
				endereco[aux] = enderecodoempregado;
				System.out.println("Endereço cadastrado com sucesso!\n\n");
			}else if(aux == 19){
				System.out.println("Limite máximo de endereços atingido ! "
						+ "Compre a versão PREMIUM para ter acesso ilimitado\n"
						+ "Ou delete algum empregado.\n\n");
			}
		}
		
	}
	public static void inserirtipo(int tipos[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o tipo de funcionário:\n1- Assalariado | 2- Horista | 3- Comissionado\n Funcionário tipo: ");
		
		int tipodigitado = input.nextInt();
		
		for(aux = 0; aux<20; aux++){
			
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
					+ "1- Adição de empregados\n"
					+ "2- Remoção de empregados\n"
					+ "3- Lançar cartão de ponto\n"
					+ "4- Lançar resultado de venda\n"
					+ "5- Lançar taxa de serviço\n"
					+ "6- Alterar detalher de empregado\n"
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"
					+ "9- Agenda de pagamento\n"
					+ "10- Criação de novas agendas\n"
					+ "11- Nomes dos empregados\n"
					+ "0 - Para sair do programa\n\n");
			
			comando = input.nextInt();
			
			if(comando == 0){
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Adição de empregados");
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
					System.out.println("Listagem dos empregados");
				
				default:
					System.out.println("Por favor, insira um comando válido!");
					break;
			}
			
		}
	}

}
