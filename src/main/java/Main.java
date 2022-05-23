import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        String[] wordsList = new String[]{"дядя","стол","папа","мама"};
        ArrayList<String> resultList = service.searchTwoEvenLetters(wordsList);
        service.getUniqChars(resultList);
        //System.out.println(service.getUniqChars(resultList));
    }
}
