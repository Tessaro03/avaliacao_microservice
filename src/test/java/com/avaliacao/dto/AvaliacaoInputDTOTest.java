package com.avaliacao.dto;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.avaliacao.dtos.avaliacao.AvaliacaoInputDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class AvaliacaoInputDTOTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Deve ocorrer erro por nota ser maior do que o maximo")
    public void NotaMaiorQueMaximo() {
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, 6.0, "observacao");

        Set<ConstraintViolation<AvaliacaoInputDTO>> violations = validator.validate(avaliacaoInputDTO);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size()); 

        ConstraintViolation<AvaliacaoInputDTO> violation = violations.iterator().next();
        assertEquals("deve ser menor que ou igual à 5", violation.getMessage());
    }

    @Test
    @DisplayName("Deve ocorrer erro por nota ser menor do que o minimo")
    public void NotaMenorQueMinimo() {
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, -1.0, "observacao");

        Set<ConstraintViolation<AvaliacaoInputDTO>> violations = validator.validate(avaliacaoInputDTO);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size()); 

        ConstraintViolation<AvaliacaoInputDTO> violation = violations.iterator().next();
        assertEquals("deve ser maior que ou igual à 0", violation.getMessage());
    }

    @Test
    @DisplayName("Deve ocorrer erro por nota ser nula")
    public void NotaNull() {
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1L, null, "observacao");

        Set<ConstraintViolation<AvaliacaoInputDTO>> violations = validator.validate(avaliacaoInputDTO);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size()); 

        ConstraintViolation<AvaliacaoInputDTO> violation = violations.iterator().next();
        assertEquals("não deve ser nulo", violation.getMessage());
    }

    @Test
    @DisplayName("Não deve ocorrer nenhum erro")
    public void NotaDentroDoIntervalo() {
        AvaliacaoInputDTO avaliacaoInputDTO = new AvaliacaoInputDTO(1l, 3.0, "observacao");

        Set<ConstraintViolation<AvaliacaoInputDTO>> violations = validator.validate(avaliacaoInputDTO);

        assertTrue(violations.isEmpty());
    }
}