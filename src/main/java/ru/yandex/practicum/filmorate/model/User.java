package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
public class User {
    private long id; // целочисленный идентификатор

    @NotNull
    @NotBlank
    @Email
    private String email; // почта

    @NotNull
    @NotBlank
    @Pattern(regexp = "\\S+")
    private String login;  // логин пользователя

    private String name;  // имя

    @NotNull
    @Past
    private LocalDate birthday; // дата рождения
}
