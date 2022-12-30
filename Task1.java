import java.util.HashMap;
import java.util.Map;

/*
 * Подсчитать количество вхождения каждого слова
 * Пример:
 * Россия идет вперед всей планеты. Планета — это не Россия.
 */

 class Task1 {
    public static void main(String[] args) {
            String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
            text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
            while (text.contains("  ")){
                text = text.replace("  ", " ");
            }
            String[] arrayText = text.split(" ");
    
            Map<String, Integer> map = getCountWords(arrayText);
    
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                System.out.println(entry.getKey() + " - " + entry.getValue());
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
