/**
 * Java 1. Home task 5
 *
 * @author Elena Vasileva
 * @version 22.02.2022
 */
package ru.geekbrains.lesson5;

public class Worker {
    private String fullName;
    private String position;
    private String email;
    private String telephoneNumber;
    private int salary;
    private byte age;

    Worker(String fullName, String position, String email, String telephoneNumber, int salary, byte age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    //В этом задании нужен только один метод getAge(). Но, для полноты картины решила расписать все.

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        if (fullName != null) {
            this.fullName = fullName;
        };
    }

    public String getPosition() {
        return position;
    }

    public void setPosition() {
        if (position != null) {
            this.position = position;
        };
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        if (email != null) {
            this.email = email;
        };
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber() {
        if (telephoneNumber != null) {
            this.telephoneNumber = telephoneNumber;
        };
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary() {
        if (salary > 0) {
            this.salary = salary;
        };
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return fullName + ", " +
               position + ", " +
               email + ", " +
               telephoneNumber + ", " +
               salary + ", " +
               age;
    }
}
