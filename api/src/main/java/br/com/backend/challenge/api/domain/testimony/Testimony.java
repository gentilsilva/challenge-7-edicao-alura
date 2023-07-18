package br.com.backend.challenge.api.domain.testimony;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Testimony")
@Table(name = "tb_testimony")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Testimony {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_picture")
    private String userPicture;

    @Column(name = "user_testimony")
    private String userTestimony;

    @Column(name = "user_name")
    private String userName;
    
    private Boolean active;

}
