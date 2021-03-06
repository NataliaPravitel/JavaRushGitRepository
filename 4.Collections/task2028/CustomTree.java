package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
Амиго, похоже ты уже достаточно окреп. Самое время проверить свои навыки в большой задаче!
Сегодня реализуем свое дерево немного нестандартным способом(на базе AbstractList).
Вводную информацию можешь получить используя свой любимый поисковик и текст ниже.
Элементы дерева должны следовать так как показано на картинке:
Для начала сделаем наше дерево потомком класса AbstractList с параметром типа String,
а также реализуем интерфейсы Cloneable и Serializable.
Реализацию методов get(int index) и size() пока оставь стандартной.

Требования:
1. Класс CustomTree должен поддерживать интерфейс Cloneable.
2. Класс CustomTree должен поддерживать интерфейс Serializable.
3. Класс CustomTree должен быть потомком класса AbstractList<String>.


Построй дерево(2)
Несмотря на то что наше дерево является потомком класса AbstractList, это не список в привычном понимании.
В частности нам недоступны принимающие в качестве параметра индекс элемента.
Такие методы необходимо переопределить и бросить новое исключение типа UnsupportedOperationException.
Вот их список:
public String get(int index)
public String set(int index, String element)
public void add(int index, String element)
public String remove(int index)
public List<String> subList(int fromIndex, int toIndex)
protected void removeRange(int fromIndex, int toIndex)
public boolean addAll(int index, Collection<? extends String> c)

Требования:
1. При попытке вызвать метод get(int index) должно возникать исключение типа
UnsupportedOperationException.
2. При попытке вызвать метод set(int index, String element) должно возникать исключение типа
UnsupportedOperationException.
3. При попытке вызвать метод add(int index, String element) должно возникать исключение типа
UnsupportedOperationException.
4. При попытке вызвать метод String remove(int index) должно возникать исключение типа
UnsupportedOperationException.
5. При попытке вызвать метод subList(int fromIndex, int toIndex) должно возникать исключение типа
UnsupportedOperationException.
6. При попытке вызвать метод removeRange(int fromIndex, int toIndex) должно возникать исключение
типа UnsupportedOperationException.
7. При попытке вызвать метод addAll(int index, Collection<? extends String> c) должно возникать
исключение типа UnsupportedOperationException.


Построй дерево(3)
Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
1.  В классе CustomTree создай вложенный статический параметризированный класс Entry<T>
с модификатором доступа по умолчанию.
2. Обеспечь поддержку этим классом интерфейса Serializable.
3. Создай такие поля (модификатор доступа по умолчанию):
- String elementName;
- boolean availableToAddLeftChildren, availableToAddRightChildren;
- Entry<T> parent, leftChild, rightChild;
- при необходимости, можешь создавать и другие поля;
4. Реализуй публичный конструктор с одним параметром типа String:
- установи поле elementName равным полученному параметру;
- установи поле availableToAddLeftChildren равным true;
- установи поле availableToAddRightChildren равным true;
5. Реализуй публичный метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей
availableToAddLeftChildren и availableToAddRightChildren.

Требования:
1. Класс CustomTree.Entry должен быть объявлен с модификатором доступа по умолчанию.
2. Класс CustomTree.Entry должен поддерживать интерфейс Serializable.
3. В классе CustomTree.Entry должно существовать поле elementName типа String.
4. В классе CustomTree.Entry должно существовать поле availableToAddLeftChildren типа boolean.
5. В классе CustomTree.Entry должно существовать поле availableToAddRightChildren типа boolean.
6. В классе CustomTree.Entry должно существовать поле parent типа Entry.
7. В классе CustomTree.Entry должно существовать поле leftChild типа Entry.
8. В классе CustomTree.Entry должно существовать поле rightChild типа Entry.
9. В классе CustomTree.Entry должен быть корректно реализован конструктор с одним параметром
типа String (смотри условие).
10. В классе CustomTree.Entry должен корректно реализован метод isAvailableToAddChildren
(смотри условие).


