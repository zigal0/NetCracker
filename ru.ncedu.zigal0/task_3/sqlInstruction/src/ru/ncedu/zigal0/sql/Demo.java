package ru.ncedu.zigal0.sql;

public class Demo {
    public static void main(String[] args) {
        ConstructorOfSqlQuery sql = new ConstructorOfSqlQuery();
        sql.getConditionsFromConsole();
        System.out.println(sql.getCurrentConditions());
        sql.setConditions("b01-813b", 5);
        sql.createSqlQuery();
        sql.showSql();
        sql.saveFile();
    }
}

