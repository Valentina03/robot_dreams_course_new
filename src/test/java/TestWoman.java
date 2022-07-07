import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestWoman {
    private static final Logger log = LogManager.getLogger(TestWoman.class);
    String firstName = "Ray";
    String lastName = "Dlomova";
    boolean hasPet = false;
    int age = 35;
    Man man1;
    Man man2;

    @BeforeMethod
    public void beforeMethod(){
        this.man1 = new Man("Ban","Coll",51, false);
        this.man2 = new Man("Rad","Boll",19, false);
    }

    @Test(groups = {"setters","getters"})
    public void testCreate(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New woman was create {}", woman);
        assert this.firstName.equals(woman.getFirstName());
        assert this.lastName.equals(woman.getLastName());
        assert this.age == woman.getAge();
        assert this.hasPet == woman.hasPet();
    }

    @Test(dataProvider = "invalid name test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyFirstName(String firstName){
        new Woman(firstName, this.lastName, this.age, this.hasPet);
    }

    @Test(dataProvider = "invalid name test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyLastName(String lastName){
        new Woman(this.firstName, lastName, this.age, this.hasPet);
    }

    @Test(dataProvider = "invalid age test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithIncorrectAge(int age){
        new Woman(this.firstName, this.lastName, age, this.hasPet);
    }

    @Test(dataProvider = "age for retired woman test data", dataProviderClass = DataProvidersTest.class)
    public void testIsRetired(int age){
        Woman woman = new Woman(this.firstName, this.lastName, age, this.hasPet);
        assert woman.isRetired();
    }

    @Test(dataProvider = "invalid age for retired woman test data", dataProviderClass = DataProvidersTest.class, priority = 1)
    public void testIsNotRetired(int age){
        Woman woman = new Woman(this.firstName, this.lastName, age, this.hasPet);
        assert !woman.isRetired();
    }

    @Test()
    public void testRegisterPartnership(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        assert woman.registerPartnership(this.man1);
        assert woman.isHasPartner();
    }

    @Test()
    public void testChangeLastName(){
        String lastName = "Coll";
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        assert lastName.equals(woman.getLastName());
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipTwiceSamePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        assert !woman.registerPartnership(this.man1);
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipPerPersonWithPartner(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        assert !woman.registerPartnership(this.man2);
    }

    @Test()
    public void testDeregisterPartnership(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        assert woman.deregisterPartnership(this.man1);
        assert !woman.isHasPartner();
    }

    @Test()
    public void testReturnLastName(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        woman.deregisterPartnership(this.man1);
        assert this.lastName.equals(woman.getLastName());
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipTwiceSamePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        woman.registerPartnership(this.man1);
        woman.deregisterPartnership(this.man1);
        assert !woman.deregisterPartnership(this.man1);
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipSinglePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.hasPet);
        assert !woman.deregisterPartnership(this.man1);
    }
}
