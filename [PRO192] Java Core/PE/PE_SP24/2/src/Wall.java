public class Wall {
   private String place;
   private int area;

    public Wall() {
    }

    public Wall(String place, int area) {
        this.place = place;
        this.area = area;
    }

    public String getPlace() {
        return place;
    }

    public int getArea() {
        return area;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return place+","+area;
    }
   
}