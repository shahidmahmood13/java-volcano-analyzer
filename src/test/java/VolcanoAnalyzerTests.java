import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;


public class VolcanoAnalyzerTests {
    VolcanoAnalyzer va;

    @Before
    public void setUp() throws Exception {
        va = new VolcanoAnalyzer();
        va.loadVolcanoes(Optional.empty());
    }

    @Test
    public void volcanoExists() {
        //Setup
        Volcano classUnderTest = new Volcano();

        //Execute


        //Assert
        Assert.assertNotNull(classUnderTest);

        //Teardown
    }

    @Test
    public void loadVolcanoes() throws IOException, URISyntaxException {
        //Setup
        Integer expected = 804;

        //Execute
        Integer actual = va.numbVolcanoes();

        //Assert
        Assert.assertEquals("should have 804 volcanoes", expected, actual);

        //Teardown
    }

    @Test
    public void eruptedInEighties() {
        //Setup
        Integer expected = 40;

        //Execute
        Integer actual = va.eruptedInEighties().size();

        //Assert
        Assert.assertEquals("should have 40 volcanoes", expected, actual);

        //Teardown
    }

    @Test
    public void highVEI() {
        //Setup
        String[] expected = { "Macauley Island", "Kikai", "Masaya", "Pago", "Taal", "Pinatubo", "Long Island", "Black Peak", "St. Helens", "Veniaminof", "Aniakchak", "Santorini", "Taupo", "Pago", "Pinatubo", "Raoul Island", "Okmok", "Apoyeque", "Ambrym", "Bona-Churchill", "Taupo", "Ksudach", "Ilopango", "Rabaul", "Pago", "Bona-Churchill", "Dakataua", "Ceboruco", "Changbaishan", "Quilotoa", "Kuwae", "Bardarbunga", "Huaynaputina", "Long Island", "Tambora", "Krakatau", "Santa Maria", "Novarupta", "Pinatubo" };

        //Execute
        String[] actual = va.highVEI();

        //Assert
        Assert.assertEquals("should have 39 volcanoes", expected.length, actual.length);
        Assert.assertArrayEquals("should have the correct volcanoes",expected, actual);

        //Teardown
    }

    @Test
    public void mostDeadly() {
        //Setup
        Volcano expected = new Volcano();
        expected.setYear(450);
        expected.setTsu("");
        expected.setEQ("");
        expected.setName("Ilopango");
        expected.setLocation("El Salvador");
        expected.setCountry("El Salvador");
        expected.setLatitude(13.672);
        expected.setLongitude(-89.053);
        expected.setElevation(450);
        expected.setType("Caldera");
        expected.setVEI(6);
        expected.setAgent("");
        expected.setDEATHS("30000");

        //Execute
        Volcano actual = va.mostDeadly();

        //Assert
        Assert.assertEquals("should have correct year", expected.getYear(), actual.getYear());
        Assert.assertEquals("should have correct Tsu", expected.getTsu(), actual.getTsu());
        Assert.assertEquals("should have correct EQ", expected.getEQ(), actual.getEQ());
        Assert.assertEquals("should have correct Name", expected.getName(), actual.getName());
        Assert.assertEquals("should have correct Location", expected.getLocation(), actual.getLocation());
        Assert.assertEquals("should have correct Country", expected.getCountry(), actual.getCountry());
        Assert.assertEquals("should have correct Latitude", expected.getLatitude(), actual.getLatitude());
        Assert.assertEquals("should have correct Longitude", expected.getLongitude(), actual.getLongitude());
        Assert.assertEquals("should have correct Elevation", expected.getElevation(), actual.getElevation());
        Assert.assertEquals("should have correct Type", expected.getType(), actual.getType());
        Assert.assertEquals("should have correct VEI", expected.getVEI(), actual.getVEI());
        Assert.assertEquals("should have correct Agent", expected.getAgent(), actual.getAgent());
        Assert.assertEquals("should have correct DEATHS", expected.getDEATHS(), actual.getDEATHS());
        //Teardown
    }

