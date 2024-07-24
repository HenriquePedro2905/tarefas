package api.tarefas.dolmain.tarefas;


import java.time.LocalDate;

public record TarefasReqDTO(

    Long id,

    String name,

    String description,

    LocalDate dateConclusion,

    Boolean status,
    
    Priority priority ) {}
