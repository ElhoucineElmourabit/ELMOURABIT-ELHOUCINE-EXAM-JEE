package bdcc.elmourabit.elhoucine.services;

import bdcc.elmourabit.elhoucine.dtos.ClientDTO;
import bdcc.elmourabit.elhoucine.entities.Client;
import bdcc.elmourabit.elhoucine.exceptions.ClientNotFoundException;
import bdcc.elmourabit.elhoucine.mappers.CreditMapperImpl;
import bdcc.elmourabit.elhoucine.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final CreditMapperImpl mapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.toClient(clientDTO);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) throws ClientNotFoundException {
        return clientRepository.findById(id)
                .map(mapper::fromClient)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));
        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
