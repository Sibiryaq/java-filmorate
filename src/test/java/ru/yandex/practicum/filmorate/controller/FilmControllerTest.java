package ru.yandex.practicum.filmorate.controller;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.Film;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmControllerTest {
    private Film film;
    private static Validator validator;
    private Set<ConstraintViolation<Film>> violations;

    @BeforeEach
    public void beforeEach() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        film = new Film();
        film.setId(1L);
        film.setName("Cтарикам тут не место");
        film.setDescription("Наемный убийца преследует ветерана войны, " +
                "укравшего деньги наркодилеров. Философский триллер братьев Коэн\"");
        film.setDuration(122);
        film.setReleaseDate(LocalDate.of(2007, 5, 19));

        violations = validator.validate(film);
    }

    @Test
    public void testAddFilm() {
        violations = validator.validate(film);
        assertEquals(1, violations.size(), "Ошибки валидации");
        List<Film> films = new ArrayList<>();
        films.add(film);
        assertTrue(films.contains(film), "Фильм не был добавлен в список");
    }

    @Test
    public void testEmptyFilmName() {
        film.setName("");
        violations = validator.validate(film);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testInvalidDuration() {
        film.setDuration(-1);
        violations = validator.validate(film);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testIncorrectRelease() {
        film.setReleaseDate(LocalDate.parse(String.valueOf(LocalDate.of(1895, 12, 27))));
        violations = validator.validate(film);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testEmptyDescription() {
        film.setDescription("");
        violations = validator.validate(film);
        assertEquals(0, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testIncorrectDurationIsNegative() {
        film.setDuration(-1);
        violations = validator.validate(film);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }
} */
