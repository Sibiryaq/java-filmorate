package ru.yandex.practicum.filmorate.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.validator.exception.FilmValidatorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.yandex.practicum.filmorate.validator.FilmValidator.validate;

class FilmValidatorTest {
    private Film film;

    @BeforeEach
    public void setUp() {
        film = new Film();
        film.setId(100L);
        film.setName("Sherlock");
        film.setDescription("Just film");
        film.setReleaseDate(LocalDate.parse("2015-01-01"));
        film.setDuration(215);
    }

    @Test
    void testValidateName() {
        assertDoesNotThrow(() -> validate(film));
        film.setName(null);
        assertThrows(FilmValidatorException.class, () -> validate(film));
        film.setName("    ");
        assertThrows(FilmValidatorException.class, () -> validate(film));
    }

    @Test
    void testValidateDescription() {
        assertDoesNotThrow(() -> validate(film));
        film.setDescription(new String(new char[200]));
        assertDoesNotThrow(() -> validate(film));
        film.setDescription(new String(new char[201]));
        assertThrows(FilmValidatorException.class, () -> validate(film));
        film.setDescription(new String(new char[202]));
        assertThrows(FilmValidatorException.class, () -> validate(film));
    }

    @Test
    void testValidateReleaseDate() {
        assertDoesNotThrow(() -> validate(film));
        film.setReleaseDate(LocalDate.parse("1895-12-27"));
        assertThrows(FilmValidatorException.class, () -> validate(film));
        film.setReleaseDate(LocalDate.parse("1895-12-28"));
        assertDoesNotThrow(() -> validate(film));
        film.setReleaseDate(LocalDate.parse("1895-12-29"));
        assertDoesNotThrow(() -> validate(film));
    }

    @Test
    void testValidateDuration() {
        assertDoesNotThrow(() -> validate(film));
        film.setDuration(-1);
        assertThrows(FilmValidatorException.class, () -> validate(film));
        film.setDuration(0);
        assertDoesNotThrow(() -> validate(film));
        film.setDuration(1);
        assertDoesNotThrow(() -> validate(film));
    }
}
