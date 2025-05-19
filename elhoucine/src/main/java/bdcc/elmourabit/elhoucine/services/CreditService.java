package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.CreditDTO;
import bdcc.elmourabit.elhoucine.dtos.ImmobilierDTO;
import bdcc.elmourabit.elhoucine.dtos.PersonnelDTO;
import bdcc.elmourabit.elhoucine.dtos.ProfessionnelDTO;
import bdcc.elmourabit.elhoucine.exceptions.CreditNotFoundException;

import java.util.List;

public interface CreditService {
    // Immobilier
    ImmobilierDTO saveImmobilier(ImmobilierDTO dto) throws CreditNotFoundException;
    ImmobilierDTO getImmobilierById(Long id) throws CreditNotFoundException;
    List<ImmobilierDTO> getAllImmobilier();

    // Personnel
    PersonnelDTO savePersonnel(PersonnelDTO dto);
    PersonnelDTO getPersonnelById(Long id);
    List<PersonnelDTO> getAllPersonnel();

    // Professionnel
    ProfessionnelDTO saveProfessionnel(ProfessionnelDTO dto) throws CreditNotFoundException;
    ProfessionnelDTO getProfessionnelById(Long id) throws CreditNotFoundException;
    List<ProfessionnelDTO> getAllProfessionnel();
}
