import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

public class VolcanoAnalyzerTests {
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
    public void volcanoListIsLoaded() throws IOException, URISyntaxException {
        //Setup
        Integer expected = 804;
        VolcanoAnalyzer classUnderTest = new VolcanoAnalyzer();
        classUnderTest.loadVolcanoes(Optional.empty());

        //Execute
        Integer actual = classUnderTest.numbVolcanoes();

        //Assert
        Assert.assertEquals("should have 804 volcanoes", expected, actual);

        //Teardown
    }
}
