package org.me.bookstore.controller;

import jakarta.annotation.PostConstruct;
import org.me.bookstore.model.Book;
import org.me.bookstore.model.Order;
import org.me.bookstore.model.Users;
import org.me.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookController bookController;

    @Autowired
    private UsersController usersController;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        // Ellenőrizzük, hogy az order tartalmazza-e a szükséges adatokat
        if (order.getBooks() == null || order.getBooks().isEmpty() || order.getUser() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Az order totalPrice értékét újraszámoljuk a biztonság kedvéért
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }


    @PostConstruct
    public void init() {
        List<Book> allBooks = bookController.getAllBooks();
        List<Users> allUsers = usersController.getAllUsers();

        if (allBooks.size() < 3 || allUsers.size() < 2) {
            throw new IllegalStateException("Nem áll rendelkezésre elegendő könyv vagy felhasználó a példa rendelések létrehozásához");
        }

        // Első rendelés - az első két könyv az első felhasználónak
        List<Book> orderBooks1 = Arrays.asList(allBooks.get(0), allBooks.get(1));
        Order order1 = new Order(orderBooks1, allUsers.get(0)); // A 0 érték felül lesz írva
        orderService.saveOrder(order1);

        // Második rendelés - a második és harmadik könyv a második felhasználónak
        List<Book> orderBooks2 = Arrays.asList(allBooks.get(1), allBooks.get(2));
        Order order2 = new Order(orderBooks2, allUsers.get(1)); // A 0 érték felül lesz írva
        orderService.saveOrder(order2);

        // Harmadik rendelés - az első és harmadik könyv ismét az első felhasználónak
        List<Book> orderBooks3 = Arrays.asList(allBooks.get(0), allBooks.get(2));
        Order order3 = new Order(orderBooks3, allUsers.get(0)); // A 0 érték felül lesz írva
        orderService.saveOrder(order3);
    }
}