// Brody F.
// 12/11/25
// V 1.0
// Purpose : Complete the assignment

package exceptions;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

public class exceptionsfile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("output.txt");
        Scanner sc2 = null;

        try {
            FileWriter writer = new FileWriter(file);
            double[] doubleRandomNumber = new double[25];
            for (int i = 0; i < 25; i++) {
                doubleRandomNumber[i] = Math.random() * 250;
                writer.write(doubleRandomNumber[i] + "\n");
                System.out.println(doubleRandomNumber[i]);
            }
            writer.close(); 

            double[] numbers = new double[25];
            sc2 = new Scanner(file);
            for (int i = 0; i < numbers.length; i++) {
                if (sc2.hasNextDouble()) {
                    numbers[i] = sc2.nextDouble();
                }
            }

            System.out.println("Welcome to the index checker!");
            System.out.print("Enter an index (0-24): ");
            int indexNumber = sc.nextInt();
            System.out.println("Value at index " + indexNumber + ": " + numbers[indexNumber]);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("Successful!");
            sc.close();
            if (sc2 != null) sc2.close();
        }
    }
}
