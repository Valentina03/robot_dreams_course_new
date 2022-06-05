
public class Main {
    public static void main(String[] args) {
        for (Planet planet:Planet.values()){
            System.out.println(planet + ": " + planet.getNumber() + ", " + planet.getDistanceFromPrevious() + ", " +
                    planet.getDistanceFromSun() + ", " + planet.getRadius() + ", " + planet.getPrevious() + ", " +
                    planet.getNext());
        }
    }
}