Построй дерево(4)
Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить
поле root типа Entry<String> c модификатором доступа по умолчанию.
Инициируй его в конструкторе CustomTree, имя (elementName) не важно.
Итак, основа дерева создана, пора тебе поработать немного самому.
Вспомним как должно выглядеть наше дерево.
Элементы дерева должны следовать так как показано на картинке:
Необходимо написать методы, которые бы позволили создать такую структуру дерева
и проводить операции над ней.

Тебе необходимо:
1) переопределить метод add(String s) - добавляет элементы дерева,
в качестве параметра принимает имя элемента (elementName),
искать место для вставки начинаем слева направо.
2) переопределить метод size() - возвращает текущее количество элементов в дереве.
3) реализовать метод getParent(String s) - возвращает имя родителя элемента дерева,
имя которого было полученного в качестве параметра.

Если необходимо, можешь вводить дополнительные методы и поля, не указанные в задании.

Требования:
1. В классе CustomTree должно существовать поле root типа Entry.
2. В классе CustomTree должны быть переопределены методы add(String s) и size().
3. После добавления N элементов в дерево с помощью метода add, метод size должен возвращать N.
4. Метод getParent должен возвращать имя родителя для любого элемента дерева.


Построй дерево(5)
Добавлять в дерево элементы мы можем, теперь займись удалением:
Необходимо реализовать метод remove(Object o), который будет удалять элемент дерева
имя которого было полученного в качестве параметра.
Если переданный объект не является строкой, метод должен бросить UnsupportedOperationException.
Если в дереве присутствует несколько элементов с переданным именем -
можешь удалить только первый найденный.
Не забывай сверять поведение своего дерева с картинкой:
Что будет если удалить из дерева элементы "3", "4", "5" и "6",
а затем попытаемся добавить новый елемент?
В таком случае элементы "1" и "2" должны восстановить возможность иметь потомков
(возможно придется внести изменения в метод add()).

