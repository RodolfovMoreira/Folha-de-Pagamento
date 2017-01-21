package sistemadepagamento;

import java.util.Scanner;

public class Sistema {
	
	//--------------------- Adi��o de Funcion�rio --------------------------
	public static void inserirNome(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o nome do empregado: ");
		fulano.nome = input.nextLine();
	}
	public static void inserirEndereco(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o endere�o do empregado: ");
		fulano.adress = input.nextLine();
	}
	public static void inserirTipo(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Selecione o tipo de funcion�rio:\n\t1- Assalariado | 2- Horista | 3- Comissionado\n Funcion�rio tipo: ");
		fulano.type = input.nextInt();
		fulano.metodopagamento = 3;
	}
	public static void inserirSalario(Empregado fulano){
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o sal�rio do empregado: ");
		fulano.salario = input.nextDouble();
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
			fulano.idsindicato = posicao;
			
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
		
		System.out.println("Lista de ID's: ");
		
		for(aux = 0; aux<20; aux++){
			if(trabalhadores[aux] != null){
				fulano = trabalhadores[aux];
				System.out.println("ID: " + aux + " Nome: " + fulano.nome);
			}
		}
		System.out.println(" ");
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
	
    //----------------- Lan�amento de Cart�o de Ponto -----------------------
        
    public static void listarIDsHoristas(Empregado[] trabalhadores){
		
		int aux;
		Empregado fulano = new Empregado();
		
		System.out.println("Lista de ID's: ");
		
		for(aux = 0; aux<20; aux++){
			if(trabalhadores[aux] != null){
				fulano = trabalhadores[aux];
                                if(fulano.type == 2)
				System.out.println("ID: " + aux + " Nome: " + fulano.nome);
			}
		}
		System.out.println(" ");
	}
    public static void inserirHora(Empregado[] trabalhadores){
            
            Scanner input = new Scanner(System.in);
            int id,horas;
            int h_semana;
            int h_extra;
            
		
            listarIDsHoristas(trabalhadores);
            System.out.print("Digite a ID do funcion�rio que ir� submeter o cart�o de ponto: ");
            
            id = input.nextInt();
            
            Empregado fulano = trabalhadores[id];
            h_extra = fulano.horasextras;
            h_semana = fulano.horassemana;
            
           System.out.print("Digite as horas pagas: "); 
          
           horas = input.nextInt();
           
           h_semana = h_semana+horas;
           h_extra = h_extra + (horas-8);
          
           if(horas <= 8){ 
               fulano.horassemana= h_semana; 
           }else{
               h_semana = fulano.horassemana;
               fulano.horassemana = h_semana + 8;
               fulano.horasextras = h_extra;
           }
           listarHorasPagas(trabalhadores,id);
           System.out.println("\nHoras adicionadas com sucesso !");
        }
    public static void listarHorasPagas(Empregado[] trabalhadores, int id){
		
            Empregado fulano = new Empregado();
			
            fulano = trabalhadores[id];
            System.out.println("Empregado: " + fulano.nome + " | Horas: " + fulano.horassemana + " | Horas extras: " + fulano.horasextras);			
	}
        
    //-----------------------------------------------------------------------
    
    //---------------- Lan�amento de Resultado de Venda ---------------------
    
    public static void listarIDsComissionados(Empregado[] trabalhadores){
		
		int aux;
		Empregado fulano = new Empregado();
		
		System.out.println("Lista de ID's: ");
		
		for(aux = 0; aux<20; aux++){
			if(trabalhadores[aux] != null){
				fulano = trabalhadores[aux];
                                if(fulano.type == 3)
				System.out.println("ID: " + aux + " Nome: " + fulano.nome);
			}
		}
		System.out.println(" ");
	}
    
    public static void lancarResultadoVenda(Empregado[] trabalhadores){

        Scanner input = new Scanner(System.in);
        int ID, data;
        double valor, aux;
        
        listarIDsComissionados(trabalhadores);
        System.out.print("Digite o ID do funcion�rio em que deseja lan�ar uma venda: ");
        
        ID = input.nextInt();
        Empregado fulano = trabalhadores[ID];
        
        System.out.print("Digite o valor da venda: ");
        valor = input.nextDouble();
         
        System.out.print("Digite o dia da venda: ");
        data = input.nextInt();
        
        aux = fulano.vendasacumuladas;
        aux = aux + valor;
        
        fulano.vendasacumuladas = aux;
        
        System.out.println("O valor acumulado agora �: " + aux);
    }
    
    //-----------------------------------------------------------------------
    
    //---------------- Lan�ar Taxa de Servi�o ------------------------------
  
    public static void inserirTaxaServico(Empregado[] trabalhadores){
    	
        Scanner input = new Scanner(System.in);
        int ID;
        double taxa;
        
        listarIDsComissionados(trabalhadores);
        System.out.print("Digite o ID do funcion�rio em que deseja lan�ar uma taxa de servi�o: ");
        
        ID = input.nextInt();
        
        Empregado fulano = trabalhadores[ID];
        
        System.out.print("Digite o valor da taxa: ");
        
        taxa = input.nextDouble();
        fulano.taxadeservico = taxa;
        
        System.out.println("A taxa de servi�o do empregado " + fulano.nome + " agora � " + fulano.taxadeservico);
    }
    
    //-----------------------------------------------------------------------
    
    //--------------- Alterar detalhes do Empregado -------------------------
    
    public static void alterarNome(Empregado fulano, int ID){
        
    	Scanner input = new Scanner(System.in);
        String nome;
        
        System.out.print("---------------------------------\nDigite o nome correto do empregado: ");
        
        nome = input.nextLine();
        fulano.nome = nome;
        System.out.println("Nome alterado com sucesso!\n---------------------------------");
    }
    public static void alterarEndereco(Empregado fulano, int ID){
    	
    	Scanner input = new Scanner(System.in);
        String endereco;
        
        System.out.print("---------------------------------\nDigite o endere�o correto do empregado: ");
        
        endereco = input.nextLine();
        fulano.adress = endereco;
        System.out.println("Endere�o alterado com sucesso!\n---------------------------------");
    }
    public static void alterarTipo(Empregado fulano, int ID){
    	
    	Scanner input = new Scanner(System.in);
        int tipo;
        
        System.out.print("---------------------------------\nDigite o tipo correto do empregado. (1- Assalariado | 2- Horista | 3- Comissionado)\nTipo: ");
        
        tipo = input.nextInt();
        fulano.type = tipo;
        System.out.println("Tipo alterado com sucesso!\n---------------------------------");
    }
    public static void alterarMetodoPagamento(Empregado fulano, int ID){
    	
    	Scanner input = new Scanner(System.in);
        int metodo;
        
        System.out.print("---------------------------------\nDigite o novo m�todo de pagamento do empregado:  "
        		+ "(1- Cheque por Correios | 2- Cheque em M�os | 3- Dep�sito em Conta)\n"
        		+ "M�todo: ");
        
        metodo = input.nextInt();
        fulano.metodopagamento = metodo;
        System.out.println("M�todo de pagamento alterado com sucesso!\n---------------------------------");
    }
    public static void alterarPertenceSindicato(Empregado fulano, int ID){
    	
    	Scanner input = new Scanner(System.in);
        
        System.out.print("---------------------------------\nDigite '1' se faz parte do Sindicato ou '0' se n�o faz parte: ");
        
        fulano.pertencesindicato = input.nextInt();
        System.out.println("Altera�ao feita com sucesso!\n---------------------------------");
    }
    public static void alterarIDSindicato(Empregado fulano, int ID, Empregado[] trabalhadores){
    	
    	Scanner input = new Scanner(System.in);
        Empregado sicrano;
    	int novoid, aux, confere;
        
        System.out.print("---------------------------------\nDigite o novo ID do Sindicato que deseja: ");
        
        novoid = input.nextInt();
        
        for(aux = 0; aux < 20; aux++){
        	sicrano = trabalhadores[aux];
        	confere = sicrano.idsindicato;
        	
        	if(confere == novoid){
        		System.out.println("Este ID ja est� sendo usado por outro empregado!\n---------------------------------");
        		break;
        	}else if(aux == 19){
        		fulano.idsindicato = novoid;
                System.out.println("Altera�ao feita com sucesso!\n---------------------------------");
        		break;
        	}
        }
        
        System.out.println("Endere�o alterado com sucesso!\n---------------------------------");
    }
    public static void alterarTaxaSindical(Empregado fulano, int ID){
    	
    	Scanner input = new Scanner(System.in);
        double taxa;
        
        System.out.print("---------------------------------\nDigite a taxa sindical correta: ");
        
        taxa = input.nextDouble();
        fulano.taxasindical = taxa;
        System.out.println("Taxa sindical alterada com sucesso!\n---------------------------------");
    }
    
    public static void alterarDadosdoEmpregado(Empregado[] trabalhadores){
    	
    	Scanner input = new Scanner(System.in);
        int ID, comando;
        Empregado fulano;
        
        listarIDs(trabalhadores);
        System.out.print("\nDigite o ID do funcion�rio no qual deseja alterar algum dado: ");
        
        ID = input.nextInt();
        fulano = trabalhadores[ID];
        comando = 1;
        
        while(comando != 0){
            System.out.println("-----------------------------------------------------------\n"
            		+ "Selecione o dado que deseja alterar de: "+ fulano.nome +"\n" 
            		+ "1 - Nome\n"
            		+ "2 - Endere�o\n"
            		+ "3 - Tipo\n"
            		+ "4 - M�todo de Pagamento\n"
            		+ "5 - Participa��o no Sindicato\n"
            		+ "6 - ID do Sindicato\n"
            		+ "7 - Taxa Sindical\n"
            		+ "0 - Para voltar ao Menu Principal\n"
            		+ "-----------------------------------------------------------\n");
            
            comando = input.nextInt();
            
            if(comando == 0){
            	System.out.println("\n\n\n\n");
            	break;
            }
            
            switch(comando){
            	case 1:
            		alterarNome(fulano,ID);
            		break;
            		
            	case 2:
            		alterarEndereco(fulano,ID);
            		break;
            	
            	case 3:
            		alterarTipo(fulano,ID);
            		break;
            		
            	case 4:
            		alterarMetodoPagamento(fulano,ID);
            		break;
            		
            	case 5:
            		alterarPertenceSindicato(fulano,ID);
            		break;
            		
            	case 6:
            		alterarIDSindicato(fulano,ID,trabalhadores);
            		break;
            		
            	case 7:
            		alterarTaxaSindical(fulano,ID);
            		break;
            		
            	default:
					System.out.println("Por favor, insira um comando v�lido!");
					break;
            }
            
        }
        
    }
    
    //-----------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		
		Empregado[] trabalhadores = new Empregado[20]; //Empty vector of objects - NULL by DEFAULT
		
		//---------------------- INTERFACE ---------------------------
		int comando = 1;
		Scanner input = new Scanner(System.in);
		
		
		while(comando != 0){
			
			System.out.println("----------------------------------------------------\n"
                                + "Seja bem vindo!\nSelecione uma das op��es abaixo:\n\n"
					+ "1- Adi��o de empregados\n"          // feito           
					+ "2- Remo��o de empregados\n"		   // feito
					+ "3- Lan�ar cart�o de ponto\n"        // feito
					+ "4- Lan�ar resultado de venda\n"     // feito
					+ "5- Lan�ar taxa de servi�o\n"		   // feito
					+ "6- Alterar detalher de empregado\n" 
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"
					+ "9- Agenda de pagamento\n"
					+ "10- Cria��o de novas agendas\n"
					+ "11- Listar dos empregados\n"         // feito    
					+ "0 - Para sair do programa\n"         // feito
                                + "----------------------------------------------------\n\n\n\n\n\n\n\n\n\n\n");
			
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
					System.out.println("Lan�ar cart�o de ponto-");
                    inserirHora(trabalhadores);
					break;
				
				case 4:
					System.out.println("Lan�ar resultado de venda-");
					lancarResultadoVenda(trabalhadores);
					break;
					
				case 5:
					System.out.println("Lan�ar taxa de venda");
					inserirTaxaServico(trabalhadores);
					break;
				
				case 6:
					System.out.println("Alterar detalhes de um empregado");
					alterarDadosdoEmpregado(trabalhadores);
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
