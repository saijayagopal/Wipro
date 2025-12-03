import java.util.*;

public class SmartLibrarySystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        switch (option) {
            case 1 -> {
                Manager<BookItem> bookSection = new Manager<>();
                int count = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= count; i++) {
                    int id = in.nextInt();
                    in.nextLine();
                    String title = in.nextLine();
                    String author = in.nextLine();
                    int pages = in.nextInt();
                    if (i != count) in.nextLine();
                    bookSection.addRecord(new BookItem(id, title, author, pages));
                }
                bookSection.showAll();
            }

            case 2 -> {
                Manager<DvdItem> dvdSection = new Manager<>();
                int num = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= num; i++) {
                    int id = in.nextInt();
                    in.nextLine();
                    String title = in.nextLine();
                    String director = in.nextLine();
                    int time = in.nextInt();
                    if (i != num) in.nextLine();
                    dvdSection.addRecord(new DvdItem(id, title, director, time));
                }

                Manager<MagazineItem> magSection = new Manager<>();
                num = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= num; i++) {
                    int id = in.nextInt();
                    in.nextLine();
                    String name = in.nextLine();
                    String pub = in.nextLine();
                    int issue = in.nextInt();
                    if (i != num) in.nextLine();
                    magSection.addRecord(new MagazineItem(id, name, pub, issue));
                }
                dvdSection.showAll();
                magSection.showAll();
            }

            case 3 -> {
                Manager<BookItem> books = new Manager<>();
                int total = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= total; i++) {
                    int id = in.nextInt();
                    in.nextLine();
                    String name = in.nextLine();
                    String writer = in.nextLine();
                    int pages = in.nextInt();
                    if (i != total) in.nextLine();
                    books.addRecord(new BookItem(id, name, writer, pages));
                }
                int findId = in.nextInt();
                if (books.checkout(findId)) {
                    System.out.println("Item " + findId + " checked out successfully.");
                } else {
                    System.out.println("Item " + findId + " not found in the library.");
                }
            }

            case 4 -> {
                Manager<MagazineItem> mags = new Manager<>();
                int total = in.nextInt();
                in.nextLine();
                for (int i = 1; i <= total; i++) {
                    int id = in.nextInt();
                    in.nextLine();
                    String title = in.nextLine();
                    String pub = in.nextLine();
                    int issue = in.nextInt();
                    if (i != total) in.nextLine();
                    MagazineItem m = new MagazineItem(id, title, pub, issue);
                    m.checkedOut = true;
                    mags.addRecord(m);
                }
                int findId = in.nextInt();
                if (mags.returnItem(findId)) {
                    System.out.println("Item " + findId + " returned successfully.");
                } else {
                    System.out.println("Item " + findId + " not found in the library.");
                }
            }

            default -> System.out.println("Invalid choice");
        }
        in.close();
    }
}

class BaseItem {
    private int id;
    private String title;
    private String creator;
    public boolean checkedOut;

    public BaseItem(int id, String title, String creator) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.checkedOut = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCreator() { return creator; }

    public void issue() throws AlreadyIssuedException {
        if (checkedOut) throw new AlreadyIssuedException("Item already checked out");
        checkedOut = true;
    }

    public void receive() throws NotIssuedException {
        if (!checkedOut) throw new NotIssuedException("Item not currently checked out");
        checkedOut = false;
    }

    @Override
    public String toString() {
        return "Item ID: " + id + "\nTitle: " + title + "\nCreator: " + creator + "\nChecked Out: " + checkedOut;
    }
}

class AlreadyIssuedException extends Exception {
    public AlreadyIssuedException(String msg) {
        super(msg);
    }
}

class NotIssuedException extends Exception {
    public NotIssuedException(String msg) {
        super(msg);
    }
}

class BookItem extends BaseItem {
    private int pages;
    public BookItem(int id, String title, String author, int pages) {
        super(id, title, author);
        this.pages = pages;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Book\nNumber of Pages: " + pages;
    }
}

class DvdItem extends BaseItem {
    private int duration;
    public DvdItem(int id, String title, String director, int duration) {
        super(id, title, director);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: DVD\nDuration: " + duration + " minutes";
    }
}

class MagazineItem extends BaseItem {
    private int issue;
    public MagazineItem(int id, String title, String publisher, int issue) {
        super(id, title, publisher);
        this.issue = issue;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Magazine\nIssue Number: " + issue;
    }
}

class Manager<T extends BaseItem> {
    private List<T> records = new ArrayList<>();

    public void addRecord(T item) {
        records.add(item);
    }

    public void showAll() {
        for (T item : records) {
            System.out.println(item);
            System.out.println("-------------");
        }
    }

    public boolean checkout(int id) {
        T found = locate(id);
        if (found != null) {
            try {
                found.issue();
                return true;
            } catch (AlreadyIssuedException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean returnItem(int id) {
        T found = locate(id);
        if (found != null) {
            try {
                found.receive();
                return true;
            } catch (NotIssuedException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    private T locate(int id) {
        for (T item : records) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
}





