package com.javarush.task.task35.task3513;
//2048 (1)
//Привет! Надеюсь ты уже успел устать от обычных задач и с нетерпением ждешь большую!
//Сегодня напишем java реализацию игры 2048. Вкратце, если ты о ней ничего не слышал,
// целью игры является получение плитки номиналом 2048 на игровом поле 4х4.
// Подробнее можешь прочитать в википедии https://ru.wikipedia.org/wiki/2048_(%D0%B8%D0%B3%D1%80%D0%B0)
//
//Для начала нам понадобятся такие классы:
//1. Controller - будет следить за нажатием клавиш во время игры.
//2. Model - будет содержать игровую логику и хранить игровое поле.
//3. View - обеспечит отображение текущего состояния игры на экран.
//4. Main - будет содержать только метод main и служить точкой входа в наше приложение.
//
//Создай их!
//
//
//Требования:
//1. Должен быть создан класс Controller.
//2. Должен быть создан класс Model.
//3. Должен быть создан класс View.
//4. Должен быть создан класс Main с публичным статическим методом main (String[] args).

//2048 (10)
//Пора приступить к реализации метода main в классе Main, чтобы иметь возможность наконец-то запустить игру и отдохнуть!
//
//Метод main нам нужен только для того чтобы запустить приложение, все внутренности мы уже реализовали.
//Для этого мы создадим в нем модель и контроллер, а также объект типа JFrame.
// Для примера я назову его game, но ты можешь выбрать любое другое имя.
//
//У нашей игры (объекта типа JFrame) мы должны будем вызвать некоторые методы для того чтобы все корректно отображалось на экране:
//
//game.setTitle("2048");
//game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//game.setSize(450, 500);
//game.setResizable(false);
//
//game.add(controller.getView());
//
//
//game.setLocationRelativeTo(null);
//game.setVisible(true);
//
//Обрати внимание на метод add в который мы передаем представление из контроллера.
// У нас еще нет геттера для поля view в классе Controller. Не забудь его добавить.
//
//P.S. Результатом выполнения этого задания будет рабочая версия игры 2048,
// если у тебя вдруг что-то не работает, или работает не так как ожидалось,
// обязательно разберись и исправь прежде чем переходить к следующим задачам.
//
//
//Требования:
//1. В классе Controller должен быть создан корректный геттер для поля view.
//2. В методе main класса Main должна быть создана новая модель и контроллер на базе этой модели.
//3. В методе main класса Main должен быть создан объект типа JFrame.
//4. В методе main класса Main на объекте JFrame должны быть выполнены методы перечисленные в условии задачи.

//2048 (17)
//Поздравляю с реализацией своей собственной версии игры 2048!
//
//Помимо основного функционала ты также реализовал отмену последнего хода и автоматический
// выбор наилучшего хода с помощью оценки эффективности одиночного хода.
//
//Из возможных улучшений можешь попробовать увеличить глубину анализа эффективности хода и
// проверить, сможет ли твой алгоритм набрать максимально возможный счет в 839,732 очков.
//
//
//Требования:
//1. Поздравляю, ты отлично справился!

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    Model model = new Model();
    Controller controller = new Controller(model);
    JFrame game = new JFrame();

    game.setTitle("2048");
    game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    game.setSize(450, 500);
    game.setResizable(false);

    game.add(controller.getView());

    game.setLocationRelativeTo(null);
    game.setVisible(true);
  }
}
