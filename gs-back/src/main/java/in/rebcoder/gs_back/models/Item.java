package in.rebcoder.gs_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean isSold;
    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    private Home home; // The home where this item is listed for sale
}

