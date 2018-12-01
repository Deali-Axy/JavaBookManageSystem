package da.Model;

import java.util.Date;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private Date publication_date;
    private int pages;
    private String ISBN;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return String.format("id: %d\n" +
                        "name: %s\n" +
                        "author: %s\n" +
                        "publisher: %s\n" +
                        "publication_date: %s\n" +
                        "pages: %d\n" +
                        "ISBN: %s\n",
                this.id, this.name, this.author, this.publisher,
                this.publication_date.toString(), this.pages, this.ISBN);
    }
}
