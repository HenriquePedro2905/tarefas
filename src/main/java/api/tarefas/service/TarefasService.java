package api.tarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.tarefas.dolmain.Tarefas;
import api.tarefas.dolmain.TarefasRepository;
import api.tarefas.dolmain.TarefasReqDTO;
import lombok.var;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public Tarefas crationTask(TarefasReqDTO data) {
        Tarefas newTask = new Tarefas(data);
        return repository.save(newTask);
    }

    public List<Tarefas> listarALL(){
        return repository.findAll();
    }

    public Optional<Tarefas> listarById(Long id){
        return repository.findById(id);
    }

    public Tarefas updateTask(TarefasReqDTO data){
        var task = repository.findById(data.id());
        Tarefas tarefa = task.get();

        if (data.description() != null) {
            tarefa.setDescription(data.description());    
        }
        
        if (data.dateConclusion() != null) {
            tarefa.setDateConclusion(data.dateConclusion());    
        }
        if (data.status() != null) {
            tarefa.setStatus(data.status());    
        }
        
        return repository.save(tarefa);
    }
}
