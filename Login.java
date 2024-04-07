import java.util.*;

public class Login {
    
    private static final String VALID_PASSWORD = "password";
    private int attemptCount = 0;

    public void login(String password) throws MaxWarning, WrongPassword {
        attemptCount++;
        if (attemptCount == 3) {
            throw new MaxWarning("Maximum of 3 tries has exceeded.");
        }
        if (!password.equals(VALID_PASSWORD)) {
            throw new WrongPassword("Wrong password.");
        }
        attemptCount = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            try {
                login.login(password);
                System.out.println("Login successful :)");
                break;
            } catch (MaxWarning e) {
                System.out.println(e.getMessage());
                
            } catch (WrongPassword e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}