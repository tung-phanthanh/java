/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Com;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phtung
 */
public class Menu {
    public int int_getChoice(ArrayList options) {
        Scanner sc = new Scanner(System.in);
        double respone;
        int n = options.size();
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        while (true) {
            try {
                System.out.print("Please choose an option from 1 to " + n + ": ");
                String s = sc.nextLine().trim();
                if (s.isEmpty()) {
                    System.out.println("Input cannot be blank. Please try again");
                    continue;
                }
                respone = Double.parseDouble(s);
                if ((int) respone != respone) {
                    System.out.println("Input cannot be a real number. Please try again");
                    continue;
                }
                if (respone < 1 || respone > n) {
                    System.out.println("Invalid input. Please enter a number in range [1, " + n + "]");
                    continue;
                }
                return (int) respone;
            } catch (NumberFormatException e) {
                System.out.println("Input cannot be a string. Please input a number");
            }
        }
    }
    
    public Object ref_getChoice(ArrayList options) {
        int respone = int_getChoice(options);
        return options.get(respone - 1);
    }
}
