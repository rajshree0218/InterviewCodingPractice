package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.iteratorDesignPattern;


import java.util.Arrays;
import java.util.List;

/*
* Iterator Design Pattern
* Let's look at this attached diagram once and understand the need for Iterator Design Pattern.
*
* So,it provides a way to access element of a collection sequentially without exposing the underlying
* representation of the collection.
*
*
* */
public class Main {

    public static void main(String[] args) {
        List<Book> list = Arrays.asList(
                new Book(100, "Science"),
                new Book(200, "Maths"),
                new Book(300, "English"),
                new Book(400, "GK")
        );

        Library lib = new Library(list);
        Iterator iterator = lib.createIterator();

        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