Требования:
1. После удаления последнего добавленного элемента из дерева с помощью метода remove,
метод size должен возвращать N-1.
2. После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1
(для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3. Если переданный объект не является строкой, метод remove()
должен бросить UnsupportedOperationException.
4. Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
  Entry<String> root;
  private List<Entry<String>> tree = new LinkedList<>();

  public CustomTree() {
    this.root = new Entry<>(null);
    tree.add(root);
  }

  @Override
  public String get(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int size() {
    return tree.size() - 1;
  }

  public void printChild(String s) {
    for (Entry<String> el : tree) {
      if (el.elementName != null) {
        if (el.elementName.equals(s)) {
          System.out.println(el.leftChild.elementName);
          System.out.println(el.rightChild);
        }
      }
    }
  }

  @Override
  public boolean add(String s) {
    Queue<Entry<String>> tempTree = new LinkedList<>();
    tempTree.add(root);
    Deque<Entry<String>> elementsWithBothDeleteChildren = new ArrayDeque<>();
    boolean isAdd = false;

    do{
      Entry<String> topElementInBranch = tempTree.poll();
      if (topElementInBranch != null) {
        String nameTOP = topElementInBranch.elementName;
        if (topElementInBranch.availableToAddLeftChildren) {
          Entry<String> leftChild = new Entry<>(s);
          topElementInBranch.leftChild = leftChild;
          leftChild.parent = topElementInBranch;
          topElementInBranch.availableToAddLeftChildren = false;
          isAdd = true;

          return tree.add(leftChild);

        } else if (topElementInBranch.availableToAddRightChildren) {
          Entry<String> rightChild = new Entry<>(s);
          topElementInBranch.rightChild = rightChild;
          rightChild.parent = topElementInBranch;
          topElementInBranch.availableToAddRightChildren = false;
          isAdd = true;
          return tree.add(rightChild);

        } else if (!topElementInBranch.isAvailableToAddChildren()) {

          if (topElementInBranch.wasDeleteBothChildren()) {
            elementsWithBothDeleteChildren.add(topElementInBranch);

          } else {
            tempTree.add(topElementInBranch.leftChild);
            tempTree.add(topElementInBranch.rightChild);
          }

        }
      }

    } while (!tempTree.isEmpty());
    if (!isAdd && elementsWithBothDeleteChildren.size() > 0) {
      do {
        Entry<String> elementWithBothDeleteChildren = elementsWithBothDeleteChildren.poll();
        for (Entry<String> element : tree) {
          if (element.elementName != null) {
            if (element.elementName.equals(elementWithBothDeleteChildren.elementName)) {
              element.availableToAddLeftChildren = true;
              element.availableToAddRightChildren = true;
            }
          }
        }
      } while (!elementsWithBothDeleteChildren.isEmpty());

      return add(s);
    }

    return false;
  }

  @Override
  public boolean remove(Object o) {
    if (! (o instanceof String)) {
      throw new UnsupportedOperationException();
    }
    String removeElementName = (String) o;
    Deque<Entry<String>> allElementsInDeleteBranch = new ArrayDeque<>();

    for (Entry<String> element : tree) {
      if (element.elementName != null && element.elementName.equals(removeElementName)) {
        allElementsInDeleteBranch.add(element);
        break;
      }
    }
    allElementsInDeleteBranch = searchAllChild(allElementsInDeleteBranch);

    do {
      Entry<String> deleteElement = allElementsInDeleteBranch.pollLast();
      String deleteElementName = deleteElement.elementName;
      String parentDeleteElemName = deleteElement.parent.elementName;

      for (Entry<String> elementInTree : tree) {
        String elName = elementInTree.elementName;

        if (elName != null) {
          if (elementInTree.leftChild != null) {
            if (elName.equals(parentDeleteElemName) &&
                    elementInTree.leftChild.elementName.equals(deleteElementName)) {

              elementInTree.availableToAddLeftChildren = false;
              elementInTree.deleteLeftChildren = true;
              elementInTree.leftChild = null;
              break;
            }

          } if(elementInTree.rightChild != null) {
            if (elName.equals(parentDeleteElemName)
                    && elementInTree.rightChild.elementName.equals(deleteElementName)) {

              elementInTree.availableToAddRightChildren = false;
              elementInTree.deleteRightChildren = true;
              elementInTree.rightChild = null;
              break;
            }
          }
        }
      }
      deleteElement.availableToAddLeftChildren = false;
      deleteElement.availableToAddRightChildren = false;
      deleteElement.parent = null;
      tree.remove(deleteElement);
    } while (!allElementsInDeleteBranch.isEmpty());

    return false;
  }

  private Deque<Entry<String>> searchAllChild(Deque<Entry<String>> removeElements) {
    Deque<Entry<String>> temp = new ArrayDeque<>(removeElements);

    do {
      Entry<String> top = temp.pollLast();

      if (!top.isAvailableToAddChildren()) {
        removeElements.add(top.leftChild);
        temp.add(top.leftChild);
        removeElements.add(top.rightChild);
        temp.add(top.rightChild);
      } else if (!top.availableToAddLeftChildren) {
        removeElements.add(top.leftChild);
        temp.add(top.leftChild);
      } else if (!top.availableToAddRightChildren) {
        removeElements.add(top.rightChild);
        temp.add(top.rightChild);
      }

    } while (!temp.isEmpty());
    return removeElements;
  }

  public String getParent(String s) {
    String parent = null;
    for (Entry<String> element : tree) {
      if (s.equals(element.elementName) && element.parent != null) {
        parent = element.parent.elementName;
      }
    }
    return parent;
  }

  @Override
  public String set(int index, String element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void add(int index, String element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String remove(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<String> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException();
  }

  @Override
  protected void removeRange(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(int index, Collection<? extends String> c) {
    throw new UnsupportedOperationException();
  }

  static class Entry<T> implements Serializable {
    String elementName;
    boolean availableToAddLeftChildren;
    boolean availableToAddRightChildren;
    boolean deleteLeftChildren;
    boolean deleteRightChildren;
    Entry<T> parent;
    Entry<T> leftChild;
    Entry<T> rightChild;

    public Entry(String elementName) {
      this.elementName = elementName;
      this.availableToAddLeftChildren = true;
      this.availableToAddRightChildren = true;
      this.deleteLeftChildren = false;
      this.deleteRightChildren = false;
    }

    public boolean isAvailableToAddChildren() {
      return availableToAddLeftChildren || availableToAddRightChildren;
    }

    public boolean wasDeleteBothChildren() {
      return deleteLeftChildren && deleteRightChildren;
    }

  }
}
