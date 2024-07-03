package operator_final;

//Ключевое слово final может использоваться в трех местах
//1. При объявлении класса. Если у класса стоит слово final, Значит этот класс не может иметь потомков
public final class Human {

    //2. При объявлении переменной. Значение в переменную можно положить только один раз.
    // Больше изменять переменную не получится
    //Раз переменная final, значит она - константа; -> значит ее можно сделать публичной и записать заглавными буквами.
    public final String VIEW = "Homo Sapiens";


    //3. При объявлении метода. Метод нельзя переопределить в классах - потомках;
    public final void live() {
        System.out.println("Я жив и буду жить!");
    }
}
