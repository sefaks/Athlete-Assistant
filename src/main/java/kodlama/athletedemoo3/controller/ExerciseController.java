package kodlama.athletedemoo3.controller;

import jakarta.validation.Valid;
import kodlama.athletedemoo3.dto.ExerciseDto;
import kodlama.athletedemoo3.model.Exercise;
import kodlama.athletedemoo3.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/exercises")
@RequiredArgsConstructor
    public class ExerciseController {


        private final ExerciseService exerciseService;


        @PostMapping(path="/add-exercise")
        public ResponseEntity<ExerciseDto> add(@Valid @RequestBody ExerciseDto exerciseDto) {
            return  ResponseEntity.ok(exerciseService.saveExercise(exerciseDto));
        }

    @GetMapping
    public ResponseEntity<List<ExerciseDto>> showAll() {
        return ResponseEntity.ok(exerciseService.getAll());
    }

    @GetMapping
    private Exercise getExerciseById(int id) {
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteExercise(@PathVariable  int id){
        exerciseService.deleteExercise(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
