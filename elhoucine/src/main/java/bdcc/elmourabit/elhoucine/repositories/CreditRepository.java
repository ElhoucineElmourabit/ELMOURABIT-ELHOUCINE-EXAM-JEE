package bdcc.elmourabit.elhoucine.repositories;

import bdcc.elmourabit.elhoucine.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
