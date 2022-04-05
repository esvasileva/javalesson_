package core.lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Первый");
        stringArrayList.add("Второй");
        stringArrayList.add("Третий");
        stringArrayList.add("Четвертый");
        stringArrayList.add("Пятый");
        stringArrayList.add("Шестой");
        stringArrayList.add("Седьмой");
        stringArrayList.add("Восьмой");
        stringArrayList.add("Девятый");
        stringArrayList.add("Десятый");
        stringArrayList.add("Первый");
        stringArrayList.add("двенадцатый");
        stringArrayList.add("Второй");
        stringArrayList.add("Пер");
        stringArrayList.add("Второ");
        stringArrayList.add("Двенацатый");

        System.out.println(stringArrayList);

        HashMap<String, Integer> repeatWords = new HashMap<>();
        for (int i = 0; i < stringArrayList.size(); i++) {
            if (repeatWords.containsKey(stringArrayList.get(i)) == true) {
                repeatWords.put(stringArrayList.get(i), repeatWords.get(stringArrayList.get(i)) + 1);
            } else {
                repeatWords.put(stringArrayList.get(i), 1);
            }
        }
        System.out.println(repeatWords);
    }
}
