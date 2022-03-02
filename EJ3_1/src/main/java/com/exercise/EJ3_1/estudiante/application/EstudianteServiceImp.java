package com.exercise.EJ3_1.estudiante.application;

import com.exercise.EJ3_1.asignaturas.infrastructure.repository.AsignaturasRepo;
import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.input.EstudianteInputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudianteFullOutputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudiantesListOutputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.controller.DTO.output.EstudianteOutputDTO;
import com.exercise.EJ3_1.estudiante.infrastructure.repository.EstudianteRepo;
import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import com.exercise.EJ3_1.persona.domain.Persona;
import com.exercise.EJ3_1.persona.infrastructure.repository.PersonaRepo;
import com.exercise.EJ3_1.profesor.domain.Profesor;
import com.exercise.EJ3_1.profesor.infrasctructure.repository.ProfesorRepo;
import com.exercise.EJ3_1.shared.NotFoundException;
import com.exercise.EJ3_1.shared.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService{

    @Autowired
    ProfesorRepo profesorRepo;

    @Autowired
    PersonaRepo personaRepo;

    @Autowired
    EstudianteRepo estudianteRepo;

    @Autowired
    AsignaturasRepo asignaturasRepo;

    @Override
    public EstudiantesListOutputDTO findAll(){
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        List<EstudianteOutputDTO> estudianteOutputDTO = new ArrayList<>();
        EstudiantesListOutputDTO estudiantesListOutputDTO = new EstudiantesListOutputDTO();
        for (Estudiante estudiante : estudiantes) {
            estudianteOutputDTO.add(new EstudianteOutputDTO(estudiante));
        }
        estudiantesListOutputDTO.setEstudianteListOutputDTO(estudianteOutputDTO);
        return estudiantesListOutputDTO;
    }

    @Override
    public EstudianteOutputDTO getStudentById(String id, String outputType) {
        Estudiante estudiante =
                estudianteRepo.findById(id).orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+ " no encontrado"));
        if(outputType.equalsIgnoreCase("full")){
            EstudianteFullOutputDTO estudianteFullOutputDto  = new EstudianteFullOutputDTO(estudiante);
            return estudianteFullOutputDto;
        }else{
            EstudianteOutputDTO estudianteOutputDto = new EstudianteOutputDTO(estudiante);
            return estudianteOutputDto;
        }

    }

    @Override
    public EstudianteInputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) {

        checkPersona(estudianteInputDTO);

        Estudiante estudiante = EstudianteInputDTOToEstudiante(estudianteInputDTO);
        estudianteRepo.saveAndFlush(estudiante);

        return estudianteInputDTO;
    }

    public EstudianteOutputDTO setEstudiante(String id, EstudianteInputDTO estudianteInputDTO) {
        Estudiante estudiante =
                estudianteRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+ " no encontrado"));

        EstudianteOutputDTO estudianteOutputDTO = updateEstudiante(id, estudiante, estudianteInputDTO);
        estudiante = estudianteOutputDtoToEstudiante(estudianteOutputDTO);
        estudianteRepo.saveAndFlush(estudiante);
        return estudianteOutputDTO;
    }

    @Override
    public void delEstudiante(String id) {
        estudianteRepo.delete(
                estudianteRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+ " no encontrado")));
    }

    @Override
    public List<String> addAsignaturas(String id, List<String> asignaturas){
        Estudiante estudiante =
                estudianteRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+ " no encontrado"));
        List<Asignaturas> allAsignaturas = estudiante.getAsignaturas();
        boolean found = false;
        for(int i = 0; i < asignaturas.size(); i++){
            for(int j = 0; j < allAsignaturas.size() && !found; j++){
                if(allAsignaturas.get(j).getIdAsignatura().equals(asignaturas.get(i))){
                    found = true;
                }
            }
            if(!found){
                allAsignaturas.add(asignaturasRepo.findById(asignaturas.get(i)).orElseThrow());
            }
        }

        estudiante.setAsignaturas(allAsignaturas);
        estudianteRepo.saveAndFlush(estudiante);

        List<String> showAsignaturas = new ArrayList<>();
        for(int i = 0; i < allAsignaturas.size(); i++){
            showAsignaturas.add(allAsignaturas.get(i).getAsignatura());
        }

        return showAsignaturas;
    }

    @Override
    public List<String> delAsignaturas(String id, List<String> asignaturas){
        Estudiante estudiante =
                estudianteRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Estudiante con id: "+id+ " no encontrado"));

        List<Asignaturas> allAsignaturas = estudiante.getAsignaturas();
        boolean found = false;
        for(int i = 0; i < asignaturas.size(); i++){
            for(int j = 0; j < allAsignaturas.size() && !found; j++){
                if(allAsignaturas.get(j).getIdAsignatura().equals(asignaturas.get(i))){
                    allAsignaturas.remove(j);
                    found = true;
                }
            }
            found = false;
        }

        estudiante.setAsignaturas(allAsignaturas);
        estudianteRepo.saveAndFlush(estudiante);

        List<String> showAsignaturas = new ArrayList<>();
        for(int i = 0; i < allAsignaturas.size(); i++){
            showAsignaturas.add(allAsignaturas.get(i).getIdAsignatura());
        }

        return showAsignaturas;
    }

    private Estudiante EstudianteInputDTOToEstudiante(EstudianteInputDTO estudianteInputDto){
        Estudiante estudiante = new Estudiante();

        estudiante.setIdPersona(personaRepo.findById(Integer.valueOf(estudianteInputDto.getIdPersona())).orElseThrow(()->new NotFoundException("Persona introducida no válida")));
        estudiante.setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        estudiante.setComments(estudianteInputDto.getComments());
        estudiante.setBranch(estudianteInputDto.getBranch());
        estudiante.setIdProfesor(profesorRepo.findById(estudianteInputDto.getIdProfesor()).orElseThrow(()->new NotFoundException("Profesor introducido no válido")));

        List<Asignaturas> asignaturas = new ArrayList<>();
        for (int i = 0; i < estudianteInputDto.getAsignaturas().size(); i++){
            asignaturas.add(asignaturasRepo.findById(estudianteInputDto.getAsignaturas().get(i)).orElseThrow(()-> new NotFoundException("Asignatura no válida")));
        }
        estudiante.setAsignaturas(asignaturas);
        return estudiante;
    }

    private Estudiante estudianteOutputDtoToEstudiante(EstudianteOutputDTO estudianteOutputDto){
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(estudianteOutputDto.getIdEstudiante());
        estudiante.setIdPersona(personaRepo.findById(Integer.valueOf(estudianteOutputDto.getIdPersona())).orElseThrow(()-> new NotFoundException("Persona introducida no válida")));
        estudiante.setBranch(estudianteOutputDto.getBranch());
        estudiante.setComments(estudianteOutputDto.getComments());
        estudiante.setNumHoursWeek(estudianteOutputDto.getNumHoursWeek());
        estudiante.setIdProfesor(profesorRepo.findById(estudianteOutputDto.getIdProfesor()).orElseThrow(()->new NotFoundException("Profesor introducido no válido")));

        List<Asignaturas> asignaturas = new ArrayList<>();
        for (int i = 0; i < estudianteOutputDto.getAsignaturas().size(); i++){
            asignaturas.add(asignaturasRepo.findById(estudianteOutputDto.getAsignaturas().get(i)).orElseThrow(()-> new NotFoundException("Estudio introducido no válido")));
        }
        estudiante.setAsignaturas(asignaturas);

        return estudiante;
    }

    private void checkPersona(EstudianteInputDTO estudianteInputDto){
        List<Estudiante> estudiantes = estudianteRepo.findAll();
        List<Profesor> profesores = profesorRepo.findAll();

        for (int i = 0; i < estudiantes.size(); i++){
            if(estudianteInputDto.getIdPersona().equals(String.valueOf(estudiantes.get(i).getIdPersona().getId()))){
                throw new UnprocesableException("La persona "+estudianteInputDto.getIdPersona()+ " ya se encuentra asignada");
            }
        }

        for (int i = 0; i < profesores.size(); i++){
            if(estudianteInputDto.getIdPersona().equals(String.valueOf(profesores.get(i).getIdPersona()))){
                throw new UnprocesableException("La persona "+estudianteInputDto.getIdPersona()+ " ya se encuentra asignada");
            }
        }
    }

    private EstudianteOutputDTO updateEstudiante(String id, Estudiante estudiante, EstudianteInputDTO estudianteInputDTO){
        EstudianteOutputDTO estudianteOutputDto = new EstudianteOutputDTO(estudiante);

        if (estudianteInputDTO.getIdPersona() != null) {
            Persona persona = personaRepo.findById(Integer.valueOf(estudianteInputDTO.getIdPersona())).orElseThrow(()->new NotFoundException("Persona con id: "+id+ " no encontrada"));
            checkPersona(estudianteInputDTO);
            estudianteOutputDto.setIdPersona(persona.getId().toString());
        }

        if (estudianteInputDTO.getIdProfesor() != null) {
            Profesor profesor = profesorRepo.findById(estudianteInputDTO.getIdProfesor()).orElseThrow(()->new NotFoundException("Profesor con id: "+id+ " no encontrado"));
            estudianteOutputDto.setIdProfesor(estudianteInputDTO.getIdProfesor());
        }

        if (estudianteInputDTO.getBranch() != null){
            estudianteOutputDto.setBranch(estudianteInputDTO.getBranch());
        }

        if (estudianteInputDTO.getComments() != null){
            estudianteOutputDto.setComments(estudianteInputDTO.getComments());
        }

        if (estudianteInputDTO.getNumHoursWeek() != null){
            estudianteOutputDto.setNumHoursWeek(estudianteInputDTO.getNumHoursWeek());
        }

        if (estudianteInputDTO.getAsignaturas() != null){
            List<String> asignaturas = estudianteInputDTO.getAsignaturas();
            for(int i = 0; i < asignaturas.size(); i++){
                asignaturasRepo.findById(asignaturas.get(i)).orElseThrow(()->new NotFoundException("La asignatura: "+id+ " no es válida"));
            }
            estudianteOutputDto.setAsignaturas(estudianteInputDTO.getAsignaturas());
        }

        return estudianteOutputDto;
    }
}