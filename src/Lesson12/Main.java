/*

ДЗ 12
Используя API https://reqres.in/

Получить список ВСЕХ юзеров
Удалить всех юзеров с именем George, сохранив последнее их состояние
Восстановить удалённых юзеров

by Smirnov SM
on 06.12.2021

ver 1.0

 */

package Lesson12;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        List<Response> listAll = new ArrayList<>();

        // первоначально получаем запросом вспомогательную информацию (total_pages, total)
        HttpRequest getVspom = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://reqres.in/api/users?page=1"))
                .build();
        HttpResponse<String> responseVspom = client.send(getVspom, HttpResponse.BodyHandlers.ofString());
        Response objVspom = mapper.readValue(responseVspom.body(), Response.class);

        // обрабатываем все страницы GET запросами
        for (int i = 1; i < objVspom.getTotalPages() + 1; i++) {
            HttpRequest get = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create("https://reqres.in/api/users?page=" + i))
                    .build();
            HttpResponse<String> response = client.send(get, HttpResponse.BodyHandlers.ofString());
            Response obj = mapper.readValue(response.body(), Response.class);

            listAll.add(obj);
        }
        // выводим получившийся список со всеми юзерами
        System.out.println(listAll);

        // количество страниц
        int pagesCount = objVspom.getTotalPages();
        // количество юзеров на одной странице
        int usersCountPerPage = objVspom.getPerPage();
        System.out.println(pagesCount + "   " + usersCountPerPage);


        // формируем список Джорджей и список ID Джорджей
        List<DataItem> georgesList = new ArrayList<>();
        List<String> georgesListId = new ArrayList<>();

        for (int i = 0; i < pagesCount; i++) {
            for (int j = 0; j < usersCountPerPage; j++) {
                if (listAll.get(i).getData().get(j).getFirstName().equals("George")) {
                    georgesList.add(listAll.get(i).getData().get(j));
                    georgesListId.add(listAll.get(i).getData().get(j).getId());
                }
            }

        }

        System.out.println("GEORGES LIST:" + '\n' + georgesList);
        System.out.println();
        System.out.println("DELETING GEORGES!");

        // удаляем записи с Джорджами по ID
        for (int i = 0; i < georgesList.size(); i++) {
            HttpRequest deleteGeorge = HttpRequest.newBuilder()
                    .DELETE()
                    .header("accept", "application/json")
                    .uri(URI.create("https://reqres.in/api/users" + georgesListId.get(i)))
                    .build();
            HttpResponse<String> responseDelete = client.send(deleteGeorge, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code after deleting George with ID = " + georgesListId.get(i) +
                    " (must be 204): " + responseDelete.statusCode());
        }

        System.out.println();

        // восстанавливаем записи с Джорджами по ID
        for (int i = 0; i < georgesList.size(); i++) {
            User user = new User();
            user.setFirstName(georgesList.get(i).getFirstName());
            user.setLastName(georgesList.get(i).getLastName());
            user.setEmail(georgesList.get(i).getEmail());
            user.setAvatar(georgesList.get(i).getAvatar());

            String body = mapper.writeValueAsString(user);

            // добавляем Джорджей обратно
            HttpRequest postGeorge = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .header("content-type", "application/json")
                    .uri(URI.create("https://reqres.in/api/users"))
                    .build();
            HttpResponse<String> responsePostGeorge = client.send(postGeorge, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code after updating George with ID = " + georgesListId.get(i) +
                    " (must be 201): " + responsePostGeorge.statusCode());
            System.out.println("UPDATED:" + '\n' + responsePostGeorge.body());
            System.out.println();
        }

    }

}
