package book;

import book.model.Book;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.ZoneId;

public class BookGenerator {

    private Faker faker = new Faker();

    public Book generateBook(){

        LocalDate localDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Book b = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().numberBetween(2, 2000))
                .available(faker.bool().bool())
                .build();
        return b;

    }
}
