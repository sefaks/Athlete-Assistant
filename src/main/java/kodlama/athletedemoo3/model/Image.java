package kodlama.athletedemoo3.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name="exercise_id")
    private int exerciseId;


    @Column(name = "image_id")
    private int imageId;

    @Column(name="image_content")
    private String imageContent;

}
