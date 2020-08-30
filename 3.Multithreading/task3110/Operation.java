package com.javarush.task.task31.task3110;
//Archiver (3)
// Как видишь, архивировать оказалось не так уж и сложно. Но наш архиватор получился каким-то уж слишком примитивным.
//Настоящий архиватор должен уметь гораздо больше: распаковку архива, добавление нового файла в существующий архив, удаление файла из архива, просмотр содержимого архива.
//Сейчас мы будем улучшать наш архиватор. А для этого придется написать несколько новых классов.
//Сначала давай создадим enum Operation, который будет содержать все команды, которые поддерживает наш архиватор.
//Так же было бы удобно использовать ConsoleHelper для работы с консолью, чтобы все что касается консоли было собрано в одном классе.
//В дальнейшем, если не указано обратного, то весь ввод и вывод должен происходить через ConsoleHelper.
//
//1. Объяви enum Operation, в него добавить команды:
//1.1. Создать архив CREATE
//1.2. Добавить файл в архив ADD
//1.3. Удалить файл из архива REMOVE
//1.4. Извлечь содержимое архива EXTRACT
//1.5. Просмотреть содержимое архива CONTENT
//1.6. Выйти из программы EXIT
//2. Создай класс ConsoleHelper и реализуй в нем статические публичные методы:
//2.1. Вывести сообщение в консоль void writeMessage(String message)
//2.2. Прочитать строку с консоли String readString()
//2.3. Прочитать число с консоли int readInt()
//Методы чтения с консоли могут бросать исключение IOException в случае ошибки ввода, учти это при их объявлении.
//
//Требования:
//•	Создай enum Operation. Он должен содержать следующие значения: CREATE, ADD, REMOVE, EXTRACT, CONTENT, EXIT.
//•	Создай класс ConsoleHelper.
//•	В классе ConsoleHelper нужно реализовать статический метод void writeMessage(String message), который будет выводить message в консоль.
//•	В классе ConsoleHelper нужно реализовать статический метод String readString(), который будет считывать с консоли строку.
//•	В классе ConsoleHelper нужно реализовать статический метод int readInt(), который будет считывать с консоли число.

public enum Operation {
    CREATE,
    ADD,
    REMOVE,
    EXTRACT,
    CONTENT,
    EXIT
}
