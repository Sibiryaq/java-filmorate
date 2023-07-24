package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Mpa {
    private Integer id;

    @NotBlank(message = "Наименование рейтинга не должно быть пустым")
    private String name;
}
