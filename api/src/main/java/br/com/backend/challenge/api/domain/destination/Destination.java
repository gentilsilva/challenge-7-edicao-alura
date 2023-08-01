package br.com.backend.challenge.api.domain.destination;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Destination")
@Table(name = "tb_destination")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_picture", length = 2048)
    private String firstPicture;

    @Column(name = "second_picture", length = 2048)
    private String secondPicture;

    private String name;

    @Column(length = 160)
    private String meta;

    @Column(name = "descritive_text", columnDefinition = "TEXT")
    private String descritiveText;

    @Column(name = "is_active")
    private Boolean isActive;

    public Destination(DestinationFormDTO destinationFormDTO) {
        this.firstPicture = destinationFormDTO.firstPicture();
        this.secondPicture = destinationFormDTO.secondPicture();
        this.name = destinationFormDTO.name();
        this.meta = destinationFormDTO.meta();
        this.descritiveText = destinationFormDTO.descritiveText();
        this.isActive = true;
    }

    public void update(DestinationUpdateFormDTO destinationUpdateFormDTO) {
        if (!destinationUpdateFormDTO.firstPicture().isBlank()) {
            this.firstPicture = destinationUpdateFormDTO.firstPicture();
        }
        if (!destinationUpdateFormDTO.secondPicture().isBlank()) {
            this.secondPicture = destinationUpdateFormDTO.secondPicture();
        }
        if (!destinationUpdateFormDTO.name().isBlank()) {
            this.name = destinationUpdateFormDTO.name();
        }
        if (!destinationUpdateFormDTO.meta().isBlank()) {
            this.meta = destinationUpdateFormDTO.meta();
        }
        if (!destinationUpdateFormDTO.descritiveText().isBlank()) {
            this.descritiveText = destinationUpdateFormDTO.descritiveText();
        }

    }

    public void inactive() {
        this.isActive = false;
    }
}
