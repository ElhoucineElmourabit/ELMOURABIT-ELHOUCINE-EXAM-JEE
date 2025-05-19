package bdcc.elmourabit.elhoucine.web;


import bdcc.elmourabit.elhoucine.dtos.ProfessionnelDTO;
import bdcc.elmourabit.elhoucine.exceptions.CreditNotFoundException;
import bdcc.elmourabit.elhoucine.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professionnel")
@AllArgsConstructor
public class ProfessionelRestController {
    private final CreditService creditService;

    @PostMapping
    public ProfessionnelDTO save(@RequestBody ProfessionnelDTO dto) throws CreditNotFoundException {
        return creditService.saveProfessionnel(dto);
    }

    @GetMapping("/{id}")
    public ProfessionnelDTO get(@PathVariable Long id) throws CreditNotFoundException {
        return creditService.getProfessionnelById(id);
    }

    @GetMapping
    public List<ProfessionnelDTO> getAll() {
        return creditService.getAllProfessionnel();
    }
}
