
public class Zebra {

    private String owner;
    private int weight;

    public Zebra() {
    }

    public Zebra(String owner, int weight) {
        this.owner = owner;
        this.weight = weight;
    }

    public String getOwner() {
        char[] c = owner.toCharArray();
        String s = "";
        for (int i = 0; i < c.length; i++) {
            if (Character.isAlphabetic(c[i]) || (c[i] - '0') % 2 != 0) {
                s += c[i];
            }
        }
        return s;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight-owner.length();
    }

}
