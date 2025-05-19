package bdcc.elmourabit.elhoucine.dtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {

    private Long id;
    private String nom;
    private String email;

}

