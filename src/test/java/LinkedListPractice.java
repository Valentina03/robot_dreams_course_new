import java.util.LinkedList;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<String> nameList2 = new LinkedList<>();
        nameList2.add("test");
        System.out.println(nameList2.get(0));
        System.out.println(nameList2.getFirst());
        System.out.println(nameList2.peekFirst());
        System.out.println(nameList2.peekLast());
    }
}
