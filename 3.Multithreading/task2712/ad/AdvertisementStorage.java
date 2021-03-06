package com.javarush.task.task27.task2712.ad;
//Ресторан(7)
//При выборе, с какого класса начать, старайся найти тот, который используют другие, и который сам ничего не использует.
//В нашем случае - это хранилище рекламных роликов (AdvertisementStorage).
//Мы решили, что оно будет единственным в ресторане и сделали его синглтоном.
//
//Опишем его.
//1. Видео должно где-то храниться, пусть это будет список.
//Создадим поле videos и инициализируем его пустым листом.
//Подумай, должно ли поле videos иметь возможность менять свое значение?
//
//2. Чтобы как-то работать с видео, создай публичные методы:
//2.1. list() - который вернет список всех существующих доступных видео.
//2.2. add(Advertisement advertisement) - который добавит новое видео в список videos.
//
//3. В конструкторе класса добавим в список videos какие-то данные. У меня это:
//Object someContent = new Object();
//new Advertisement(someContent, "First Video", 5000, 100, 3 * 60) // 3 min
//new Advertisement(someContent, "Second Video", 100, 10, 15 * 60) //15 min
//new Advertisement(someContent, "Third Video", 400, 2, 10 * 60) //10 min
//
//4. В AdvertisementManager создадим final поле-ссылку на экземпляр AdvertisementStorage и назовем ее storage.
//Не забудь инициализировать созданное поле!
//
//
//Требования:
//1. В классе AdvertisementManager должно быть создано поле storage содержащее экземпляр класса AdvertisementStorage.
//2. В классе AdvertisementStorage список videos должен быть объявлен с модификатором доступа final.
//3. В классе AdvertisementStorage метод list должен возвращать список videos и быть публичным.
//4. В классе AdvertisementStorage метод add должен принимать один параметр типа Advertisement и добавлять полученный объект в список videos.
//5. В конструкторе класса AdvertisementStorage в список videos должно быть добавлено несколько объектов типа Advertisement.

import java.util.ArrayList;
import java.util.List;

public final class AdvertisementStorage {
  private static AdvertisementStorage instance;
  private final List<Advertisement> videos = new ArrayList<>();

  private AdvertisementStorage() {
    Object someContent = new Object();
    videos.add(new Advertisement(someContent, "First Video", 5000, 100,
            3 * 60));
    videos.add(new Advertisement(someContent, "Second Video", 100, 10,
            15 * 60));
    videos.add(new Advertisement(someContent, "Third Video", 400, 1,
            10 * 60));
    videos.add(new Advertisement(someContent, "четвертое видео", 5000, 100,
            4 * 60));
  }

  public static AdvertisementStorage getInstance() {
    if (instance == null) {
      instance = new AdvertisementStorage();
    }
    return instance;
  }

  public List<Advertisement> list() {
    return videos;
  }

  public void add(Advertisement advertisement) {
    videos.add(advertisement);
  }

}
