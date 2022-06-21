
import java.util.ArrayList;

public class ArraysListPractice {
    public ArraysListPractice() {
    }

    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<String>(100);
        nameList.add("Chicago");
        nameList.add(0, "Paris");
        System.out.println(nameList.size());
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }
        for (String i : nameList) {
            System.out.println(i);
        }
        System.out.println(nameList.contains("Paris"));
//        HashSet <String> nameSet = new HashSet<>();
//        nameSet.add("Test");
//        System.out.println(nameSet);
//        for (String s : nameSet) {
//            System.out.println(s);
//        }
    }

    public static void test() {

    }


    public void test2(String test) {
        ArraysListPractice arraysListPractice = new ArraysListPractice();
        arraysListPractice.test();
        test();
    }
}
