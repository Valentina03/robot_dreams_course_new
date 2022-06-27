public abstract class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Person partner;
    private boolean pet;

    public Person(String firstName, String lastName, int age, Person partner, boolean pet) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        this.partner = partner;
        setPet(pet);
    }

    public Person(String firstName, String lastName, int age, boolean pet) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setPet(pet);
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            System.out.println("Empty firstName");
            throw new IllegalArgumentException("Empty firstName");
        } else {
            this.firstName = firstName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            System.out.println("Empty lastName");
            throw new IllegalArgumentException("Empty lastName");
        } else {
            this.lastName = lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.printf("Incorrect age - %s %n", age);
            throw new IllegalArgumentException("Empty age");
        }
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    public abstract boolean isRetired();

    public boolean isHasPartner() {
        return partner != null;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public void deletePartner(){
        this.partner = null;
    }

    public boolean registerPartnership(Person partner) {
        if (!isHasPartner() && !partner.isHasPartner()) {
            this.setPartner(partner);
            partner.setPartner(this);
            System.out.printf("%s and %s have registered partnership!!! %n", getLastName(), partner.getLastName());
            return true;
        } else {
            System.out.printf("%s or %s already has partner! %n", getLastName(), partner.getLastName());
            return false;
        }
    }

    public boolean deregisterPartnership(Person partner){
        if (this.isHasPartner() && partner.isHasPartner()){
            if (partner.equals(partner.partner.partner)){
                this.deletePartner();
                partner.deletePartner();
                System.out.printf("%s and %s deregistered partnership!!! %n", getLastName(), partner.getLastName());
                return true;
            } else {
                System.out.printf("%s and %s hasn't partnership!!! %n", getLastName(), partner.getLastName());
                return false;
            }
        } else {
            System.out.printf("%s or %s not partner! %n", getLastName(), partner.getLastName());
            return false;
        }
    }
}
