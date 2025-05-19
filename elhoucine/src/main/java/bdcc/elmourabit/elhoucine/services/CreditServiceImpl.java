package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.CreditDTO;
import bdcc.elmourabit.elhoucine.dtos.ImmobilierDTO;
import bdcc.elmourabit.elhoucine.dtos.PersonnelDTO;
import bdcc.elmourabit.elhoucine.dtos.ProfessionnelDTO;
import bdcc.elmourabit.elhoucine.entities.*;
import bdcc.elmourabit.elhoucine.exceptions.CreditNotFoundException;
import bdcc.elmourabit.elhoucine.mappers.CreditMapperImpl;
import bdcc.elmourabit.elhoucine.repositories.ClientRepository;
import bdcc.elmourabit.elhoucine.repositories.CreditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService{
    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;
    private final CreditMapperImpl mapper;


    // IMMOBILIER
    @Override
    public ImmobilierDTO saveImmobilier(ImmobilierDTO dto) throws CreditNotFoundException {
        Immobilier immo = (Immobilier) mapper.toCredit(dto);
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new CreditNotFoundException("Client not found"));
        immo.setClient(client);
        Immobilier saved = (Immobilier) creditRepository.save(immo);
        return (ImmobilierDTO) mapper.fromCredit(saved);
    }

    @Override
    public ImmobilierDTO getImmobilierById(Long id) throws CreditNotFoundException {
        Immobilier immo = (Immobilier) creditRepository.findById(id)
                .filter(c -> c instanceof Immobilier)
                .orElseThrow(() -> new CreditNotFoundException("Immobilier not found"));
        return (ImmobilierDTO) mapper.fromCredit(immo);
    }

    @Override
    public List<ImmobilierDTO> getAllImmobilier() {
        return creditRepository.findAll().stream()
                .filter(c -> c instanceof Immobilier)
                .map(c -> (ImmobilierDTO) mapper.fromCredit(c))
                .collect(Collectors.toList());
    }

    // PERSONNEL
    @Override
    public PersonnelDTO savePersonnel(PersonnelDTO dto) {
        Personnel per = (Personnel) mapper.toCredit(dto);
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        per.setClient(client);
        Personnel saved = (Personnel) creditRepository.save(per);
        return (PersonnelDTO) mapper.fromCredit(saved);
    }

    @Override
    public PersonnelDTO getPersonnelById(Long id) {
        Personnel per = (Personnel) creditRepository.findById(id)
                .filter(c -> c instanceof Personnel)
                .orElseThrow(() -> new RuntimeException("Personnel not found"));
        return (PersonnelDTO) mapper.fromCredit(per);
    }

    @Override
    public List<PersonnelDTO> getAllPersonnel() {
        return creditRepository.findAll().stream()
                .filter(c -> c instanceof Personnel)
                .map(c -> (PersonnelDTO) mapper.fromCredit(c))
                .collect(Collectors.toList());
    }

    // PROFESSIONNEL
    @Override
    public ProfessionnelDTO saveProfessionnel(ProfessionnelDTO dto) throws CreditNotFoundException {
        Professionnel pro = (Professionnel) mapper.toCredit(dto);
        Client client = clientRepository.findById(dto.getClientDTO().getId())
                .orElseThrow(() -> new CreditNotFoundException("Client not found"));
        pro.setClient(client);
        Professionnel saved = (Professionnel) creditRepository.save(pro);
        return (ProfessionnelDTO) mapper.fromCredit(saved);
    }

    @Override
    public ProfessionnelDTO getProfessionnelById(Long id) throws CreditNotFoundException {
        Professionnel pro = (Professionnel) creditRepository.findById(id)
                .filter(c -> c instanceof Professionnel)
                .orElseThrow(() -> new CreditNotFoundException("Professionnel not found"));
        return (ProfessionnelDTO) mapper.fromCredit(pro);
    }

    @Override
    public List<ProfessionnelDTO> getAllProfessionnel() {
        return creditRepository.findAll().stream()
                .filter(c -> c instanceof Professionnel)
                .map(c -> (ProfessionnelDTO) mapper.fromCredit(c))
                .collect(Collectors.toList());
    }
}