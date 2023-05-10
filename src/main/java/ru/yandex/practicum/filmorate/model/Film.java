package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;
import ru.yandex.practicum.filmorate.validator.AfterDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//Setter,Getter,ToString,EqualsAndHashCode,RequiredArgsConstructor(final-поля или NonNull)
@Data
@Builder
public class Film {
    private long id; //целочисленный идентификатор

    @NotNull
    @NotBlank
    private String name; //название

    @NotNull
    @Size(max = 200)
    private String description; //описание

    @NotNull
    @AfterDate(value = "1895-12-28")
    private LocalDate releaseDate; //дата релиза;

    @NotNull
    @Positive
    private int duration;  //продолжительность фильма
}
