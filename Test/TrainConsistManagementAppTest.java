import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC", 50));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertEquals(1, result.size());
    }
    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Test", 60));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }
    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("Low", 40));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }
    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 80));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }
    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 10));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }
    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 80));

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertEquals(bogies.size(), result.size());
    }
    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }
    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();

        bogies.add(new TrainConsistManagementApp.Bogie("A", 70));
        bogies.add(new TrainConsistManagementApp.Bogie("B", 30));

        int originalSize = bogies.size();

        TrainConsistManagementApp.filterBogies(bogies, 60);

        assertEquals(originalSize, bogies.size());
    }
}