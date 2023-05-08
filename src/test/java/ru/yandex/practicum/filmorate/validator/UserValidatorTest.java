package ru.yandex.practicum.filmorate.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.validator.exception.UserValidatorException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static ru.yandex.practicum.filmorate.validator.UserValidator.validate;

class UserValidatorTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(100L);
        user.setEmail("example@example.com");
        user.setLogin("qwerty123");
        user.setName("Zxczxc");
        user.setBirthday(LocalDate.parse("1997-01-01"));
    }

    @Test
    void testValidateEmail() {
        assertDoesNotThrow(() -> validate(user));
        user.setEmail(null);
        assertThrows(UserValidatorException.class, () -> validate(user));
        user.setEmail("exampleexample.com");
        assertThrows(UserValidatorException.class, () -> validate(user));
    }

    @Test
    void testValidateLogin() {
        assertDoesNotThrow(() -> validate(user));
        user.setLogin(null);
        assertThrows(UserValidatorException.class, () -> validate(user));
        user.setLogin("Best user");
        assertThrows(UserValidatorException.class, () -> validate(user));
    }

    @Test
    void testValidateName() {
        assertDoesNotThrow(() -> validate(user));
        user.setName(null);
        assertDoesNotThrow(() -> validate(user));
        assertEquals(user.getLogin(), user.getName());
        user.setName("      ");
        assertDoesNotThrow(() -> validate(user));
        assertEquals(user.getLogin(), user.getName());
    }

    @Test
    void testValidateBirthday() {
        assertDoesNotThrow(() -> validate(user));
        user.setBirthday(LocalDate.MAX);
        assertThrows(UserValidatorException.class, () -> validate(user));
    }
}

