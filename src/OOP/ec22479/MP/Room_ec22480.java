package OOP.ec22479.MP;

import java.util.Random;

public class Room_ec22480 extends Room {

	Item[] items = new Item[] {new Item("Poison Vile"),
			       new Item("Frog Tongue"),
				   new Item("Awakening Bell")};

	int[] prices = new int[] {4, 8, 10};
	boolean hasTmansWisdomTooth = false;

	public Direction visit(Visitor visitor, Direction from)
	{
		if (!hasTmansWisdomTooth)
		{
			visitor.tell("Welcome to Hoppers Market\nZUBAIR: What would you like to purchase?");
			char choice = visitor.getChoice(
							"a) " + items[0].name + ": " + prices[0] + " Gold Pieces" +
							"\nb) " + items[1].name + ": " + prices[1] + " Gold Pieces" +
							"\nc) " + items[2].name + ": " + prices[2] + " Gold Pieces" +
							"\nd) EXIT" , 
							new char[] {'a', 'b', 'c', 'd'});

			Item itemChosen = new Item("EMPTY");
			int price = 0;

			if (choice == 'a') 
			{
				itemChosen = items[0];
				price = prices[0];
			}
			else if (choice == 'b') 
			{
				itemChosen = items[1];
				price = prices[1];
			}
			else if (choice == 'c') 
			{
				itemChosen = items[2];
				price = prices[2];
			}
			else if (choice == 'd') 
			{
				return Direction.opposite(from);
			}

			if (visitor.hasEqualItem(itemChosen)) 
			{
				visitor.tell("ZUBAIR: I am sensing that you may have already purchased item: " + itemChosen.name + 
						     ". As a sign of gratitude, you may take the item at a discounted price of " + (price / 2) + " Gold Pieces.");
				price /= 2;
			}

			if (!itemChosen.name.equals("EMPTY")) 
			{
				visitor.takeGold(price);
				visitor.giveItem(itemChosen);
			}

			if (visitor.hasEqualItem(new Item("T Man's Wisdom Tooth"))) 
			{
				visitor.tell("""
						Oh what's this.
						Your pocket seems to be shining.
						You take out T Man's Wisdom Tooth as a blinding light fills the room.
						ZUBAIR: THAT IS...!
						Zubair has a shocked look on his face.
						ZUBAIR: LEAVE AT ONCE AND NEVER RETURN!

						As you leave the shop begins crumbling around you. ZUBAIR runs out of the shop in lightning speed and lightly brushes your shoulder.
						He seems to be holding a few coins.
						It seems he robbed you of 5 coins amidst the chaos.""");
				GUIVisitor_ec22479.pause(7000);
				visitor.takeGold(5);
				hasTmansWisdomTooth = true;
			}
		}
		else 
		{
			int itemNum = new Random().nextInt(items.length); 
			visitor.tell("A heap of rubble appears before you and a sign labelled \"Hoppers Market\" lies on top."
					   + "\nSomething appears to be glistening in the dump."
					   + "\nYou take a closer look and find a " + items[itemNum].name + " and 2 coins."
					   + "\n\nAs you turn to leave, a torn piece of paper is on the floor. You pick it up and read it.:"
					   + "\n\nChaos and destruction will follow he who holds T Man's Wisdom Tooth."
					   + "\nCould this be related to the destruction here."
					   + "\nYou exit the room.");
			House_ec22479.hasTmansWisdomTooth = true;
			GUIVisitor_ec22479.pause(7000);
		}
		return Direction.opposite(from);
	}
}


