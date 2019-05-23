package input;

import util.Helper;

public enum Command {
    EXIT("exit"),
    LOOK("ls"),

    NORTH("gn"),
    SOUTH("gs"),
    WEST("gw"),
    EAST("ge"),

    PICK("p"),
    USE("u"),

    INVENTORY("i"),

    INPUT_ERROR("_default_");

    private String consoleInput;

    Command(String consoleInput) {
        this.consoleInput = consoleInput;
    }

    public String toInputString() {
        return this.consoleInput;
    }

    public static Command fromInputString(String inp) {

        for (Command c : Command.values()) {
            if (c.toInputString().equalsIgnoreCase(Helper.getFirstWord(inp))) {
                return c;
            }
        }
        return INPUT_ERROR;
    }


}

