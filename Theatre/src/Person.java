public class Person {//https://www.w3schools.com/java/java_classes.asp
    //private variables to hold the name, surname and email of a person
    private  String name;
    private String surname;
    private String email;
    //The constructor method that takes in a name,surname and email
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    //the method that returns the name of the person
    public  String getName(){
        return name;
    }
    //the method that returns the surname of the person
    public String getSurname(){
        return surname;
    }
    //the method that returns the email of the person
    public String getEmail(){
        return email;
    }
}
