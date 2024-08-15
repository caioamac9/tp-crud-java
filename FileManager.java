import java.io.*;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "pessoas.txt";

    public void saveToFile(List<Person> personList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Person person : personList) {
                writer.println(person.getName() + "," + person.getAge() + "," + person.getEmail() + "," + person.getPhone());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(List<Person> personList) {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    personList.add(new Person(data[0], Integer.parseInt(data[1]), data[2], data[3]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
