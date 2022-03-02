package com.exercise.EJ3_1.estudiante.domain;

import com.exercise.EJ3_1.asignaturas.domain.Asignaturas;
import com.exercise.EJ3_1.persona.domain.Persona;
import com.exercise.EJ3_1.profesor.domain.Profesor;
import com.exercise.EJ3_1.shared.StringSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdEstudiante")
    @GenericGenerator(
        name = "IdEstudiante",
        strategy = "com.exercise.EJ3_1.shared.StringSequenceIdGenerator",
        parameters = {
                @Parameter(name= StringSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
        })

    private String idEstudiante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona idPersona;

    @NonNull
    private Integer numHoursWeek;

    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor idProfesor;

    @NonNull
    private String branch;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = {@JoinColumn(name = "id_estudiante")},
            inverseJoinColumns = {@JoinColumn(name = "id_asignatura")}
    )
    List<Asignaturas> asignaturas;


}
