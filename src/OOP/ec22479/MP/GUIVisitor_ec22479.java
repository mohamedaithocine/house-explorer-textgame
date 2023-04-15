package OOP.ec22479.MP;
import java.util.ArrayList;

class GUIVisitor_ec22479 implements Visitor {

    // Nothing really special here. I've added a collection and a pause method to delay the outputting of text so that the user has enough time to read
    private int purse;
    private final ArrayList<Item> items = new ArrayList<>();

    
    public GUIVisitor_ec22479() {
        purse = 0;
    }
    
    
    private static final char[] yOrN = { 'y', 'n'};

    public void tell(String m) {
            MP_ec22479.MPec22479.gameOutput.setText(m + "\n");
            pause(MP_ec22479.gamePace);
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms); }
        catch (Exception e) {Thread.currentThread().interrupt();}
    }

    public char getChoice(String descriptionOfChoices, char[] a) {
            if (a.length >= 1) {
                MP_ec22479.MPec22479.buttonA.setEnabled(true);
                MP_ec22479.MPec22479.buttonA.setText(String.valueOf(a[0]));
            } if (a.length >= 2) {
                MP_ec22479.MPec22479.buttonB.setEnabled(true);
                MP_ec22479.MPec22479.buttonB.setText(String.valueOf(a[1]));
            } if (a.length >= 3) {
                MP_ec22479.MPec22479.buttonC.setEnabled(true);
                MP_ec22479.MPec22479.buttonC.setText(String.valueOf(a[2]));
            } if (a.length >= 4) {
                MP_ec22479.MPec22479.buttonD.setEnabled(true);
                MP_ec22479.MPec22479.buttonD.setText(String.valueOf(a[3]));
            } if (a.length > 4) System.out.println("THERES TOO MANY BUTTONS");


        MP_ec22479.MPec22479.choiceOutput.setText(descriptionOfChoices);
        while (!MP_ec22479.MPec22479.buttonClicked) {MP_ec22479.MPec22479.repaint();}
        MP_ec22479.MPec22479.buttonClicked = false;
        MP_ec22479.MPec22479.buttonA.setEnabled(false);
        MP_ec22479.MPec22479.buttonB.setEnabled(false);
        MP_ec22479.MPec22479.buttonC.setEnabled(false);
        MP_ec22479.MPec22479.buttonD.setEnabled(false);
        return MP_ec22479.MPec22479.userChoice;
    }

    
    public boolean giveItem(Item x) {
        boolean trueOrFalse = false;
        MP_ec22479.MPec22479.takeItem = true;
        MP_ec22479.MPec22479.choiceOutput.setText("You are being offered: " + x.name);
        pause(MP_ec22479.gamePace);
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            items.add(x);
            trueOrFalse = true;
        }
        return trueOrFalse;

    }

    public void getItems() {
        if (items.isEmpty()) {
            MP_ec22479.MPec22479.gameOutput.append("\nYou don't have anything in your inventory.");
        }
        else {
            MP_ec22479.MPec22479.gameOutput.append("\nYou have: ");
            for (Item item : items) MP_ec22479.MPec22479.gameOutput.append(item.name + ", ");
        }
    }

    public boolean hasIdenticalItem(Item x) {
        for (Item item : items)
            if (x.name.equals(item.name))
                return true;
        return false;
    }
        
    public boolean hasEqualItem(Item x) {
        for (Item item : items)
            if (x.equals(item))
                return true;
        return false;
    }
    
    public void giveGold(int n) {
        MP_ec22479.MPec22479.choiceOutput.setText("You are given "+n+" gold pieces.");
        purse += n;
        MP_ec22479.MPec22479.goldAmount.setText("Gold: " + purse);
    }
        
    public int takeGold(int n) {
        
        if (n<0) {
            MP_ec22479.MPec22479.choiceOutput.setText("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            MP_ec22479.MPec22479.choiceOutput.setText("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }
        
        int t = Math.min(n, purse);

        MP_ec22479.MPec22479.choiceOutput.setText(t+" pieces of gold are taken from you.");
        purse -= t;
        MP_ec22479.MPec22479.choiceOutput.append("\nYou now have "+purse+" pieces of gold.");
        MP_ec22479.MPec22479.goldAmount.setText("Gold: " + purse);
        return t;
    }
}
