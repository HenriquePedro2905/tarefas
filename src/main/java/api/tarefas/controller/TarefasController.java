package api.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.tarefas.dolmain.TarefasReqDTO;
import api.tarefas.service.TarefasService;

@RestController
@RequestMapping("/task")
public class TarefasController {

    @Autowired
    TarefasService service;

    public ResponseEntity<Void> registerTask(@RequestBody TarefasReqDTO data){
        service.crationTask(data);
        return ResponseEntity.status(201).build();
    }
}
