package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.RemboursementDTO;
import bdcc.elmourabit.elhoucine.exceptions.RemboursementNotFoundException;

import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO dto) throws RemboursementNotFoundException;
    RemboursementDTO getRemboursement(Long id) throws RemboursementNotFoundException;
    List<RemboursementDTO> listRemboursements();
    void deleteRemboursement(Long id);

}
