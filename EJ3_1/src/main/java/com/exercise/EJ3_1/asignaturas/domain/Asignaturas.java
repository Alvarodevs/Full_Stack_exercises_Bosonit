package com.exercise.EJ3_1.asignaturas.domain;

import com.exercise.EJ3_1.estudiante.domain.Estudiante;
import com.exercise.EJ3_1.profesor.domain.Profesor;
import com.exercise.EJ3_1.shared.StringSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Asignaturas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IdAsignatura")
    @GenericGenerator(
            name = "IdAsignatura",
            strategy = "com.exercise.EJ3_1.shared.StringSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                    @Parameter(name = StringSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d")
            })
    @Column(name = "id_asignatura")
    private String idAsignatura;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;

    @NonNull
    private String asignatura;

    private String comments;

    @NonNull
    private Date initialDate;

    private Date finishDate;

}
