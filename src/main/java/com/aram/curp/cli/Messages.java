package com.aram.curp.cli;

import static java.lang.String.format;

/**
 * Class to manage the command line application's messages
 */
final class Messages {

    private static final String INSTRUCTIONS = "\nMexican CURP validator. Enter a String to test, or enter 'exit' to close";
    private static final String VALID_CURP_CODE = "The input '%s' is a VALID mexican CURP code";
    private static final String INVALID_CURP_CODE = "The input '%s' IS NOT a valid mexican CURP code";
    private static final String CLOSING_PROGRAM = "You chose to exit. Closing program. Program finished.";

    String instructions() {
        return INSTRUCTIONS;
    }

    String validCurpCode(CharSequence sequence) {
        return format(VALID_CURP_CODE, sequence);
    }

    String invalidCurpCode(CharSequence sequence) {
        return format(INVALID_CURP_CODE, sequence);
    }

    String closingProgram() {
        return CLOSING_PROGRAM;
    }
}
