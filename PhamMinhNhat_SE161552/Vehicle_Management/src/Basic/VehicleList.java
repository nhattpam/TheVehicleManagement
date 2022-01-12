package Basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import Validation.Validation;

/**
 *
 * @author nhattpam
 */
public class VehicleList implements I_Vehicle {

    private ArrayList<Vehicle> list = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addVehicle() {
        boolean check;
        do {
            int choice = Validation.getAnInteger("1.CAR or 2.MOTOBIKE: ", "Just 1 or 2!!", 1, 2);
            if (choice == 1) {
                int pos;
                String code, color, type;
                int date;
                do {
                    code = Validation.getString("Enter code of car: ", "Not blank or empty!");
                    pos = checkID(code);
                    if (pos >= 0) {
                        System.out.println("The id has been already in list!!.");
                    }
                } while (pos != -1);
                String name = Validation.getString("Enter name of Car: ", "Not blank or empty.Input again!");
                int choiceColor = Validation.getAnInteger("Choice color(1.Blue 2.Green 3.Red): ", "Just 1 to 3.", 1, 3);         
                if(choiceColor == 1)
                    color = "BLUE";
                else if(choiceColor == 2)
                    color = "GREEN";
                else
                    color = "RED";
                int price = Validation.getAnInteger("Enter price of Car(>0): ", "More than 0!!", 1);
                String brand = Validation.getString("Enter brand of Car: ", "Not blank or empty!");
                int choiceType = Validation.getAnInteger("Choice color(1.Sport 2.Travel 3.Common): ", "Just 1 to 3.", 1, 3);    
                if(choiceType == 1)
                    type = "SPORT";
                else if(choiceType == 2)
                    type = "TRAVEL";
                else
                    type = "COMMON";
                
                do{
                    date = Validation.getAnInteger("Enter year of car(<= 2022): ", "Beetween 0 and 2022", 1);
                }while(date > 2022);
                Vehicle car = new Car(code, name, color, price, brand, type, date);
                list.add(car);
                System.out.println("The car has been added in list. Successfully.");
            } else {
                int pos;
                boolean license;
                String code,color;
                do {
                    code = Validation.getString("Enter code of motobike: ", "Not blank or empty!");
                    pos = checkID(code);
                    if (pos >= 0) {
                        System.out.println("The id has been already in list!!.");
                    }
                } while (pos != -1);
                String name = Validation.getString("Enter name of Motobike: ", "Not blank or empty.Input again!");
                int choiceColor = Validation.getAnInteger("Choice color(1.Blue 2.Green 3.Red): ", "Just 1 to 3.", 1, 3);         
                if(choiceColor == 1)
                    color = "BLUE";
                else if(choiceColor == 2)
                    color = "GREEN";
                else
                    color = "RED";
                int price = Validation.getAnInteger("Enter price of Motobike(>0): ", "More than 0!!", 1);
                String brand = Validation.getString("Enter brand of Motobike: ", "Not blank or empty!");
                int speed = Validation.getAnInteger("Enter speed of Motobike(>0): ", "More than 0.Input  again!", 1);
                int checkLicense = Validation.getAnInteger("Do you have license? (1.YES or 2.NO): ", "Just 1 or 2!", 1, 2);
                if (checkLicense == 1) {
                    license = true;
                } else {
                    license = false;
                }
                Vehicle motobike = new Motobike(code, name, color, price, brand, speed, license);
                list.add(motobike);
                System.out.println("The motobike has been added in list.Successfully.");
            }
            String checkContinue = Validation.getID("Do you want to continues add? (Y/N): ", "Just Y or N.", "^[y|Y|n|N]$");
            check = Validation.yesOrNO(checkContinue);
        } while (check == true);
    }

