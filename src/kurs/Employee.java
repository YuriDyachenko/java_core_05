package kurs;

import java.util.Random;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void out() {
        System.out.printf("Сотрудник: %s, должность: %s, email: %s, телефон: %s, зарплата: %d, возраст: %d\n",
                name, position, email, phone, salary, age);
    }

    public int getAge() {
        return age;
    }

    static int randomAge() {
        return new Random().nextInt(30) + 30;
    }

    static int randomSalary() {
        int salary = new Random().nextInt(30000) + 30000;
        return salary - salary % 1000;
    }

    static String randomPosition() {
        String[] positions = {"Директор", "Бухгалтер", "Менеджер", "Инженер", "Снабженец", "Кладовщик", "Учетчик"};
        return positions[new Random().nextInt(positions.length)];
    }

    static String randomEMail(String name) {
        String[] servers = {"mail.ru", "yandex.ru", "rambler.ru", "outlook.com", "gmail.com"};
        return transcribe(name) + "@" + servers[new Random().nextInt(servers.length)];
    }

    static String randomPhone() {
        return "" + (4950000000L + new Random().nextInt(10000000));
    }

    static String randomName() {
        String[] names = {"Иван", "Петр", "Сергей", "Николай", "Денис", "Константин", "Юрий", "Дмитрий", "Алексей",
                "Владимир", "Сидор", "Алексей"};
        String[] sonames = {"Черепанов", "Денисов", "Иванов", "Петров", "Сидоров", "Сергеев", "Зюганов",
                "Черномырдин", "Столыпин", "Степаненко"};
        return names[new Random().nextInt(names.length)] + " " + sonames[new Random().nextInt(sonames.length)];
    }

    static String transcribe(String word) {
        String frm = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ1234567890";
        String to1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
                "abvgdejgzijklmnoprstufhccss_y_ejjabvgdejgzijklmnoprstufhccss_y_ejj1234567890";
        String to2 = "                                                    " +
                "      e                 hhc    ua                        hhc    ua          ";
        String to3 = "                                                    " +
                "                          h                                h                ";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int pos = frm.indexOf(word.charAt(i));
            if (pos == -1) {
                stringBuilder.append('_');
            } else {
                stringBuilder.append(to1.charAt(pos));
                char c = to2.charAt(pos);
                if (c != ' ') stringBuilder.append(c);
                c = to3.charAt(pos);
                if (c != ' ') stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
