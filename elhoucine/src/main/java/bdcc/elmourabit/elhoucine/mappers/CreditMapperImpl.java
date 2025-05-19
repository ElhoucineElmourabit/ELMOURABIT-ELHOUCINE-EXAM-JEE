package bdcc.elmourabit.elhoucine.mappers;

import bdcc.elmourabit.elhoucine.dtos.*;
import bdcc.elmourabit.elhoucine.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {
    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }
    public Client toClient(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return client;
    }
    
    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        dto.setCreditDTO(fromCredit(remboursement.getCredit()));
        return dto;
    }

    public Remboursement toRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        // Le champ Credit doit être injecté ailleurs (service)
        return remboursement;
    }
    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof Immobilier immo) {
            ImmobilierDTO dto = new ImmobilierDTO();
            BeanUtils.copyProperties(immo, dto);
            dto.setType("IMO");
            dto.setClientDTO(fromClient(immo.getClient()));
            dto.setTypeBien(immo.getTypeBien());
            return dto;
        } else if (credit instanceof Personnel per) {
            PersonnelDTO dto = new PersonnelDTO();
            BeanUtils.copyProperties(per, dto);
            dto.setType("PER");
            dto.setClientDTO(fromClient(per.getClient()));
            dto.setMotif(per.getMotif());
            return dto;
        } else if (credit instanceof Professionnel pro) {
            ProfessionnelDTO dto = new ProfessionnelDTO();
            BeanUtils.copyProperties(pro, dto);
            dto.setType("PRO");
            dto.setClientDTO(fromClient(pro.getClient()));
            dto.setMotif(pro.getMotif());
            dto.setRaisonSociale(pro.getRaisonSociale());
            return dto;
        }
        return null;
    }

    public Credit toCredit(CreditDTO dto) {
        if (dto instanceof ImmobilierDTO immoDto) {
            Immobilier immo = new Immobilier();
            BeanUtils.copyProperties(immoDto, immo);
            immo.setClient(toClient(immoDto.getClientDTO()));
            immo.setTypeBien(immoDto.getTypeBien());
            return immo;
        } else if (dto instanceof PersonnelDTO perDto) {
            Personnel per = new Personnel();
            BeanUtils.copyProperties(perDto, per);
            per.setClient(toClient(perDto.getClientDTO()));
            per.setMotif(perDto.getMotif());
            return per;
        } else if (dto instanceof ProfessionnelDTO proDto) {
            Professionnel pro = new Professionnel();
            BeanUtils.copyProperties(proDto, pro);
            pro.setClient(toClient(proDto.getClientDTO()));
            pro.setMotif(proDto.getMotif());
            pro.setRaisonSociale(proDto.getRaisonSociale());
            return pro;
        }
        return null;
    }
}
