package api.tarefas.dolmain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{

        @Query("SELECT t FROM Tarefas t ORDER BY " +
           "CASE t.priority " +
           "WHEN 'ALTA' THEN 1 " +
           "WHEN 'MEDIA' THEN 2 " +
           "WHEN 'BAIXA' THEN 3 " +
           "END")
    List<Tarefas> findAllOrderByPriority();
}
