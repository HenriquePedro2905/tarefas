package api.tarefas.dolmain;

import java.util.Date;

public record TarefasReqDTO(

    String description,

    Date dateConclusion,

    Boolean status) {

}
