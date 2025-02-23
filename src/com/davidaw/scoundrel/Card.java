package com.davidaw.scoundrel;

public final class Card implements Comparable<Card>{

	private final CardType type;
	private final int value;
	
	public Card(CardType type, int value) {
		this.type = type;
		this.value = value;
	}
	
	public CardType getType() {
		return type;
	}
	
	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Card other) {
		return this.value - other.value;
	}
	
}
