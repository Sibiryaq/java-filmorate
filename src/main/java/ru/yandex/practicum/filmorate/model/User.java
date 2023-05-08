package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class User {
    private long id; // целочисленный идентификатор
    @Email
    private String email; // почта
    @NotBlank
    private String login;  // логин пользователя
    private String name;  // имя
    @PastOrPresent
    private LocalDate birthday; // дата рождения
}
