package api.tarefas.dolmain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    long id;

    String description;

    @Column(name = "date_conclusion")
    Date dateConclusion;

    Boolean status;


    public Tarefas(TarefasReqDTO dt) {
        this.description = dt.description();
        this.dateConclusion = dt.dateConclusion();
        this.status = dt.status();
    }

}
