import org.testng.annotations.DataProvider;

public class DataProvidersTest {
    @DataProvider(name = "invalid name test data")
    public Object[][] getNamesData(){
        return new Object[][]{
                {null},{""},{"  "}};
    }
    @DataProvider(name = "invalid age test data")
    public Object[][] getAgeData() {
        return new Object[][]{
                {0}, {-1}};
    }
    @DataProvider(name = "age for retired man test data")
    public Object[][] getAgeForRetiredManData() {
        return new Object[][]{
                {65},{66},{90}};
    }
    @DataProvider(name = "age for retired woman test data")
    public Object[][] getAgeForRetiredWomanData() {
        return new Object[][]{
                {60},{61},{90}};
    }
    @DataProvider(name = "invalid age for retired man test data")
    public Object[][] getInvalidAgeForRetiredManData() {
        return new Object[][]{
                {1},{30},{64}};
    }
    @DataProvider(name = "invalid age for retired woman test data")
    public Object[][] getInvalidAgeForRetiredWomanData() {
        return new Object[][]{
                {1},{30},{59}};
    }
}