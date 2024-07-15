package api.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.tarefas.dolmain.TarefasReqDTO;
import api.tarefas.service.TarefasService;
import lombok.var;

@RestController
@RequestMapping("/task")
public class TarefasController {

    @Autowired
    TarefasService service;

    @PostMapping
    public ResponseEntity<Void> registerTask(@RequestBody TarefasReqDTO data){
        service.crationTask(data);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/listar")
    public ResponseEntity listTasks(){
        var allTask = service.listarALL();
        return ResponseEntity.ok(allTask);
    }

    @GetMapping("/listarById")
    public ResponseEntity listTasksById(@RequestBody TarefasReqDTO data){
        var taskById = service.listarById(data.id());
        return ResponseEntity.ok(taskById);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateTask(@RequestBody TarefasReqDTO data){
        service.updateTask(data);
        return ResponseEntity.ok().build();
    }
}
