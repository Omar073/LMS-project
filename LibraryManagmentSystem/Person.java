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
  
    //constructor
    public Person(int user_ID, String password, boolean isAdmin, String FirstName, String LastName, String Gender, String Address, int PhoneNumber, String Email, boolean isBlocked) {
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
  
    // rent a book
    public void rent_book(int userId, Book book) {
      if (book.order_List == null) {
        book.order_List = new int[1];
        book.order_List[0] = userId;
        System.out.println("You have been added to the order list");
      } else {
        int[] newOrderList = new int[book.order_List.length + 1];
        System.arraycopy(book.order_List, 0, newOrderList, 0, book.order_List.length);
        newOrderList[book.order_List.length] = userId;
        book.order_List = newOrderList;
        System.out.println("Book rented successfully");
      }
    }
  
    // search for a book
    public Book search_book(String bookName, ArrayList<Book> books) {
      for (Book book : books) {
        if (book.getBookName().equalsIgnoreCase(bookName)) {
          return book;
        }
      }
      return null;
    }
  
  }