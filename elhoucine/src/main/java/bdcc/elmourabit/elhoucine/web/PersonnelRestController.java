package bdcc.elmourabit.elhoucine.web;

import bdcc.elmourabit.elhoucine.dtos.PersonnelDTO;
import bdcc.elmourabit.elhoucine.services.CreditService;
import bdcc.elmourabit.elhoucine.services.CreditServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel")
public class PersonnelRestController {
    private CreditService creditService;

    @PostMapping
    public PersonnelDTO save(@RequestBody PersonnelDTO dto) {
        return creditService.savePersonnel(dto);
    }

    @GetMapping("/{id}")
    public PersonnelDTO get(@PathVariable Long id) {
        return creditService.getPersonnelById(id);
    }

    @GetMapping
    public List<PersonnelDTO> getAll() {
        return creditService.getAllPersonnel();
    }
}
