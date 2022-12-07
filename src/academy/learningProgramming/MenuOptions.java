package academy.learningProgramming;

public enum MenuOptions {

    TAKE_NEW_DOG(1, "TAKE_NEW_DOG"),
    TAKE_NEW_MONKEY(2, "TAKE_NEW_MONKEY"),
    RESERVE_ANIMAL(3, "RESERVE_ANIMAL"),
    PRINT_DOGS(4, "PRINT_DOGS"),
    PRINT_MONKEYS(5, "PRINT_MONKEYS"),
    PRINT_RESERVED_ANIMALS(6, "PRINT_RESERVED_ANIMALS"),
    EXIT(0, "EXIT");


    private final int option;

    private final String value;


    MenuOptions(int option, String value) {
        this.option = option;
        this.value = value;

    }


    public int getOption() {
        return option;
    }

    public String getValue() {
        return value;
    }

    public static MenuOptions getOption(int option) {
        for ( MenuOptions options : MenuOptions.values() ) {
            if (option == options.getOption()) {
                return options;
            }
        }

        throw new IllegalArgumentException(String.format("Menu option %s does not exist", option));
    }


}
