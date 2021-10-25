package Lesson7_1;

import java.util.Random;

public class ClientGenerator implements ClientGeneration{

    @Override
    public Client generateClient() {
        Client client = new Client();
        client.setId(createClientId());
        client.setFio(createClientFio());
        return client;
    }

    public int createClientId() {
        Random random = new Random();
        return Math.abs(random.nextInt());
    }

    public String createClientFio() {
        Random random = new Random();
        int num = random.nextInt((500 - 1) + 1) + 1;
        return "Casual Customer " + num;
    }

}
