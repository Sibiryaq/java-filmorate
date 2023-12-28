# java-filmorate
Этот проект - это платформа для любителей фильмов, которая предоставляет возможность пользователям выбирать, и оценивать свои любимые фильмы, а также находить наиболее популярные среди них. Так же есть возможность добавлять друзей

# Структура базы данных:

![диаграмма по ссылке на локальный файл в проекте](/diagram.png)

**Примеры запросов к базе данных:**

_________

<details>
  <summary>Добавить фильм</summary>
  
  ``` 
  INSERT INTO film (film_id, title, description, duration, release_date) VALUES (ID, 'TITLE', 'DESCRIPTION', DURATION , 'RELEASE (YYYY-MM-DD)';
  ```

</details>    

<details>
  <summary>Добавить жанр и рейтинг MPA</summary>

  ```
  INSERT INTO film_genre (film_id, genre_id, mpa_rating_id) VALUES (FILM_ID, GENRE_ID, MPA_RATING_ID);
  ```
</details>    

<details>
  <summary>Добавить в друзья</summary>

  ```
  INSERT INTO friends (user_id, friend_id, status)  VALUES (USER_ID, FRIEND_ID, 'FALSE');
  ```
</details>    

<details>
  <summary>Подтверждение дружбы</summary>
  
  ```
  UPDATE friends
  SET status = TRUE
  WHERE user_id = ID_ПОЛЬЗОВАТЕЛЯ;
  ```
</details>    

Возможности:
- REST controllers - можно ставить лайки фильмам, сортировать фильмы по рейтингу, жанру, заводить друзей, смотреть их любимые фильмы.
- Во время группового проекта были добавлены такие функциональности, как:  
  - **«Поиск»** 
  - **«Популярные фильмы»**, которая предусматривает вывод самых любимых у зрителей фильмов по жанрам и годам. 

Ссылка на групповой проект: https://github.com/AndreyAFedotov/java-filmorate



