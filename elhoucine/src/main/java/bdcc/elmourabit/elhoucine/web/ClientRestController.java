package bdcc.elmourabit.elhoucine.web;

import bdcc.elmourabit.elhoucine.dtos.ClientDTO;
import bdcc.elmourabit.elhoucine.exceptions.ClientNotFoundException;
import bdcc.elmourabit.elhoucine.services.ClientService;
import bdcc.elmourabit.elhoucine.services.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientRestController {
    private final ClientServiceImpl clientService;

    @PostMapping
    public ClientDTO save(@RequestBody ClientDTO dto) {
        return clientService.saveClient(dto);
    }

    @GetMapping("/{id}")
    public ClientDTO get(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.getClient(id);
    }

    @GetMapping
    public List<ClientDTO> getAll() {
        return clientService.listClients();
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO dto) throws ClientNotFoundException {
        return clientService.updateClient(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
