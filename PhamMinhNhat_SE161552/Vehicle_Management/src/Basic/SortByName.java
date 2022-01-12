package Basic;

import java.util.Comparator;

/**
 *
 * @author nhattpam
 */
public class SortByName implements Comparator<Vehicle>{

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o2.getName().compareTo(o1.getName());
    }
    
}
