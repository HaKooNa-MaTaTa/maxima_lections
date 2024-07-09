package java_io_and_dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Java IO (Input / Output) - библиотека для работы с потоками данных (ввода и вывода)
//Поток данных - упорядоченная последовательность данных, которой соответствует определенный источник
public class HumanDAOInFileMemory implements IHumanDAO {

    private static int count_id = 0;
    //throws - переводится вот так - "Я не хочу обрабатывать это исключение, пусть его будет обрабатывать тот, кто вызовет мой метод"
    @Override
    public Human create(Human human) {
        human.setId(count_id);
        count_id++;
        File file = new File("resources/humans.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Файл не получилось создать");
            e.printStackTrace();
            System.exit(0);
        }
        //InputStream и OutputStream - абстрактные классы для чтения и записи байтов
        //Reader и Writer - абстрактные классы для чтение и записи символов

        try {
            //Данная реализация направлена на быстродействие, за счет того, что записывает сначала все в буфер, а потом разом все пишет в файл
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/humans.txt", true));
            bufferedWriter.write(human.toString() + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("IOException :C");
        }

        return human;
    }

    @Override
    public Human findById(int id) {
        return null;
    }

    @Override
    public void update(Human human) {

    }

    @Override
    public void delete(int id) {

    }
}
