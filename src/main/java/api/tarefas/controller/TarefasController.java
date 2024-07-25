package api.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.tarefas.dolmain.tarefas.TarefasReqDTO;
import api.tarefas.dolmain.tarefas.TarefasReqUpdDTO;
import api.tarefas.service.TarefasService;

@RestController
@RequestMapping("/task")
public class TarefasController {

    @Autowired
    TarefasService service;

    @PostMapping
    public ResponseEntity<Void> registerTask(@RequestBody TarefasReqDTO data){
        System.out.println(data.dateConclusion());
        service.creationTask(data);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/listAll/{userId}")
    public ResponseEntity listTasks(@PathVariable Integer userId){
        var allTask = service.listarALL(userId);
        return ResponseEntity.ok(allTask);
    }

    @GetMapping("{id}")
    public ResponseEntity listById(@PathVariable Long id){
        var taskByid = service.listarById(id);
        return ResponseEntity.ok(taskByid);
    }

    @GetMapping("/listByCompleted/{userId}")
    public ResponseEntity listTasksByCompleted(@PathVariable Integer userId){
        var taskByCompleted = service.listarByCompletd();
        return ResponseEntity.ok(taskByCompleted);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateTask(@RequestBody TarefasReqDTO data){
        service.updateTask(data);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/updateStatus")
    public ResponseEntity<Void> updateTask(@RequestBody TarefasReqUpdDTO data){
        service.updateStatus(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listarByPriority/{userId}")
    public ResponseEntity listTasksByPriority(@PathVariable Integer userId){
        var tasksByPriority = service.listarByPriority(userId);
        return ResponseEntity.ok(tasksByPriority);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestBody TarefasReqDTO data){
        service.deleteTask(data.id());;
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteCompleted")
    public ResponseEntity deleteByCompleted(@RequestBody TarefasReqDTO data){
        service.deleteCompletedTask();
        return ResponseEntity.ok().build();
    }
        
}
