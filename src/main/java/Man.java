public class Man extends Person {

    public Man(String firstName, String lastName, int age, Person partner, boolean pet) {
        super(firstName, lastName, age, partner, pet);
    }

    public Man(String firstName, String lastName, int age, boolean pet) {
        super(firstName, lastName, age, pet);
    }

    @Override
    public void isRetired() {
        if (getAge() >= 65) {
            System.out.printf("%s retired %n", getLastName());
        }
    }
}
