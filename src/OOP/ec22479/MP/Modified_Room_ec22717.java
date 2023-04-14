package OOP.ec22479.MP;

class Modified_Room_ec22717 extends Room {
    public Direction visit(Visitor visitor, Direction directionFrom) {
        boolean hasInspectedShelf = false;
        boolean hasOpenedBox = false;
        boolean lightOn = true;
        
        // Tells you where you came from.
        if(directionFrom == Direction.FROM_NORTH) {
            visitor.tell("You arrive from the northern entrance.");
        }else if(directionFrom == Direction.FROM_EAST) {
            visitor.tell("You arrive from the eastern entrance.");
        }else if(directionFrom == Direction.FROM_SOUTH) {
            visitor.tell("You arrive from the southern entrance.");
        }else if(directionFrom == Direction.FROM_WEST) {
            visitor.tell("You arrive from the western entrance.");
        }
        
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor);
        ChooseAction(hasInspectedShelf, hasOpenedBox, lightOn, visitor);
        visitor.tell("You feel like you've been here too long. It's time to explore other rooms.");
        return Leave(visitor, lightOn);
    }
    
    void ChooseAction(boolean hasInspectedShelf, boolean hasOpenedBox, boolean lightOn, Visitor visitor) {
        Item key = new Item("Key");
        
        // Shows current condition of room.
        if(lightOn) {
            visitor.tell("You are at a well-lit, wooden room. A large wooden shelf sits in the corner of the room. A door can be seen on each wall.");
        }else {
            visitor.tell("You are in a dark room. Light bleeds through the underside of the doors on each wall.");
        }

        // Asks what you would like to do.
        visitor.tell("What would you like to do?");

        char[] twoOptions = {'a', 'b'};
        char[] threeOptions = {'a', 'b', 'c'};
        char[] fourOptions = {'a', 'b', 'c', 'd'};
        
        // Gives options you can do.
        if(!hasInspectedShelf && lightOn) {
            char choice = visitor.getChoice("a)Inspect shelf b)Turn off lights c)Leave room", threeOptions);
            if(choice == 'a') {
                if(!hasOpenedBox) {
                    visitor.tell("You approach the shelf. A small, white box with golden engravings sits to one side.");
                }else {
                    visitor.tell("You approach the shelf. An opened, small, white box with golden engravings sits to one side.");
                }
            }else if(choice == 'b'){
                visitor.tell("You flip a switch on the wall. The room is now dark.");
                lightOn = false;
            }else if(choice == 'c'){
                Leave(visitor, true);
                return;
            }
        }else if(hasInspectedShelf && lightOn) {
            char choice = visitor.getChoice("a)Inspect shelf b)Open box c)Turn off lights d)Leave room", fourOptions);
            if(choice == 'a') {
                if(!hasOpenedBox) {
                    visitor.tell("You approach the shelf. A small, white box with golden engravings sits to one side.");
                }else {
                    visitor.tell("You approach the shelf. An opened, small, white box with golden engravings sits to one side.");
                }
            }else if(choice == 'b') {
                if(visitor.hasEqualItem(key)) {
                    visitor.tell("You try to use your key to open the box... It works!");
                    visitor.tell("You take 5 gold.");
                    visitor.giveGold(5);
                }else if(!visitor.hasEqualItem(key)) {
                    visitor.tell("You try to open the box... It needs a key.");
                }
            }else if(choice == 'c') {
                visitor.tell("You flip a switch on the wall. The room is now dark.");
                lightOn = false;
            }else if(choice == 'd') {
                Leave(visitor, true);
                return;
            }
        }else {
            char choice = visitor.getChoice("a)Turn on lights b)Leave room", twoOptions);
            if(choice == 'a') {
                visitor.tell("You carefully make your way to the switch on the wall. Flipping the switch, the lights turn on.");
                lightOn = true;
            }else if(choice == 'b'){
                Leave(visitor, false);
                return;
            }
        }
        Leave(visitor, lightOn);
    }
    
    Direction Leave(Visitor visitor, boolean lightOn) {
        char[] fourOptions = {'a', 'b', 'c', 'd'};
        
        visitor.tell("In which direction would you like to leave?");
        char choice = visitor.getChoice("a)North b)East c)South d)West", fourOptions);
        if(!lightOn) {
            visitor.tell("You stumble in the dark toward the door.");
        }
        if(choice == 'a') {
            visitor.tell("You take the northern exit.");
            return Direction.TO_NORTH;
        }else if(choice == 'b') {
            visitor.tell("You take the eastern exit.");
            return Direction.TO_EAST;
        }else if(choice == 'c') {
            visitor.tell("You take the southern exit.");
            return Direction.TO_SOUTH;
        }else if(choice == 'd') {
            visitor.tell("You take the western exit.");
            return Direction.TO_WEST;
        }
        return null;
    }
}
