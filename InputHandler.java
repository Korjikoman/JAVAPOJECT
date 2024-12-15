import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] safeMultipleInt() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String lines = br.readLine();

            // Разделяем строку по пробелам
            String[] strs = lines.trim().split("\\s+");

            // Преобразуем строковый массив в числовой
            int[] numbers = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                try {
                    numbers[i] = Integer.parseInt(strs[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Input error: " + strs[i] + " is not an integer.");
                    return new int[0]; // Возвращаем пустой массив при ошибке
                }
            }
            return numbers;

        } catch (IOException e) {
            System.out.println("Reading error.");
            return new int[0]; // Возвращаем пустой массив в случае ошибки чтения
        }

    }

    public static int safeInt(int min, int max) {
        int input;

        while (true) {
            try {
                System.out.print(" (enter an integer between " + min + " and " + max + "):  ");
                input = Integer.parseInt(scanner.nextLine());

                // Check range
                if (input < min || input > max) {
                    throw new InvalidInputException("Input out of range. Please enter a number within the range.");
                }

                return input; // If all checks passed, return the number

            } catch (NumberFormatException e) {
                // Handle input error (not a number)
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (InvalidInputException e) {
                // Handle exception: print error message
                System.out.println(e.getMessage());
            }
        }
    }

    // Function to check the validity of string input
    public static String safeString(int maxLength) {
        String input;

        while (true) {
            try {
                input = scanner.nextLine();

                // Check for empty string
                if (input.isEmpty()) {
                    throw new InvalidInputException("Input cannot be empty. Please enter a valid string.");
                }

                // Check for valid characters (letters and spaces)
                for (char ch : input.toCharArray()) {
                    if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
                        throw new InvalidInputException(
                                "Invalid character in input. Only letters and spaces are allowed.");
                    }
                }

                // Check for maximum length
                if (input.length() > maxLength) {
                    throw new InvalidInputException(
                            "Input is too long. Please enter a string within the allowed length.");
                }

                return input; // If all checks passed, return the string

            } catch (InvalidInputException e) {
                // Handle exception: print error message
                System.out.println(e.getMessage());
            }
        }
    }

}
