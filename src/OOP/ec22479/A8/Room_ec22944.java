package OOP.ec22479.A8;

class Room_ec22944 extends Room
{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) throws InterruptedException
    {
        A8.a8.imagePanel.setIcon(A8.a8.tanvirsRoom);
        String context = "a) Look under my pillow, b) Play games on my computer, c) Ransack my room";
        char[] choices = {'a', 'b', 'c'};
        Item WisdomTooth = new Item("T Man's Wisdom Tooth");

        visitor.tell("Welcome to T Man's lair!. Have 3 gold on me!");
        visitor.giveGold(3);
        visitor.tell("What would you like to do?");
        char visitorFirstChoice = visitor.getChoice(context, choices);

        while(!(visitorFirstChoice == 'a' || visitorFirstChoice == 'b' || visitorFirstChoice == 'c'))
        {
            visitorFirstChoice = visitor.getChoice(context, choices);
        }

        if(visitorFirstChoice == 'a')
        {
            visitor.tell("You found my wisdom tooth. Hope you find it useful later!");
            visitor.giveItem(WisdomTooth);
        }

        else if(visitorFirstChoice == 'b')
        {
            visitor.tell("You wasted all your time playing The Sims 4. I hope you're proud of yourself.");
        }

        else if(visitorFirstChoice == 'c')
        {
            visitor.tell("T Man walked in on you trying to steal his beloved possessions. You panicked and gave him your gold. Serves you right!");
            visitor.takeGold(10);
        }

        String exitDirections = "a) North, b) East, c) South, d) West";
        char[] exitChoices = {'a', 'b', 'c', 'd'};
        
        visitor.tell("Which way would you like to exit?");
        char visitorExitChoice = visitor.getChoice(exitDirections, exitChoices);
        if(visitorExitChoice == 'a')
        {
            return Direction.TO_NORTH;
        }

        else if(visitorExitChoice == 'b')
        {
            return Direction.TO_EAST;
        }

        else if(visitorExitChoice == 'c')
        {
            return Direction.TO_SOUTH;
        }

        else
        {
            return Direction.TO_WEST;
        }
    }
} 