package api.tarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.tarefas.dolmain.Tarefas;
import api.tarefas.dolmain.TarefasRepository;
import api.tarefas.dolmain.TarefasReqDTO;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public Tarefas crationTask(TarefasReqDTO data) {
        Tarefas newTask = new Tarefas(data);
        return repository.save(newTask);
    }

}
