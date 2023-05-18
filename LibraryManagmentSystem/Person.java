import java.util.ArrayList;

abstract public class Person{

  private int user_ID;
  private String password;
  private boolean isAdmin;
  private String FirstName;
  private String LastName;
  private String Gender;
  private String Address;
  private int PhoneNumber;
  private String Email;
  private boolean isBlocked;
  public ArrayList<Book> book_cart = new ArrayList<>();

  // default constructor
  public Person() {
  }

  //constructor
  public Person(String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, int user_ID, String password, boolean isBlocked, boolean isAdmin) {
    this.user_ID = user_ID;
    this.password = password;
    this.isAdmin = isAdmin;
    this.FirstName = FirstName;
    this.LastName = LastName;
    this.Gender = Gender;
    this.Address = Address;
    this.PhoneNumber = PhoneNumber;
    this.Email = Email;
    this.isBlocked = isBlocked;
  }

  // setters
  public void setuser_ID(int id) {
    this.user_ID = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public void setFirstName(String firstName) {
    this.FirstName = firstName;
  }

  public void setLastName(String lastName) {
    this.LastName = lastName;
  }

  public void setGender(String Gender){
    this.Gender = Gender;
  }

  public void setAddress(String address) {
    this.Address = address;
  }

  public void setPhoneNumber(int phoneNumber) {
    this.PhoneNumber = phoneNumber;
  }

  public void setEmail(String email) {
    this.Email = email;
  }

  public void setIsBlocked(boolean isBlocked) {
    this.isBlocked = isBlocked;
  }

  public void setCart(ArrayList<Book> book_cart){
    this.book_cart = book_cart;
  }

  // getters
  public int getuser_ID() {
    return this.user_ID;
  }

  public String getPassword() {
    return this.password;
  }

  public boolean getIsAdmin() {
    return this.isAdmin;
  }

  public String getFirstName() {
    return this.FirstName;
  }

  public String getLastName() {
    return this.LastName;
  }

  public String getGender(){
    return this.Gender;
  }

  public String getAddress() {
    return this.Address;
  }

  public int getPhoneNumber() {
    return this.PhoneNumber;
  }

  public String getEmail() {
    return this.Email;
  }

  public boolean getIsBlocked() {
    return this.isBlocked;
  }

  // get cart
  public ArrayList<Book> getCart(){

    return book_cart;
  }

  // // rent a book
  // public abstract void rent_book(Person person, ArrayList<Person> persons, ArrayList<Book> books);

  // // search for a book
  // public abstract Book search_book(ArrayList<Book> books);
  
  // // remove a book from cart
  // public abstract void removeBookFromCart(Person person);



  // public abstract Person search_user(ArrayList<Person> persons);

  // public abstract void displayPersonInfo(Person p);

  // public abstract void viewAllUsers(Librarian librarian);

}