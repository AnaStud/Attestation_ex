import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество(строки) дата_рождения(dd.mm.yyyy) номер_телефона(целое беззнаковое число без форматирования) пол(символ латиницей f или m)");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: введите все данные, разделяя пробелом");
        } else {
            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String dateOfBirth = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            try {
                String filename = lastName + ".txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                String userData = lastName + " " + firstName + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender;
                writer.write(userData);
                writer.newLine();
                writer.close();
                System.out.println("Данные успешно записаны в файл: " + filename);
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный номер телефона");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}