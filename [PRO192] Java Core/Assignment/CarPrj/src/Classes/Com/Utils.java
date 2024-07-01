/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Com;

import java.util.Scanner;

/**
 *
 * @author phtung
 */
public class Utils {
    public static Scanner sc = new Scanner(System.in);
    public static String validString(String str, String s) {
        String string;
        while (true) {            
            System.out.print(str);
            string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println(s + " cannot be blank. Please try again");
            } else {
                break;
            }
        }
        return string;
    }
    
    public static double validDouble(String str) {
        double num;
        String s;
        while (true) {
            try {
                System.out.print(str);
                s = sc.nextLine().trim();
                if (s == null) {
                    System.out.println("Input cannot be blank. Please try again");
                    continue;
                }
                num = Double.parseDouble(s);
                if (num < 0) {
                    System.out.println("Input cannot less or equal than 0. Please try again");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot be a string. Please input a number");
            }
        }
    }
}
