package OOP.ec22479.MP;

import javax.swing.*;
import java.util.Objects;

public class MP_ec22479 extends JFrame {

    //Hello! This mini project has been modified a little bit to make room changes easier, however, for the best user experience, keep using this house that I made


    //*************************************************** IMAGES ***************************************************//

    // To change the images, paste your images inside the images folder and then put their name (with extension) below
    // Recommended size for image is 203 x 203

    String homeImageLocation = "home.jpg";
    String room1ImageLocation = "mosRoom.jpg";
    String room2ImageLocation = "tanvirsRoom.jpg";
    String room3ImageLocation = "zubairsRoom.jpg";
    String room4ImageLocation = "fahimsRoom.jpg";
    String gameOverImageLocation = "houseTourOver.jpg";


    //*************************************************** ROOMS ***************************************************//

    /* The current layout of the house is as follows:
    |------------------------|
    |                        |
    |        Room 4          |
    |                        |
    |------------------------|------------------------|
    |                        |                        |
    |        Room 2          |        Room 3          |
    |                        |                        |
    |------------------------|------------------------|
    |                        |
    |        Room 1          |
    |                        |
    |------------------------|
                ↑
      USER ENTERS FROM HERE                                                                                        */

    // Change the rooms of the house you'd like to visit
    protected static final Room room1 = new Room_ec22479();
    protected static final Room room2 = new Room_ec22944();
    protected static final Room room3 = new Room_ec22480();
    protected static final Room room4 = new Room_ec22717();

    //********************************************** MISCELLANEOUS ************************************************//
    protected static final int gamePace = 100; //How long (in ms) should the program wait after giving information to the user

    // ADVANCED
    // If your new rooms don't work nicely with my house, you can use your own house, BUUUTT, you'll have to add the changeIcon method to your rooms.
    // It will look something like: MP_ec22479.changeIcon(MP_ec22479.MPec22479.Room1Icon);
    private final House house = new House_ec22479();

    // If you would like to change the direction you enter the house from, change this :D
    static Direction entryDirection = Direction.UNDEFINED;




    // I would advise not to touch the rest of the code below, unless you know what you're doing!

    //*************************************************************************************************************//
    ImageIcon homeIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + homeImageLocation)));
    ImageIcon Room1Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + room1ImageLocation)));
    ImageIcon Room2Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + room2ImageLocation)));
    ImageIcon Room3Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + room3ImageLocation)));
    ImageIcon Room4Icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + room4ImageLocation)));
    ImageIcon gameOverIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images\\" + gameOverImageLocation)));

    protected static void changeIcon(ImageIcon icon) {
            MPec22479.imagePanel.setIcon(icon);
        }

    protected JButton buttonA;
    protected JButton buttonB;
    protected JButton buttonC;
    protected JButton buttonD;
    protected JLabel goldAmount;
    private JPanel panelMain;

    protected JButton Inventory;
    protected JTextArea gameOutput;

    protected JLabel imagePanel;
    protected JTextArea choiceOutput;

    protected char userChoice;
    protected boolean buttonClicked = false;
    protected boolean takeItem = false;

    public MP_ec22479() {
        setContentPane(panelMain);
        setTitle("Mo's Maison");
        setSize(659, 410);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        buttonA.addActionListener(e -> {
                userChoice = buttonA.getText().charAt(0);
                buttonClicked = true; });
        buttonB.addActionListener(e -> {
                userChoice = buttonB.getText().charAt(0);
                buttonClicked = true; });
        buttonC.addActionListener(e -> {userChoice = buttonC.getText().charAt(0); buttonClicked = true; });
        buttonD.addActionListener(e -> {userChoice = buttonD.getText().charAt(0); buttonClicked = true; });
        Inventory.addActionListener(e -> v.getItems());

    }
    public static MP_ec22479 MPec22479 = new MP_ec22479();
    private final Visitor v = new GUIVisitor_ec22479();


    public static void main(String[] args) {
        changeIcon(new ImageIcon(Objects.requireNonNull(MP_ec22479.class.getResource("images\\unknownImage.jpg"))));
        MPec22479.house.visit(MPec22479.v, entryDirection);
        changeIcon(MPec22479.gameOverIcon);
        MPec22479.v.tell("HOUSE TOUR OVER\n" + MPec22479.goldAmount.getText());
        MPec22479.v.getItems();
    }
}