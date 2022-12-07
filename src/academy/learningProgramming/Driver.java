package academy.learningProgramming;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    /**
     * This class is the main driver of Dog and Monkey classes
     * inside it is a loop that display a menu of options:
     * it asks the user for eithr new dog or monkey, or to print for available animals.
     *
     * @Author Mohamed Hassan
     * @Version 1.0
     */

    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menuOptions();

    }


    public static void menuOptions() {
        MenuOptions option;
        do {
            displayMenu();

            option = getOptionFromUser();

            if (option == MenuOptions.TAKE_NEW_DOG) {
                intakeNewDog(scanner);
            } else if (option == MenuOptions.TAKE_NEW_MONKEY) {

                intakeNewMonkey(scanner);
            } else if (option == MenuOptions.RESERVE_ANIMAL) {
                reserveAnimal(scanner);
            } else if (option == MenuOptions.PRINT_DOGS) {
                printAnimals(option);
            } else if (option == MenuOptions.PRINT_MONKEYS) {
                printAnimals(option);
            } else if (option == MenuOptions.PRINT_RESERVED_ANIMALS) {
                printAnimals(option);
            } else if (option == MenuOptions.EXIT) {
                System.out.println("Good bye.");
            } else {
                System.out.println("Invalid input!!");
                System.out.println("Please enter valid input.");
            }

        } while (option != MenuOptions.EXIT);
    }


    private static MenuOptions getOptionFromUser() {
        return MenuOptions.getOptionID(getNextNumber());
    }

    public static int getNextNumber() {
        return scanner.nextInt();
    }


    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\tRescue Animal System Menu");
        System.out.println("[0] Quit application");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");

        System.out.println();
        System.out.println("Enter a menu selection\n");
    }

    //Take a new dog.
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?\n");
        String name = scanner.nextLine();
        for ( Dog dog : dogList ) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        //if name isn't in dog list, get more info. and add to dog list.
        System.out.println("What is " + name + "'s breed?\n");
        String breed = scanner.nextLine();

        System.out.println("What is " + name + " gender?\n");
        String gender = scanner.nextLine();

        System.out.println("Enter " + name + "'s age:\n");
        String age = scanner.nextLine();

        System.out.println("Enter " + name + "'s weight:\n");
        String weight = scanner.nextLine();

        System.out.println("Enter " + name + "'s acquisition date:\n");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is " + name + "'s acquisition country.");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is " + name + "'s training status?\n");
        String trainingStatus = scanner.nextLine();

        System.out.println("What country is " + name + " in service ?\n");
        String countryInService = scanner.nextLine();

        boolean reserved;

        while (true) {

            System.out.println("Is " + name + " reserved? type YES  or NO\n");
            String answer = scanner.next().strip().toLowerCase();

            if (answer.equals("yes")) {
                reserved = true;
                break;
            } else if (answer.equals("no")) {
                reserved = false;
                break;
            } else {
                System.out.println("Invalid input. Please tye YES or NO");
            }
        }

        //Create new dog object, and add to dog list
        dogList.add(new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, countryInService));
    }

    //Take new monkey.
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is monkey's name?\n");
        String name = scanner.nextLine();
        for ( Monkey monkey : monkeyList ) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println(name + " is already in our system.");
                return; //return to menu
            }
        }
        //if name isn't in monkey list, it is new monkey, get more info. and  add to monkey list.
        System.out.println("What is " + name + "'s gender?\n");
        String gender = scanner.nextLine();
        System.out.println("Enter " + name + "'s age:\n");
        String age = scanner.nextLine();
        System.out.println("Enter " + name + "'s weight:\n");
        String weight = scanner.nextLine();
        System.out.println("Enter " + name + "'s acquisition date:\n");
        String acquisitionDate = scanner.nextLine();
        System.out.println("What is " + name + "'s acquisition country.");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is " + name + "'s training status?\n");
        String trainingStatus = scanner.nextLine();


        System.out.println("What country is " + name + " in service ?\n");
        String countryInService = scanner.nextLine();

        System.out.println("What is " + name + "'s tail length?\n");
        int tailLength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is " + name + "'s height?\n");
        int height = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is " + name + "'s body length?\n");
        int bodyLength = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What species " + name + " is ?\n");
        String species = scanner.nextLine();

        boolean reserved;

        while (true) {
            System.out.println("Is " + name + " reserved? type YES  or NO\n");
            String answer = scanner.next().strip().toLowerCase();
            if (answer.equals("yes")) {
                reserved = true;
                break;
            } else if (answer.equals("no")) {
                reserved = false;
                break;
            } else {
                System.out.println("Invalid input. Please tye YES or NO");
            }
        }

        //create new monkey object and add to monkey list.
        monkeyList.add(new Monkey(name, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, countryInService, tailLength, height, bodyLength, species));

    }


    public static void reserveAnimal(Scanner scanner) {
        boolean foundAnimal = false;

        System.out.println("What type animal do you want to resere?:\n Enter 'dog' or 'monkey:\n");
        String animalType = scanner.nextLine().strip();

        System.out.println("Type in service country:\n");
        String country = scanner.nextLine().strip();

        if (animalType.equalsIgnoreCase("dog")) {
            for ( Dog dog : dogList ) {
                if ((!dog.getReserved()) && dog.getInServiceLocation().equalsIgnoreCase(country)) {

                    dog.setReserved(true);
                    System.out.println(dog.getName() + " reserved for you.");
                    foundAnimal = true;
                    break; //out of loop if when unreserved dog is found.

                }
            }
            if (!foundAnimal) {
                System.out.println("Sorry, We do not have a dog to reserve for you " +
                        "at this moment\nPlease check back soon.");
            }

        } else if (animalType.equalsIgnoreCase("monkey")) {
            for ( Monkey monkey : monkeyList ) {

                if ((!monkey.getReserved()) && (monkey.getInServiceLocation().equalsIgnoreCase(country))) {
                    monkey.setReserved(true);
                    System.out.println(monkey.getName() + " reserved for you.");
                    foundAnimal = true;

                    break;//out of loop if when unreserved monkey is found.
                }
            }
            if (!foundAnimal) {
                System.out.println("Sorry, We do not have a monkey to reserve for you " +
                        "at this moment\nPlease check back soon.");
            }
        }
    }


    /**
     * Depending on the user's choice, this method
     * rints dogs list, monkey list or full-trained available non-reserved animals.
     *
     * @Param option, the option user choice. either to print only dogs or monkey
     * available non-reserved animals.
     */
    public static void printAnimals(MenuOptions option) {
        int numOfAvailableAnimals = 0; // This variable gets incremented if fully trained
        // non-reserved animlas are found
        // and at the end of loop, number of animals will be printed:

        //check what option the user entered to print appropriate list.
        if (option == MenuOptions.PRINT_RESERVED_ANIMALS) {
            for ( Dog dog : dogList ) {
                System.out.printf("Dog name: %s\n", dog.getName());
                System.out.printf("Training status: %s\n", dog.getTrainingStatus());
                System.out.printf("Acquisition country: %s\n", dog.getAcquisitionLocation());
                if (dog.getReserved()) {
                    System.out.println(dog.getName() + " is reserved.");
                }
                System.out.println();
            }
        } else if (option == MenuOptions.PRINT_MONKEYS) {
            for ( Monkey monkey : monkeyList ) {
                System.out.printf("Monkey name: %s\n", monkey.getName());
                System.out.printf("Training status: %s\n", monkey.getTrainingStatus());
                System.out.printf("Acquisition country: %s\n", monkey.getAcquisitionLocation());
                if (monkey.getReserved()) {
                    System.out.println(monkey.getName() + " is reserved.");
                }
                System.out.println();
            }
        } else if (option == MenuOptions.PRINT_RESERVED_ANIMALS) {

            System.out.println("Printing Fully trained Available Dogs:");
            System.out.println("---------------------------------------");

            for ( Dog dog : dogList ) {
                if ((!dog.getReserved()) && (dog.getTrainingStatus().equalsIgnoreCase("in service"))) {
                    numOfAvailableAnimals += 1;
                    System.out.printf("Dog name: %s\n", dog.getName());
                    System.out.printf("Training status: %s\n", dog.getTrainingStatus());
                    System.out.printf("Acquisition country: %s\n", dog.getAcquisitionLocation());

                    System.out.println();
                }
            }
            //print number of available dogs
            if (numOfAvailableAnimals == 1) {
                System.out.println("There is " + numOfAvailableAnimals + " non-reserved available dog.");
                numOfAvailableAnimals = 0; // reset num animals found to count num of monkey below.
            } else {
                System.out.println("There are " + numOfAvailableAnimals + " non-reserved available dogs.");
                numOfAvailableAnimals = 0; // reset num animals found to count num of monkey below.

            }
            System.out.println();
            System.out.println("Printing Fully trained Available Monkeys:");
            System.out.println("-----------------------------------------");

            for ( Monkey monkey : monkeyList ) {
                if ((!monkey.getReserved()) && (monkey.getTrainingStatus().equalsIgnoreCase("in service"))) {
                    numOfAvailableAnimals += 1;
                    System.out.printf("Monkey name: %s\n", monkey.getName());
                    System.out.printf("Training Status: %s\n", monkey.getTrainingStatus());
                    System.out.printf("Acquisition country: %s\n", monkey.getAcquisitionLocation());
                    System.out.println();
                }
            }

            //print number of available monkeys
            if (numOfAvailableAnimals == 1) {
                System.out.println("There is " + numOfAvailableAnimals + " non-reserved available monkey.");
            } else {
                System.out.println("There are " + numOfAvailableAnimals + " non-reserved available monkeys.");

            }
        } else {
            System.out.println("Invalid input! Please try again.");
        }
    }
}