package academy.digitallab.store.serviceproduct.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "tbl_categories")
//AllArgsConstructor Generar constructor con todas las pros
//NoArgsConstructor El costrctor sin ags
//Builder Instacias de la entidad
@AllArgsConstructor @NoArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

