package bdcc.elmourabit.elhoucine.web;

import bdcc.elmourabit.elhoucine.dtos.RemboursementDTO;
import bdcc.elmourabit.elhoucine.exceptions.RemboursementNotFoundException;
import bdcc.elmourabit.elhoucine.services.RemboursementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remboursements")
@AllArgsConstructor
@CrossOrigin("*")
public class RemboursementRestController {

    private final RemboursementService remboursementService;

    @PostMapping
    public RemboursementDTO save(@RequestBody RemboursementDTO dto) throws RemboursementNotFoundException {
        return remboursementService.saveRemboursement(dto);
    }

    @GetMapping("/{id}")
    public RemboursementDTO get(@PathVariable Long id) throws RemboursementNotFoundException {
        return remboursementService.getRemboursement(id);
    }

    @GetMapping
    public List<RemboursementDTO> getAll() {
        return remboursementService.listRemboursements();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }
}