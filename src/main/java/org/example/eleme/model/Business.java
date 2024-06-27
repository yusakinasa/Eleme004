package org.example.eleme.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "business")
@Data
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;

    private String name;
    private String description;
    private String address;
    private String phone;
}
