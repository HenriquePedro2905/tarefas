package api.tarefas.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import api.tarefas.dolmain.tarefas.Tarefas;
import api.tarefas.dolmain.tarefas.TarefasRepository;
import api.tarefas.dolmain.tarefas.TarefasReqDTO;
import api.tarefas.dolmain.tarefas.TarefasReqUpdDTO;
import api.tarefas.dolmain.users.Users;
import lombok.var;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public Tarefas creationTask(TarefasReqDTO data) {
        long userId = getAuthenticatedUserId();
        Tarefas newTask = new Tarefas(data);
        newTask.setUserId(userId);
        return repository.save(newTask);
    }

    public List<Tarefas> listarALL(Integer usersId){
        return repository.findByUserId(usersId);
    }

    public List<Tarefas> listarByCompletd(){
        return repository.findByCompleted();
    }
    
    public Optional<Tarefas> listarById(Long id){
        return repository.findById(id);
    }

    public Tarefas updateTask(TarefasReqDTO data){
        var task = repository.findById(data.id());
        Tarefas tarefa = task.get();

        if (data.name() != null) {
            tarefa.setName(data.name());;    
        }
        if (data.description() != null) {
            tarefa.setDescription(data.description());    
        }
        if (data.dateConclusion() != null) {
            tarefa.setDateConclusion(data.dateConclusion());    
        }
        if (data.status() != null) {
            tarefa.setStatus(data.status());    
        }
        if (data.priority() != null) {
            tarefa.setPriority(data.priority());    
        }
        return repository.save(tarefa);
    }

    public Tarefas updateStatus(TarefasReqUpdDTO data){
        var task = repository.findById(data.id());
        Tarefas tarefa = task.get();

        if (data.status() != null) {
            tarefa.setStatus(data.status());    
        }

        return repository.save(tarefa);
    }

    public List<Tarefas> listarByPriority(Integer userId){
        return repository.findAllOrderByPriority(userId);
    }

    public void deleteTask(Long id){
        var taskDelete = repository.findById(id).get();
        repository.delete(taskDelete);
    }

    public void deleteCompletedTask(){
        List<Tarefas> tarefa = new ArrayList<>(listarByCompletd());
        for(Tarefas tarefas : tarefa){
            repository.deleteById(tarefas.getId());
        }
    }

    public LocalDate conversionDate(String dateIsso){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateIsso, formatter);
    }

    public Long getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = (Users) authentication.getPrincipal();
        return user.getId();
    }
}
