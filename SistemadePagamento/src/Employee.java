import java.util.Scanner;

public class Employee {
	
	// ----------------  TEMPO  --------------
	
	//  Necessita de duas vari�veis, uma para o dia do m�s e um vetor de 7 posi��es para o dia da semana,
	//primeiramente inicia as duas chamando  "iniciar---" de cada uma,
	//avan�a o dia chamando a fun��o "avancardia" colocando a vari�vel do mes para receber o retorno
	//para consultar qual o dia do m�s ou o dia da semana, somente � necess�rio chamar tais fun��es.
	
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
	public static int avancardia(int vetor[], int diadomes){ // Avan�a o dia da semana e o dia do m�s
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
	public static int diadomes(int dia){ // Retorna o dia do m�s
		return dia;
	}
	// -------------------------------------
	
	// ------------- ADI��O DE EMPREGADO -------------
	
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
				System.out.println("Limite m�ximo de empregados atingido ! "
						+ "Compre a vers�o PREMIUM para ter acesso a empregados ilimitados\n"
						+ "Ou delete algum empregado.\n\n");
			}
		}
	}
	public static void inserirendere�o(String endereco[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite o endere�o do empregado: ");
		String enderecodoempregado = input.next();
		
		for(aux = 0; aux<20; aux++){
			if(endereco[aux] == null){
				endereco[aux] = enderecodoempregado;
				System.out.println("Endere�o cadastrado com sucesso!\n\n");
			}else if(aux == 19){
				System.out.println("Limite m�ximo de endere�os atingido ! "
						+ "Compre a vers�o PREMIUM para ter acesso ilimitado\n"
						+ "Ou delete algum empregado.\n\n");
			}
		}
		
	}
	public static void inserirtipo(int tipos[]){
		
		int aux;
		Scanner input = new Scanner(System.in);
		System.out.println("Selecione o tipo de funcion�rio:\n1- Assalariado | 2- Horista | 3- Comissionado\n Funcion�rio tipo: ");
		
		int tipodigitado = input.nextInt();
		
		for(aux = 0; aux<20; aux++){
			
		}
		
	}
	//-----------------------------------------------
	
	

	public static void main(String[] args) {
		//-------------------------------------- DECLARA��ES ---------------------------------------------------
		
		// -- Vari�veis do Tempo -- 
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
			
			System.out.println("Seja bem vindo!\nSelecione uma das op��es abaixo:\n\n"
					+ "1- Adi��o de empregados\n"
					+ "2- Remo��o de empregados\n"
					+ "3- Lan�ar cart�o de ponto\n"
					+ "4- Lan�ar resultado de venda\n"
					+ "5- Lan�ar taxa de servi�o\n"
					+ "6- Alterar detalher de empregado\n"
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"
					+ "9- Agenda de pagamento\n"
					+ "10- Cria��o de novas agendas\n"
					+ "11- Nomes dos empregados\n"
					+ "0 - Para sair do programa\n\n");
			
			comando = input.nextInt();
			
			if(comando == 0){
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Adi��o de empregados");
					break;
				
				case 2:
					System.out.println("Remo��o de empregados");
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
					
					dmes = avancardia(semana,dmes);
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
					System.out.println("Listagem dos empregados");
				
				default:
					System.out.println("Por favor, insira um comando v�lido!");
					break;
			}
			
		}
	}

}
