/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phtung
 */
public class MyString implements IString {

    @Override
    public int f1(String str) {
        int count = 0;
        String[] strArray = str.split("\\s");
        for (String x : strArray) {
            if (containTwoOdd(x)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        String[] strArray = str.split("\\s");
        String result = "";
        int indexLengthMax = 0;
        int indexLengthMin = 0;
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[indexLengthMax].length() < strArray[i].length()) {
                indexLengthMax = i;
            }
            
            if (strArray[indexLengthMin].length() > strArray[i].length()) {
                indexLengthMin = i;
            }
        }
        strArray[indexLengthMin] = strArray[indexLengthMax].length() + "";
        for (String x : strArray) {
            result += x + " ";
        }
        return result.trim();
    }
    
    public boolean containTwoOdd(String str) {
        char[] charArray = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                if(Integer.parseInt("" + charArray[i]) % 2 == 1) {
                    count++;
                }
            }
        }
        return count >= 2;
    }
}
