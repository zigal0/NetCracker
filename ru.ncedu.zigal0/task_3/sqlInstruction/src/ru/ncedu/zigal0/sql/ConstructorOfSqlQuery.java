package ru.ncedu.zigal0.sql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import static ru.ncedu.zigal0.sql.Color.*;

/**
 * Class ConstructorOfSqlQuery represents class for construct simple sql request.
 */
public class ConstructorOfSqlQuery {

   private int conditionDolgCount;
   private String conditionGroup;
   private String sql;

   /**
    * Gets required conditions to construct sql query.
    */
   public void getConditionsFromConsole() {
      Scanner in = new Scanner(System.in);
      String dolgCount;
      System.out.print("id_Group = ");
      conditionGroup = in.nextLine();
      do {
         System.out.print("dolgCount > ");
         dolgCount = in.nextLine();
         if (isNumeric(dolgCount)) {
            break;
         }
         System.out.println(ANSI_RED + "Wrong coefficients, try other" + ANSI_RESET);
      } while (true);

      conditionDolgCount = Integer.parseInt(dolgCount);
   }

   /**
    * Sets new conditions
    * @param group - id of group (string)
    * @param dolgCount - number of debts
    */
   public void setConditions(String group, int dolgCount) {
      conditionDolgCount = dolgCount;
      conditionGroup = group;
   }

   /**
    * Returns "No Conditions" if is was not initialize, otherwise returns current conditions.
    * @return - conditions
    */
   public String getCurrentConditions() {
      if (conditionGroup == null) {
         return "No conditions";
      }
      return "id_Group = " + conditionGroup + " dolgCount > " + conditionDolgCount;
   }

   /**
    * Creates new sql query from template and conditions and saves it into private variable sql.
    */
   public void createSqlQuery() {
      if (conditionGroup == null) {
         throw new NoSuchElementException();
      }
      StringBuilder str = new StringBuilder();

      String fileName = "template.txt";
      try (Scanner scanner = new Scanner(new File(fileName))) {

         while (scanner.hasNext()){
            str.append(scanner.nextLine());
            str.append("\n");
         }

      } catch (IOException e) {
         System.out.println("There is no file with such name");
      }
      str.append("WHERE id_Group = '");
      str.append(conditionGroup);
      str.append("' AND ");
      str.append("dolgCount > ");
      str.append(conditionDolgCount);
      str.append("\n");
      sql= str.toString();
   }

   /**
    * Shows current instruction.
    */
   public void showSql() {
      System.out.println(sql);
   }

   /**
    * Saves current sql query into "instruction.sql" file.
    */
   public void saveFile() {
      if (sql == null) {
         throw new NoSuchElementException();
      }
      try {
         String newFile = "instruction.sql";
         FileWriter output = new FileWriter(newFile);
         output.write(sql);
         output.close();
         System.out.println("New sql instruction was created! Search file: 'newSqlInstruction.txt'");
      } catch (IOException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }
   }

   /**
    * Checks whether the String a valid integer.
    * @param str - the String to check
    * @return true if the string is integer otherwise false
    */
   private static boolean isNumeric(String str) {
      try {
         Integer.parseInt(str);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
}
