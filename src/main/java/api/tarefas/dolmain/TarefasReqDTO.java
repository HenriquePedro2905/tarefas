package api.tarefas.dolmain;

import java.util.Date;

public record TarefasReqDTO(

    String descrition,

    Date dateConclusion,

    Boolean status) {

}
