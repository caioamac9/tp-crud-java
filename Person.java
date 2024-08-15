import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String email;
    private String phone;

    public Person(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Nome: " + name + "\nIdade: " + age + "\nEmail: " + email + "\nTelefone: " + phone;
    }

    public static void addPerson(List<Person> personList, Scanner scanner) {
        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();
        System.out.print("Digite a idade: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String phone = scanner.nextLine();

        personList.add(new Person(name, age, email, phone));
        System.out.println("Pessoa adicionada.");
    }

    public static void findPerson(List<Person> personList, Scanner scanner) {
        System.out.print("Digite o nome: ");
        String name = scanner.nextLine();
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(name)) {
                System.out.println(person);
                return;
            }
        }
        System.out.println("Não encontrada.");
    }

    public static void updatePerson(List<Person> personList, Scanner scanner) {
        System.out.print("Digite o nome da pessoa à atualizar: ");
        String name = scanner.nextLine();

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getName().equalsIgnoreCase(name)) {
                System.out.print("Digite o novo nome: ");
                String newName = scanner.nextLine();
                System.out.print("Digite a nova idade: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o novo email: ");
                String newEmail = scanner.nextLine();
                System.out.print("Digite o novo telefone: ");
                String newPhone = scanner.nextLine();

                personList.set(i, new Person(newName, newAge, newEmail, newPhone));
                System.out.println("Atualizado.");
                return;
            }
        }
        System.out.println("Não encontrada.");
    }

    public static void deletePerson(List<Person> personList, Scanner scanner) {
        System.out.print("Digite o nome da pessoa à excluir: ");
        String name = scanner.nextLine();

        if (personList.removeIf(person -> person.getName().equalsIgnoreCase(name))) {
            System.out.println("Deletado.");
        } else {
            System.out.println("Não encontrada.");
        }
    }
}
