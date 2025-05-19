package bdcc.elmourabit.elhoucine.repositories;

import bdcc.elmourabit.elhoucine.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
