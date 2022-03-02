package com.exercise.EJ3_1.estudiante.infrastructure.controller;

import com.exercise.EJ3_1.estudiante.application.EstudianteService;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.input.EstudianteInputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudianteOutputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudiantesListOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("estudiante")
@RestController
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @PostMapping
    public EstudianteInputDTO addEstudiante(@Valid @RequestBody EstudianteInputDTO estudianteInputDTO){
        return estudianteService.addEstudiante(estudianteInputDTO);
    }

    @GetMapping
    public EstudiantesListOutputDTO findAll(){
        return estudianteService.findAll();
    }

    @GetMapping("{id}")
    public EstudianteOutputDTO getStudentById(@PathVariable String id, @Value("simple") @RequestParam(name = "outputType", defaultValue = "simple", required = false)
            String outputType){
        return estudianteService.getStudentById(id, outputType);
    }

    @PutMapping("{id}")
    public EstudianteOutputDTO setStudent(@PathVariable String id, @RequestBody EstudianteInputDTO studentInputDto) {

        return estudianteService.setEstudiante(id, studentInputDto);

    }

    @PutMapping("{id}/asignar")
    public List<String> addAsignaturas(@PathVariable String id, @RequestBody List<String> estudianteAsignaturas){
        return estudianteService.addAsignaturas(id, estudianteAsignaturas);
    }

    @PutMapping("{id}/desasignar")
    public List<String> delAsignaturas(@PathVariable String id, @RequestBody List<String> estudianteAsignaturas){
        return estudianteService.delAsignaturas(id, estudianteAsignaturas);
    }

    @DeleteMapping("{id}")
    public void delEstudiante(@PathVariable String id){
        estudianteService.delEstudiante(id);
    }
}