    @Test
    public void causedTsunami() {
        //Setup
        double expected = 17;

        //Execute
        double actual = va.causedTsunami();

        //Assert
        Assert.assertEquals("should be about 17.0 percent", expected, actual, .1);

        //Teardown
    }

    @Test
    public void mostCommonType() {
        //Setup
        String expected = "Stratovolcano";

        //Execute
        String actual = va.mostCommonType();

        //Assert
        Assert.assertEquals("should be Stratovolcano", expected, actual);

        //Teardown
    }

    @Test
    public void eruptionsByCountry() {
        //Setup
        int expected1 = 47;
        int expected2 = 189;
        int expected3 = 0;

        //Execute
        int actual1 = va.eruptionsByCountry("United States");
        int actual2 = va.eruptionsByCountry("Indonesia");
        int actual3 = va.eruptionsByCountry("Zimbabwe");

        //Assert
        Assert.assertEquals("should be 47 eruptions in United States", expected1, actual1);
        Assert.assertEquals("should be 189 eruptions in Indonesia", expected2, actual2);
        Assert.assertEquals("should be 0 eruptions in Zimbabwe", expected3, actual3);
        //Teardown
    }

    @Test
    public void averageElevation() {
        //Setup
        double expected = 1993.71;

        //Execute
        double actual = va.averageElevation();

        //Assert
        Assert.assertEquals("should be about 1993.71", expected, actual, .1);

        //Teardown
    }

    @Test
    public void volcanoTypes() {
        //Setup
        String[] expected = { "Caldera", "Stratovolcano", "Complex volcano", "Shield volcano", "Pyroclastic shield", "Volcanic field", "Lava dome", "Subglacial volcano", "Crater rows", "Tuff cone", "Fissure vent", "Pyroclastic cone", "Submarine volcano", "Lava cone", "Pumice cone", "Mud volcano", "Cinder cone", "Compound volcano", "Maar"};
        //Execute
        String[] actual = va.volcanoTypes();

        //Assert
        Assert.assertEquals("should have 19 volcano types", expected.length, actual.length);
        Assert.assertArrayEquals("should have the correct volcano types",expected, actual);

        //Teardown
    }

    @Test
    public void percentNorth() {
        //Setup
        double expected = 64.55;

        //Execute
        double actual = va.percentNorth();

        //Assert
        Assert.assertEquals("should be about 64.55 percent", expected, actual, .1);

        //Teardown
    }

    @Test
    public void manyFilters() {
        //Setup
        String[] expected = { "Galunggung", "Hudson, Cerro" };
        //Execute
        String[] actual = va.manyFilters();

        //Assert
        Assert.assertEquals("should have 3 volcanoes", expected.length, actual.length);
        Assert.assertArrayEquals("should have the correct volcanoes",expected, actual);

        //Teardown
    }

    @Test
    public void elevatedVolcanoes() {
        //Setup
        String[] expected = { "Tungurahua", "Cotopaxi", "Bona-Churchill", "Bona-Churchill", "Ruiz", "Tungurahua", "Cotopaxi", "Cotopaxi", "Cotopaxi", "Cotopaxi", "Sabancaya", "Ararat", "Ruiz", "Cotopaxi", "Tungurahua", "Tungurahua", "Popocatepetl", "Sangay", "Ruiz", "Sabancaya", "Huila", "Popocatepetl", "Tungurahua", "Tungurahua", "Tungurahua", "Huila", "Tungurahua", "Huila", "Tungurahua", "Tungurahua", "Tungurahua", "Ubinas" };

        //Execute
        String[] actual = va.elevatedVolcanoes(4990);

        //Assert
        Assert.assertEquals("should have 32 volcanoes above 4990", expected.length, actual.length);
        Assert.assertArrayEquals("should have the correct volcanoes",expected, actual);

        //Teardown
    }

    @Test
    public void topAgentsOfDeath() {
        //Setup
        String[] expected = { "P", "M", "W", "A", "I" };

        //Execute
        String[] actual = va.topAgentsOfDeath();

        //Assert
        Assert.assertEquals("should have 5 Agents of Death", expected.length, actual.length);
        Assert.assertArrayEquals("should have the correct Agents of Death",expected, actual);

        //Teardown
    }
}