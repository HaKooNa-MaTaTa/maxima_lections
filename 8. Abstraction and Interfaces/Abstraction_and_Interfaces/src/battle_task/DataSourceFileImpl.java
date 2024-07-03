package battle_task;

import java.util.UUID;

public class DataSourceFileImpl implements DataSource {

    private final Data[] dats = new Data[10];
    @Override
    public Data createData(String message) {
        System.out.println("Ищу файл для записи");
        System.out.println("Идет поиск... 1");
        System.out.println("Идет поиск... 2");
        System.out.println("Идет поиск... 3");
        System.out.println("Идет поиск... 4");
        System.out.println("Идет поиск... 5");
        System.out.println("Файл для записи найден");
        Data data = new Data(UUID.randomUUID().toString(), message);

        for (int i = 0; i < dats.length; i++) {
            if (dats[i] == null) {
                dats[i] = data;
                System.out.println("Данные записаны в файл");
                return data;
            }
        }
        System.out.println("Не удалось записать данные в файл - закончилось место");
        return null;
    }

    @Override
    public Data read(String id) {
        System.out.println("Ищу файл для поиска данных");
        System.out.println("Идет поиск... 1");
        System.out.println("Идет поиск... 2");
        System.out.println("Идет поиск... 3");
        System.out.println("Идет поиск... 4");
        System.out.println("Идет поиск... 5");
        System.out.println("Файл для поиска найден");
        for (int i = 0; i < dats.length; i++) {
            if (dats[i] != null && dats[i].getId().equals(id)) {
                System.out.println("Запись в файле найдена");
                return dats[i];
            }
        }

        System.out.println("Запись не найдена в файле");
        return null;
    }

    @Override
    public void update(String id, String message) {
        //TODO: на дом
    }

    @Override
    public void delete(String id) {
        //TODO: на дом
    }
}
