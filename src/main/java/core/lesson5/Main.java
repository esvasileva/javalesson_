package core.lesson5;



public class Main {
    public static void main(String[] args) {
        AppData city = new AppData(new String[]{"Country", "Region", "City"}, new String[][]{{"Russia","Leningradskii","Saint-Petersburg"}, {"South Korea","Region","Seoul"}});
        city.createFile("file1");
        city.saveIntoFile(new String[][] {{"Spain","Catalonia","Barselona"}, {"China","Region","Beijing"}});

        AppData city1 = new AppData(new String[]{"Country", "Region", "City"}, new String[][]{{"Russia","Leningradskii","Saint-Petersburg"}, {"South Korea","Region","Seoul"}});
        city1.saveIntoFile(new String[][] {{"Spain","Catalonia","Barselona"}, {"China","Region","Beijing"}});
    }
}
