package bdcc.elmourabit.elhoucine.dtos;

import bdcc.elmourabit.elhoucine.entities.enums.CreditStatut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data

public abstract class CreditDTO {

    private String type;

   }
