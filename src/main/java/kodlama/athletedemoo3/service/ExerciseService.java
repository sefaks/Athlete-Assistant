package kodlama.athletedemoo3.service;

import kodlama.athletedemoo3.dto.ExerciseDto;
import kodlama.athletedemoo3.model.Exercise;

import java.util.List;

public interface ExerciseService {

    ExerciseDto saveExercise(ExerciseDto exerciseDto);

    void deleteExercise(int id);

    List<ExerciseDto> getAll();

    Exercise getExerciseById(int id);
}
