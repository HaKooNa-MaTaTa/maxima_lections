package animals;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Grey");
        Dog dog = new Dog("Black", "Boooch");
        Monkey monkey = new Monkey("Black", "Cezar", 2, 2);

        Monkey monkey2 = new Human("Brunette", "Petr", 1, 2, "Petrov", "Petrovich");

        Human human = new Human("Blondin", "Ivan", 2, 2, "Ivanov", "Ivanovich");


        //Восходящее преобразование - когда в объектной переменной класса предка (класса родителя) лежит
        // ссылка на объект класса потомка (дочернего класса)
        //Нисходящее преобразование - приведение типа объектной переменной к типу объекта
        //Animal animal = new Human("White", "Banzai", 2, 2, "Lalala", "lalalallovich");
        //instanceof -> проверяет, создавался ли данный объект на основе данного класса
        if (monkey2 instanceof Human) {
//            monkey2.jump();
//            double number = 12.7;
//            int a = (int) number;
            //Берем ссылку на объект Петра и кладем в переменную типа Human
            Human petr = (Human) monkey2;

            petr.work();
            petr.jump();
            petr.voice();
        }

        animal.voice();
        System.out.println("***********");
        dog.voice();
        dog.keep();
        System.out.println("***********");
        monkey.voice();
        monkey.jump();
        System.out.println("***********");
        human.voice();
        human.jump();
        human.work();
    }
}
