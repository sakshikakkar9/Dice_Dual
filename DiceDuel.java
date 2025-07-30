package Dice_Dual;
import java.util.*;

public class DiceDuel {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🎲 Welcome to Dice Duel 🎲");
        System.out.println("Choose Mode:\n1. Single Player (vs CPU)\n2. Two Player");

        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        String player1, player2;

        if (mode == 1) {
            System.out.print("Enter your name: ");
            player1 = scanner.nextLine();
            player2 = "CPU";
        } else {
            System.out.print("Enter Player 1 name: ");
            player1 = scanner.nextLine();
            System.out.print("Enter Player 2 name: ");
            player2 = scanner.nextLine();
        }

        playGame(player1, player2);
    }

    static void playGame(String p1, String p2) {
        int p1Wins = 0, p2Wins = 0;
        int round = 1;

        System.out.println("\n🎮 Starting Best-of-3 Match!\n");

        while (p1Wins < 2 && p2Wins < 2) {
            System.out.println("🔹 Round " + round + " - Press ENTER to roll...");
            scanner.nextLine(); // Wait for user to press enter

            int p1Roll1 = rollDice(6);
            int p1Roll2 = rollDice(6);
            int p1Total = p1Roll1 + p1Roll2;

            int p2Roll1 = rollDice(6);
            int p2Roll2 = rollDice(6);
            int p2Total = p2Roll1 + p2Roll2;

            System.out.println(p1 + " rolled: " + p1Roll1 + " + " + p1Roll2 + " = " + p1Total);
            System.out.println(p2 + " rolled: " + p2Roll1 + " + " + p2Roll2 + " = " + p2Total);

            if (p1Total > p2Total) {
                System.out.println("✅ " + p1 + " wins this round!\n");
                p1Wins++;
            } else if (p2Total > p1Total) {
                System.out.println("✅ " + p2 + " wins this round!\n");
                p2Wins++;
            } else {
                System.out.println("🤝 It's a tie!\n");
            }

            round++;
        }

        System.out.println("🏁 Final Result: " + p1 + " " + p1Wins + " - " + p2Wins + " " + p2);
        System.out.println("🏆 Winner: " + (p1Wins > p2Wins ? p1 : p2));
    }

    static int rollDice(int sides) {
        return random.nextInt(sides) + 1;
    }
}
