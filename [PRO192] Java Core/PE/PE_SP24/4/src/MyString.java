public class MyString implements IString{

    @Override
    public int f1(String string) {
        int count = 0;
        String[] s = string.split("\\s");
        for (String item : s) {
            if (checkWord(item)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String string) {
        int count = 0;
        String str = "";
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if ("13579".contains(array[i] + "")) {
                count++;
            }
            if (count > 1) {
                for (int j = 0; j < i; j++) {
                    if (array[i] == array[j]) {
                        array[i] = array[0];
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }
        return str;
    }
    
    public boolean checkWord (String word) {
        char[] array = word.toCharArray();
        if (Character.isAlphabetic(array[0]) && Character.isAlphabetic(array[array.length - 1])) {
            for (int i = 1; i < array.length - 1; i++) {
                if (Character.isAlphabetic(array[i])) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}