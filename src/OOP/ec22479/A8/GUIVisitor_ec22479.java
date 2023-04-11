package OOP.ec22479.A8;

import java.awt.event.ActionEvent;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

class GUIVisitor_ec22479 implements Visitor {
         
    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items;
    private int next;
    
    public GUIVisitor_ec22479(PrintStream ps, InputStream is) {
        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;
    }
    
    
    private static final char[] yOrN = { 'y', 'n'};

    public void tell(String m) throws InterruptedException {
        A8.a8.gameOutput.setText(m + "\n");
        Thread.sleep(2000);
    }

    public char getChoice(String d, char[] a) {
        for (int i = 0; i<a.length; i++) {
            if (a[i] == A8.a8.buttonA.getText().charAt(0)) {
                A8.a8.buttonA.setEnabled(true);
            }
            else if (a[i] == A8.a8.buttonB.getText().charAt(0)) {
                A8.a8.buttonB.setEnabled(true);
            }
            else if (a[i] == A8.a8.buttonC.getText().charAt(0)) {
                A8.a8.buttonC.setEnabled(true);
            }
            else if (a[i] == A8.a8.buttonD.getText().charAt(0)) {
                A8.a8.buttonD.setEnabled(true);
            }
            else System.out.println("This shouldn't be happening :(");

        }
        A8.a8.choiceOutput.setText(d);
        while (!A8.a8.buttonClicked) {A8.a8.repaint();}
        A8.a8.buttonClicked = false;
        A8.a8.buttonA.setEnabled(false);
        A8.a8.buttonB.setEnabled(false);
        A8.a8.buttonC.setEnabled(false);
        A8.a8.buttonD.setEnabled(false);
        return A8.a8.userChoice;
    }

    
    public boolean giveItem(Item x) throws InterruptedException {
        A8.a8.buttonA.setText("y");
        A8.a8.buttonB.setText("n");
        A8.a8.takeItem = true;
        A8.a8.choiceOutput.setText("You are being offered: "+x.name);
        Thread.sleep(2000);
        if (next >= items.length) {
            A8.a8.choiceOutput.setText("But you have no space and must decline.");
            return false;
        }
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            items[next] = x;
            next++;
            return true;
        } else return false;
    }

    public void getItems() {
        if (items[0] == null) {
            A8.a8.gameOutput.append("\nYou don't have anything in your inventory.");
        }
        else {
            A8.a8.gameOutput.append("\nYou have: ");
            for (int i = 0; i < next; i++) A8.a8.gameOutput.append(items[i].name + ", ");
        }
    }

    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++) 
            if (x == items[i]) 
                return true;
        return false;
    }
        
    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++) 
            if (x.equals(items[i])) 
                return true;
        return false;
    }
    
    public void giveGold(int n) {
        A8.a8.choiceOutput.setText("You are given "+n+" gold pieces.");
        purse += n;
        A8.a8.goldAmount.setText("Gold: " + purse);
    }
        
    public int takeGold(int n) {
        
        if (n<0) {
            A8.a8.choiceOutput.setText("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            A8.a8.choiceOutput.setText("but you didn't fall for it and returned the 'loan'.");
            return 0;
        }
        
        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        A8.a8.choiceOutput.setText(t+" pieces of gold are taken from you.");
        purse -= t;
        A8.a8.choiceOutput.append("\nYou now have "+purse+" pieces of gold.");
        A8.a8.goldAmount.setText("Gold: " + purse);
        return t;
    }
}
