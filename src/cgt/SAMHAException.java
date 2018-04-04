package cgt;

public class SAMHAException extends Exception {

    int codErro;
    String [] msgsErro;

    public SAMHAException(int cod) {
        
        super("Erro genérico.");
        msgsErro = new String[500];
        this.codErro = cod;
        
        msgsErro[0] = "Usuário inválido";

        msgsErro[1] = "Campo NOME inválido";
        msgsErro[2] = "Campo MATRICULA inválido";
        msgsErro[3] = "Campo LOGIN inválido";
        msgsErro[4] = "Campo SENHA inválido";
        msgsErro[5] = "Campo CARGA HORÁRIA inválido"; 
        msgsErro[6] = "Campo DESCRIÇÃO inválido";
    }
    
    @Override
    public String getMessage() {        
        return msgsErro[codErro];
    }  
}
