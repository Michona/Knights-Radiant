package input;

import data.parser.items.ItemParser;
import data.parser.orientation.OrientationParser;

import java.util.Scanner;

public class CommandReceiver {

    public static void main(String[] args) {

        //initial setup!
        OrientationParser.INSTANCE.parseJson();
        ItemParser.INSTANCE.parseJson();

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