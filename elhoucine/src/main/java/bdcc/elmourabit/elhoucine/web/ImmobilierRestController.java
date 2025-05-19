package bdcc.elmourabit.elhoucine.web;

import bdcc.elmourabit.elhoucine.dtos.ImmobilierDTO;
import bdcc.elmourabit.elhoucine.exceptions.CreditNotFoundException;
import bdcc.elmourabit.elhoucine.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/immobilier")
@AllArgsConstructor
@CrossOrigin("*")
public class ImmobilierRestController {

    private CreditService creditService;

    @PostMapping
    public ImmobilierDTO save(@RequestBody ImmobilierDTO dto) throws CreditNotFoundException {
        return creditService.saveImmobilier(dto);
    }

    @GetMapping("/{id}")
    public ImmobilierDTO get(@PathVariable Long id) throws CreditNotFoundException {
        return creditService.getImmobilierById(id);
    }

    @GetMapping
    public List<ImmobilierDTO> getAll() {
        return creditService.getAllImmobilier();
    }
}