    public int checkID(String id) {
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void updateVehicle() {
        int check = Validation.getAnInteger("What kind of vehicle you want to update? (1.CAR or 2.MOTOBIKE).", "JUST 1 OR 2.", 1, 2);
        if(check == 1){
            String color,type;
            int date;
            String code = Validation.getString("Enter code of car: ", "Not blank or empty!");
            Car x = checkIDCar(code);
            if(x != null){                
                String name = Validation.getString("Enter new name of car you want to update: ", "Not blank or empty!");
                x.setName(name);
                int choiceColor = Validation.getAnInteger("Choice color(1.Blue 2.Green 3.Red): ", "Just 1 to 3.", 1, 3);         
                if(choiceColor == 1)
                    color = "BLUE";
                else if(choiceColor == 2)
                    color = "GREEN";
                else
                    color = "RED";
                x.setColor(color);
                int price = Validation.getAnInteger("Enter new price of car you want to update(>0): ", "Not blank or empty.", 1);
                x.setPrice(price);
                
                String brand = Validation.getString("Enter new brand you want to update: ", "Not blank or empty!");
                x.setBrand(brand);
                
                int choiceType = Validation.getAnInteger("Choice color(1.Sport 2.Travel 3.Common): ", "Just 1 to 3.", 1, 3);    
                if(choiceType == 1)
                    type = "SPORT";
                else if(choiceType == 2)
                    type = "TRAVEL";
                else
                    type = "COMMON";
                x.setType(type);
                do{
                    date = Validation.getAnInteger("Enter year of car(<= 2022): ", "Beetween 0 and 2022", 1);
                }while(date > 2022);
                x.setDate(date);
                System.out.println("The Car has been updated successfully.");
            }else{
                System.out.println("Car does not exist.");
            }
        }else{
            String color,type;
            String code = Validation.getString("Enter code of motobike: ", "Not blank or empty!");
            Motobike x = checkIDMotobike(code);
            if(x != null){
                boolean license;
                String name = Validation.getString("Enter new name of motobike you want to update: ", "Not blank or empty!");
                x.setName(name);
                
                int choiceColor = Validation.getAnInteger("Choice color(1.Blue 2.Green 3.Red): ", "Just 1 to 3.", 1, 3);         
                if(choiceColor == 1)
                    color = "BLUE";
                else if(choiceColor == 2)
                    color = "GREEN";
                else
                    color = "RED";
                x.setColor(color);
                
                int price = Validation.getAnInteger("Enter new price of motobike you want to update(>0): ", "Not blank or empty.", 1);
                x.setPrice(price);
                
                String brand = Validation.getString("Enter new brand you want to update: ", "Not blank or empty!");
                x.setBrand(brand);
                
                int speed = Validation.getAnInteger("Enter new speed you want to update(>0): ", "More than 0!", 1);
                x.setSpeed(speed);
                int checkLicense = Validation.getAnInteger("Enter new license? (1.YES or 2.NO): ", "Just 1 or 2!", 1, 2);
                if (checkLicense == 1) {
                    license = true;
                } else {
                    license = false;
                }
                x.setLicense(license);
                System.out.println("The motobike has been updated successfully.");
            }else{
                System.out.println("Motobike does not exits.");
            }
        }           
    }
    public Motobike checkIDMotobike(String code){
        if(list.isEmpty())
            return null;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase(code))
                return (Motobike)list.get(i);
        }
        return null;
    }
    public Car checkIDCar(String code){
        if(list.isEmpty())
            return null;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase(code))
                return (Car)list.get(i);
        }
        return null;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void deleteVehicle() {
        int check = Validation.getAnInteger("What kind of vehicle you want to delete? (1.CAR or 2.MOTOBIKE).", "JUST 1 OR 2.", 1, 2);
        if(check == 1){
            String code = Validation.getString("Enter ID of car you wannt to delete: ", "Not blank or empty");
            Car x = checkIDCar(code);
            if(x != null){                
                list.remove(x);
                System.out.println("The Car has been deleted successfully.");
            }else{
                System.out.println("Car does not exist. FAIL!");
            }
        }else{
            String code = Validation.getString("Enter ID of motobike you wannt to update: ", "Not blank or empty");
            Motobike x = checkIDMotobike(code);
            if(x != null){
                list.remove(x);
                System.out.println("The motobike has been deleted successfully.");
            }else{
                System.out.println("Motobike does not exits. FAIL!");
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void searchDescendingVehicle() {
        ArrayList<Vehicle> listS = new ArrayList();
        String name = Validation.getString("Enter name of vehicle you want to search: ", "Not blank or empty");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().contains(name))
                listS.add(list.get(i));
        }
        Collections.sort(listS, new SortByName());
        for (Vehicle x : listS) {
            x.showInformation();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void searchByID() {
        int check = Validation.getAnInteger("What kind of vehicle you want to search? (1.CAR or 2.MOTOBIKE).", "JUST 1 OR 2.", 1, 2);
        if(check == 1){
            String code = Validation.getString("Enter ID of car you wannt to search: ", "Not blank or empty");
            Car x = checkIDCar(code);
            if(x == null){
                System.out.println("Not find ID of Car in the list.");
            }else{
                System.out.println("Here is the information of Car: ");
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
                System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   TYPE   |     DATE      |");
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
                x.showInformation();
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
            }
        }else{
            String code = Validation.getString("Enter ID of motobike you wannt to search: ", "Not blank or emtpy");
            Motobike x = checkIDMotobike(code);
            if(x == null)
                System.out.println("Not find ID of Motobike in the list.");
            else{
                System.out.println("Here is  information of motobike: ");
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
                System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   SPEED  |    LICENSE    |");
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
                x.showInformation();
                System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
            }
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showVehicle() {
        System.out.println("CAR:");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   TYPE   |     DATE      |");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Car) {
                list.get(i).showInformation();
            }
        }
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("\n");
        System.out.println("MOTOBIKE: ");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   SPEED  |    LICENSE    |");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Motobike) {
                list.get(i).showInformation();
            }
        }
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void showDescendingByPrice() {
        Collections.sort(list, new SortByPrice());
        System.out.println("CAR:");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   TYPE   |     DATE      |");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Car) {
                list.get(i).showInformation();
            }
        }
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("\n");
        System.out.println("MOTOBIKE: ");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        System.out.println("|    ID    |     NAME      |   COLOR  |   PRICE  |   BRAND  |   SPEED  |    LICENSE    |");
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Motobike) {
                list.get(i).showInformation();
            }
        }
        System.out.println("+----------+---------------+----------+----------+----------+----------+---------------+");
    }

    @Override
    public void saveFile() {
        if(list.size() == 0){
            System.out.println("Empty list");
            return;
        }
        try{
            File f = new File("vehicle.txt");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) instanceof Car)
                    pw.println(list.get(i).toString());
            }
            pw.println("MOTOBIKE");
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) instanceof Motobike)
                    pw.println(list.get(i).toString());
            }
            pw.close();
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void AddFromFile(){
        try{
            File f = new File("vehicle.txt");
            if(!f.exists())
                return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details = bf.readLine()).equalsIgnoreCase("MOTOBIKE") == false){
                StringTokenizer stk = new StringTokenizer(details, ",");
                String id = stk.nextToken();
                String name = stk.nextToken();
                String color = stk.nextToken();
                int price = Integer.parseInt(stk.nextToken());
                String brand = stk.nextToken();
                String type = stk.nextToken();
                int date = Integer.parseInt(stk.nextToken());
                list.add(new Car(id, name, color, price,brand, type, date));
            }
            boolean a;
                while((details = bf.readLine()) != null){
                    StringTokenizer stk = new StringTokenizer(details, ",");
                    String id = stk.nextToken();
                    String name = stk.nextToken();
                    String color = stk.nextToken();
                    int price = Integer.parseInt(stk.nextToken());
                    String brand = stk.nextToken();
                    int speed = Integer.parseInt(stk.nextToken());
                    boolean license = Boolean.parseBoolean(stk.nextToken());
                    list.add(new Motobike(id, name, color, price, brand, speed, license));
                }
            bf.close();
            fr.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
