import org.testng.annotations.Test;

public class TestWoman {
    String firstName = "Ray";
    String lastName = "Dlomova";
    boolean isPet = false;
    int age = 35;

    @Test(groups = {"setters","getters"})
    public void testCreate(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        assert this.firstName.equals(woman.getFirstName());
        assert this.lastName.equals(woman.getLastName());
        assert this.age == woman.getAge();
        assert this.isPet == woman.isPet();
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyFirstName(){
        String firstName = "";
        Woman woman = new Woman(firstName, this.lastName, this.age, this.isPet);
        assert woman.getFirstName() == null;
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyLastName(){
        String lastName = "";
        Woman woman = new Woman(this.firstName, lastName, this.age, this.isPet);
        assert woman.getLastName() == null;
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithIncorrectAge(){
        int age = 0;
        Woman woman = new Woman(this.firstName, this.lastName, age, this.isPet);
        assert woman.getAge() <= 0;
    }

    @Test()
    public void testIsRetired(){
        int age = 96;
        Woman woman = new Woman(this.firstName, this.lastName, age, this.isPet);
        assert woman.isRetired();
    }

    @Test(priority = 1)
    public void testIsNotRetired(){
        int age = 18;
        Woman woman = new Woman(this.firstName, this.lastName, age, this.isPet);
        assert !woman.isRetired();
    }

    @Test()
    public void testRegisterPartnership(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        assert woman.registerPartnership(man);
        assert woman.isHasPartner();
    }

    @Test()
    public void testChangeLastName(){
        String lastName = "Coll";
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban",lastName,61, false);
        woman.registerPartnership(man);
        assert lastName.equals(woman.getLastName());
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipTwiceSamePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        woman.registerPartnership(man);
        assert !woman.registerPartnership(man);
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipPerPersonWithPartner(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man1 = new Man("Ban","Coll",61, false);
        Man man2 = new Man("Rad","Boll",19, false);
        woman.registerPartnership(man1);
        assert !woman.registerPartnership(man2);
    }

    @Test()
    public void testDeregisterPartnership(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        woman.registerPartnership(man);
        assert woman.deregisterPartnership(man);
        assert !woman.isHasPartner();
    }

    @Test()
    public void testReturnLastName(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        woman.registerPartnership(man);
        woman.deregisterPartnership(man);
        assert this.lastName.equals(woman.getLastName());
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipTwiceSamePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        woman.registerPartnership(man);
        woman.deregisterPartnership(man);
        assert !woman.deregisterPartnership(man);
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipSinglePersons(){
        Woman woman = new Woman(this.firstName, this.lastName, this.age, this.isPet);
        Man man = new Man("Ban","Coll",61, false);
        assert !woman.deregisterPartnership(woman);
    }
}
