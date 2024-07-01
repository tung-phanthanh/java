/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Com;

import java.util.*;
import java.io.*;

/**
 *
 * @author phtung
 */
public class CarList extends ArrayList<Car> {

    private BrandList brandList;

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length != 5) {
                    System.out.println("Incorrect line format: " + line);
                    continue;
                }

                String carID = parts[0];
                String brandID = parts[1];
                String color = parts[2];
                String frameID = parts[3];
                String engineID = parts[4];

                int brandIndex = brandList.searchID(brandID);
                if (brandIndex == -1) {
                    System.out.println("Brand not found for ID: " + brandID);
                    continue;
                }

                Brand brand = brandList.get(brandIndex);
                Car car = new Car(carID, brand, color, frameID, engineID);
                this.add(car);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
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
                for (Car c : this) {
                    pw.println(c);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        System.out.println("Successfully");
        return true;
    }

    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String frameID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String engineID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(engineID)) {
                return i;
            }
        }
        return -1;
    }

    public void addCar() {
        String carID, frameID, engineID, color;
        while (true) {
            carID = Utils.validString("Enter car ID: ", "Car ID");
            if (searchID(carID) == -1) {
                break;
            } else {
                System.out.println("Id cannot duplicate. Please try another car ID");
            }
        }

        Brand brand = brandList.get(new Menu().int_getChoice(new ArrayList<>(brandList)) - 1);
        color = Utils.validString("Enter color: ", "Color");

        while (true) {
            frameID = Utils.validString("Enter frame ID (in format F00000): ", "Frame ID");
            if (!frameID.matches("F\\d{5}")) {
                System.out.println("Frame ID must in format F00000");
                continue;
            }
            if (searchFrame(frameID) == -1) {
                break;
            } else {
                System.out.println("Frame ID cannot duplicate. Please try another car ID");
            }
        }

        while (true) {
            engineID = Utils.validString("Enter engine ID (in format E00000): ", "Engine ID");
            if (!engineID.matches("E\\d{5}")) {
                System.out.println("Engine ID must in format E00000");
                continue;
            }
            if (searchEngine(engineID) == -1) {
                break;
            } else {
                System.out.println("Engine ID cannot duplicate. Please try another car ID");
            }
        }
        this.add(new Car(carID, brand, color, frameID, engineID));
        System.out.println("Successfully");
    }

    public void printBasedBrandName() {
        String aPartOfBrandName = Utils.validString("Enter brand name: ", "Brand name");
        int count = 0;
        for (int i = 0; i < this.size(); i++) {
            Car c = this.get(i);
            if (c.getBrand().getBrandName().toLowerCase().contains(aPartOfBrandName.toLowerCase())) {
                System.out.println(c.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected");
        }
    }

    public boolean removeCar() {
        String removedID = Utils.validString("Enter Car ID you want to remove: ", "Car ID");
        int pos = searchID(removedID);
        if (pos >= 0) {
            this.remove(pos);
            System.out.println("Successfully");
            return true;
        } else {
            System.out.println("Car not found!");
            return false;
        }
    }

    public boolean updateCar() {
        String carID, frameID, engineID, color;
        carID = Utils.validString("Enter car ID you want to update: ", "Car ID");
        int pos = searchID(carID);
        if (pos == -1) {
            System.out.println("Car not found");
            return false;
        } else {
            Brand brand = brandList.get(new Menu().int_getChoice(new ArrayList<>(brandList)) - 1);
            color = Utils.validString("Enter color: ", "Color");

            while (true) {
                frameID = Utils.validString("Enter frame ID (in format F00000): ", "Frame ID");
                if (!frameID.matches("F\\d{5}")) {
                    System.out.println("Frame ID must in format F00000");
                    continue;
                }
                if (searchFrame(frameID) == -1 || searchFrame(frameID) == pos) {
                    break;
                } else {
                    System.out.println("Frame ID cannot duplicate. Please try another car ID");
                }
            }

            while (true) {
                engineID = Utils.validString("Enter engine ID (in format E00000): ", "Engine ID");
                if (!engineID.matches("E\\d{5}")) {
                    System.out.println("Engine ID must in format E00000");
                } else {
                    if (searchEngine(engineID) == -1 || searchEngine(engineID) == pos) {
                        break;
                    } else {
                        System.out.println("Engine ID cannot duplicate. Please try another car ID");
                    }
                }
            }
            Car car = this.get(pos);
            car.setBrand(brand);
            car.setColor(color);
            car.setEngineID(engineID);
            car.setFrameID(frameID);
            System.out.println("Update successfully to: " + car.screenString());
            return true;
        }
    }

    public void listCars() {
        Collections.sort(this);
        for (Car car : this) {
            System.out.println(car.screenString());
        }
    }
}
