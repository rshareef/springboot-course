package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

// use jakarta persistence annotation
// entity is an object that exists

// many-to-many entity relationship between book and author; an author can have many books and a book can have many authors.

@Entity
public class Book {
    @Id
    // saying that the ID will get generated by the database.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;


    @ManyToMany
    // introduce joined table between entities (by default, each entity has a separate table).
    @JoinTable(name = "author book", joinColumns = @JoinColumn(name = "book id"),
        inverseJoinColumns = @JoinColumn(name = "author id"))
    // set up relationship between entities
    private Set<Author> authors;
    // when dealing with JPAs it's better to use a SET and not a LIST because each item will be unique.
    public Set<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    // IntelliJ generated getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Overriding the default print method.
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    // implementing equals and hashcode so Hibernate (object-relational mapping tool) can determine if two objects are the same object or not.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
