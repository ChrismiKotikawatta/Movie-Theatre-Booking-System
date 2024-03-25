public class Ticket {//https://www.w3schools.com/java/java_classes.asp
    //Defines the private fields for the Ticket class
    private  int row;
    private  int seat;
    private  double price;
    private Person person;
    //Defines the constructor for the Ticket class
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    //Defines a getter method for the row number
    public int getRow(){
        int row_number = 0;
        return row_number;
    }
    //Defines a getter method for the seat number
    public int getSeat(){
        int seat_number=0;
        return seat_number;
    }
    //Defines a getter method for the ticket price
    public double getPrice(){
        return price;
    }
    //Calls a method called print to print the name,surname,email,row number,seat number and the ticket price
    public void print(){
        System.out.println("Person name: " + person.getName());
        System.out.println("Person surname: " + person.getSurname());
        System.out.println("Person email: " + person.getEmail());
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
    }
    //Defines a getter method for the person
    public Person getPerson() {
        return person;
    }
}
