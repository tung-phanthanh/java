/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phtung
 */
public class Cake {
    private String maker;
    private int price;

    public Cake() {
    }

    public Cake(String maker, int price) {
        this.maker = maker;
        this.price = price;
    }

    public String getMaker() {
        String first = maker.substring(0, 1).toUpperCase();
        String remain = maker.substring(1).toLowerCase();
        return first + remain;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
