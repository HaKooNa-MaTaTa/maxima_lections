package java_io_and_dao;

import java.io.IOException;

public class HumanService implements IHumanService {

    private final IHumanDAO humanDAO;

    public HumanService(IHumanDAO humanDAO) {
        this.humanDAO = humanDAO;
    }


    @Override
    public Human create(Human human) {
        System.out.println("Проверяем корректность данных...");
        System.out.println("Проверяем корректность данных... 1");
        System.out.println("Проверяем корректность данных... 2");
        System.out.println("Проверяем корректность данных... 3");
        System.out.println("Проверяем корректность данных... 4");
        System.out.println("Проверяем корректность данных... 5");
        if (human.getAge() > 0) {
            System.out.println("Проверка завершена. Сохраняем...");
            return humanDAO.create(human);
        } else {
            //throw - "выкидывает" исключительную ситуацию
            throw new IllegalArgumentException("Не верный возраст");
        }
    }

    @Override
    public Human findById(int id) {
        return humanDAO.findById(id);
    }

    @Override
    public void update(Human human) {
        humanDAO.update(human);
    }

    @Override
    public void delete(int id) {
        humanDAO.delete(id);
    }
}
