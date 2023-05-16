package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private Long id; // целочисленный идентификатор

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

    private Set<Long> friends = new HashSet<>();

    public User(Long id, String email, String login, String name, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = (name == null || name.isEmpty() || name.isBlank()) ? login : name;
        this.birthday = birthday;
    }

}
