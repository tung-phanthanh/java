
import java.util.Collections;
import java.util.List;

public class MyWall implements IWall{

    @Override
    public int f1(List<Wall> t) {
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < t.size(); i++) {
            if (isSquareNumber(t.get(i).getPlace().length()) && t.get(i).getArea() < minArea) {
                minArea = t.get(i).getArea();
            }
        }
        return minArea;
    }

    @Override
    public void f2(List<Wall> t) {
        Collections.reverse(t.subList(3, 6));
    }

    @Override
    public void f3(List<Wall> t) {
        int minArea = t.get(0).getArea();
        int minIndex = 0;
        for (int i = 1; i < t.size(); i++) {
            if (t.get(i).getArea() < minArea) {
                minArea = t.get(i).getArea();
                minIndex = i;
            }
        }
        Wall temp = t.get(minIndex);
        t.set(0, temp);
    }
    
    public boolean isSquareNumber(int n) {
       if (n <= 1) {
           return false;
       }
       return Math.sqrt(n) * Math.sqrt(n) == n;
    }
}