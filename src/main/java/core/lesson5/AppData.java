package core.lesson5;

import java.io.*;

public class AppData {
    private String[] header;
    private String[][] data;
    private String fileName;

    public AppData(String[] header, String[][] data) {
        this.header = header;
        this.data = data;
    }

    public void createFile(String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".csv"))) {
            for (int i = 0; i < header.length; i++) {
                writer.write(header[i]+";");
            }
            writer.write("\n");
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    writer.write(data[i][j] + ";");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileName = fileName + ".csv";
    }

    public void saveIntoFile(String[][] newData) {
        if (fileName == null) {
            System.out.println("Файл не создан. Воспользутесь методом createFile");
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (int i = 0; i < header.length; i++) {
                    writer.write(header[i]+";");
                }
                writer.write("\n");
                for (int i = 0; i < newData.length; i++) {
                    for (int j = 0; j < newData[0].length; j++) {
                        writer.write(newData[i][j] + ";");
                    }
                    writer.write("\n");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
