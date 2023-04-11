package OOP.ec22479.A8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A8 extends JFrame {
    JButton buttonA;
    JButton buttonB;
    JButton buttonC;
    JButton buttonD;
    protected JLabel goldAmount;
    private JPanel panelMain;

    protected JButton Inventory;
    protected JTextArea gameOutput;

    protected JLabel imagePanel;
    protected JTextArea choiceOutput;

    protected ImageIcon home = new ImageIcon(getClass().getResource("home.jpg"));
    protected ImageIcon mosRoom = new ImageIcon(getClass().getResource("mosRoom.jpg"));
    protected ImageIcon tanvirsRoom = new ImageIcon(getClass().getResource("tanvirsRoom.jpg"));
    protected ImageIcon tanvirsRoom2 = new ImageIcon(getClass().getResource("tanvirsRoom2.jpg"));
    protected ImageIcon zubairsRoom = new ImageIcon(getClass().getResource("zubairsRoom.jpg"));
    protected ImageIcon fahimsRoom = new ImageIcon(getClass().getResource("fahimsRoom.jpg"));

    private final Room room1 = new Room_ec22717(); // North, East, South, West
    private final Room room2 = new Room_ec22479(); // Leavin this room leads north
    private final Room room3 = new Room_ec22944(); // North, East, South, West
    private final Room room4 = new Room_ec22480(); // Leaves opposite direction they came from
    protected String currentRoom;
    protected char userChoice;
    boolean buttonClicked = false;
    boolean takeItem = false;

    public A8() {
        setContentPane(panelMain);
        setTitle("Mo's Maison");
        setSize(659, 410);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        buttonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    if (!takeItem) {
                        userChoice = 'a';
                    } else {
                        userChoice = 'y';
                        A8.a8.buttonA.setText("a");
                        A8.a8.buttonB.setText("b");
                        takeItem = false;
                    }
                    buttonClicked = true;

            }
        });
        buttonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!takeItem)
                    userChoice = 'b';
                else {
                    userChoice = 'n';
                    A8.a8.buttonA.setText("a");
                    A8.a8.buttonB.setText("b");
                    takeItem = false;
                }
                buttonClicked = true;
            }
        });
        buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userChoice = 'c';
                buttonClicked = true;
            }
        });
        buttonD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userChoice = 'd';
                buttonClicked = true;
            }
        });

        Inventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                v.getItems();
            }
        });

    }
    public static A8 a8 = new A8();
    Visitor v = new GUIVisitor_ec22479(System.out, System.in);

    public static void main(String[] args) throws InterruptedException {
        a8.imagePanel.setIcon(a8.home);
        House_ec22479 house = new House_ec22479();

        house.visit(a8.v, Direction.UNDEFINED);
    }








}
