import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {

        HashMap<Integer, String> nameMap = new HashMap<>();
        nameMap.put(0, "Валя");
        nameMap.put(1, "sss");
        System.out.println(nameMap.get(0));
        System.out.println(nameMap.containsKey(0));
        System.out.println(nameMap.entrySet());
        for (Map.Entry<Integer, String> integerStringEntry : nameMap.entrySet()) {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        }

        System.out.println(nameMap);
        System.out.println(nameMap.keySet());
        System.out.println(nameMap.values());
        System.out.println(nameMap.remove(1));
        System.out.println(nameMap.entrySet());

        LinkedHashMap<Integer, Integer> namehashmap = new LinkedHashMap<>();
    }
}
