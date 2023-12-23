package JavaFinalCodingPorject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards = new ArrayList<Card>();

	Deck() {
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

		for (String suit : suits) {
			int count = 2;
			for (String number : numbers) {
				Card card = new Card(number, suit, count);
				cards.add(card);
				count++;
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		Card card = cards.remove(0);
		return card;
	}
	
}
