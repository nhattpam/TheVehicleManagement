package VehicleManager;

import Basic.VehicleList;
import MENU.Menu;

/**
 *
 * @author nhattpam
 */
public class VehicleManager {
    public static void main(String[] args)  {
        Menu menu = new Menu("Happiness Vehicle System Management       ");
        menu.addNewOption("        1. Add new vehicle.");
        menu.addNewOption("        2. Update vehicle by ID.");
        menu.addNewOption("        3. Delete vehicle.");
        menu.addNewOption("        4. Search by name(descending).");
        menu.addNewOption("        5. Search by id.");
        menu.addNewOption("        6. Show all vehicle.");
        menu.addNewOption("        7. Show all (descending by price).");
        menu.addNewOption("        8. Store date to file.");
        VehicleList a = new VehicleList();
        a.AddFromFile();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    a.addVehicle();
                    break;
                case 2:
                    a.updateVehicle();
                    break;                    
                case 3:
                    a.deleteVehicle();
                    break;
                case 4:
                   a.searchDescendingVehicle();
                    break;
                case 5:
                    a.searchByID();
                    break;
                case 6:
                    a.showVehicle();
                    break;
                case 7:
                    a.showDescendingByPrice();
                    break;
                case 8:
                    a.saveFile();
                    System.out.println("Bye,bye.See you next time!!");
                    break;
            }
        } while (choice != 8);
    }
}
