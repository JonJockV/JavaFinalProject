package JavaFinalCodingPorject;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<>();
	private int score;
	private String name;
	
	Player(String name){
		this.setName(name);
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void describe() {
		System.out.println("Player: " + name);
		System.out.println("Player Hand:");
		for (Card card : hand) {
			card.describe();
		}
	}
	
	public Card flip() {
		Card topCard = hand.remove(0);
		return topCard;
	}
	
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	
	public void incrementScore() {
		score++;
	}
	
}
