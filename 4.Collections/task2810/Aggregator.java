package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.HabrCareerStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
  public static void main(String[] args) {
    HtmlView view = new HtmlView();
    Provider providerHH = new Provider(new HHStrategy());
    Provider providerHabr = new Provider(new HabrCareerStrategy());
    Model model = new Model(view, providerHH, providerHabr);
    Controller controller = new Controller(model);
    view.setController(controller);
    view.userCitySelectEmulationMethod();
  }
}
