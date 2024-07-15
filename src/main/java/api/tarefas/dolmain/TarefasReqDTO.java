package api.tarefas.dolmain;

import java.util.Date;

public record TarefasReqDTO(

    Long id,

    String name,

    String description,

    Date dateConclusion,

    Boolean status,
    
    Priority priority ) {}
