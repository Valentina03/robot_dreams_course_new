import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMan {
    private static final Logger log = LogManager.getLogger(TestMan.class);
    String firstName = "Han";
    String lastName = "Roll";
    boolean hasPet = true;
    int age = 39;
    Woman woman1;
    Woman woman2;

    @BeforeMethod
    public void beforeMethod(){
        this.woman1 = new Woman("Ray","Dlomova",61, true);
        this.woman2 = new Woman("Klay","Blomova",19, false);
    }

    @Test(groups = {"setters","getters"})
    public void testCreate(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New man was create {}", man);
        assert this.firstName.equals(man.getFirstName());
        assert this.lastName.equals(man.getLastName());
        assert this.age == man.getAge();
        assert this.hasPet == man.hasPet();
    }

    @Test(dataProvider = "invalid name test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyFirstName(String firstName){
        new Man(firstName, this.lastName, this.age, this.hasPet);
    }

    @Test(dataProvider = "invalid name test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyLastName(String lastName){
        new Man(this.firstName, lastName, this.age, this.hasPet);
    }

    @Test(dataProvider = "invalid age test data", dataProviderClass = DataProvidersTest.class, groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithIncorrectAge(int age){
        new Man(this.firstName, this.lastName, age, this.hasPet);
    }

    @Test(dataProvider = "age for retired man test data", dataProviderClass = DataProvidersTest.class)
    public void testIsRetired(int age){
        Man man = new Man(this.firstName, this.lastName, age, this.hasPet);
        log.info("New man was create {}", man);
        assert man.isRetired();
    }

    @Test(dataProvider = "invalid age for retired man test data", dataProviderClass = DataProvidersTest.class, priority = 1)
    public void testIsNotRetired(int age){
        Man man = new Man(this.firstName, this.lastName, age, this.hasPet);
        log.info("New man was create {}", man);
        assert !man.isRetired();
    }

    @Test()
    public void testRegisterPartnership(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New man was create - {}", man);
        assert man.registerPartnership(this.woman1);
        log.info("Man - {} registered partnership with {}, {}", man, woman1, 10);
        assert man.isHasPartner();
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipTwiceSamePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New man was create {}", man);
        man.registerPartnership(this.woman1);
        assert !man.registerPartnership(this.woman1);
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipPerPersonWithPartner(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New man was create {}", man);
        man.registerPartnership(this.woman1);
        assert !man.registerPartnership(this.woman2);
    }

    @Test()
    public void testDeregisterPartnership(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        log.info("New man was create {}", man);
        man.registerPartnership(this.woman1);
        assert man.deregisterPartnership(this.woman1);
        assert !man.isHasPartner();
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipTwiceSamePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        man.registerPartnership(this.woman1);
        man.deregisterPartnership(this.woman1);
        assert !man.deregisterPartnership(this.woman1);
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipSinglePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.hasPet);
        assert !man.deregisterPartnership(this.woman1);
    }
}
