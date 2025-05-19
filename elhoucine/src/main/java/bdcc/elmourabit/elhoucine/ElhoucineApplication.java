package bdcc.elmourabit.elhoucine;

import bdcc.elmourabit.elhoucine.entities.Client;
import bdcc.elmourabit.elhoucine.entities.Immobilier;
import bdcc.elmourabit.elhoucine.entities.Personnel;
import bdcc.elmourabit.elhoucine.entities.Remboursement;
import bdcc.elmourabit.elhoucine.entities.enums.ImmobilierType;
import bdcc.elmourabit.elhoucine.repositories.ClientRepository;
import bdcc.elmourabit.elhoucine.repositories.CreditRepository;
import bdcc.elmourabit.elhoucine.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class ElhoucineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElhoucineApplication.class, args);
	}

	@Component
	public class TestDataLoader implements CommandLineRunner {

		private ClientRepository clientRepository;
		private CreditRepository creditRepository;
		private RemboursementRepository remboursementRepository;

		public TestDataLoader(ClientRepository clientRepository,
							  CreditRepository creditRepository,
							  RemboursementRepository remboursementRepository) {
			this.clientRepository = clientRepository;
			this.creditRepository = creditRepository;
			this.remboursementRepository = remboursementRepository;
		}

		@Override
		public void run(String... args) throws Exception {

			Client client = new Client();
			client.setNom("Elmourabit Elhoucine");
			client.setEmail("elhoucine@example.com");
			clientRepository.save(client);


			Immobilier immobilier = new Immobilier();
			immobilier.setMontant(500000);
			immobilier.setTypeBien(ImmobilierType.MAISON);
			immobilier.setClient(client);
			creditRepository.save(immobilier);


			Personnel consommation = new Personnel();
			consommation.setMontant(10000);
			consommation.setMotif("blabla");
			consommation.setClient(client);
			creditRepository.save(consommation);


			Remboursement r1 = new Remboursement();
			r1.setMontant(2000);
			r1.setCredit(immobilier);
			r1.setDate(new Date());
			remboursementRepository.save(r1);

			Remboursement r2 = new Remboursement();
			r2.setMontant(500);
			r2.setCredit(consommation);
			r2.setDate(new Date());
			remboursementRepository.save(r2);

		}
	}

}
