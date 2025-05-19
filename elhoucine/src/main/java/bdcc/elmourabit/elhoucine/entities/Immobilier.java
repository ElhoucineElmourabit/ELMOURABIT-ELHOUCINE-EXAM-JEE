package bdcc.elmourabit.elhoucine.entities;

import bdcc.elmourabit.elhoucine.entities.enums.ImmobilierType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("IMO")
@Data @NoArgsConstructor @AllArgsConstructor
public class Immobilier extends Credit{
    @Enumerated(EnumType.STRING)
    private ImmobilierType typeBien;
}
