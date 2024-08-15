import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Person> personList = new ArrayList<>();
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {

        fileManager.loadFromFile(personList);

        while (true) {
            System.out.println("Selecione:");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Procurar pessoa");
            System.out.println("3. Editar pessoa");
            System.out.println("4. Deletar pessoa");
            System.out.println("5. Sair");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (option) {
                case 1:
                    Person.addPerson(personList, scanner);
                    break;
                case 2:
                    Person.findPerson(personList, scanner);
                    break;
                case 3:
                    Person.updatePerson(personList, scanner);
                    break;
                case 4:
                    Person.deletePerson(personList, scanner);
                    break;
                case 5:
                    fileManager.saveToFile(personList);
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
