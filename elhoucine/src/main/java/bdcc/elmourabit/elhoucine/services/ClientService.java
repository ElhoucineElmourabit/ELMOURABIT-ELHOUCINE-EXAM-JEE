package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.ClientDTO;
import bdcc.elmourabit.elhoucine.exceptions.ClientNotFoundException;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id) throws ClientNotFoundException;
    List<ClientDTO> listClients();
    ClientDTO updateClient(Long id, ClientDTO clientDTO) throws ClientNotFoundException;
    void deleteClient(Long id);
}
