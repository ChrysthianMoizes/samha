package cgt;

public class SAMHAException extends Exception {

    int codErro;
    String [] msgsErro;

    public SAMHAException(int cod) {
        
        super("SBPR erro genérico.");
        msgsErro = new String[500];
        this.codErro = cod;

        msgsErro[0] = "Código de erro inválido!";
        
        // Produtor 1 - 6
        msgsErro[1] = "Campo NOME inválido";
        msgsErro[2] = "Campo MATRICULA inválido";
        msgsErro[3] = "Campo LOGIN inválido";
        msgsErro[4] = "Campo SENHA inválido";  
        
        //Tipo de Serviço 7 - 20
        msgsErro[7] = "Campo valor do tipo de serviço inválido"; 
        msgsErro[8] = "Tipo de Serviço vinculado a Serviço(s)!";
        
        //Cargo
        msgsErro[20] = "Campo NOME DO CARGO inválido";
        
        //Serviço 50 - 100
        msgsErro[50] = "Propriedade vinculada a Serviço(s)!";
        msgsErro[51] = "Todas as máquinas estão agendadas para essa data!";
        msgsErro[52] = "Valor da multa inválido!";
        msgsErro[53] = "Valor total inválido!";
        msgsErro[54] = "Produtor vinculado a Serviço(s)!";
        
        //Relatório 100 - 150
        msgsErro[100] = "Não existe páginas para exibir.";
    }
    
    @Override
    public String getMessage() {        
        return msgsErro[codErro];
    }  
}
