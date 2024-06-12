package org.example.SystemDesign.lowLevelDesign._03_behaviouralDesignPatterns.iteratorDesignPattern;

import java.util.List;

public class Library {

    private List<Book> list;

    public Library(List<Book> list) {
        this.list = list;
    }

    public Iterator createIterator(){
        return new BookIterator(list);
    }
}
