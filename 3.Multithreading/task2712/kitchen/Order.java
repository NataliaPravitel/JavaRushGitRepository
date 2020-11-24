package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Ресторан(1)
//Давай напишем программу для автоматизации работы в ресторане.
//
//Пусть задание сформулировано так - директор ресторана хочет, чтобы:
//1. на каждом столике лежал планшет, через который можно было бы сделать заказ;
//2. пока заказ готовится, на планшете показывалась реклама;
//3. в конце рабочего дня была возможность посмотреть различную статистику:
//а) загрузки повара;
//б) сумму выручки за заказы;
//в) сумму выручки за показы рекламы.
//
//Мы будем разрабатывать ядро, без UI. UI ты потом сможешь дописать самостоятельно, сейчас ограничимся консольным интерфейсом.
//Также мы часть данных захардкодим, ты потом сможешь прикрутить БД, и работать с ней.
//
//Выделим несколько фич, которые будем реализовывать:
//
//Первая:
//- созданный посетителем заказ будет автоматически поступать к повару;
//- повар будет готовить его какое-то время и отмечать приготовленным;
//- после этого официант будет относить его.
//
//Вторая:
//- подобрать нужные рекламные ролики из списка оплаченных;
//- отображение рекламных роликов во время приготовления заказа;
//- максимизировать прибыль от показа рекламы.
//
//Третья:
//- подсчет статистики;
//- отображение статистики директору.
//
//Начнем с первой фичи - автоматизация обработки заказа:
//
//Итак..
//1. Создай класс Restaurant с методом main.
//
//2. Начнем с планшета, создадим класс Tablet, в котором создадим поле private final int number -
// это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ.
// Номер планшета должен инициализироваться в конструкторе переданным параметром.
//
//3. В классе Tablet создадим метод public void createOrder(), который будет создавать заказ из тех блюд,
// которые выберет пользователь.
//Для этого создадим класс Order, который поместим в пакет kitchen.
//
//4. В классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
//Т.е. где-то должен быть список всех блюд, и должен быть список выбранных блюд в классе Order.
//В классе Order нужны поля private final Tablet tablet и protected List<Dish> dishes.
//Конструктор должен принимать один параметр типа Tablet и инициализировать поле tablet.
//
//5. Нам нужен класс Dish(Блюдо), создадим его в пакете kitchen. Пусть это будет enum со списком блюд:
// Fish, Steak, Soup, Juice, Water.
//
//6. Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить.
// Для этого в Dish создай метод public static String allDishesToString(), который сформирует строку из всех блюд.
//
//Пример: "Fish, Steak, Soup, Juice, Water". Формируй строку динамически.
//
//
//Требования:
//1. В классе Restaurant должен быть создан метод public static void main(String[] args).
//2. В классе Tablet должно быть создано поле private final int number.
//3. Конструктор класса Tablet должен принимать 1 параметр типа int и инициализировать поле number.
//4. В пакете kitchen должен быть создан enum Dish с элементами Fish, Steak, Soup, Juice, Water.
//5. В Dish должен быть создан статический метод allDishesToString, динамически формирующий строку из всех блюд.
//6. В пакете kitchen должен быть создан класс Order, содержащий в себе список блюд(dishes), а также планшет(tablet).
//7. Конструктор класса Order должен принимать один параметр типа Tablet и инициализировать поле tablet.
//8. В классе Tablet должен существовать метод public void createOrder().

public class Order {
  private final Tablet tablet;
  protected List<Dish> dishes;

  public Order(Tablet tablet) throws IOException {
    this.tablet = tablet;
    initDishes();
  }

  public List<Dish> getDishes() {
    return dishes;
  }

  @Override
  public String toString() {
    if (!isEmpty()) {
      return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() +
              "min";
    } else {
      return null;
    }
  }

  public int getTotalCookingTime() {
    int totalCookingTime = 0;
    for(Dish dish : dishes) {
      totalCookingTime += dish.getDuration();
    }
    return totalCookingTime;
  }

  public boolean isEmpty() {
    return dishes.isEmpty();
  }

  protected void initDishes() throws IOException {
    this.dishes = ConsoleHelper.getAllDishesForOrder();
  }
}
