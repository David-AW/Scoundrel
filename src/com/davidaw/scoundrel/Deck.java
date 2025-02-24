package com.davidaw.scoundrel;

import java.util.Random;
import java.util.Stack;

public class Deck extends ArrayQueue<Card>{
	
	private Random random;
	
	public Deck() {
		super(44);
		
		random = new Random();
		
		// 26 monster cards, 9 weapon cards, 9 potion cards
		Card[] pool = new Card[44];

		for (int i = 0; i < 13; i++) {
			pool[i*2] = new Card(CardType.MONSTER, i+2);
			pool[i*2+1] = new Card(CardType.MONSTER, i+2);
		}

		for (int i = 0; i < 9; i++) {
			pool[i+26] = new Card(CardType.WEAPON, i+2);
			pool[i+35] = new Card(CardType.POTION, i+2);
		}
		
		fill(pool);
	}
	
	public void shuffle() {
		floorShuffle();
		splitShuffle();
		floorShuffle();
	}
	
	private void floorShuffle() {
		for (int i = 0; i < size(); i++) {
			swap(random.nextInt(0, maxSize()), i);
		}
	}
	
	private void splitShuffle() {
		Stack<Card> a = new Stack<Card>();
		Stack<Card> b = new Stack<Card>();
		Card[] cards = toArray();
		for (int i = 0; i < cards.length; i++) {
			if (i < cards.length/2)
				a.push(cards[i]);
			else
				b.push(cards[i]);
		}
		clear();
		while(!b.isEmpty()) {
			enqueue(b.pop());
			if (!a.isEmpty())
				enqueue(a.pop());
		}
	}
	
}
