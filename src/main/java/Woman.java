public class Woman extends Person {

    private String oldLastName;

    public Woman(String firstName, String lastName, int age, Person partner, boolean pet) {
        super(firstName, lastName, age, partner, pet);
    }

    public Woman(String firstName, String lastName, int age, boolean pet) {
        super(firstName, lastName, age, pet);
    }

    @Override
    public boolean isRetired() {
        if (getAge() >= 60) {
            System.out.printf("%s retired %n", getLastName());
            return true;
        }
        return false;
    }

    @Override
    public boolean registerPartnership(Person partner) {
        if (super.registerPartnership(partner)){
            this.oldLastName = getLastName();
            setLastName(partner.getLastName());
            System.out.printf("%s get new lastname - %s! %n", this.oldLastName, this.getLastName());
            return true;
        } else return false;
    }

    @Override
    public boolean deregisterPartnership(Person partner) {
         if (super.deregisterPartnership(partner)){
             setLastName(oldLastName);
             System.out.printf("%s return lastname %n", this.getLastName());
             return true;
         } else return false;
    }
}
