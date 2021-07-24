package ru.ncedu.zigal0.sql;

import java.util.NoSuchElementException;

public class Demo {
    public static void main(String[] args) {
        ConstructorOfSqlQuery sql = new ConstructorOfSqlQuery();
        try {
            sql.saveFile();
        } catch (NoSuchElementException e) {
            System.out.println("Sql is not created yet");
        }
        try {
            sql.createSqlQuery();
        } catch (NoSuchElementException e) {
            System.out.println("Conditions are not defined");
        }
        sql.getConditionsFromConsole();
        System.out.println(sql.getCurrentConditions());
        sql.setConditions("b01-813b", 5);
        try {
            sql.createSqlQuery();
            sql.showSql();
            sql.saveFile();
        } catch (NoSuchElementException e) {
            System.out.println("An error occurred");
        }
    }
}

