package OOP.ec22479.MP;
// Mohamed Ait-Hocine
// Assignment 4
// 23/02/2023
// V1.1
// Changed absolutely nothing.

class Room_ec22479 extends Room {
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        String direction;
        if (directionVisitorArrivesFrom == Direction.TO_NORTH) {
            direction = "south.";
        }
        else if (directionVisitorArrivesFrom == Direction.TO_EAST) {
            direction = "west.";
        }
        else if (directionVisitorArrivesFrom == Direction.TO_SOUTH) {
            direction = "north.";
        }
        else if (directionVisitorArrivesFrom == Direction.TO_WEST) {
            direction = "east.";
        }
        else {direction = ".. where did you come from?";}
        visitor.tell("You entered a large empty room.. \nEvery wall is a mirror..? \nYou just came from the " + direction );
        visitor.tell("As you slowly make sense of where you are, you realise there are only two options for you. \nWhat will you choose?");
        char [] possibleChoices = {'a', 'b'};
        char selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);

        while (!(selectedChoice == 'a' || selectedChoice == 'b')) {
            visitor.tell("Invalid option. Try again");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);
        }
        
        if (selectedChoice == 'a') {
            visitor.tell("You stare at your reflection. Your face is clearer than ever.");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);}
            
        while (!(selectedChoice == 'a' || selectedChoice == 'b')) {
            visitor.tell("Invalid option. Try again");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);
        }

        if (selectedChoice == 'a') {
            visitor.tell("You look at your eyes, filled with this desire to ponder.. \nThey sparkle with determination.. \n'I will make it out alive!' You exclaim.");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);}

        while (!(selectedChoice == 'a' || selectedChoice == 'b')) {
            visitor.tell("Invalid option. Try again");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);
        }
                
        if (selectedChoice == 'a') {
            visitor.tell("You continue to look at your eyes, slowly sinking into them.. \nYou can't stop looking.. \nYour fixed gaze is interrupted. \nThis reflection of yours.. is moving on its own.");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);}

        while (!(selectedChoice == 'a' || selectedChoice == 'b')) {
            visitor.tell("Invalid option. Try again");
            selectedChoice = visitor.getChoice("a) Stare at your reflection. \nb) Charge straight into your reflection.", possibleChoices);
        }
        
        if (selectedChoice == 'a') {
            visitor.tell("It seeps out of the mirror. Holding a shiny object in its hand.");
            visitor.giveGold(10);
            visitor.tell("It has given you 10 gold. You've given yourself 10 gold?");
            possibleChoices[0] = 'b';
            selectedChoice = visitor.getChoice("b) Follow your reflection", possibleChoices);
            while (!(selectedChoice == 'b')) {
                visitor.tell("Invalid option. Try again");
                selectedChoice = visitor.getChoice("b) Follow your reflection", possibleChoices);
            }
        }
                
            
        

        final Item BrokenGlass = new Item("Broken Glass");

        visitor.tell("The mirrors shatter, and a door is revealed. \nYou decide to pick up some broken glass.");
        visitor.giveItem(BrokenGlass);
        return Direction.TO_NORTH;
        
    }
}
