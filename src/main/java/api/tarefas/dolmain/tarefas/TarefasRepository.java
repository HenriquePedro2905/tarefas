package api.tarefas.dolmain.tarefas;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import api.tarefas.dolmain.users.Users;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{

    @Query("SELECT t FROM Tarefas t WHERE t.userId = :userId ORDER BY " +
           "CASE t.priority " +    
           "WHEN 'ALTA' THEN 1 " +
           "WHEN 'MEDIA' THEN 2 " +
           "WHEN 'BAIXA' THEN 3 " +
           "END")
    List<Tarefas> findAllOrderByPriority(@Param("userId") Integer userId);

    @Query("SELECT t FROM Tarefas t WHERE t.status = true AND t.userId = :userId")
    List<Tarefas> findByCompleted(@Param("userId") Integer userId);

    List<Tarefas> findByUserId(Integer UsersId);
}
