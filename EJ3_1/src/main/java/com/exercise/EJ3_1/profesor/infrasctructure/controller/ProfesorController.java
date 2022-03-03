package com.exercise.EJ3_1.profesor.infrasctructure.controller;

import com.exercise.EJ3_1.profesor.application.ProfesorService;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.input.ProfesorInputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorListOutputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RequestMapping("profesor")
@RestController
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;

    @PostMapping
    public ProfesorInputDTO addProfesor(@Valid @RequestBody ProfesorInputDTO profesorInputDTO){
        return profesorService.addProfesor(profesorInputDTO);
    }

    @GetMapping
    public ProfesorListOutputDTO findAll(){
        return profesorService.findAll();
    }

    @GetMapping("{id}")
    public ProfesorOutputDTO getProfesorById(@PathVariable String id){
        return profesorService.filterProfesorById(id);
    }

    //Feign call
    @GetMapping("/rest_template/{id}")
    ResponseEntity<ProfesorOutputDTO> getProfesorRestTemplate(@PathVariable String id){
        ResponseEntity<ProfesorOutputDTO> rs = new RestTemplate().getForEntity("http://localhost:8081/profesor/"+id,ProfesorOutputDTO.class);
        return ResponseEntity.ok(rs.getBody());
    }

    @PutMapping("{id}")
    public ProfesorOutputDTO setProfesor(@PathVariable String id, @RequestBody ProfesorInputDTO profesorInputDto) {

        return profesorService.setProfesor(id, profesorInputDto);
    }

    @DeleteMapping("{id}")
    public void delProfesor(@PathVariable String id){
        profesorService.delProfesor(id);
    }
}
