package JavaFinalCodingPorject;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to automated War!");
		System.out.println("Please enter the name of Player One:");
		String playerOneName = sc.nextLine();
		System.out.println("Please enter the name of Player Two:");
		String playerTwoName = sc.nextLine();
		System.out.println("Game On!");
		sc.close();
		
		Deck deck = new Deck();
		deck.shuffle();
		Player playerOne = new Player(playerOneName);
		Player playerTwo = new Player(playerTwoName);
		
		for (int i = 0; i < 52; i++) {
			if (i % 2 == 0) {
				playerOne.draw(deck);
			} else {
				playerTwo.draw(deck);
			}
		}
		
		for (int i = 0; i < 26; i++) {
			//Turn number
			System.out.println("Round " + (i + 1));
			
			//Each flips card
			Card p1FlippedCard = playerOne.flip();
			Card p2FlippedCard = playerTwo.flip();
			
			//System prints the cards
			System.out.println(playerOneName + "'s card: ");
			p1FlippedCard.describe();
			System.out.println(playerTwoName + "'s card: ");
			p2FlippedCard.describe();
			
			//Statement to find the winner of the round, or tie, then add to the score of the winner.
			if (p1FlippedCard.getValue() > p2FlippedCard.getValue()) {
				System.out.println(playerOneName + " wins this round.");
				playerOne.incrementScore();
			} else if (p1FlippedCard.getValue() < p2FlippedCard.getValue()) {
				System.out.println(playerTwoName + " wins this round.");
				playerTwo.incrementScore();
			} else {
				System.out.println("It was a tie! No points awarded.");
			}
			System.out.println("Scores after this round:");
			System.out.println(playerOneName + "'s score: " + playerOne.getScore());
			System.out.println(playerTwoName + "'s score: " + playerTwo.getScore());
			System.out.println("----------------------------------");
		}
		
		//Compare the final scores
		System.out.println("Here are the final scores:");
		System.out.println(playerOneName + ": " +playerOne.getScore());
		System.out.println(playerTwoName + ": " + playerTwo.getScore());
		if (playerOne.getScore() > playerTwo.getScore()) {
			System.out.println(playerOneName + " Wins!");
		} else if (playerOne.getScore() < playerTwo.getScore()) {
			System.out.println(playerTwoName + " Wins!");
		} else {
			System.out.println("The scores were tied, no winner this time.");
		}
	}
}
