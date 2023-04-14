package OOP.ec22479.MP;
import javax.swing.*;
import java.util.Objects;
import static OOP.ec22479.MP.MP_ec22479.*;

public class House_ec22479 extends House {

    static ImageIcon brokenWindow = new ImageIcon(Objects.requireNonNull(House_ec22479.class.getResource("images\\brokenWindow.jpg")));
    static ImageIcon backDoorExit = new ImageIcon(Objects.requireNonNull(House_ec22479.class.getResource("images\\backDoorExit.jpg")));
    private final Room room1 = MP_ec22479.room1;
    private final Room room2 = MP_ec22479.room2;
    private final Room room3 = MP_ec22479.room3;
    private final Room room4 = MP_ec22479.room4;
    String currentRoom;
    static boolean hasTmansWisdomTooth = false;

    public static void exitThroughWindow(Visitor v) {
        changeIcon(brokenWindow);
        v.tell("THIS GLASS ISN'T GOING TO FIX ITSELF! GIVE ME 10 GOLD!!");
        v.takeGold(10);
    }

    public static Direction enterRoom(Room room, Visitor v, Direction d, ImageIcon icon) {
        changeIcon(icon);
        return room.visit(v,d);
    }

    public Direction visit(Visitor v, Direction d){
        changeIcon(MPec22479.homeIcon);
        v.tell("Welcome to the humble abode.");
        v.tell("This is quite a small house, but please make yourself comfortable");
        v.tell("Also, please leave through a door.. I can't keep on fixing windows");

        // FIRST ROOM
        d = enterRoom(room1, v, d, MPec22479.Room1Icon);
        v.tell("That was quite a weird room.. wasn't it?");
        currentRoom = "Room1";


        while (true) {

            // MOHAMED
            if (currentRoom.equals("Room1")) {
                if (d == Direction.TO_NORTH) {
                currentRoom = "Room2";
                d = enterRoom(room2, v, d, MPec22479.Room2Icon);
                }
                else if (d == Direction.TO_EAST) {
                    exitThroughWindow(v);
                    return d;
                }
                else if (d == Direction.TO_SOUTH) {
                    changeIcon(MPec22479.homeIcon);
                    v.tell("You've had enough of this house and just left back where you came from :)");
                }
                else if (d == Direction.TO_WEST) {
                    exitThroughWindow(v);
                    return d;
                }
            }

            if (currentRoom.equals("Room2")) {
                if (d == Direction.TO_NORTH) {
                    if (!hasTmansWisdomTooth) { //This works only with the default room2, this can be removed if room2 is changed.
                        currentRoom = "Room3";
                        d = enterRoom(room3, v, d, MPec22479.Room3Icon);
                    } else {
                        MPec22479.imagePanel.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("tanvirsRoom2.jpg"))));
                        String exitDirections = "a) North, b) East, c) South, d) West";
                        char[] exitChoices = { 'a', 'b', 'c', 'd' };
                        v.tell("This room seems to be just rubble now.. please try another exit");
                        char visitorExitChoice = v.getChoice(exitDirections, exitChoices);

                        if (visitorExitChoice == 'b') {
                            d = Direction.TO_EAST;
                        }

                        else if (visitorExitChoice == 'c') {
                            d = Direction.TO_SOUTH;
                        }

                        else {
                            d = Direction.TO_WEST;
                        }

                    }

                }
                else if (d == Direction.TO_EAST) {
                    currentRoom = "Room4";
                    d = enterRoom(room4, v, d, MPec22479.Room4Icon);}
                else if (d == Direction.TO_SOUTH) {
                    currentRoom = "Room1";
                    MPec22479.imagePanel.setIcon(MPec22479.Room1Icon);
                    d = enterRoom(room1, v, d, MPec22479.Room1Icon);
                } else if (d == Direction.TO_WEST) {
                    exitThroughWindow(v);
                    return d;
                }
            }

            if (currentRoom.equals("Room3")) {
                if (d == Direction.TO_NORTH) {
                    exitThroughWindow(v);
                    return d;
                }
                else if (d == Direction.TO_EAST) {
                    exitThroughWindow(v);
                    return d;
                }
                else if (d == Direction.TO_SOUTH) {
                    currentRoom = "Room2";
                    d = enterRoom(room2, v, d, MPec22479.Room2Icon);
                }
                else if (d == Direction.TO_WEST) {
                    exitThroughWindow(v);
                    return d;
                }

            }

            if (currentRoom.equals("Room4")) {
                if (d == Direction.TO_NORTH) {
                    exitThroughWindow(v);
                    return d;
                }
                else if (d == Direction.TO_EAST) {
                    changeIcon(backDoorExit);
                    v.tell("You left through the back door.");
                    v.tell("I hope you enjoyed your stay! :)");
                    v.giveGold(10);
                    v.tell("Have a safe journey!");
                    return d;
                }
                else if (d == Direction.TO_SOUTH) {
                    exitThroughWindow(v);
                    return d;
                }
                else if (d == Direction.TO_WEST) {
                    currentRoom = "Room2";
                    enterRoom(room2, v, d, MPec22479.Room2Icon);
                }
            }
        }
    }
}
