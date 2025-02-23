package com.davidaw.scoundrel;

public class Deck {

	private Card[] pool;
	
	public Deck() {
		// 26 monster cards, 9 weapon cards, 9 potion cards
		pool = new Card[44];

		for (int i = 0; i < 13; i++) {
			pool[i*2] = new Card(CardType.MONSTER, i+2);
			pool[i*2+1] = new Card(CardType.MONSTER, i+2);
		}

		for (int i = 0; i < 9; i++) {
			pool[i+26] = new Card(CardType.WEAPON, i+2);
			pool[i+35] = new Card(CardType.POTION, i+2);
		}
	}
	
}
