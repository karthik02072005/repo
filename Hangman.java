import java.util.Scanner;
public class Hangman {
    public static void main(String[] args) {
        String[] words = {"media", "java", "aquaman", "godawn", "hangman"};
        String wordToGuess = words[(int) (Math.random() * words.length)];
        StringBuilder currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        int attempts = 6;
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0 && currentGuess.toString().contains("_")) {
            System.out.println("Current guess: " + currentGuess);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.nextLine().charAt(0);
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    currentGuess.setCharAt(i, guess);
                    correctGuess = true;
                }
            }
            if (!correctGuess) {
                attempts--;
            }
        }
        if (currentGuess.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
        }
        scanner.close();
    }
}
