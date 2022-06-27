import org.testng.annotations.Test;

public class TestMan {
    String firstName = "Han";
    String lastName = "Roll";
    boolean isPet = true;
    int age = 39;

    @Test(groups = {"setters","getters"})
    public void testCreate(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        assert this.firstName.equals(man.getFirstName());
        assert this.lastName.equals(man.getLastName());
        assert this.age == man.getAge();
        assert this.isPet == man.isPet();
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyFirstName(){
        String firstName = "";
        Man man = new Man(firstName, this.lastName, this.age, this.isPet);
        assert man.getFirstName() == null;
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithEmptyLastName(){
        String lastName = "";
        Man man = new Man(this.firstName, lastName, this.age, this.isPet);
        assert man.getLastName() == null;
    }

    @Test(groups = {"setters"}, priority = 1, expectedExceptions = IllegalArgumentException.class)
    public void testCreateWithIncorrectAge(){
        int age = 0;
        Man man = new Man(this.firstName, this.lastName, age, this.isPet);
        assert man.getAge() <= 0;
    }

    @Test()
    public void testIsRetired(){
        int age = 96;
        Man man = new Man(this.firstName, this.lastName, age, this.isPet);
        assert man.isRetired();
    }

    @Test(priority = 1)
    public void testIsNotRetired(){
        int age = 18;
        Man man = new Man(this.firstName, this.lastName, age, this.isPet);
        assert !man.isRetired();
    }

    @Test()
    public void testRegisterPartnership(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman = new Woman("Ray","Dlomova",61, true);
        assert man.registerPartnership(woman);
        assert man.isHasPartner();
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipTwiceSamePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman = new Woman("Ray","Dlomova",61, true);
        man.registerPartnership(woman);
        assert !man.registerPartnership(woman);
    }

    @Test(priority = 1)
    public void testNotPossibleRegisterPartnershipPerPersonWithPartner(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman1 = new Woman("Ray","Dlomova",61, true);
        Woman woman2 = new Woman("Klay","Blomova",19, false);
        man.registerPartnership(woman1);
        assert !man.registerPartnership(woman2);
    }

    @Test()
    public void testDeregisterPartnership(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman = new Woman("Ray","Dlomova",61, true);
        man.registerPartnership(woman);
        assert man.deregisterPartnership(woman);
        assert !man.isHasPartner();
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipTwiceSamePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman = new Woman("Ray","Dlomova",61, true);
        man.registerPartnership(woman);
        man.deregisterPartnership(woman);
        assert !man.deregisterPartnership(woman);
    }

    @Test(priority = 1)
    public void testNotPossibleDeregisterPartnershipSinglePersons(){
        Man man = new Man(this.firstName, this.lastName, this.age, this.isPet);
        Woman woman = new Woman("Ray","Dlomova",61, true);
        assert !man.deregisterPartnership(woman);
    }
}
