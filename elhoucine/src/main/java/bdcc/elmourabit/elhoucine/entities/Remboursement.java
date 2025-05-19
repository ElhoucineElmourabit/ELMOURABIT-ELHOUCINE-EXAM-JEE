package bdcc.elmourabit.elhoucine.entities;

import bdcc.elmourabit.elhoucine.entities.enums.RemboursementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private RemboursementType remboursementType;

    @ManyToOne
    private Credit credit;
}
