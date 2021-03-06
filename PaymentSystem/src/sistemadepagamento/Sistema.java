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
		
		int tipo;
		Scanner input = new Scanner(System.in);
		System.out.print("Selecione o tipo de funcion�rio:\n\t1- Assalariado | 2- Horista | 3- Comissionado\n Funcion�rio tipo: ");
		tipo = input.nextInt();
		fulano.type = tipo;
		fulano.metodopagamento = 3; // Por default todos recebem dep�sito banc�rio
		
		if(tipo == 1){
			fulano.tipodepagamento = 1;
			fulano.diadepagamento = 30;
		}else if(tipo == 2){
			fulano.tipodepagamento = 2;
			fulano.diadepagamento = 6;
		}else{
			fulano.tipodepagamento = 3;
			fulano.diadepagamento = 13;
		}
		
		fulano.taxadeservico = 0.1;
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
        Empregado sicrano = new Empregado();
    	int novoid, aux, confere,check;
        
        System.out.print("---------------------------------\nDigite o novo ID do Sindicato que deseja: ");
        
        novoid = input.nextInt();
        
        check = 10;
        
        for(aux = 0; aux < 20; aux++){
        	if(trabalhadores[aux] != null){
            	sicrano = trabalhadores[aux];
            	confere = sicrano.idsindicato;
            	
            	if(confere == novoid){
            		System.out.println("Este ID ja est� sendo usado por outro empregado!\n---------------------------------");
            		check = 1;
            		break;
            	}else if(aux == 19){
            		fulano.idsindicato = novoid;
                    System.out.println("Altera�ao feita com sucesso!\n---------------------------------");
            		break;
            	}	
        	}
        }
        if((aux != 19)&&(check == 10)){
        	fulano.idsindicato = novoid;
        	 System.out.println("Novo ID : "+ fulano.idsindicato +"\nAltera�ao feita com sucesso!\n---------------------------------");
        }
        
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
    
    //----------------------Undo/Redo----------------------------------------
    
    public static void saveUndoRedo(Empregado[] trabalhadores, Empregado[] undoredo){
    	
    	int aux;
    	
    	for(aux = 0;aux < 20; aux++){
    		//if(trabalhadores[aux] != null){
    			undoredo[aux] = trabalhadores[aux];
    		//}
    	}
    }
    
    public static void useUndoRedo(Empregado[] trabalhadores, Empregado[] undoredo){
    	
    	int aux;
    	
    	for(aux = 0;aux < 20; aux++){
    		//if(undoredo[aux] != null){
    			trabalhadores[aux] = undoredo[aux];
    		//}
    	}
    }
    
    public static void selectionUndoRedo(Empregado[] trabalhadores,Empregado[] undo, Empregado[] redo){
    	
    	Scanner input = new Scanner(System.in);
    	int selecao;
    	
    	System.out.print("---------------------------------\nSelecione uma das op��es:\n"
    			+ "1 - Undo\n"
    			+ "2 - Redo\n---------------------------------\n");
    	
    	selecao = input.nextInt();
    	
    	if(selecao == 1){
    		useUndoRedo(trabalhadores,undo);
    		System.out.println("UNDO foi um sucesso!");
    	}else if(selecao == 2){
    		useUndoRedo(trabalhadores,redo);
    		System.out.println("REDO foi um sucesso!");
    	}else{
    		System.out.println("Digite um comando v�lido!.");
    	}
    	
    }
    
    //-----------------------------------------------------------------------
    
    //----------------- Agenda de Pagamento ---------------------------------
    
    public static int consultarMensal(Empregado fulano){
    	
    	int retorno = 0;
    	int aux;
    	int[] alt_mensalmente = {3,4,5,6,10,11,12,13,17,18,19,20,24,25,26,27,30}; // 17 pos
    	
    	for(aux=0;aux<17;aux++){
    		if(alt_mensalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
    			break;
    		}
    	}
   
    	return retorno;
    }
    public static int consultarSemanal(Empregado fulano){
    	
    	int retorno = 0;
    	int aux;
    	
		int[] semanalmente = {6,13,20,27}; // 4 pos
		int[] alt_semanalmente = {3,10,17,24}; // 4 pos
		int[] alt1_semanalmente = {4,11,18,25}; // 4 pos
		int[] alt2_semanalmente = {5,12,19,26}; // 4 pos
		
    	for(aux=0;aux<4;aux++){
    		if(semanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
				System.out.println(semanalmente[0] + ", " + semanalmente[1] + ", " + semanalmente[2] + ", " + semanalmente[3] + "!");
    			break;
    		}else if(alt_semanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
    				System.out.println(alt_semanalmente[0] + ", " + alt_semanalmente[1] + ", " + alt_semanalmente[2] + ", " + alt_semanalmente[3] + "!");
    			break;
    		}else if(alt1_semanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
				System.out.println(alt1_semanalmente[0] + ", " + alt1_semanalmente[1] + ", " + alt1_semanalmente[2] + ", " + alt1_semanalmente[3] + "!");
    			break;
    		}else if(alt2_semanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
				System.out.println(alt2_semanalmente[0] + ", " + alt2_semanalmente[1] + ", " + alt2_semanalmente[2] + ", " + alt2_semanalmente[3] + "!");
    			break;
    		}
    	}
   
    	return retorno;
    }
    public static int consultarBiMensal(Empregado fulano){
    	
    	int retorno = 0;
    	int aux;
		int[] bisemanalmente = {13, 27};  // 2 pos
		int[] alt_bisemanalmente = {6,20}; // 2 pos
		
    	for(aux=0;aux<2;aux++){
    		if(bisemanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
				System.out.println(bisemanalmente[0] + ", " + bisemanalmente[1] + "!");
    			break;
    		}else if(alt_bisemanalmente[aux] == fulano.diadepagamento){
    			retorno = 1;
				System.out.println(alt_bisemanalmente[0] + ", " + alt_bisemanalmente[1] + "!");
    			break;
    		}
    	}
   
    	return retorno;
    }
    
    public static void consultarAgenda(Empregado[] trabalhadores){
    	
    	Scanner input = new Scanner(System.in);
    	int ID;
    	Empregado fulano = new Empregado();
    	
    	listarIDs(trabalhadores);

    	System.out.print("---------------------------------\nDigite o ID do funcion�rio no qual deseja consultar a agenda: ");
    	
    	ID = input.nextInt();
    	
    	fulano = trabalhadores[ID];
    	
    	if(fulano.tipodepagamento == 1){
    		System.out.println("O dia de pagamento de " + fulano.nome + " � todo dia " + fulano.diadepagamento + "!");
    	}else if(fulano.tipodepagamento == 2){
    		System.out.println("Os dias de pagamento de " + fulano.nome + " ser�o: ");
    		consultarSemanal(fulano);
    	}else if(fulano.tipodepagamento == 3){
    		System.out.print("Os dias de pagamento de " + fulano.nome + " ser�o: ");
    		consultarBiMensal(fulano);
    	}
    	System.out.println("---------------------------------");
    }
    
    //-----------------------------------------------------------------------
    
    //---------------- Cria��o de Novas Agendas de Pagamento ----------------
    
    public static void alterarAgenda(Empregado[] trabalhadores){
    	
    	Scanner input = new Scanner(System.in);
    	int ID, tipo, escolha;
    	Empregado fulano = new Empregado();
    	
    	listarIDs(trabalhadores);

    	System.out.print("---------------------------------\nDigite o ID do funcion�rio no qual deseja alterar a agenda: ");
    	
    	ID = input.nextInt();
    	
    	fulano = trabalhadores[ID];
    	tipo = fulano.type;
    	
    	if(tipo == 1){
			System.out.println("\n\nEscolha um dos n�meros abaixo para ser o novo dia de pagamento:\n3,4,5,6,10,11,12,13,17,18,19,20,24,25,26,27 ou 30\nDia: ");
			escolha = input.nextInt();
			fulano.diadepagamento = escolha;
			System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
		}else if(tipo == 2){
			System.out.println("\n\nEscolha uma das op��es abaixo para ser os novos dias de pagamento:\n1- Dias: 6,13,20 e 27\n2- Dias: 3, 10, 17 e 24\n3- Dias: 4, 11, 18 e 25\n"
					+ "4- Dias: 5, 12, 19 e 26\n\nEscolha: ");
			escolha = input.nextInt();
			
			if(escolha == 1){
				fulano.diadepagamento = 6;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else if(escolha == 2){
				fulano.diadepagamento = 3;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else if(escolha == 3){
				fulano.diadepagamento = 4;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else if(escolha == 4){
				fulano.diadepagamento = 5;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else{
				System.out.println("ERRO! Na pr�xima vez selecione um n�mero certo!");
			}
		}else{
			System.out.println("\n\nEscolha um dos n�meros abaixo para ser o novo dia de pagamento:\n1- Dias: 13 e 27\n2- Dias: 6 e 20\nEscolha: ");
			escolha = input.nextInt();
			
			if(escolha == 1){
				fulano.diadepagamento = 13;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else if(escolha == 2){
				fulano.diadepagamento = 6;
				System.out.println("Dia de pagamento alterado com sucesso!\n---------------------------------");
			}else{
				System.out.println("ERRO! Na pr�xima vez selecione um n�mero certo!");
			}
		}
    }
    
    //-----------------------------------------------------------------------
    
	//--------------------- Rodar Folha de Pagamento ------------------------
    
    public static void printPaymentMensal(Empregado fulano){
    	
    	int confere;
    	String metodo1 = "cheque pelos correios.";
    	String metodo2 = "cheque em m�os.";
    	String metodo3 = "dep�sito banc�rio.";
    	
    	confere = fulano.metodopagamento;
    	
		System.out.print(fulano.nome + " ser� pago hoje o valor de R$ " + fulano.salario + " por ");
		
		if(confere == 1){
			System.out.print(metodo1);
		}else if(confere == 2){
			System.out.print(metodo2);
		}else if(confere == 3){
			System.out.print(metodo3);
		}
		System.out.println(" ");
    }
    public static void printPaymentHorista(Empregado fulano){
    	
    	int confere;
    	double salario, total, totalextra;
    	
    	String metodo1 = "cheque pelos correios.";
    	String metodo2 = "cheque em m�os.";
    	String metodo3 = "dep�sito banc�rio.";
    	
    	confere = fulano.metodopagamento;
    	salario = fulano.salario;
    	total = fulano.horassemana;
    	totalextra = fulano.horasextras;
    	
    	total = total*salario;
    	total = total + (totalextra*1.5*salario);
    	if(total != 0){
    		System.out.print(fulano.nome + " ser� pago hoje o valor de R$ " + total + " por ");
    		
    		if(confere == 1){
    			System.out.print(metodo1);
    		}else if(confere == 2){
    			System.out.print(metodo2);
    		}else if(confere == 3){
    			System.out.print(metodo3);
    		}
    		System.out.println(" ");
    	}

		fulano.horasextras = 0;
		fulano.horassemana = 0;
    }
    public static void printPaymentComissionado(Empregado fulano){
    	
    	int confere;
    	double total, metadesalario;
    	
    	String metodo1 = "cheque pelos correios.";
    	String metodo2 = "cheque em m�os.";
    	String metodo3 = "dep�sito banc�rio.";
    	
    	confere = fulano.metodopagamento;
    	
    	metadesalario = fulano.salario/2;
    	total = fulano.vendasacumuladas * fulano.taxadeservico;
    	
    	total = total+metadesalario;
    	
    	if(total != 0){
    		System.out.print(fulano.nome + " ser� pago hoje o valor de R$ " + total + " por ");
    		
    		if(confere == 1){
    			System.out.print(metodo1);
    		}else if(confere == 2){
    			System.out.print(metodo2);
    		}else if(confere == 3){
    			System.out.print(metodo3);
    		}
    		System.out.println(" ");
    	}
		
		fulano.vendasacumuladas = 0;
    }

    public static int confere6(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
    	int[] semanalmente = {6,13,20,27}; // 4 pos
    	
    	for(aux=0; aux<4; aux++){
    		if(semanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }
    public static int confere3(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
		int[] alt_semanalmente = {3,10,17,24}; // 4 pos
    	
    	for(aux=0; aux<4; aux++){
    		if(alt_semanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }
    public static int confere4(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
		int[] alt1_semanalmente = {4,11,18,25}; // 4 pos
    	
    	for(aux=0; aux<4; aux++){
    		if(alt1_semanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }
    public static int confere5(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
		int[] alt2_semanalmente = {5,12,19,26}; // 4 pos
    	
    	for(aux=0; aux<4; aux++){
    		if(alt2_semanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }

    public static int conferebi13(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
		int[] bisemanalmente = {13, 27};  // 2 pos
    	
    	for(aux=0; aux<2; aux++){
    		if(bisemanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }
    public static int conferebi6(int confere, int dia){
    	
    	int pode = 0; 
    	int aux;
		int[] alt_bisemanalmente = {6,20}; // 2 pos
    	
    	for(aux=0; aux<2; aux++){
    		if(alt_bisemanalmente[aux] == dia){
    			pode = 1;
    		}
    	}
    	
    	return pode;
    }
    
    public static int confereHorista(Empregado fulano){
    	
    	int confere = 0;
    	int aux;
    	
		int[] semanalmente = {6,13,20,27}; // 4 pos
		int[] alt_semanalmente = {3,10,17,24}; // 4 pos
		int[] alt1_semanalmente = {4,11,18,25}; // 4 pos
		int[] alt2_semanalmente = {5,12,19,26}; // 4 pos
		
    	for(aux=0;aux<4;aux++){
    		if(semanalmente[aux] == fulano.diadepagamento){
    			confere = 6;
    			break;
    		}else if(alt_semanalmente[aux] == fulano.diadepagamento){
    			confere = 3;
    			break;
    		}else if(alt1_semanalmente[aux] == fulano.diadepagamento){
    			confere = 4;
    			break;
    		}else if(alt2_semanalmente[aux] == fulano.diadepagamento){
    			confere = 5;
    			break;
    		}
    	}
    	
    	return confere;
    }
    public static int confereComissionado(Empregado fulano){
    	
    	int confere = 0;
    	int aux;
		int[] bisemanalmente = {13, 27};  // 2 pos
		int[] alt_bisemanalmente = {6,20}; // 2 pos
		
    	for(aux=0;aux<2;aux++){
    		if(bisemanalmente[aux] == fulano.diadepagamento){
    			confere = 13;
    			break;
    		}else if(alt_bisemanalmente[aux] == fulano.diadepagamento){
    			confere = 6;
    			break;
    		}
    	}
 
    	return confere;
    }
    
    public static void rodarFolhadePagamento(Empregado[] trabalhadores){
    	
    	Scanner input = new Scanner(System.in);
    	int dia, aux, tipo, confere, diadepgmt;
    	int pode = 0;
    	Empregado fulano = new Empregado();
    	

    	System.out.print("---------------------------------\nDigite o dia para rodar a folha: ");
    	dia = input.nextInt();
    	System.out.println(" ");
    	
    	
    	for(aux=0;aux<20;aux++){
    		if(trabalhadores[aux] != null){
    			fulano = trabalhadores[aux];
    			tipo = fulano.type;
    			
    			if(tipo == 1){
    				confere = fulano.diadepagamento;
    				if(dia == confere){
    					printPaymentMensal(fulano);
    				}
    			}else if(tipo == 2){
    				confere = confereHorista(fulano);
    				diadepgmt = fulano.diadepagamento;
    				if(confere == diadepgmt){
    					if(confere == 6){
    						pode = confere6(confere,dia);
    					}else if(confere == 3){
    						pode = confere3(confere,dia);
    					}else if(confere == 4){
    						pode = confere4(confere,dia);
    					}else{
    						pode = confere5(confere,dia);
    					}
    					
    					if(pode == 1){
            				printPaymentHorista(fulano);
    					}
    					
    				}
    			}else{
    				confere = confereComissionado(fulano);
    				diadepgmt = fulano.diadepagamento;
    				if(confere == diadepgmt){
    					if(confere == 13){
    						pode = conferebi13(confere,dia);
    					}else if(confere == 6){
    						pode = conferebi6(confere,dia);
    					}
    					
    					if(pode == 1){
            				printPaymentComissionado(fulano);	
    					}
    				}
    			}	
    		}
    	}
   
    	System.out.println("\n---------------------------------");
    }
    
    //-----------------------------------------------------------------------
    
    
	public static void main(String[] args) {
		
		Empregado[] redo = new Empregado[20];
		Empregado[] undo = new Empregado[20];
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
					+ "6- Alterar detalher de empregado\n" // feito
					+ "7- Rodar folha de pagamento\n"
					+ "8- Undo/Redo\n"					   // feito
					+ "9- Agenda de pagamento\n"		   // feito
					+ "10- Cria��o de novas agendas\n"	   // feito
					+ "11- Listar dos empregados\n"        // feito    
					+ "0 - Para sair do programa\n"        // feito
                                + "----------------------------------------------------\n\n\n\n\n\n\n\n\n\n\n");
			
			comando = input.nextInt();
			
			if(comando == 0){
				System.out.println("Obrigado por utilizar o Sistema !");
				break;
			}
			
			switch(comando){
				case 1:
					System.out.println("Sistema de adi��o de empregado - \n");
					saveUndoRedo(trabalhadores,undo);
					adicionarFuncionario(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
				
				case 2:
					System.out.println("Remo��o de empregados-\n");
					saveUndoRedo(trabalhadores,undo);
					deletarFuncionario(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
					
				case 3:
					saveUndoRedo(trabalhadores,undo);
					System.out.println("Lan�ar cart�o de ponto-");
                    inserirHora(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
				
				case 4:
					System.out.println("Lan�ar resultado de venda-");
					saveUndoRedo(trabalhadores,undo);
					lancarResultadoVenda(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
					
				case 5:
					System.out.println("Lan�ar taxa de venda");
					saveUndoRedo(trabalhadores,undo);
					inserirTaxaServico(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
				
				case 6:
					System.out.println("Alterar detalhes de um empregado");
					saveUndoRedo(trabalhadores,undo);
					alterarDadosdoEmpregado(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
					
				case 7:
					System.out.println("Rodar folha de pagamento");
					saveUndoRedo(trabalhadores,undo);
					rodarFolhadePagamento(trabalhadores);
					saveUndoRedo(trabalhadores,redo);
					break;
					
				case 8:
					System.out.println("Undo/Redo");
					selectionUndoRedo(trabalhadores,undo,redo);
					break;
					
				case 9:
					System.out.println("Agenda de Pagamento");
					consultarAgenda(trabalhadores);
					break;
					
				case 10:
					System.out.println("Cria��o de novas agendas");
					alterarAgenda(trabalhadores);
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
