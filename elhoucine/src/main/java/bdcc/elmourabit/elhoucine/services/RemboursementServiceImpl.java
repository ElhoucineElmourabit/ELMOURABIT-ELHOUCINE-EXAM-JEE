package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.RemboursementDTO;
import bdcc.elmourabit.elhoucine.entities.Credit;
import bdcc.elmourabit.elhoucine.entities.Remboursement;
import bdcc.elmourabit.elhoucine.exceptions.RemboursementNotFoundException;
import bdcc.elmourabit.elhoucine.mappers.CreditMapperImpl;
import bdcc.elmourabit.elhoucine.repositories.CreditRepository;
import bdcc.elmourabit.elhoucine.repositories.RemboursementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RemboursementServiceImpl implements RemboursementService{
    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final CreditMapperImpl mapper;


    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO dto) throws RemboursementNotFoundException {
        Remboursement remboursement = mapper.toRemboursement(dto);
        Credit credit = creditRepository.findById(dto.getId())
                .orElseThrow(() -> new RemboursementNotFoundException("Credit not found"));
        remboursement.setCredit(credit);
        return mapper.fromRemboursement(remboursementRepository.save(remboursement));
    }

    @Override
    public RemboursementDTO getRemboursement(Long id) throws RemboursementNotFoundException {
        return remboursementRepository.findById(id)
                .map(mapper::fromRemboursement)
                .orElseThrow(() -> new RemboursementNotFoundException("Remboursement not found"));
    }

    @Override
    public List<RemboursementDTO> listRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }
}