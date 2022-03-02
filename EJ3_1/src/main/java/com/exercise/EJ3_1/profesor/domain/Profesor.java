package com.exercise.EJ3_1.profesor.domain;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import com.exercise.EJ3_1.persona.domain.Persona;
import com.exercise.EJ3_1.shared.StringSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Idprofesor")
    @GenericGenerator(
            name = "Idprofesor",
            strategy = "com.exercise.EJ3_1.shared.StringSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),
                    @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            })
    private String idProfesor;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "id_persona")
    private Persona idPersona;

    private String comments;

    @NotBlank(message = "branch es nulo")
    private String branch;

    @OneToMany(mappedBy = "idProfesor", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

}
