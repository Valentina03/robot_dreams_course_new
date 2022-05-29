import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Service {

    private boolean isEven(int number) {
        return (number % 2 == 0);
    }

    private boolean checkValuesCharMap(HashMap<Character, Integer> charCountMap) {
        Integer[] values = charCountMap.values().toArray(new Integer[0]);
        for (int k = 0; k < charCountMap.values().size(); k++) {
            if (!isEven(values[k])) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> searchTwoEvenLetters(String[] usersList) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < usersList.length; i++) {
            char[] charWord = usersList[i].toCharArray();
            HashMap<Character, Integer> charCountMap = new HashMap<>();
            for (int j = 0; j < charWord.length; j++) {
                charCountMap.put(charWord[j], charCountMap.getOrDefault(charWord[j], 0) + 1);
            }
            if (checkValuesCharMap(charCountMap)) {
                resultList.add(usersList[i]);
                if (resultList.size() == 2) {
                    break;
                }
            }
        }
        return resultList;
    }

    public HashSet<Character> getUniqChars(ArrayList<String> list) {
        HashSet<Character> resultChars = new HashSet<>();
        for (String word : list) {
            char[] chars = word.toCharArray();
            for (char element : chars) {
                resultChars.add(element);
            }
        }
        return resultChars;
    }
}

