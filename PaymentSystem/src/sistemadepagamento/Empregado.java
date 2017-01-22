package sistemadepagamento;

public class Empregado {
	
	String nome = new String();
	String adress = new String();
	int type;    // 1- Assalariado 2- Horista 3-Comissionado
	double salario;
    int horassemana;
    int horasextras;
    double vendasacumuladas;
    double taxadeservico;
    int pertencesindicato;
    int idsindicato;
    double taxasindical;
    int metodopagamento; // 1- Cheque correios 2- Cheque em mãos 3- Depósito em conta 
    int tipodepagamento; // 1- Mensal 2- Semanal 3- Bi-semanal
    int diadepagamento;
}
