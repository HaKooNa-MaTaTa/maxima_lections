package object;

public class MainObj {
    public static void main(String[] args) {
        //Суперкласс, который является прародителем всех классов, в том числе, написанных самим разработчиком
        //Object

        Car bmwBlack = new Car("BMW", "X5", "Black");
        Car bmwBlue = new Car("BMW", "X5", "Blue");
        Car audi = new Car("Audi", "RS 6", "White");

        //Вызываем методы суперкласса Object
        System.out.println("Метод .toString()");
        System.out.println(bmwBlack.toString());// Текстовое представление объекта

        System.out.println("******************");
        System.out.println("Метод .equals()");
        //.equals() - Метод, который сравнивает два объекта. Если они идентичны - true, нет - false
        System.out.println(bmwBlack.equals(bmwBlue));
        System.out.println(bmwBlack.equals(audi));
        System.out.println("******************");
        System.out.println("Метод .hashCode()");
        //.hashCode() - Метод, который представляет объект в целочисленном виде
        System.out.println(bmwBlack.hashCode());
        System.out.println(bmwBlue.hashCode());
        System.out.println(audi.hashCode());

        //Контракты переопределения .equals() и .hashCode()
        //.equals() (5 контрактов):
        //null - для любого объекта x, вызов x.equals(null) всегда должен возвращать false
        // 1 контракт, связанный со сравнением объекта с самим с собой
        // Рефлективность - сколько бы раз не вызывался equals над объектом x (x.equals(x)), всегда должно возвращаться true
        // 2 контракта когда сравниваются 2 объекта
        // Симметричность - всегда, если x.equals(y) вернул true, значит и y.equals(x) тоже должен возвращать true
        // Согласованность - для любых x и y, всегда должен возвращаться один и тот же результат, при условии, что между
        // вызовами equals объекты не изменялись
        // 1 контракт когда сравниваются 3 объекта
        // Транзитивность - если x.equals(y) (x = y) вернул true и y.equals(z) (y = z) вернул true, (x = y = z)
        // x.equals(z) так же должен вернуть true

        //Рефлективность - сколько бы раз не вызывался equals над объектом x (x.equals(x)), всегда должно возвращаться true
        //Симметричность - всегда, если x.equals(y) вернул true, значит и y.equals(x) тоже должен возвращать true
        //Транзитивность - если x.equals(y) (x = y) вернул true и y.equals(z) (y = z) вернул true, (x = y = z)
        //Согласованность - для любых x и y, всегда должен возвращаться один и тот же результат, при условии, что между
        //вызовами equals объекты не изменялись
        //null - для любого объекта x, вызов x.equals(null) всегда должен возвращать false

        //HASHCODE
        //Вызов метода hashCode над одним и тем же объектом, должен возвращать всегда одно и то же значение при условии
        //что между вызовами объект не менялся
        //Вызов hashCode над двумя объектами должен возвращать одно и то же значение, если эти объекты равны по equals()

        //При этом, может получиться так, что объекты по equals разные, а hashCode выдает одно и то же значение.


        bmwBlack.getClass(); //Метод, который возвращает объект, который содержит информацию о классе, объекта
        bmwBlack = new Car("BMW", "E36", "Black");
    }
}
