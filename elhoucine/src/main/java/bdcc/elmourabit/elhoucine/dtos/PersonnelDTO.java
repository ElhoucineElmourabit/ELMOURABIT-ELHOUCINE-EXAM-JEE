package bdcc.elmourabit.elhoucine.dtos;


import bdcc.elmourabit.elhoucine.entities.enums.CreditStatut;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class PersonnelDTO extends CreditDTO {
    private Long id;
    private Date dateDem;
    private CreditStatut statut;
    private Date dateAcc;
    private double montant;
    private int duree;
    private double taux;
    private ClientDTO clientDTO;
    private String motif;
}
