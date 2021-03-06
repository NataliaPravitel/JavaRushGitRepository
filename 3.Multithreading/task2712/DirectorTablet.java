package com.javarush.task.task27.task2712;
//Ресторан(15)
//Давай подумаем что нужно сделать, чтобы директор мог посмотреть:
//1. какую сумму заработали на рекламе, сгруппировать по дням;
//2. загрузка (рабочее время) повара, сгруппировать по дням;
//3. список активных роликов и оставшееся количество показов по каждому;
//4. список неактивных роликов (с оставшемся количеством показов равным нулю).
//
//Для каждого пункта добавим соответствующий метод в StatisticManager.
//Директор будет вызывать метод, StatisticManager будет делать различные подсчеты.
//Но директор должен из какого-то места вызвать эти методы. Дадим ему планшет, но с другим ПО.
//Для этого создадим класс DirectorTablet, в котором будут дружелюбный интерфейс и возможность обращения к статистике.
//
//1. В корне задачи-проекта создай класс DirectorTablet.
//
//2. В классе DirectorTablet создай четыре void метода:
//printAdvertisementProfit(), printCookWorkloading(), printActiveVideoSet(), printArchivedVideoSet()
//Они соответствуют перечисленным четырем пунктам.
//
//3. Чтобы можно было проверить результат, добавим в метод main создание директорского планшета и
// вывод статистики с помощью методов перечисленных выше.
//
//Нам понадобятся еще некоторые методы.
//4. В EventDataRow создай методы:
//Date getDate(), реализация которого вернет дату создания записи int getTime(), реализация которого вернет время - продолжительность
//
//5. В StatisticManager void register(Cook cook), который зарегистрирует полученного повара.
//Создай в классе StatisticManager множество (Set) поваров (cooks) и добавь в него повара.
//
//6. Реализуй необходимые геттеры у классов CookedOrderEventDataRow, NoAvailableVideoEventDataRow и VideoSelectedEventDataRow.
//
//
//Требования:
//1. В классе DirectorTablet должны быть созданы методы перечисленные в условии задачи.
//2. В методе main класса Restaurant должен быть создан новый DirectorTablet и вызваны методы отображения статистики.
//3. В интерфейсе EventDataRow должны быть объявлены методы getDate и getTime.
//4. В классе StatisticManager должен быть реализован метод register с одним параметром типа Cook,
// регистрирующий полученного повара в множестве всех поваров (cooks).

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
  StatisticManager statisticManager = StatisticManager.getInstance();

  void printAdvertisementProfit() {
    Map<Date, Long> profitPerDayByAdvertisement = statisticManager
            .getProfitPerDayByAdvertisementMap();
    long totalAmount = 0;
    for (Map.Entry<Date, Long> entry : profitPerDayByAdvertisement.entrySet()) {
      ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
              .format(entry.getKey()) + " - " + 1.0 * entry.getValue() / 100);
      totalAmount += entry.getValue();
    }
    ConsoleHelper.writeMessage("Total - " + 1.0 * totalAmount / 100);
  }

  void printCookWorkloading() {
    Map<Date, TreeMap<String, Integer>> cookWork = statisticManager.getWorkingTimePerDaysByCooks();
    for (Map.Entry<Date, TreeMap<String, Integer>> entry : cookWork.entrySet()) {
      TreeMap<String, Integer> cookNameAndTime = entry.getValue();
      String date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)
              .format(entry.getKey());
      ConsoleHelper.writeMessage(date);
      for (Map.Entry<String, Integer> cookData : cookNameAndTime.entrySet()) {
        String name = cookData.getKey();
        int workTime = cookData.getValue();
        ConsoleHelper.writeMessage(name + " - " + (workTime + 59) / 60 + " min");
      }
    }
  }

  void printActiveVideoSet() {
    StatisticAdvertisementManager advertisementManager =
            StatisticAdvertisementManager.getInstance();
    TreeSet<Advertisement> videos = advertisementManager.getVideoSet(true);
    videos.forEach(advertisement ->
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits()));
  }

  void printArchivedVideoSet() {
    StatisticAdvertisementManager advertisementManager =
            StatisticAdvertisementManager.getInstance();
    TreeSet<Advertisement> videos = advertisementManager.getVideoSet(false);
    videos.forEach(advertisement ->
            ConsoleHelper.writeMessage(advertisement.getName()));
  }
}
