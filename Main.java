import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static PersonManager personManager = new PersonManager();
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        fileManager.loadFromFile(personManager.personList);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Criar Pessoa");
            System.out.println("2. Achar Pessoa");
            System.out.println("3. Editar Pessoa");
            System.out.println("4. Deletar Pessoa");
            System.out.println("5. Sair e Salvar");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    fileManager.saveToFile(personManager.personList);
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        personManager.addPerson(new Person(name, age, email, phone));
        System.out.println("Person added successfully.");
    }

    private static void findPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Person person = personManager.getPersonByName(name);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private static void updatePerson() {
        System.out.print("Enter the name of the person to update: ");
        String name = scanner.nextLine();

        Person existingPerson = personManager.getPersonByName(name);
        if (existingPerson != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String newPhone = scanner.nextLine();

            boolean updated = personManager.updatePerson(name, new Person(newName, newAge, newEmail, newPhone));
            if (updated) {
                System.out.println("Person updated successfully.");
            } else {
                System.out.println("Person not found.");
            }
        } else {
            System.out.println("Person not found.");
        }
    }

    private static void deletePerson() {
        System.out.print("Enter the name of the person to delete: ");
        String name = scanner.nextLine();

        boolean deleted = personManager.deletePerson(name);
        if (deleted) {
            System.out.println("Person deleted successfully.");
        } else {
            System.out.println("Person not found.");
        }
    }
}
