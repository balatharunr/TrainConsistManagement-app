import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    static class Bogie {
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
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .toList();
    }
    public static void main(String[] args) {
        System.out.println("============================\n");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("============================\n");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        System.out.println("ALL Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        List<Bogie> filtered = filterBogies(bogies, 60);
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b);
        }
        System.out.println("\nUC8 filtering completed...");
    }
}