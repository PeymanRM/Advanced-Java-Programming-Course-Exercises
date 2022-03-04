package classwork;

import java.util.Scanner;

public class Library {
    private int bookCount = 0;
    private String[][] bookList;
    Scanner input = new Scanner(System.in);

    public Library(int bookCount, String[] books){
        this.bookCount = bookCount;
        bookList = new String[bookCount][3]; // [][0]name, [][1]status, [][2]Borrower ID, index = bookId
        for(int id = 0; id < bookCount; id++) {
            bookList[id][0] = books[id];
            bookList[id][1] = "Available";
        }
    }

    public void getBooks() {
        for(int id = 0; id < bookCount; id++) {
            System.out.print("ID="+ id + "\t\tName=\"" + bookList[id][0] + "\"\t\tStatus=" + bookList[id][1]);
            if(bookList[id][1] == "Borrowed"){
                System.out.print(" by \"" + bookList[id][2] +"\"");
            }
            System.out.println();
        }
    }

    public void borrowBook() {
        //input needed information
        System.out.print("Enter the ID of the book (To return enter -1):");
        int bookId = input.nextInt();
        if(bookId == -1) return;
        System.out.print("Enter the ID of the borrower (To return enter -1):");
        String borrowerId = input.next();
        if(Integer.parseInt(borrowerId) == -1) return;

        //put
        if (bookId < 0 || bookId >= bookCount){
            System.out.println("There is no book with such an ID!");
            return;
        } else if(bookList[bookId][1] != "Available") {
            System.out.println("Sorry! The book isn't available right now.");
        } else {
            bookList[bookId][1] = "Borrowed";
            bookList[bookId][2] = borrowerId;
            System.out.println("Successfully borrowed \"" + bookList[bookId][0] + "\" for \"" + bookList[bookId][2] +"\"");
        }
    }

    public void returnBook() {
        //input needed information
        System.out.print("Enter the ID of the book (To return to the main menu enter -1):");
        int bookId = input.nextInt();
        if(bookId == -1) return;

        //put
        if (bookId < 0 || bookId >= bookCount){
            System.out.println("There is no book with such an ID!");
            return;
        } else if(bookList[bookId][1] != "Borrowed") {
            System.out.println("The book is not borrowed.");
        } else {
            bookList[bookId][1] = "Available";
            bookList[bookId][2] = null;
            System.out.println("Successfully returned \"" + bookList[bookId][0] + "\"");
        }
    }
}
