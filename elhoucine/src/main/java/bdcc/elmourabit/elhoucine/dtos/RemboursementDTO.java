package bdcc.elmourabit.elhoucine.dtos;

import bdcc.elmourabit.elhoucine.entities.enums.RemboursementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private CreditDTO creditDTO;
    private RemboursementType remboursementType;
}
