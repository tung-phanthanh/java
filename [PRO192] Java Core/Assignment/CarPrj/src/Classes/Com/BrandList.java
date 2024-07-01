/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Com;

import java.io.*;
import java.util.*;

/**
 *
 * @author phtung
 */
public class BrandList extends ArrayList<Brand> {

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return false;
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("[,:]");
                    if (parts.length == 4) {
                        Brand brand = new Brand(parts[0].trim(), parts[1].trim(), parts[2].trim(), Double.parseDouble((parts[3]).trim()));
                        this.add(brand);
                    } else {
                        System.out.println("Invalid format: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return false;
        } else {
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                for (Brand b : this) {
                    pw.println(b);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        System.out.println("Successfully");
        return true;
    }

    public int searchID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        return (Brand) menu.ref_getChoice(this);
    }

    public void addBrand() {
        String brandId, brandName, soundBrand;
        double price;
        while (true) {
            brandId = Utils.validString("Enter brand ID: ", "Brand ID");
            if (searchID(brandId) == -1) {
                break;
            } else {
                System.out.println("Id cannot duplicate. Please try another brand ID");
            }
        }
        brandName = Utils.validString("Enter brand name: ", "Name");
        soundBrand = Utils.validString("Enter sound name: ", "Sound");
        price = Utils.validDouble("Enter price: ");
        this.add(new Brand(brandId, brandName, soundBrand, price));
        System.out.println("Successfully");
    }

    public void updateBrand() {
        String brandId, brandName, soundBrand;
        double price;
        while (true) {
            brandId = Utils.validString("Enter brand ID: ", "ID");
            int i = searchID(brandId);
            if (i == -1) {
                System.out.println("Id not found");
            } else {
                System.out.println("Before: " + this.get(i).toString());
                brandName = Utils.validString("Enter new brand name: ", "Name");
                soundBrand = Utils.validString("Enter new sound name: ", "Sound");
                price = Utils.validDouble("Enter new price: ");
                this.get(i).setBrandName(brandName);
                this.get(i).setSoundBrand(soundBrand);
                this.get(i).setPrice(price);
                System.out.println("Successfully update to: " + this.get(i));
                break;
            }
        }
    }

    public void listBrands() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i));
        }
    }

    //Additional function to remove brand by id if no brand exists in vehicle list
    public boolean deleteBrandByID(CarList carList) {
        String brandID = Utils.validString("Enter brand ID you want to remove: ", "Brand ID");
        int brandIndex = searchID(brandID);
        if (brandIndex == -1) {
            System.out.println("Brand not found.");
            return false;
        }

        // Check if any cars are associated with this brand
        for (Car car : carList) {
            if (car.getBrand().getBrandID().equals(brandID)) {
                System.out.println("Cannot delete brand. It is associated with one or more cars.");
                return false;
            }
        }

        // Delete the brand if no cars are associated with it
        this.remove(brandIndex);
        System.out.println("Brand deleted successfully.");
        return true;
    }
}
