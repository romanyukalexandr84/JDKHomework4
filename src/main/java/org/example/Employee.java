package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String phoneNumber;
    private String name;
    private int experienceInMonths;

    @Override
    public String toString() {
        return "Сотрудник {" +
                "Табельный номер = " + id +
                ", Номер телефона = '" + phoneNumber + '\'' +
                ", Имя = '" + name + '\'' +
                ", Трудовой стаж (кол-во месяцев) = " + experienceInMonths +
                "}" + "\n";
    }
}
