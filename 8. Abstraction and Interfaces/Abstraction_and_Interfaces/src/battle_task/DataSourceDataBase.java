package battle_task;

import java.util.UUID;

public class DataSourceDataBase implements DataSource {

    private final Data[] dats = new Data[100];
    @Override
    public Data createData(String message) {
        System.out.println("Устанавливаю связь с базой данных");
        System.out.println("Устанавливается связь... 1");
        System.out.println("Устанавливается связь... 2");
        System.out.println("Устанавливается связь... 3");
        System.out.println("Устанавливается связь... 4");
        System.out.println("Устанавливается связь... 5");
        System.out.println("Связь установлена");

        Data data = new Data(UUID.randomUUID().toString(), message);

        for (int i = 0; i < dats.length; i++) {
            if (dats[i] == null) {
                dats[i] = data;
                System.out.println("Данные записаны в базу данных");
                return data;
            }
        }
        System.out.println("Не удалось записать данные в базу данных - неизвестная ошибка");
        return null;
    }

    @Override
    public Data read(String id) {
        System.out.println("Устанавливаю связь с базой данных");
        System.out.println("Устанавливается связь... 1");
        System.out.println("Устанавливается связь... 2");
        System.out.println("Устанавливается связь... 3");
        System.out.println("Устанавливается связь... 4");
        System.out.println("Устанавливается связь... 5");
        System.out.println("Связь установлена");
        for (int i = 0; i < dats.length; i++) {
            if (dats[i] != null && dats[i].getId().equals(id)) {
                System.out.println("Запись в базе данных найдена");
                return dats[i];
            }
        }

        System.out.println("Запись не найдена в базе данных");
        return null;
    }

    @Override
    public void update(String id, String message) {
        //TODO: На дом
    }

    @Override
    public void delete(String id) {
        //TODO: На дом
    }
}
