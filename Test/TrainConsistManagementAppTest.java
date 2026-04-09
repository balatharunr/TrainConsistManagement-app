import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC", 50));

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(122, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 20));
        bogies.add(new TrainConsistManagementApp.Bogie("C", 30));

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(60, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Only", 40));

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(40, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("X", 15));
        bogies.add(new TrainConsistManagementApp.Bogie("Y", 25));

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(40, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 20));
        bogies.add(new TrainConsistManagementApp.Bogie("C", 30));

        int total = TrainConsistManagementApp.getTotalCapacity(bogies);

        assertTrue(total == 60);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 20));

        int originalSize = bogies.size();

        TrainConsistManagementApp.getTotalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
    }
}