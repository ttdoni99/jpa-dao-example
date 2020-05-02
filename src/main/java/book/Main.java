package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;



public class Main {

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator Generator= new BookGenerator();
        for (int i = 0; i < 1500; i++) {

            Book books = Generator.generateBook();
            bookDao.persist(books);
        }


        bookDao.findAll().stream().forEach(System.out::println);
    }
}
