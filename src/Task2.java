import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        String[] array = new String[] {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        creatMap(array);
        sort();
    }
    public static Map<String, Integer> arr = new TreeMap<>();

    public static void creatMap(String[] strArr) {
        for (String s : strArr) {
            String[] s1 = s.split(" ");
            if (arr.containsKey(s1[0])) {
                arr.put(s1[0], arr.get(s1[0])+1);
            } else {
                arr.put(s1[0], 1);
            }
        }
    }

    public static void sort() {
        Map<Integer, List<String>> integerListMap = new TreeMap<>(Collections.reverseOrder());
        String[] name = arr.keySet().toArray(new String[0]);
        for (String s : name) {
            int n = arr.get(s);
            if(integerListMap.containsKey(n)) {
                integerListMap.get(n).add(s);
            } else {
                ArrayList<String> str = new ArrayList<>();
                str.add(String.valueOf(s));
                integerListMap.put(n, str);
            }
        }
        integerListMap.remove(1);
        System.out.println(integerListMap);
    }


}

