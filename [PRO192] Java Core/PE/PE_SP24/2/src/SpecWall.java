public class SpecWall extends Wall{
     private String color;

    public SpecWall() {
    }

    public SpecWall(String place, int area, String color) {
        super(place, area);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.getPlace()+","+color+","+super.getArea();
    }
    public void setData(){
        String s = "";
        char[] c = getPlace().toCharArray();
        for(int i = 0; i < c.length; i++){
            if(Character.isAlphabetic(c[i])){
                s+= c[i];
            }
        }
        setPlace(s);
    }
    public String getValue(){
        if(getArea() % getPlace().length()  != 0){
            return color;
        }else{
            int x = getArea() / getPlace().length();
            return color+x;
        }
    }
}