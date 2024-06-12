package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iteratorDesignPattern;


import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Library;

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
        List<org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book> list = Arrays.asList(
                new org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book(100, "Science"),
                new org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book(200, "Maths"),
                new org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book(300, "English"),
                new org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book(400, "GK")
        );

        Library lib = new Library(list);
        Iterator iterator = lib.createIterator();

        while(iterator.hasNext()){
            org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
