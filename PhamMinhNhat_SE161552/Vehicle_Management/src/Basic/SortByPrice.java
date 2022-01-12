package Basic;

import java.util.Comparator;

/**
 *
 * @author nhattpam
 */
public class SortByPrice implements Comparator<Vehicle>{

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return (int)(o2.getPrice() - o1.getPrice());
    }
    
}
