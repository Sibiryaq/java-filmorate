package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import ru.yandex.practicum.filmorate.validator.AfterDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//Setter,Getter,ToString,EqualsAndHashCode,RequiredArgsConstructor(final-поля или NonNull)
@Data
public class Film {
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Size(max = 200)
    private String description;

    @NotNull
    @AfterDate(value = "1895-12-28")
    private LocalDate releaseDate;

    @NotNull
    @Positive
    private int duration;

    private Set<Long> likes; // Сет, чтобы НЕ добавить одного и того же дважды. Один пользователь - один лайк

    public Film(Long id, String name, String description, Integer duration, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.likes = new HashSet<>();
    }


}
