
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author phtung
 */
public class MyCoffee implements ICoffee {

    @Override
    public int f1(List<Coffee> t) {
        int count = 0;
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).getName().contains("A") && t.get(i).getName().contains("B")) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    @Override
    public void f2(List<Coffee> t) {
        int indexMax = getMaxIndex(t);
        t.remove(indexMax);
    }

    @Override
    public void f3(List<Coffee> t) {
        Comparator<Coffee> compare = new Comparator<Coffee>() {
            @Override
            public int compare(Coffee o1, Coffee o2) {
                int unit1 = o1.getSize() % 10;
                int unit2 = o2.getSize() % 10;
                if (unit1 < unit2) {
                    return 1;
                } else if (unit1 == unit2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };

        Collections.sort(t.subList(0, 3), compare);
    }

    public int getMaxIndex(List<Coffee> t) {
        int valueMax = t.get(0).getSize();
        int indexMax = 0;
        for (int i = 1; i < t.size(); i++) {
            if (valueMax < t.get(i).getSize()) {
                valueMax = t.get(i).getSize();
                indexMax = i;
            }
        }
        return indexMax;
    }
}
