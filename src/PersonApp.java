import java.util.Scanner;

public class PersonApp {
    public static void main(String[] args) {
        ClassDataArray Persons = new ClassDataArray(20);

        Persons.Insert("Mashonganyika", "Douglas", 21);
        Persons.Insert("Eita", "Geovanny", 19);
        Persons.Insert("Haimbili", "Verner", 22);


        boolean showMenu = true;
        while(showMenu){
            showMenu = menu(Persons);
        }
    }

    public static boolean shouldContinue(Scanner scanner){
        System.out.print("Do you want to continue? (T/F): ");
        return (scanner.nextLine().toUpperCase().equals("T")) ? true : false;
    }

    public static boolean menu(ClassDataArray persons){
        System.out.println("What would you like to do?:");
        System.out.println("1: Display all persons>");
        System.out.println("2: Insert a person>");
        System.out.println("3: Delete a person>");
        System.out.println("4: Find a person>");

        Scanner newScanner = new Scanner(System.in);
        switch (newScanner.nextLine()){
            case "1":
                persons.DisplayA();
                return shouldContinue(newScanner);
            case "2":
                System.out.println("Write the first name");
                String firstName = newScanner.nextLine();
                System.out.println("Write the last name");
                String lastName = newScanner.nextLine();
                System.out.println("Enter the age");
                int age = Integer.parseInt(newScanner.nextLine());
                persons.Insert(firstName, lastName, age);
                return shouldContinue(newScanner);
            case "3":
                System.out.println("Please enter the Last Name of the person you want to delete");
                String deleteln = newScanner.nextLine();
                boolean result = persons.Delete(deleteln);
                if(result){
                    System.out.println("Person deleted");
                }else{
                    System.out.println("Could not find person");
                }
                return shouldContinue(newScanner);
            case "4":
                System.out.println("Please enter the Last Name of the person you want to find");
                String findln = newScanner.nextLine();
                Person result2 = persons.Find(findln);

                if(result2 != null){
                    result2.displayPerson();
                }else{
                    System.out.println("Could not find the person");
                }
                return shouldContinue(newScanner);
            default:
                return shouldContinue(newScanner);
        }

    }
}
