/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phtung
 */
public class SpecCoffee extends Coffee {
    private int price;

    public SpecCoffee() {
    }

    public SpecCoffee(String name, int size, int price) {
        super(name, size);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + price;
    }
    
    public void setData() {
        super.setName("CF" + super.getName());
    }
    
    public int getValue() {
        if (super.getSize() > 10) {
            return price;
        } else {
            return price + 5;
        }
    }
}
