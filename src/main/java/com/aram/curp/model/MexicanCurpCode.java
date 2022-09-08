package com.aram.curp.model;

import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

/**
 * Static final class to represent the Mexican 'CURP' code
 * It's single responsibility is to validate whether
 * a CharSequence is a valid mexican 'CURP' code or not.
 */

public final class MexicanCurpCode {

    /**
     * Private constructor
     */
    private MexicanCurpCode() {}

    /**
     * Regex for the Mexican 'CURP' code.
     *
     * Explanation:
     *  1) ^ for start of line
     *  2) First letter of the first last name, in upper case
     *  3) First vowel of the first last name, in upper case
     *  4) First letter of the second last name, in upper case
     *  5) First letter of the first name, in upper case
     *  6) Last two digits of the year of birth
     *  7) Two digits for the month of birth
     *  8) Two digits for the day of birth
     *  9) The character 'H' (if male) or 'M' (if female)
     * 10) Two letters for the code of the mexican state, in upper case
     * 11) First non-initial consonant of the first last name
     * 12) First non-initial consonant of the second last name
     * 13) First non-initial consonant of the first name
     * 14) Any letter in upper case or a single digit
     * 15) A single digit
     * 16) $ for end of line
     */
    private static final String MEXICAN_CURP_CODE_REGEX =
            "^[A-Z][AEIOU][A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]" +
                "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
                    "[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d]\\d$";

    /**
     * Effective Java (Joshua Bloch), Item 6: Avoid creating unnecessary objects.
     * Compile the regex only once.
     */
    private static final Pattern pattern = Pattern.compile(MEXICAN_CURP_CODE_REGEX);

    /**
     * Effective Java (Joshua Bloch), Item 64: Refer to objects by their interfaces.
     * We take any CharSequence, not just String objects.
     *
     * Tests whether a CharSequence is a valid mexican 'CURP' code or not
     *
     * @param tested the CharSequence to test
     * @return true if the CharSequence is a valid mexican 'CURP' code, false otherwise
     * @throws NullPointerException if the CharSequence is null
     */
    public static boolean isValid(CharSequence tested) throws NullPointerException {
        requireNonNull(tested);
        return pattern.matcher(tested).matches();
    }

}
