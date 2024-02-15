package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    //Метод вывода меню и навигации
    static int showMenu() {
        System.out.println();
        System.out.println("""
                Выберите необходимое действие:
                1. Вывести всю информацию о всех сотрудниках
                2. Добавить нового сотрудника в справочник
                3. Найти сотрудника по стажу
                4. Найти номер телефона сотрудника по имени
                5. Найти сотрудника по табельному номеру
                6. Закончить работу""");
        try {
            Scanner scanner = new Scanner(System.in);
            int point = scanner.nextInt();
            if (point < 1 || point > 6) {
                throw new InputMismatchException();
            }
            return point;
        } catch (InputMismatchException e) {
            System.out.println("Необходимо ввести цифровое значение от 1 до 6, повторите ввод");
            return showMenu();
        }
    }
}
