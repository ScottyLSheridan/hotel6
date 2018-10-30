import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //TODO delete function (Done, sorta)
    //TODO deal with double booking
    //TODO suites or normal rooms?
    static Scanner scanner = new Scanner(System.in);
    static List<Room> rooms = new ArrayList<Room>();
    public static void main(String[] args) {
        System.out.println("Welcome to Archi's Hotel");
        sleep(500);
        String input = "";
        while (!input.equals("end")) {
            System.out.println("To make a reservation use to 'new' command");
            System.out.println("To cancel a reservation use to 'delete' command");
            System.out.println("To logout use the 'end' command");
            System.out.println("For a list of all current reservations, use the 'list' command");
            sleep(1000);
            input = input("Enter your command: ");
            if (input.equals("new")) {
                String name = input("Enter the name of the reservation: ");
                int roomNumber = Integer.parseInt(input("Enter the room number for the reservation: "));
                Room room = new Room(name, roomNumber);
                rooms.add(room);
                System.out.println("Reservation with name: " + room.getName() + " and room number: " + room.getRoomNumber() + " has been made.");
            }

            if (input.equals("list")) {
                for(int i = 0; i < rooms.size(); i++) {
                    System.out.println(rooms.get(i).getName() + ", Room " +rooms.get(i).getRoomNumber());
                }
            }
            if (input.equals("delete")) {
                rooms.remove(rooms.size()-1);
            }
        }
    }
    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
