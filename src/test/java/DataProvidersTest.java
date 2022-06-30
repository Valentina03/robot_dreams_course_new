import org.testng.annotations.DataProvider;

public class DataProvidersTest {
    @DataProvider(name = "names test data")
    public Object[][] getNamesData(){
        return new Object[][]{
                    {null},{""},{"  "}
        };
    }
    @DataProvider(name = "age test data")
    public Object[][] getAgeData() {
        return new Object[][]{
                {0}, {-1}
        };
    }
}