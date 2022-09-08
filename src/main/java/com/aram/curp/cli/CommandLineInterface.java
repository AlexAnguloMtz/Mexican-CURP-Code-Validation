package com.aram.curp.cli;

import com.aram.curp.model.MexicanCurpCode;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Command line user interface to test
 * whether the user input is a valid mexican 'CURP' code or not
 */
public final class CommandLineInterface {

    private static final String EXIT_COMMAND = "exit";
    private final Messages messages;
    private final Scanner scanner;

    public CommandLineInterface() {
        this.messages = new Messages();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the command line application
     */
    public void start() {
        while (true) {
            run();
        }
    }

    /**
     * Main algorithm of the program.
     * 1. Obtain the user's input
     * 2. Verify whether the user wants to exit or not
     * 3. Validate the user's input and map it to an appropriate message
     * 4. Show the validation message on screen
     */
    private void run() {
        // Some Java 8...
        Stream.of(getUserInput())
                .map(this::maybeCloseProgram)
                .map(this::validationMessage)
                .forEach(this::print);
    }

    private String getUserInput() {
        return input(messages.instructions());
    }

    private String input(String message) {
        print(message);
        return scanner.nextLine();
    }

    private String maybeCloseProgram(String input) {
        if (userWantsToExit(input)) {
            print(messages.closingProgram());
            exit();
        }
        return input;
    }

    private boolean userWantsToExit(String input) {
        return EXIT_COMMAND.equalsIgnoreCase(input);
    }

    private void exit() {
        System.exit(0);
    }

    private String validationMessage(CharSequence tested) {
        return isValid(tested) ? messages.validCurpCode(tested) : messages.invalidCurpCode(tested);
    }

    private boolean isValid(CharSequence tested) {
        return MexicanCurpCode.isValid(tested);
    }

    private void print(String message) {
        System.out.println(message);
    }

}