package in.rebcoder.gs_back.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> items;

    @ManyToOne
    private User seller;

    private String saleName;
    private LocalDate saleDate;
    private String description;
    private String status;
}

