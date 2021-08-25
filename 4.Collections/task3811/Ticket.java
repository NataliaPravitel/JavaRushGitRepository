package com.javarush.task.task38.task3811;
//Реализуй в отдельном файле аннотацию Ticket.
//
//Требования к ней следующие:
//1) Должна быть публичная и доступна во время выполнения программы.
//2) Применяться может только к новым типам данных (Class, interface (including annotation type), or enum declaration).
//3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
//4) Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.
//5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
//6) Свойство createdBy будет строкой - по умолчанию Amigo.
//
//
//Requirements:
//1. Аннотация Ticket должна быть публичная и доступна во время выполнения программы.
//2. Аннотация Ticket должна применяться только к новым типам данных.
//3. Аннотация Ticket должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
//4. Аннотация Ticket должна содержать свойство priority - по умолчанию Priority.MEDIUM.
//5. Аннотация Ticket должна содержать свойство tags - массив строк, пустой по умолчанию.
//6. Аннотация Ticket должна содержать свойство createdBy - строку, равную "Amigo" по умолчанию.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ticket {
  enum Priority {
    LOW, MEDIUM, HIGH
  }

  Priority priority() default Priority.MEDIUM;

  String[] tags() default {};

  String createdBy() default "Amigo";
}
