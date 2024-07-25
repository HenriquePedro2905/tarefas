package api.tarefas.dolmain.tarefas;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;

    @Column(name = "users_id")
    private Long userId;

    private String name;

    private String description;

    @Column(name = "date_conclusion")
    private LocalDate dateConclusion;

    private Boolean status;
    
    @Enumerated(EnumType.STRING)
    private Priority priority;
    


    public Tarefas(TarefasReqDTO dt) {
        this.name = dt.name();
        this.description = dt.description();
        this.dateConclusion = dt.dateConclusion();
        this.status = dt.status();
        this.priority = dt.priority();
    }

}
