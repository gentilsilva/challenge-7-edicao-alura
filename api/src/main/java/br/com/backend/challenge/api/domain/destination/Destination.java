package br.com.backend.challenge.api.domain.destination;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Destination")
@Table(name = "tb_destination")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String picture;
    private String name;
    private BigDecimal price;

    @Column(name = "is_active")
    private Boolean isActive;

}
