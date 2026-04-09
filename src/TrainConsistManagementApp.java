import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainConsistManagementApp {
    static class Bogie{
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        public String toString() {
            return name + " -> " + capacity;
        }
    }
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("Filter Passenger Bogies Using Streams");
        System.out.println("============================\n");
        List<Bogie> bogies = new ArrayList<>();
        Map<String, Integer> capacityMap = new HashMap<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        System.out.println("All Bogies:\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println("Filtered bogies (Capacity > 60):\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println("\nAfter Sorting by Capacity:\n");
        bogies.sort((b1, b2) -> b1.capacity - b2.capacity);
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}
