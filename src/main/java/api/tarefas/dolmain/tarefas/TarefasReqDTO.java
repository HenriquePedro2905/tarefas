package api.tarefas.dolmain.tarefas;


import java.time.LocalDate;

public record TarefasReqDTO(

    Long id,

    Integer userId,

    String name,

    String description,

    LocalDate dateConclusion,

    Boolean status,
    
    Priority priority ) {}
