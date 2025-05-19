package bdcc.elmourabit.elhoucine.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PRO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professionnel extends Credit {
    private String motif;
    private String raisonSociale;
}
