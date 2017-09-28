import java.util.Scanner;
import java.util.Random;
public class main {

    public static void main(String args[]) {

        int usercard = 0;
        int userhand = 0;
        int dealcard = 0;
        int dealhand = 0;
        int userinput = 0;
        int game = 0;
        int userwin = 0;
        int dealwin = 0;
        int tiegames = 0;
        int percentage = 0;
        int newgame = 1;
        String card;


        Scanner myscanner = new Scanner(System.in);
        Random rand = new Random();

        while(userinput != 4)
        {
            if(newgame == 1) {
                game++;
                System.out.println("");
                System.out.println("START GAME #" +game+ "");    //REMEMBER TO NOT DO START GAME EVERYTIMR
                newgame = 0;
            }

            System.out.println( "");

            usercard = rand.nextInt(13)+1;
          //  dealcard = rand.nextInt(13)+1;

            if(usercard == 1) {
                System.out.println("Your card is an ACE!");
                card = "ACE";
            }
            else if(usercard == 11) {
                System.out.println("Your card is a JACK!");
                card = "JACK";
                usercard = 10;
            }
            else if(usercard == 12) {
                System.out.println("Your card is a QUEEN!");
                card = "QUEEN";
                usercard = 10;
            }
            else if(usercard == 13) {
                System.out.println("Your card is a King!");
                card = "King";
                usercard = 10;
            }
            else {
                if(usercard == 8)
                    System.out.println("Your card is an " + usercard + "!");
                else
                System.out.println("Your card is a " + usercard + "!");
            }

            if(dealcard == 11 || dealcard == 12 || dealcard == 13){
                dealcard = 10;
            }

            userhand = userhand + usercard;
            dealhand = dealcard + dealhand;
            System.out.println("Your hand is: " +userhand+ "");

            if(userhand > 21){
                System.out.println( "You exceeded 21! You Lose :(");
                dealwin++;
                userhand = 0;
                dealhand = 0;
                newgame = 1;
            }

            if(dealhand == 21){
                System.out.println( "BLACKJACK! Dealer Wins");
                dealwin++;
                userhand = 0;
                dealhand = 0;
                newgame = 1;
            }

            if(dealhand == 21)
            {
                System.out.println( "BLACKJACK! You Win! ");
                userwin++;
                userhand = 0;
                dealhand = 0;
                newgame = 1;
            }




            if(userhand != 0) {


                System.out.println("");

                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");

                System.out.print("Choose an option: ");
                System.out.print("");
                System.out.print("");


                userinput = myscanner.nextInt();

                if (userinput == 4) {
                    break;
                }

                else if (userinput == 2) {

                    dealhand = rand.nextInt(26-16)+16;

                    System.out.println("Dealer's hand: " + dealhand + "");
                    System.out.println("Your hand is: " + userhand + "");
                    if(dealhand > 21){
                        System.out.println("You win!");
                        userhand = 0;
                        dealhand = 0;
                        newgame = 1;
                    }
                    else if (userhand > dealhand) {
                        System.out.println("You win!");
                        System.out.println("");

                    } else if (dealhand > userhand) {
                        System.out.println("Dealer wins!");
                        System.out.println("");
                        userhand = 0;
                        dealhand = 0;
                        newgame = 1;

                    } else {
                        System.out.println("It's a tie! No one wins!");
                        tiegames++;
                        newgame = 1;

                    }
                } else if (userinput == 3) {
                    System.out.println("Number of Player wins: " + userwin + "");
                    System.out.println("Number of Dealer wins: " + dealwin + "");
                    System.out.println("Number of tie games: " + tiegames + "");
                    System.out.println("Total # of games played is: " + game + "");


                    percentage = (userwin / game) * 100;

                    System.out.println("Percentage of Player wins: " + percentage + "%");
                } else
                    System.out.println("");


            }






        }



    }


}
