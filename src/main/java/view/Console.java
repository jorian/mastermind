package view;

import model.Code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public Code getCode() {
        //handle getting a guess from the user

        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String input = in.next();
                for (char s: input.toCharArray()) {
                    if ((Character.getNumericValue(s) > 8 || Character.getNumericValue(s) < 1)) {
                        throw new InputMismatchException("That code contains an invalid number");
                    }
                }

                Code code = new Code();
                code.set(input);

                return code;

            } catch (InputMismatchException e) {
                System.out.println("That is not a number. Try again");
            }
        }
    }

    public void displayInstructions() {
        System.out.println("Welcome at Mastermind!");
        System.out.println("A secret code has been generated which you need to guess.");
        System.out.println("You have 12 tries. A code can have more than 1 pin value with the same value.");

    }
}
