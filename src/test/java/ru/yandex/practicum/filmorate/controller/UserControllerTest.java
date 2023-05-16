package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.User;

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

public class UserControllerTest {
    private User user;
    private static Validator validator;
    private Set<ConstraintViolation<User>> violations;

    @BeforeEach
    public void beforeEach() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        user = new User(1L, "4totakoeaaa@mail.ru", "sibiryaq", "Саша",
                LocalDate.of(1994, 6, 25));
        violations = validator.validate(user);
    }

    // Добавление пользователя
    @Test
    public void testAddFilm() {
        violations = validator.validate(user);
        assertEquals(0, violations.size(), "Ошибки валидации");
        List<User> users = new ArrayList<>();
        users.add(user);
        assertTrue(users.contains(user), "Пользователь не был добавлен в список");
    }

    // проверка пустого email
    @Test
    public void testEmailIsEmpty() {
        user.setEmail("");
        violations = validator.validate(user);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testIncorrectEmail() {
        user.setEmail("yandex.ru");
        violations = validator.validate(user);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testIncorrectLogin() {
        user.setLogin("");
        violations = validator.validate(user);
        assertEquals(2, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testIncorrectNameWithSpaces() {
        user.setLogin("sibi ryaq");
        violations = validator.validate(user);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testEmptyName() {
        user.setName("");
        violations = validator.validate(user);
        assertEquals(0, violations.size(), "Ошибки валидации");
    }

    @Test
    public void testFutureBirthday() {
        user.setBirthday(LocalDate.parse(String.valueOf(LocalDate.now().plusDays(1))));
        violations = validator.validate(user);
        assertEquals(1, violations.size(), "Ошибки валидации");
    }
}