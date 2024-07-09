/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phtung
 */
public class VNMotor extends Motor {
    private String series;

    public VNMotor() {
    }

    public VNMotor(String brandName, String series, double price) {
        super(brandName, price);
        this.series = series;
    }

    @Override
    public String toString() {
        return super.getBrandName() + " " + series + " " + super.getPrice();
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public double getSalePrice() {
        if (super.getPrice() < 3000) {
            super.setPrice(super.getPrice() * 0.95);
        } else {
            super.setPrice(super.getPrice() * 0.9);
        }
        return super.getPrice();
    }
}
