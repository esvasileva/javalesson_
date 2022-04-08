package core.lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<Integer>> phonebookHashMap;

    public Phonebook(HashMap<String, ArrayList<Integer>> phonebookHashMap) {
        this.phonebookHashMap = phonebookHashMap;
    }

    public void add(String fio, int phoneNumber) {
        ArrayList<Integer> phoneFio = phonebookHashMap.getOrDefault(fio, new ArrayList<>());
        phoneFio.add(phoneNumber);
        phonebookHashMap.put(fio, phoneFio);
        this.phonebookHashMap = phonebookHashMap;
    }

    public ArrayList<Integer> get(String fio){
        System.out.println("Результаты поиска номеров телефонов по ФИО: " + fio);
        return phonebookHashMap.get(fio);
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                phonebookHashMap +
                '}';
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook(new HashMap<>());
        phonebook.add("Вера", 78924500);
        phonebook.add("Лена", 78978900);
        phonebook.add("Лена", 78522900);

        System.out.println(phonebook);

        System.out.println(phonebook.get("Лена"));
    }

}
