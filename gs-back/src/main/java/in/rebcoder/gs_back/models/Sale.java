package in.rebcoder.gs_back.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate saleDate;
    private double totalAmount;  // Total amount for all items sold
    @ManyToMany
    private List<Item> items;    // List of items sold in this sale
    @ManyToOne
    private User seller;           // seller created the sale
}

