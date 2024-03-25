import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Theatre {
    //The three static Arrays to represent the seating rows
    static String[] row_one = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    static String[] row_two = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    static String[] row_three = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    private static  ArrayList<Ticket> Tickets = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("-----------------------------------------------");
        System.out.println("Welcome to the New Theatre!");
        while (true) {
            try {
                //printing the menu//
                System.out.println("-----------------------------------------------");
                System.out.println("Please select an option:");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area");
                System.out.println("3) Cancel ticket");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file");
                System.out.println("6) load a file");
                System.out.println("7) Print ticket information and total price");
                System.out.println("8) Sort tickets by price");
                System.out.println("0) Quit");
                System.out.println("------------------------------------------------");

                //Asking the user to enter an option//

                System.out.println();
                System.out.println("Enter option:");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> buy_ticket();
                    case 2 -> print_seating_area();
                    case 3 -> cancel_ticket();
                    case 4 -> show_available();
                    case 5 -> save();
                    case 6 -> load();
                    case 7 -> show_tickets_info();
                    case 8 -> sorting_tickets();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid option. Please try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid option!");
                scanner.nextLine();

            }
        }
    }
    //Allows the user to buy a ticket
    public static void buy_ticket() {
        Double price = 0.0;
        int row_number = 0;
        int seat_number = 0;

        while (true) {
            try {
//Asking the user to enter the row number
                System.out.println("Enter a row number: ");
                row_number = scanner.nextInt();
//Checking the row number valid or not
                if (row_number > 0 && row_number < 4) {//If its valid it will continue with the rest of the program
                    break;
                } else {//If it's not valid asks the user to re-enter the row number
                    System.out.println("Please enter a row number between 1-3");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid row number entered");
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                if (row_number == 1) {//If the row number is one the rest of the code works
                    while (true) {
                        try {
//Asking the user to enter a number between 1 and 12 as the row one has only 12 seats
                            System.out.println("Please enter a seat number (1-12):");
                            seat_number = scanner.nextInt();
                            if (seat_number > 12 || seat_number < 0) {//Checking whether the seat number valid or not
                                System.out.println("Invalid seat number. Enter a number between 1 to 12");
                            }
                            if (Objects.equals(row_one[seat_number - 1], "1")) {//Checking whether the entered seat is booked or not
                                System.out.println("The seat is already booked!");
                            } else if (Objects.equals(row_one[seat_number - 1], "0")) {
                                System.out.println("Seat booked!");
                                row_one[seat_number - 1] = "1";
                                break;
                            }
                        } catch (InputMismatchException e) {//Checking if the inputs are integers
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else if (row_number == 2) {//If the row number is two the rest of the code works
                    while (true) {
                        try {
//Asking the user to enter a number between 1 and 12 as the row two has only 16 seats
                            System.out.println("Please enter a seat number (1-16):");
                            seat_number = scanner.nextInt();
                            if (seat_number > 16 || seat_number < 0) {//Checking whether the seat number valid or not
                                System.out.println("Invalid seat number. Enter a number between 1 to 16");
                            }
                            if (Objects.equals(row_two[seat_number - 1], "1")) {//Checking whether the entered seat is booked or not
                                System.out.println("The seat is already booked!");

                            } else if (Objects.equals(row_two[seat_number - 1], "0")) {
                                System.out.println("Seat booked!");
                                row_two[seat_number - 1] = "1";
                                break;
                            }
                        } catch (InputMismatchException e) {//Checking if the inputs are integers
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else if (row_number == 3) {//If the row number is two the rest of the code works
                    while (true) {
                        try {
//Asking the user to enter a number between 1 and 20 as the row three has only 20 seats
                            System.out.println("Please enter a seat number (1-20):");
                            seat_number = scanner.nextInt();
                            if (seat_number > 20 || seat_number < 0) {//Checking whether the seat number valid or not
                                System.out.println("Invalid seat number. Enter a number between 1 to 20");
                            }
                            if (Objects.equals(row_three[seat_number - 1], "1")) {//Checking whether the entered seat is booked or not
                                System.out.println("The seat is already booked!");
                                //row_one[seat_number - 1] = "1";
                            } else if (Objects.equals(row_three[seat_number - 1], "0")) {
                                System.out.println("Seat booked!");
                                row_three[seat_number - 1] = "1";
                                break;
                            }
                        } catch (InputMismatchException e) {//Checking if the inputs are integers
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else {
                    System.out.println("Enter a valid row number");
                }
            } catch (InputMismatchException e) {//Checking if the inputs are integers
                System.out.println("Invalid number! Try again.");
                scanner.nextLine();
            }
        }
        //Asking the user to enter the name
        System.out.println("Enter your name: ");
        String name = scanner.next();
//Asking the user to enter the surname
        System.out.println("Enter your surname: ");
        String surname = scanner.next();
//Asking the user to enter the email
        System.out.println("Enter your email: ");
        String email = scanner.next();

        Person person = new Person(name, surname, email);

        while (true) {
            try {
                //Asking the user to enter the ticket price
                System.out.println("Enter the ticket price: ");
                price = scanner.nextDouble();
                break;
            } catch (
                    InputMismatchException e) {//If the ticket price is not an integer it would display an error message
                System.out.println("Invalid price entered");
                scanner.nextLine();
            }
        }

//Stores the info to the Tickets array list
        Ticket ticket = new Ticket(row_number, seat_number, price, person);
        Tickets.add(ticket);

        System.out.println("Ticket booked successfully!");
    }
    //Prints the seating area
    public static void print_seating_area() {

        System.out.println("Seating Plan! \n");

        System.out.println("\t***********\t");
        System.out.println("\t*  STAGE  *\t");
        System.out.println("\t***********\t");

        System.out.print("\t");
        for (int i = 0; i < (row_one.length); i++) {
            if (i == 6) {
                System.out.print("\t");
                System.out.print("O");
            } else if (Objects.equals(row_one[i], "0")) {
                System.out.print("O");
            } else if (Objects.equals(row_one[i], "1")) {
                System.out.print("X");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < (row_two.length); i++) {
            if (i == 8) {
                System.out.print("  ");
                System.out.print("O");
            } else if (Objects.equals(row_two[i], "0")) {
                System.out.print("O");
            } else if (Objects.equals(row_two[i], "1")) {
                System.out.print("X");
            }
        }
        System.out.println();

        for (int i = 0; i < (row_three.length); i++) {
            if (i == 10) {
                System.out.print("  ");
                System.out.print("O");
            } else if (Objects.equals(row_three[i], "0")) {
                System.out.print("O");
            } else if (Objects.equals(row_three[i], "1")) {
                System.out.print("X");
            }
        }
        System.out.println();
    }
    //Allows the user to cancel a ticket
    public static void cancel_ticket() {
        int row_number=0;
        int seat_number=0;
        while (true){
            try{
                System.out.println("Enter a row number: ");//Asks the user the row number
                row_number = scanner.nextInt();
                if (row_number>0 && row_number<4){
                    break;
                }else {
                    System.out.println("Please enter a row number between 1-3");
                }

            }catch (InputMismatchException e){//If the row number isn't an integer it would display an error message
                System.out.println("Invalid row number entered");
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                if (row_number == 1) {
                    while (true) {
                        try{
                            System.out.println("Please enter a seat number (1-12):");//Asks the user to enter the seat number
                            seat_number= scanner.nextInt();
                            if (seat_number<0 || seat_number>12){//Checks the if the seat number is valid or not
                                System.out.println("Please enter a seat number between 1-12 only");
                            }
                            if (Objects.equals(row_one[seat_number - 1], "0")) {//Checks if the entered seat number is available or occupied
                                System.out.println("Seat cannot be cancelled. Its already available.");
                                row_one[seat_number - 1] = "0";
                            } else if (Objects.equals(row_one[seat_number - 1], "1")) {//Cancels the ticket
                                System.out.println("Seat cancelled!");
                                row_one[seat_number - 1] = "0";
                                break;
                            }
                        }catch(InputMismatchException e){//If the seat number is not an integer it would display an error message
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else if (row_number == 2) {
                    while (true) {
                        try{
                            System.out.println("Please enter a seat number (1-16):");//Asks the user to enter the seat number
                            seat_number= scanner.nextInt();
                            if (seat_number<0 || seat_number>16){//Checks the if the seat number is valid or not
                                System.out.println("Please enter a seat number between 1-16 only");
                            }
                            if (Objects.equals(row_two[seat_number - 1], "0")) {//Checks if the entered seat number is available or occupied
                                System.out.println("Seat cannot be cancelled. Its already available.");
                            } else if (Objects.equals(row_two[seat_number - 1], "1")) {//Cancels the ticket
                                System.out.println("Seat cancelled!");
                                row_two[seat_number - 1] = "0";
                                break;
                            }
                        }catch(InputMismatchException e){//If the seat number is not an integer it would display an error message
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }
                    break;
                } else if (row_number == 3) {
                    while (true) {
                        try{
                            System.out.println("Please enter a seat number (1-20):");//Asks the user to enter the seat number
                            seat_number= scanner.nextInt();
                            if (seat_number<0 || seat_number>20){//Checks the if the seat number is valid or not
                                System.out.println("Please enter a seat number between 1-20 only");
                            }
                            if (Objects.equals(row_three[seat_number - 1], "0")) {//Checks if the entered seat number is available or occupied
                                System.out.println("Seat cannot be cancelled. Its already available.");
                            } else if (Objects.equals(row_three[seat_number - 1], "1")) {//Cancels the ticket
                                System.out.println("Seat cancelled!");
                                row_three[seat_number - 1] = "0";
                                break;
                            }
                        }catch(InputMismatchException e){//If the seat number is not an integer it would display an error message
                            System.out.println("Invalid seat number entered.");
                            scanner.nextLine();
                        }
                    }

                } else {//If the row number is not a number between 1 and 3 it would display an error message
                    System.out.println("Enter a valid row number");
                }
                break;

            } catch (Exception e) {//If the row number is not an integer it would display an error message
                System.out.println("Invalid number! Try again.");
            }

        }
//Updates the Tickets array list
        int i=0;
        for (int r = 0; r < Tickets.size(); r++) {
            Ticket ticket = Tickets.get(r);
            if (ticket.getRow() == row_number && ticket.getSeat() == seat_number) {
                i=r;
            }
        }
        Tickets.remove(i);
    }
    //Shows the available seats
    public static void show_available() {

        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row_one.length; i++) {
            if (row_one[i].equals("1")) {
                continue;
            } else if (Objects.equals(row_one[i], "0")) {
                System.out.print(i + 1 + " , ");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row_two.length; i++) {
            if (row_two[i].equals("1")) {
                continue;
            } else if (Objects.equals(row_two[i], "0")) {
                System.out.print(i + 1 + " , ");
            }
        }
        System.out.println();
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row_three.length; i++) {
            if (row_three[i].equals("1")) {
                continue;
            } else if (Objects.equals(row_three[i], "0")) {
                System.out.print(i + 1 + " , ");
            }
        }
        System.out.println();
    }
    //Saves the data into a file
    public static void save() { //https://www.w3schools.com/java/java_files_create.asp
        try {
            PrintWriter Writer = new PrintWriter("seats_file.txt");

            //myWriter.write("Available seats in row 1: ");
            for (int p = 0; p < row_one.length; p++) {
                Writer.write(row_one[p] + " ");
            }
            Writer.write("\n");

            //myWriter.write("Available seats in row 2: ");
            for (int q = 0; q < row_two.length; q++) {
                Writer.write(row_two[q] +  " ");
            }
            Writer.write("\n");

            //myWriter.write("Available seats in row 3: ");
            for (int r = 0; r < row_three.length; r++) {
                Writer.write(row_three[r] +  " ");
            }
            Writer.write("\n");
            Writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    //loads the saved file
    public static void load() {//https://www.w3schools.com/java/java_files_read.asp
        try{
            File writer = new File("seats_file.txt");
            Scanner myReader = new Scanner(writer);
            int rowNumber=1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] rowData = data.split(" ");
                if (rowNumber == 1) {
                    for (int i = 0; i < row_one.length; i++) {
                        row_one[i] = rowData[i];
                    }
                } else if (rowNumber == 2) {
                    for (int i = 0; i < row_two.length; i++) {
                        row_two[i] = rowData[i];
                    }
                } else if (rowNumber == 3) {
                    for (int i = 0; i < row_three.length; i++) {
                        row_three[i] = rowData[i];
                    }
                }
                rowNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("Loaded from file successfully.");
        System.out.println("Loaded seating area from the file.");
        print_seating_area();
    }
    //Shows the user the ticket info
    static void show_tickets_info() {
        if (Tickets.size() == 0 ) {
            System.out.println("No seats have been booked.");
        }
        for (Ticket ticket: Tickets){
            ticket.print();
            System.out.println();
        }
        double total_price = 0.0;
        for(Ticket ticket : Tickets) {
            total_price += ticket.getPrice();
        }
        System.out.println("Total price: " + "€" +  total_price);
    }
    //Sorts the tickets according to the price
    public static void sorting_tickets() {//https://www.javatpoint.com/bubble-sort-in-java
        int n = Tickets.size();
        Ticket temp;
        for(int i=0; i < n; i++){
            for (int j = 1; j<(n-i); j++) {
                if(Tickets.get(j-1).getPrice() > Tickets.get(j).getPrice()) {
                    //Uses the bubble code method
                    temp = Tickets.get(j-1);
                    Tickets.set(j-1, Tickets.get(j));
                    Tickets.set(j,temp);
                }
            }
        }
        System.out.println("Tickets sorted by price.");
        show_tickets_info();
    }
}


























