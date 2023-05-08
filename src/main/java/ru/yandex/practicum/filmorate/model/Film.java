package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

//Setter,Getter,ToString,EqualsAndHashCode,RequiredArgsConstructor(final-поля или NonNull)
@Data
public class Film {
    private long id; //целочисленный идентификатор
    @NotBlank
    private String name; //название
    @Size(min = 1, max = 200)
    private String description; //описание
    @PastOrPresent
    private LocalDate releaseDate; //дата релиза;
    @Positive
    private int duration;  //продолжительность фильма
}
