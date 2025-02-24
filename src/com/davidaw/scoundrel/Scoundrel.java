package com.davidaw.scoundrel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quick and easy programming project out of boredom.
 * Based on the playing card rouge-like "Scoundrel"
 * @author david-aw
 */

public class Scoundrel {

	private static Deck deck;
	private static ArrayList<Card> dungeon;
	private static Card weapon, last_kill;
	private static int health = 20;
	private static boolean can_run = true;
	
	public static void main(String[] args) {
		deck = new Deck();
		deck.shuffle();
		dungeon = new ArrayList<Card>(4);
		
		Scanner input = new Scanner(System.in);
		
		drawCards();
		renderState();
		
	}
	
	private static void runFromDungeon() {
		if (!can_run)
			return;
		for (Card card : dungeon)
			deck.enqueue(card);
		dungeon.clear();
		drawCards();
		can_run = false;
	}
	
	private static void drawCards() {
		for (int i = dungeon.size(); i < 4; i++)
			dungeon.add(deck.dequeue());
	}
	
	private static void renderState() {
		System.out.println("Deck: " + deck.size() + "/" + deck.maxSize() + "\tHealth: " + health + "\tCan you run: " + (can_run ? "Yes":"No"));
		System.out.println(dungeon);
		System.out.println("Equipped:");
		System.out.println("\t" + (weapon == null ? "NONE" : weapon) + (last_kill == null ? "" : " --> " + last_kill));
	}
}
