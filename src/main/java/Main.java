
public class Main {
    public static void main(String[] args) {
        Man man1 = new Man("Han", "Roll", 65, true);
        Man man2 = new Man("Ban", "Coll", 18, true);
        Man man3 = new Man("Rad", "Boll", 35, false);
        Man man4 = new Man("Dad", "Loll", 5, false);

        Woman woman1 = new Woman("Ray","Dlomova",61, true);
        Woman woman2 = new Woman("Klay","Blomova",19, false);
        Woman woman3 = new Woman("Say","Tlomova",32, true);
        Woman woman4 = new Woman("Vay","Flomova",8, false);

        man1.isRetired();
        man2.isRetired();
        man3.isRetired();
        man4.isRetired();

        woman1.isRetired();
        woman2.isRetired();
        woman3.isRetired();
        woman4.isRetired();

        man1.registerPartnership(woman1);
        woman2.registerPartnership(man2);

        //cases when it is impossible to register a partnership
        man1.registerPartnership(woman2);
        man2.registerPartnership(woman1);
        woman1.registerPartnership(man1);
        woman4.registerPartnership(man2);

        man1.deregisterPartnership(woman1);

       //cases when it is impossible to deregister a partnership
        man1.deregisterPartnership(woman3);
        man2.deregisterPartnership(woman1);
    }
}
