## ООП. Базовые понятия. Инкапсуляция.

Определение ООП и его принципы.

ООП - Объектно-Ориентированное Программирование - это **стиль мышления программиста, который представляет
любую программу в виде объектов, которые взаимодействуют друг с другом.**

ООП держится на четырех столпах:
- Инкапсуляция
- Абстракция
- Наследование
- Полиморфизм


Класс - абстрактный тип данных, определяемый программистом. В принципе, все программирование на Java, является написанием классов.

Объект/экземпляр класса - конкретный экземпляр класса. Он обладает состоянием и поведением.

## Инкапсуляция

Объект представляется в виде "капсулы"

Первое определение инкапсуляции - возможность объединения алгоритмов и структур данных в одной сущности класса,
и на основе класса создавать объект, обладающий поведением и состоянием

Второе определение инкапсуляции - возможность закрытия внутренней структуры данных с целью поддержания корректности кода.

Третье - предоставление контролируемого доступа к объекту.

Контролируемы доступ (целостность данных) обеспечивается благодаря двум вещам - модификаторами доступа и методами доступа

Модификатор доступа:

* public - общий доступ, класс/метод/переменная у которых стоит данный модификатор доступен из любой точки проекта
* private - класс (только для вложенных/внутренних классов) / метод / переменная,  у которой стоит данный модификатор виден/доступен только внутри своего класса
* protected - класс (только для вложенных/внутренних классов) / метод / переменная, у которой стоит данный модификатор виден/доступен только внутри своего класса и классах наследниках
* default-package - класс/метод/переменная у которых стоит данный модификатор доступен/виден только внутри своей папки

Методы доступа. Не являются какой то обязательной синтаксической единицей, но наличие методов доступа это признак качественного ООП-кода.

Есть два типа методов доступа:
Геттеры - для получения данных
Сеттеры - для изменения данных