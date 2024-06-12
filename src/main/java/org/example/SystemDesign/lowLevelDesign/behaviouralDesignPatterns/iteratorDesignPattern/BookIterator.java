package org.example.SystemDesign.lowLevelDesign.behaviouralDesignPatterns.iteratorDesignPattern;

import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book;
import org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Iterator;

import java.util.List;

public class BookIterator implements Iterator {

    private List<org.example.SystemDesign.lowLevelDesign.designPatterns.behavioural.iteratorDesignPattern.Book> books;
    private int index = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index < books.size();
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return books.get(index++);
        }
        return null;
    }
}
