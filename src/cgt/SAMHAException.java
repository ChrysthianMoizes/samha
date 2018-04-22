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
        msgsErro[7] = "Professor não selecionado";
        msgsErro[8] = "Eixo não selecionado";
        
        msgsErro[9] = "Campo NÍVEL inválido";
        msgsErro[10] = "Campo PERÍODOS inválido";
        msgsErro[11] = "Coordenadoria não selecionada";
        
        msgsErro[12] = "Curso não selecionado";
    }
    
    @Override
    public String getMessage() {        
        return msgsErro[codErro];
    }  
}
