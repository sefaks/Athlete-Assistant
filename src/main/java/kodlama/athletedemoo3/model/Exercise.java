package kodlama.athletedemoo3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="exercises")
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @SequenceGenerator(name = "seq_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;



    @Column(name="exercise_id")
    private int exerciseId;



    @Column(name="exercise_name")
    private String exerciseName;


    @OneToMany
    private List<Image> image;

}
