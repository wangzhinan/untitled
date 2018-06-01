package com.sunland.test;

import java.util.Optional;

/**
 * Author: wangzn
 * DateTime: 2018/5/29 20:13
 */
public class OptionalTest {

    public static void main(String[] args) {
        OptionalTest test = new OptionalTest();
        test.test();

    }

    public void test(){
        Student student = new Student();
        Bag bag = new Bag();
        bag.setBook(new Book());
        student.setBag(bag);
        System.out.println(getBookName(student));
    }

    public String getBookName(Student student){
        return Optional.ofNullable(student).flatMap(Student::getBag)
                .flatMap(Bag::getBook).map(Book::getName).orElse("deault");
    }

   class Student {
        private Bag bag;

       public Optional<Bag> getBag() {
           return Optional.ofNullable(bag);
       }

       public void setBag(Bag bag) {
           this.bag = bag;
       }
   }

    class Bag {
        private Book book;

        public Optional<Book> getBook() {
            return Optional.ofNullable(book);
        }

        public void setBook(Book book) {
            this.book = book;
        }
    }

    class Book {
        private String name ;

        public Book(String name) {
            this.name = name;
        }

        public Book(){

        }

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
