package com.javarush.task.task27.task2712.kitchen;
//Ресторан(3)
//Сейчас мы можем создавать заказы. Давай сделаем так, чтобы они автоматически поступали к повару.
//Есть много различных способов реализации данной функциональности.
//Почитай про паттерн Observer - http://en.wikipedia.org/wiki/Observer_pattern
//Он уже реализован в java, и мы его будем использовать.
//
//1. Создадим класс Cook(Повар) в пакете kitchen, он будет готовить. Пусть в конструкторе приходит его имя, которое выводится методом toString.
//
//2. Tablet создает заказы, а Cook их обрабатывает. Расставь правильно Observer и Observable между Tablet и Cook.
//
//3. Метод void update(Observable observable, Object arg), который необходимо реализовать, принимает два параметра.
//- observable - объект, который отправил нам значение
//- arg - само значение, в нашем случае - это объект Order
//На данном этапе мы будем лишь имитировать обработку и выведем в консоль "Start cooking - " + order
//
//3. Пишем main.
//Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
//Называем повара, имя не влияет на тесты. В моем варианте - это Amigo : )
//
//Сверим выводы в консоль. Пример моего вывода:
//Your order: [Soup] of Tablet{number=5}
//Start cooking - Your order: [Soup] of Tablet{number=5}
//
//4. Не забудь сразу после создания заказа и вывода информации о нем в консоль (найдите это место в коде) сделать следующее:
//4.1. Установить флаг setChanged()
//4.2. Отправить обсерверу заказ - notifyObservers(order);
//
//5. Также внесем небольшое изменение. Сделай так чтобы метод createOrder возвращал текущий заказ или null, если заказ создать не удалось.
//
//
//Требования:
//1. Конструктор класса Cook должен принимать в качестве параметра строку и инициализировать имя повара (поле name).
//2. Метод toString класса Cook должен возвращать значение поля name.
//3. Класс Cook должен реализовывать интерфейс Observer.
//4. Класс Tablet должен быть потомком класса Observable.
//5. В методе createOrder класса Tablet должен быть вызван метод setChanged.
//6. В методе createOrder класса Tablet должен быть вызван метод notifyObservers с текущим заказом в качестве параметра.
//7. Метод update в классе Cook должен выводить на экран строку форматированную согласно заданию.
//8. В методе main класса Restaurant должен быть создан новый повар и добавлен планшету в качестве наблюдателя с помощью метода addObserver.

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
  private String name;
  private boolean busy;
  private LinkedBlockingQueue<Order> queue;

  public Cook(String name) {
    this.name = name;
  }

  public void setQueue(LinkedBlockingQueue<Order> queue) {
    this.queue = queue;
  }

  public boolean isBusy() {
    return busy;
  }

  @Override
  public String toString() {
    return name;
  }

  public void startCookingOrder(Order order) {
    busy = true;
    ConsoleHelper.writeMessage("Start cooking - " + order);
    StatisticManager.getInstance().register(new CookedOrderEventDataRow(
            order.toString(), this.name,
            order.getTotalCookingTime()*60,
            order.getDishes()));
    try {
      Thread.sleep(order.getTotalCookingTime() * 10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    setChanged();
    notifyObservers(order);
    busy = false;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Thread.sleep(10);
        if (!queue.isEmpty()) {
          if (!this.isBusy()) {
            this.startCookingOrder(queue.take());
          }
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
