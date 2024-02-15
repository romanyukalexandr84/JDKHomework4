package org.example;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Controller {
    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(123, "89101234578", "Иван", 24),
            new Employee(124, "89169874523", "Сергей", 36),
            new Employee(785, "89205648921", "Иван", 18),
            new Employee(912, "89065247845", "Дмитрий", 36),
            new Employee(302, "89037852648", "Сергей", 24)
    ));

    //Метод работы с пунктами меню
    public static void workWithMenu() {
        int choice = View.showMenu();
        if (choice != 6) {
            switch (choice) {
                case 1:
                    System.out.println(employees);
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    System.out.println(getEmployeeByExperience());
                    break;
                case 4:
                    System.out.println(getEmployeePhoneByName());
                    break;
                case 5:
                    System.out.println(getEmployeeById());
                    break;
            }
        } else {
            return;
        }
        workWithMenu();
    }

    //Метод получения списка сотрудников по стажу
    private static List<Employee> getEmployeeByExperience() {
        List<Employee> employeesExp = new ArrayList<>();
        System.out.println("Введите стаж искомого сотрудника (кол-во месяцев):");
        Scanner scan = new Scanner(System.in);
        int exp = scan.nextInt();
        for (Employee employee : employees) {
            if (employee.getExperienceInMonths() == exp) {
                employeesExp.add(employee);
            }
        }
        return employeesExp;
    }

    //Метод получения списка телефонов сотрудников по имени
    private static List<String> getEmployeePhoneByName() {
        List<String> employeesPhones = new ArrayList<>();
        System.out.println("Введите имя искомого сотрудника:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeesPhones.add(employee.getPhoneNumber());
            }
        }
        return employeesPhones;
    }

    //Метод получения сотрудника по табельному номеру
    private static Employee getEmployeeById() {
        System.out.println("Введите id искомого сотрудника:");
        Scanner scan = new Scanner(System.in);
        int identify = scan.nextInt();
        for (Employee employee : employees) {
            if (employee.getId() == identify) {
                return employee;
            }
        }
        return null;
    }

    //Метод добавления нового сотрудника в справочник
    private static void addNewEmployee() {
        try {
            System.out.println("Введите табельный номер нового сотрудника:");
            Scanner scan = new Scanner(System.in);
            int employeeId = scan.nextInt();
            if (employeeId < 1) {
                throw new InputMismatchException();
            }
            for (Employee item : employees) {
                if (item.getId() == employeeId) {
                    throw new NumberFormatException();
                }
            }
            System.out.println("Введите телефон нового сотрудника:");
            String employeePhone = scan.next();
            if (!Pattern.matches("[0-9]+", employeePhone)) {
                throw new IllegalArgumentException();
            }
            for (Employee item : employees) {
                if (item.getPhoneNumber().equals(employeePhone)) {
                    throw new RuntimeException();
                }
            }
            System.out.println("Введите имя нового сотрудника:");
            String employeeName = scan.next();
            if (!Pattern.matches("[a-zA-Zа-яА-Я]+", employeeName)) {
                throw new IOException();
            }
            System.out.println("Введите стаж нового сотрудника:");
            int employeeExp = scan.nextInt();
            if (employeeExp < 0) {
                throw new Exception();
            }
            employees.add(new Employee(employeeId, employeePhone, employeeName, employeeExp));
            System.out.println("Сотрудник добавлен в справочник");
        } catch (InputMismatchException e) {
            System.out.println("Данные должны быть в цифровом формате и больше нуля, повторите ввод");
            addNewEmployee();
        } catch (NumberFormatException e) {
            System.out.println("Сотрудник с таким табельным номером уже есть, повторите ввод");
            addNewEmployee();
        } catch (IllegalArgumentException e) {
            System.out.println("Телефон сотрудника должен быть в цифровом формате, повторите ввод");
            addNewEmployee();
        } catch (RuntimeException e) {
            System.out.println("Сотрудник с таким телефоном уже есть, повторите ввод");
            addNewEmployee();
        } catch (IOException e) {
            System.out.println("Имя сотрудника должно быть в текстовом формате, повторите ввод");
            addNewEmployee();
        } catch (Exception e) {
            System.out.println("Стаж должен быть в цифровом формате и не быть отрицательным, повторите ввод");
            addNewEmployee();
        }
    }
}
