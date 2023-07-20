package br.com.backend.challenge.api.domain.testimony;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
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
    
    public Testimony(TestimonyFormDTO testimonyFormDto) {
        this.userPicture = testimonyFormDto.userPicture();
        this.userTestimony = testimonyFormDto.userTestimony();
        this.userName = testimonyFormDto.userName();
        this.active = true;
    }

    public void update(@Valid TestimonyUpdateFormDTO testimonyUpdateFormDTO) {
        if (!testimonyUpdateFormDTO.userPicture().equals(" ")) {
            this.userPicture = testimonyUpdateFormDTO.userPicture();
        }
        if (!testimonyUpdateFormDTO.userPicture().equals(" ")) {
            this.userTestimony = testimonyUpdateFormDTO.userTestimony();
        }
        if (!testimonyUpdateFormDTO.userPicture().equals(" ")) {
            this.userName = testimonyUpdateFormDTO.userName();
        }
    }

    public void inactivate() {
        this.active = false;
    }

}
