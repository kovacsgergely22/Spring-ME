
package org.me.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Book> books;

    @ManyToOne
    private Users user;

    @Column
    private double totalPrice;

    public Order(List<Book> books, Users user) {
        this.books = books;
        this.user = user;
        this.totalPrice = calculateTotalPrice();
    }

    // Új metódus a totalPrice kiszámításához
    private double calculateTotalPrice() {
        if (books == null || books.isEmpty()) {
            return 0.0;
        }
        return books.stream()
                .mapToDouble(Book::getPrice)
                .sum();
    }

    // Setter módosítása, hogy mindig újraszámolja a totalPrice-t amikor a books listát módosítjuk
    public void setBooks(List<Book> books) {
        this.books = books;
        this.totalPrice = calculateTotalPrice();
    }
}