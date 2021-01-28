package kurs;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //создаем пустой массив
        Employee[] employees = new Employee[5];
        //заполняем случайным образом
        fillEmployees(employees);
        //выводим всех сотрудников
        outEmployees(employees);
        //выводим по условию старше 40 лет
        outEmployeesOverAge(employees, 40);
    }

    static void fillEmployees (Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            //кому как не классу знать, как сгенерировать случайные значения полей
            //для этого там объявлены статические методы
            String name = Employee.randomName();
            //имя отдельно, потому что по нему генерируется еще и email
            employees[i] = new Employee(name, Employee.randomPosition(), Employee.randomEMail(name),
                    Employee.randomPhone(), Employee.randomSalary(), Employee.randomAge());
        }
    }

    static void outEmployeesOverAge(Employee[] employees, int minAge) {
        System.out.printf("Список сотрудников старше %d лет:\n", minAge);
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getAge() <= minAge) continue;
            count++;
            System.out.printf(" %d. ", count);
            employees[i].out();
        }
    }

    static void outEmployees(Employee[] employees) {
        System.out.println("Полный список сотрудников:");
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            count++;
            System.out.printf(" %d. ", count);
            employees[i].out();
        }
    }

}
