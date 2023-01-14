package kodlama.athletedemoo3.dto;

import kodlama.athletedemoo3.model.Image;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseDto {

    private int id;

    private int exerciseId;

    private String exerciseName;

    private List<Image> image;


}
