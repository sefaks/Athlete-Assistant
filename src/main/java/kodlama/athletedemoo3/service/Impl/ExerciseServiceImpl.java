package kodlama.athletedemoo3.service.Impl;

import kodlama.athletedemoo3.dto.ExerciseDto;
import kodlama.athletedemoo3.exception.ExerciseNotFoundException;
import kodlama.athletedemoo3.model.Exercise;
import kodlama.athletedemoo3.repository.ExerciseRepository;
import kodlama.athletedemoo3.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Override
    @Transactional
    public ExerciseDto saveExercise(ExerciseDto exerciseDto) {


        Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseDto.getExerciseName());
        exercise.setId(exerciseDto.getId());
        exercise.setExerciseId(exerciseDto.getExerciseId());
        exercise.setImage(exerciseDto.getImage());

        return exerciseDto;
    }

    @Override
    public List<ExerciseDto> getAll() {
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseDto> exerciseDtos = new ArrayList<>();

        exercises.forEach(it -> {
            ExerciseDto exerciseDto =new ExerciseDto();
            exerciseDto.setId(it.getId());
            exerciseDto.setExerciseName(it.getExerciseName());
            exerciseDto.setExerciseId(it.getExerciseId());
            exerciseDto.setImage(it.getImage());

            exerciseDtos.add(exerciseDto);
        });
        return exerciseDtos;
    }

    public Exercise getExerciseById(int id) {
        return  exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + id));
    }

    public void deleteExercise(int id){
        exerciseRepository.deleteById(id);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExercise(@PathVariable int id) {
        return new ResponseEntity<>(getExerciseById(id),OK);
    }










}
