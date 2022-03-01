package com.exercise.BS8.persona.application;

import com.exercise.BS8.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.exercise.BS8.persona.infrastructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaOutputDTO> getAllPersona();
    List<PersonaOutputDTO> getPersonaByUsuario(String usuario);
    PersonaOutputDTO getPersonaById(Integer id) throws Exception;
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO setPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO delPersona(Integer id) throws Exception;
}