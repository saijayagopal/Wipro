public class Book {
    String title;
    String author;
    int year;

    public Book() {
        title="Not specified";
        author = "Unknown";
        year =0;
    }
        public Book(String title,String author,int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }
        public void displayInfo() {
            System.out.println("Title: " +title);
            System.out.println("Author: " +author);
            System.out.println("Year: " +year);
    }
    
    public static void main(String[] args) {

        //write your answer here
           System.out.println("Book 1:");
      // call displayInfo();
      Book book1 = new Book();
      book1.displayInfo();

      System.out.println();

        System.out.println("Book 2:");
        // call displayInfo();
        Book book2 = new Book("Java Programming","Sakshi",2024);
        book2.displayInfo();
    }
  
}