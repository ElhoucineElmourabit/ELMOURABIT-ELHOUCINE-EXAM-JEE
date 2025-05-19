package bdcc.elmourabit.elhoucine.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personnel extends Credit{
    private String motif;
}
