package com.exercise.EJ3_1.asignaturas.application;

import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.input.AsignaturasInputDTO;
import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.output.AsignaturasListOutputDTO;
import com.exercise.EJ3_1.asignaturas.infrastructure.controller.DTO.output.AsignaturasOutputDTO;
import com.exercise.EJ3_1.asignaturas.infrastructure.repository.AsignaturasRepo;
import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import com.exercise.EJ3_1.estudiante.infrastructure.repository.EstudianteRepo;
import com.exercise.EJ3_1.shared.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignaturasServiceImp implements AsignaturasService {

    @Autowired
    EstudianteRepo estudianteRepo;

    @Autowired
    AsignaturasRepo asignaturasRepo;

    @Override
    public AsignaturasListOutputDTO findAll(){
        List<Asignaturas> asignaturas = asignaturasRepo.findAll();
        List<AsignaturasOutputDTO> asignaturasOutputDTO = new ArrayList<>();
        AsignaturasListOutputDTO asignaturasListOutputDTO = new AsignaturasListOutputDTO();
        for (Asignaturas asignatura : asignaturas) {
            asignaturasOutputDTO.add(new AsignaturasOutputDTO(asignatura));
        }
        asignaturasListOutputDTO.setAsignaturasListOutputDTO(asignaturasOutputDTO);
        return asignaturasListOutputDTO;
    }

    @Override
    public AsignaturasOutputDTO filterAsignaturasById(String id) {
        Asignaturas asignaturas =
                asignaturasRepo.findById(id).orElseThrow(() -> new NotFoundException("Asignatura : "+id+ " no encontrada"));
        AsignaturasOutputDTO asignaturasOutputDTO = new AsignaturasOutputDTO(asignaturas);
        return asignaturasOutputDTO;
    }

    @Override
    public AsignaturasInputDTO addAsignaturas(AsignaturasInputDTO asignaturasInputDTO) {

        Asignaturas asignaturas = asignaturasInputDTOToAsignaturas(asignaturasInputDTO);
        asignaturasRepo.saveAndFlush(asignaturas);

        return asignaturasInputDTO;
    }

    @Override
    public AsignaturasOutputDTO setAsignaturas(String id, AsignaturasInputDTO asignaturasInputDTO) {
        Asignaturas asignaturas =
                asignaturasRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Asignatura : "+id+ " no encontrada"));

        AsignaturasOutputDTO asignaturasOutputDTO = updateAsignaturas(id, asignaturas, asignaturasInputDTO);
        asignaturas = asignaturasOutputDTOToAsignaturas(asignaturasOutputDTO);
        asignaturasRepo.saveAndFlush(asignaturas);
        return asignaturasOutputDTO;
    }

    @Override
    public void delAsignaturas(String id) {
        asignaturasRepo.delete(
                asignaturasRepo
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Asignatura : "+id+ " no encontrada")));
    }


    private Asignaturas asignaturasInputDTOToAsignaturas(AsignaturasInputDTO asignaturasInputDto){
        Asignaturas asignaturas = new Asignaturas();
        asignaturas.setAsignatura(asignaturasInputDto.getAsignaturas());
        asignaturas.setComments(asignaturasInputDto.getComments());
        asignaturas.setInitialDate(asignaturasInputDto.getInitialDate());
        asignaturas.setFinishDate(asignaturasInputDto.getFinishDate());

        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < asignaturasInputDto.getEstudiantes().size(); i++){
            estudiantes.add(estudianteRepo.findById(asignaturasInputDto.getEstudiantes().get(i)).orElseThrow(()-> new NotFoundException("Estudiante no válido")));
        }
        asignaturas.setEstudiantes(estudiantes);

        return asignaturas;
    }

    private Asignaturas asignaturasOutputDTOToAsignaturas(AsignaturasOutputDTO asignaturasOutputDTO){
        Asignaturas alumnosEstudios = new Asignaturas();
        alumnosEstudios.setIdAsignatura(asignaturasOutputDTO.getIdEstudio());
        alumnosEstudios.setAsignatura(asignaturasOutputDTO.getAsignaturas());
        alumnosEstudios.setComments(asignaturasOutputDTO.getComments());
        alumnosEstudios.setInitialDate(asignaturasOutputDTO.getInitialDate());
        alumnosEstudios.setFinishDate(asignaturasOutputDTO.getFinishDate());

        List<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < asignaturasOutputDTO.getEstudiantes().size(); i++){
            estudiantes.add(estudianteRepo.findById(asignaturasOutputDTO.getEstudiantes().get(i)).orElseThrow(()-> new NotFoundException("Estudiante introducido no válido")));
        }
        alumnosEstudios.setEstudiantes(estudiantes);

        return alumnosEstudios;
    }

    private AsignaturasOutputDTO updateAsignaturas(String id, Asignaturas asignaturas, AsignaturasInputDTO asignaturasInputDTO){
        AsignaturasOutputDTO asignaturasOutputDTO = new AsignaturasOutputDTO(asignaturas);

        if (asignaturasInputDTO.getAsignaturas() != null){
            asignaturasOutputDTO.setAsignaturas(asignaturasInputDTO.getAsignaturas());
        }

        if (asignaturasInputDTO.getComments() != null){
            asignaturasOutputDTO.setComments(asignaturasInputDTO.getComments());
        }

        if (asignaturasInputDTO.getInitialDate() != null){
            asignaturasOutputDTO.setInitialDate(asignaturasInputDTO.getInitialDate());
        }

        if (asignaturasInputDTO.getFinishDate() != null){
            asignaturasOutputDTO.setFinishDate(asignaturasInputDTO.getFinishDate());
        }

        if (asignaturasInputDTO.getEstudiantes() != null){
            List<String> students = asignaturasInputDTO.getEstudiantes();
            for(int i = 0; i < students.size(); i++){
                estudianteRepo.findById(students.get(i)).orElseThrow(()->new NotFoundException("Student con id: "+id+ " no válido"));
            }
            asignaturasOutputDTO.setEstudiantes(asignaturasInputDTO.getEstudiantes());
        }

        return asignaturasOutputDTO;
    }
}
