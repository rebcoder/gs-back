package in.rebcoder.gs_back.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String postalCode;
    @OneToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;  // The seller associated with this home

}

