package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iteratorDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book;

import java.util.List;

public class Library {

    private List<org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book> list;

    public Library(List<Book> list) {
        this.list = list;
    }

    public Iterator createIterator(){
        return new BookIterator(list);
    }
}
