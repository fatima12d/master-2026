package sn.isi.master2.mapper;

import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.dto.MembreDto;
import sn.isi.master2.entity.Book;
import sn.isi.master2.entity.Membre;

public class MembreMapper {
    public static MembreDto toDTO (Membre membre) {

        return MembreDto.builder().
                id(membre.getId()).
                name(membre.getName()).
                telephone(membre.getTelephone()).
                email(membre.getEmail()).
                address(membre.getAddress()).
               build();

    }


    public static Membre toEntity (MembreDto membreDto) {
        return Membre.builder().
                id(membreDto.getId()).
                name(membreDto.getName()).
                telephone(membreDto.getTelephone()).
                email(membreDto.getEmail()).
                address(membreDto.getAddress()).
                build();

    }
}
