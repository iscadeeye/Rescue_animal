package academy.learningProgramming;

public enum MenuOptions {

    TAKE_NEW_DOG(1, "TAKE_NEW_DOG"),
    TAKE_NEW_MONKEY(2, "TAKE_NEW_MONKEY"),
    RESERVE_ANIMAL(3, "RESERVE_ANIMAL"),
    PRINT_DOGS(4, "PRINT_DOGS"),
    PRINT_MONKEYS(5, "PRINT_MONKEYS"),
    PRINT_RESERVED_ANIMALS(6, "PRINT_RESERVED_ANIMALS"),
    EXIT(0, "EXIT");


    private final int optionID;

    private final String value;


    MenuOptions(int optionID, String value) {
        this.optionID = optionID;
        this.value = value;

    }


    public int getOptionID() {
        return optionID;
    }

    public String getValue() {
        return value;
    }

    public static MenuOptions getOptionID(int option) {
        for ( MenuOptions options : MenuOptions.values() ) {
            if (option == options.getOptionID()) {
                return options;
            }
        }
        return null;
    }
}