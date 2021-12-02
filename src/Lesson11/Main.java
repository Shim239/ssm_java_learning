/*

Реализовать программу, которая бы позволяла считывать логи из файлов в указанной директории и представлять их в виде объектов для дальнейшего анализа
Стандартная запись в лог содержит следующие атрибуты

Timestamp
Level
Logger
Message
Source - файл источник

Количество файлов с логами в директории заранее не известно, предусмотреть, что логи могут лежать в поддиректориях.
Когда механизм готов, нужно считать логи из приложенных файлов, отфильтровать только записи с уровнем WARN, и вывести все записи с уникальным сообщением

Каждый новый файл должен читаться новым потоком

ver 1.0
on 01.12.2021
by Smirnov SM

 */

package Lesson11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SearchFiles searchFiles = new SearchFiles();
        System.out.println("Number of LOG files found: " + searchFiles.files.size() + '\n');

        Runnable task = () -> {

            // вывод всех найденных файлов log
            for (File file : searchFiles.files) {
                ArrayList<LogObject> logObjects = new ArrayList<>();
                System.out.println(Thread.currentThread().getName() + " add " + file); // выводим наименование файла, из которого выводятся логи

                // добавляем строки файлов log в список lines
                List<String> lines = null;
                try {
                    lines = org.apache.commons.io.FileUtils.readLines(new File(String.valueOf(file)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // парсинг файла
                for (String line : lines) {
                    String timestamp = line.substring(0, 23);

                    int levelLastIndex = line.indexOf(' ', 26);
                    String level = line.substring(26, levelLastIndex);

                    int loggerFirstIndex = line.indexOf('[', levelLastIndex);
                    int loggerLastIndex = line.lastIndexOf(']');
                    String logger = line.substring(loggerFirstIndex, loggerLastIndex + 1);

                    int messageFirstIndex = line.lastIndexOf('-');
                    int messageLastIndex = line.length();
                    String message = line.substring(messageFirstIndex + 2, messageLastIndex);

                    int sourceFirstIndex = file.toString().lastIndexOf('\\');
                    String source = file.toString().substring(sourceFirstIndex + 1);

                    if (level.equals("WARN")) {
                        logObjects.add(new LogObject(timestamp, level, logger, message, source));

                    }
                }

                // делаем map, где ключ - message, а value - вся строка
                Map<String, LogObject> map = logObjects.stream().collect(Collectors.toMap(
                        LogObject::getMessage,
                        Function.identity(),
                        (logObjects1, logObjects2) -> logObjects1));
                map.values().forEach(System.out::println);

                // пустая строка между файлами для вывода
                System.out.println();

            }
        };

        for (int i = 0; i < searchFiles.files.size(); i++) {
            Thread thread = new Thread(task);
            thread.start();
            thread.join();
        }

    }

}
