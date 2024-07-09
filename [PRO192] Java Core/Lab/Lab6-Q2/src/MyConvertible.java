/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phtung
 */
public class MyConvertible implements Convertible {

    @Override
    public double toMile(double d) {
        return d * 0.621371;
    }

    @Override
    public String getCode(String string) {
        String str = "";
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i % 3 == 0 && i != 0) {
                str += "-";
            }
            str += array[i];
        }
        return str;
    }
    
}
