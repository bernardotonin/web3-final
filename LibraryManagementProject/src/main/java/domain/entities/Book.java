package domain.entities;

import domain.enums.BookStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.Objects;
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")

    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;
    @CreationTimestamp
    @Column(nullable = false)
    private Date creation_date;
    @Enumerated(EnumType.STRING)
    private BookStatus status;

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


    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getId() == book.getId() && Objects.equals(getName(), book.getName()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getCreation_date(), book.getCreation_date()) && getStatus() == book.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAuthor(), getCreation_date(), getStatus());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", creation_date=" + creation_date +
                ", status=" + status +
                '}';
    }
}
