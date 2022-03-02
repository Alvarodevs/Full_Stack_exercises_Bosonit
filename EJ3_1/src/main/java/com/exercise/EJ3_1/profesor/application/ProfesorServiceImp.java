package com.exercise.EJ3_1.profesor.application;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import com.exercise.EJ3_1.estudiante.infrastructure.repository.EstudianteRepo;
import com.exercise.EJ3_1.persona.domain.Persona;
import com.exercise.EJ3_1.persona.infrastructure.repository.PersonaRepo;
import com.exercise.EJ3_1.profesor.domain.Profesor;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.input.ProfesorInputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorListOutputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.controller.DTO.output.ProfesorOutputDTO;
import com.exercise.EJ3_1.profesor.infrasctructure.repository.ProfesorRepo;
import com.exercise.EJ3_1.shared.NotFoundException;
import com.exercise.EJ3_1.shared.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService{

    @Autowired
    ProfesorRepo profesorRepo;

    @Autowired
    PersonaRepo personaRepo;

    @Autowired
    EstudianteRepo estudianteRepo;

    @Override
    public ProfesorListOutputDTO findAll(){
        List<Profesor> profesores = profesorRepo.findAll();
        List<ProfesorOutputDTO> profesoresOutputDTO = new ArrayList<>();
        ProfesorListOutputDTO profesorListOutputDTO = new ProfesorListOutputDTO();
        for (Profesor profesor : profesores) {
            profesoresOutputDTO.add(new ProfesorOutputDTO(profesor));
        }
        profesorListOutputDTO.setProfesorListOutputDTO(profesoresOutputDTO);
        return profesorListOutputDTO;
    }

    @Override
    public ProfesorOutputDTO filterProfesorById(String id) {
        Profesor profesor =
                profesorRepo.findById(id).orElseThrow(() -> new NotFoundException("Profesor id: "+id+ " no encontrado"));
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }

    @Override
    public ProfesorInputDTO addProfesor(ProfesorInputDTO profesorInputDto) {
        checkPersona(profesorInputDto);
        Profesor profesor = profesorInputDTOToProfesor(profesorInputDto);
        profesorRepo.saveAndFlush(profesor);

        return profesorInputDto;
    }

    @Override
    public ProfesorOutputDTO setProfesor(String id, ProfesorInputDTO profesorInputDto) {
        Profesor profesor =
                profesorRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Profesor id: "+id+ " no encontrado"));

        ProfesorOutputDTO profesorOutputDto = updateProfesor(id, profesor, profesorInputDto);
        profesor = profesorOutputDtoToProfesor(profesorOutputDto);
        profesorRepo.saveAndFlush(profesor);
        return profesorOutputDto;
    }

    @Override
    public void delProfesor(String id) {
        profesorRepo.delete(
                profesorRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Profesor id: "+id+ " no encontrado")));
    }



    private Profesor profesorInputDTOToProfesor(ProfesorInputDTO profesorInputDto){
        Profesor profesor = new Profesor();
        profesor.setIdPersona(personaRepo.findById(Integer.valueOf(profesorInputDto.getIdPersona())).orElseThrow(() -> new NotFoundException("Persona no válida")));
        profesor.setComments(profesorInputDto.getComments());
        profesor.setBranch(profesorInputDto.getBranch());

        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < profesorInputDto.getStudents().size(); i++){
            estudiantes.add(estudianteRepo.findById(profesorInputDto.getStudents().get(i)).orElseThrow(()-> new NotFoundException("Estudiante no válido")));
        }
        profesor.setEstudiantes(estudiantes);

        return profesor;
    }

    private Profesor profesorOutputDtoToProfesor(ProfesorOutputDTO profesorOutputDto){
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(profesorOutputDto.getIdProfesor());
        profesor.setIdPersona(personaRepo.findById(Integer.valueOf(profesorOutputDto.getIdPersona())).orElseThrow(()-> new NotFoundException("Persona no válida")));
        profesor.setBranch(profesorOutputDto.getBranch());
        profesor.setComments(profesorOutputDto.getComments());

        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < profesorOutputDto.getStudents().size(); i++){
            estudiantes.add(estudianteRepo.findById(profesorOutputDto.getStudents().get(i)).orElseThrow(()-> new NotFoundException("Estudiante no válido")));
        }
        profesor.setEstudiantes(estudiantes);

        return profesor;
    }

    private ProfesorOutputDTO updateProfesor(String id, Profesor profesor, ProfesorInputDTO profesorInputDto){
        ProfesorOutputDTO profesorOutputDto = new ProfesorOutputDTO(profesor);

        if (profesorInputDto.getIdPersona() != null) {
            Persona persona = personaRepo.findById(Integer.valueOf(profesorInputDto.getIdPersona())).orElseThrow(()->new NotFoundException("Persona id: "+id+ " no encontrada"));
            checkPersona(profesorInputDto);
            profesorOutputDto.setIdPersona(String.valueOf(persona.getId()));
        }

        if (profesorInputDto.getComments() != null) {
            profesorOutputDto.setComments(profesorInputDto.getComments());
        }

        if (profesorInputDto.getBranch() != null) {
            profesorOutputDto.setBranch(profesorInputDto.getBranch());
        }

        if(profesorInputDto.getStudents() != null){
            List<String> students = profesorInputDto.getStudents();
            for(int i = 0; i < students.size(); i++){
                estudianteRepo.findById(students.get(i)).orElseThrow(()->new NotFoundException("Student no válido"));
            }
            profesorOutputDto.setStudents(profesorInputDto.getStudents());
        }

        return profesorOutputDto;
    }

    private void checkPersona(ProfesorInputDTO profesorInputDto){
        List<Estudiante> students = estudianteRepo.findAll();
        List<Profesor> profesores = profesorRepo.findAll();

        for (int i = 0; i < students.size(); i++){
            if(profesorInputDto.getIdPersona().equals(String.valueOf(students.get(i).getIdPersona().getId()))){
                throw new UnprocesableException("La persona "+profesorInputDto.getIdPersona()+ " ya se encuentra asignada");
            }
        }

        for (int i = 0; i < profesores.size(); i++){
            if(profesorInputDto.getIdPersona().equals(String.valueOf(profesores.get(i).getIdPersona().getId()))){
                throw new UnprocesableException("La persona "+profesorInputDto.getIdPersona()+ " ya se encuentra asignada");
            }
        }
    }
}
