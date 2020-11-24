package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

//Ресторан(16)
//Реализуем первый пункт статистики - какую сумму заработали на рекламе, сгруппировать по дням.
//
//1. В классе VideoSelectedEventDataRow создай геттер для поля amount.
//В классе CookedOrderEventDataRow создай геттер для поля cookName.
//
//2. В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные,
// относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.
//Дополнительно добавь вспомогательный метод get в класс хранилища, чтобы получить доступ к данным.
//
//3. Начнем с логики метода printAdvertisementProfit в классе DirectorTablet.
//Используя метод из предыдущего пункта вывести в консоль в убывающем порядке даты и суммы.
//Для каждой даты из хранилища событий, для которой есть показанная реклама, должна выводится
// сумма прибыли за показы рекламы для этой даты.
//В конце вывести слово Total и общую сумму.
//
//Пример:
//14-Jul-2013 - 2.50
//13-Jul-2013 - 1.02
//12-Jul-2013 - 543.98
//Total - 547.50
//
//4. Реализуем второй пункт статистики - загрузка (рабочее время) повара, сгруппировать по дням.
//
//В StatisticManager создай метод (придумать самостоятельно), который из хранилища достанет все данные,
// относящиеся к работе повара, и посчитает общую продолжительность работы для каждого повара отдельно.
//
//5. Реализуем логику метода printCookWorkloading в классе DirectorTablet.
//Используя метод из предыдущего пункта вывести в консоль в убывающем порядке даты, имена поваров и
// время работы в минутах (округлить в большую сторону).
//Для каждой даты из хранилища событий, для которой есть запись о работе повара, должна выводится
// продолжительность работы в минутах для этой даты.
//Если повар не работал в какой-то из дней, то с пустыми данными его НЕ выводить (см. 13-Jul-2013)
//Поваров сортировать по имени
//
//Пример:
//14-Jul-2013
//Ivanov - 60 min
//Petrov - 35 min
//
//13-Jul-2013
//Ivanov - 129 min
//
//12-Jul-2013
//Ivanov - 6 min
//Petrov - 5 min
//
//6. Обрати внимание, что при выводе даты, название месяца должно быть на английском
// (при форматировании можно передать параметр Locale.ENGLISH).
//
//
//Требования:
//1. В классе VideoSelectedEventDataRow должен быть создан геттер для поля amount.
//2. В классе CookedOrderEventDataRow должен быть создан геттер для поля cookName.
//3. Метод printAdvertisementProfit класса DirectorTablet должен быть реализован в соответствии с условием задачи.
//4. Метод printCookWorkloading класса DirectorTablet должен быть реализован в соответствии с условием задачи.

public class VideoSelectedEventDataRow implements EventDataRow {
  private List<Advertisement> optimalVideoSet;
  private long amount;
  private int totalDuration;
  private Date currentDate;

  public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount,
                                   int totalDuration) {
    this.optimalVideoSet = optimalVideoSet;
    this.amount = amount;
    this.totalDuration = totalDuration;
    this.currentDate = new Date();
  }

  @Override
  public EventType getType() {
    return EventType.SELECTED_VIDEOS;
  }

  @Override
  public Date getDate() {
    return currentDate;
  }

  @Override
  public int getTime() {
    return totalDuration;
  }

  public long getAmount() {
    return amount;
  }
}
