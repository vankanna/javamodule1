package edu.wctc;

import java.util.Scanner;

public class Main {

    // Method for outputting to user to be more efficient
    static void promptUser(String prompt) {
        System.out.println(prompt);
        System.out.println("  Enter 0 for the preference on the left");
        System.out.println("  Enter 1 for the preference on the right");
    }

    public static void main(String[] args) {
        // used to control while loop
        boolean playAgain = true;
        // needed to get input
        Scanner sc = new Scanner(System.in);
        // array of prompts
        String[] prompts = {
                "Do you prefer mild or spicy",
                "Do you prefer tea or coffee",
                "Do you prefer breakfast or brunch",
                "Do you prefer summer or winter",
                "Do you prefer paper or plastic",

        };
        // while loop lets us play again
        while (playAgain) {
            // initializing the int array inside the while loop lets it refresh if you play again
            int[] answers;
            answers = new int[5];
            // initializing the total refreshes on every loop of the while loop
            int total = 0;

            // loops through the prompts and asks the user
            for (int i = 0; i < prompts.length; i++) {
                promptUser(prompts[i]);
                // using nextInt so the addition in the next loop works could parseInt instead but this is ok
                answers[i] = sc.nextInt();
            }

            // totals up the answers
            for (int answer : answers) {
                total += answer;
            }

            // decide the message based on the score
            if (total == 3) {
                System.out.println("You prefer a good balance in life");
            } else if (total > 3) {
                System.out.println("You prefer life to be spontaneous and active");
            } else {
                System.out.println("You prefer life to be calm and organized");
            }

            System.out.println("Again? Enter 1 to play again, or any other key to exit");
            String response;

            // eats the \n key left by the nextInt() function
            sc.nextLine(); // Very odd behavior when switching from nextInt to nextLine, this line will consume the "cursor"

            // gets the users input, using nextline incase user uses non int so nextInt doesnt break
            response = sc.nextLine();
            if (response.equals("1")) {
                // allows the while loop to loop again
                playAgain = true;
            } else {
                // stops the loop
                playAgain = false;
                System.out.println("Closing Program...");
            }
        }
    }
}


