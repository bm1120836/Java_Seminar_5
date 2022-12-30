import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/*
 * Найти пересечения слов в массивах и указать их общее количество
 */


public class Task3 {
    public static void main(String[] args) {
        
        String[] array1 = {"qwe", "asd", "qwe", "x"};
        String[] array2 = {"qwe", "v"};

        Map<String, Integer> mapArray1 = getCountWords(array1);
        Map<String, Integer> mapArray2 = getCountWords(array2);

        Map<String, Integer> mapResult = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mapArray1.entrySet()){
            String key = entry.getKey();
            int countMap1 = entry.getValue();
            int countMap2 = mapArray2.getOrDefault(key, 0);
            if (countMap2 > 0){
                mapResult.put(key, countMap1 + countMap2);
            }
        }

        for(Map.Entry<String, Integer> entry : mapResult.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    public static Map<String, Integer> getCountWords(String[] array){
        Map<String, Integer> map = new HashMap<>();

        for (String current : array){
            int count = map.getOrDefault(current.toLowerCase(), 0);
            map.put(current.toLowerCase(), ++count);
        }

        return map;
    }
}


