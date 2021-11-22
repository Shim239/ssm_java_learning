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

 */

package Lesson10;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        // описываем, где у нас лежат файлы, для дальнейшей работы
        Path path = Paths.get("C:\\Users\\shimg\\IdeaProjects\\ssm_java_learning\\files");

        // поиск всех файлов log в указанной директории
        Collection<File> files = org.apache.commons.io.FileUtils.listFiles
                (new File(String.valueOf(path)), new String[] {"log"}, true);

        // количество файлов log
        System.out.println("Number of LOG files: " + files.size());
        System.out.println();

        // вывод всех найденных файлов log
        for (File file : files) {
            ArrayList<LogObject> logObjects = new ArrayList<>();
            System.out.println(file); // выводим наименование файла, из которого выводятся логи

            // добавляем строки файлов log в список lines
            List<String> lines = org.apache.commons.io.FileUtils.readLines(new File(String.valueOf(file)));

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

                //String source = file.toString();

                if (level.equals("WARN")) {
                    logObjects.add(new LogObject(timestamp, level, logger, message));

                }

                Map<String, LogObject> map = logObjects.stream().collect(Collectors.toMap(
                        LogObject::getMessage,
                        Function.identity(),
                        (logObjects1, logObjects2) -> logObjects1));



                // вывод результатов
                //map.values().forEach(System.out::println);



            }
            logObjects.stream().map(LogObject::getMessage).forEach(System.out::println);

/*
            // вывод строк с level=WARN
            for (int i = 0; i < logObjects.size(); i++) {
                System.out.print(logObjects.get(i));

            }
*/

            System.out.println();

        }

    }

}
