package input;

import world.WorldBuilder;

import java.util.Scanner;

public class CommandReceiver {

    public static void main(String[] args) {

        //initial setup!
        WorldBuilder.start();
        startReceiving();
    }

    private static void startReceiving() {
        String command;
        Scanner in = new Scanner(System.in);
        CommandParser parser = new CommandParser();

        while (!(command = in.nextLine()).equals(Command.EXIT.toInputString())) {
            parser.parse(command);
        }
    }
}