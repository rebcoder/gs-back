package in.rebcoder.gs_back.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Item> items;

    @ManyToOne
    private User seller;
    @NotBlank(message = "Sale name is required")
    private String saleName;
    @FutureOrPresent(message = "Sale date cannot be in the past")
    private LocalDate saleDate;
    private String description;
    private String status;
}

