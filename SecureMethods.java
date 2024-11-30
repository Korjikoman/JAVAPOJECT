import java.util.InputMismatchException;
import java.util.Scanner;

// This class prevents user from wrong input
public class SecureMethods {
    public int secureInt(int lower_boundary, int upper_boundary) {
        int inp = -1;
        try {
            Scanner in = new Scanner(System.in);
            inp = in.nextInt();
            in.nextLine();
            if (inp < lower_boundary || inp > upper_boundary) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("Please enter integer between " + lower_boundary + " and " + upper_boundary);
            inp = secureInt(lower_boundary, upper_boundary);
        }
        return inp;
    }
}
