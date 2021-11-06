/*
генератор для создания клиентов типа ЮЛ
содержит в себе основной метод генерации и методы генерации параметров клиента по отдельности
*/

package Lesson8;

import java.util.Random;

public class EntityGenerator implements CustomerGenerator {

    // блок генерации клиентов по данным
    @Override
    public Customer generateCustomer() {
        Random random = new Random();
        Entity entity = new Entity();
        entity.setId(createEntityId());
        entity.setName(ENTITY_NAMES[random.nextInt(ENTITY_NAMES.length)]);
        entity.setInn(createEntityInn());
        entity.setOgrn(createEntityOgrn());
        return entity;
    }

    // блок генерации данных
    public int createEntityId() {
        Random random = new Random();
        return Math.abs(random.nextInt());
    }

    // массив для наименований ЮЛ
    private static final String[] ENTITY_NAMES = {
            "ООО Олимп",
            "ООО МЭК",
            "ООО СМАЙЛ",
            "ООО РУССЕРВИС",
            "ИП Бешанов Владимир Андреевич",
            "ООО МЕДИАНА"
    };

    // нашел в интернете такой вот рандомайзер через char, мне понравился
    public String createEntityInn() {
        int leftLimit = 48; // number '0'
        int rightLimit = 57; // number '9'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public String createEntityOgrn() {
        int leftLimit = 48; // number '0'
        int rightLimit = 57; // number '9'
        int targetStringLength = 13;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

}