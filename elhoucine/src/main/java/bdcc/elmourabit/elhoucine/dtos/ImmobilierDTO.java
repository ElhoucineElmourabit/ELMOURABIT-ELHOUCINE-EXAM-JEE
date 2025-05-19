package bdcc.elmourabit.elhoucine.dtos;

import bdcc.elmourabit.elhoucine.entities.enums.CreditStatut;
import bdcc.elmourabit.elhoucine.entities.enums.ImmobilierType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class ImmobilierDTO extends CreditDTO {
    private Long id;
    private Date dateDem;
    private CreditStatut statut;
    private Date dateAcc;
    private double montant;
    private int duree;
    private double taux;
    private ClientDTO clientDTO;
    private ImmobilierType typeBien;
}
