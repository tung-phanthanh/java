/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.Com.*;
import java.util.*;

/**
 *
 * @author phtung
 */
public class CarManager {
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        options.add("List all brands");
        options.add("Add a new brand");
        options.add("Search a brand based on its ID");
        options.add("Update a brand");
        options.add("Remove brand by ID");
        options.add("Save brands to the file, named brands.txt");
        options.add("List all cars in ascending order of brand names");
        options.add("List cars based on a part of an input brand name");
        options.add("Add a car");
        options.add("Remove a car based on its ID");
        options.add("Update a car based on its ID");
        options.add("Save cars to file, named cars.txt");
        options.add("Quit");
        Menu menu = new Menu();
        BrandList brandList = new BrandList();
        brandList.loadFromFile("Brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("Cars.txt");
        int choice;
        do {            
            choice = menu.int_getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                    String searchId = Utils.validString("Enter brand ID to search: ", "Brand ID");
                    int pos = brandList.searchID(searchId);
                    if (pos >= 0) {
                        System.out.println("Found");
                        System.out.println(brandList.get(pos));
                    } else {
                        System.out.println("Brand not found!");
                    }
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.deleteBrandByID(carList);
                    break;
                case 6:
                    brandList.saveToFile("Brands.txt");
                    break;
                case 7:
                    carList.listCars();
                    break;
                case 8:
                    carList.printBasedBrandName();
                    break;
                case 9:
                    carList.addCar();
                    break;
                case 10:
                    carList.removeCar();
                    break;
                case 11:
                    carList.updateCar();
                    break;
                case 12:
                    carList.saveToFile("Cars.txt");
                    break;
            }
        } while (choice != 13);
    }
}
