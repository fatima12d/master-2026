package sn.isi.master2.service;

import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.dto.MembreDto;

import java.util.List;

public interface IMembre {
    MembreDto save(MembreDto membreDto);
    MembreDto update(int id,MembreDto membreDto);
    void  delete(int id);
    MembreDto getById(int id);
    List<MembreDto> getAll();
}
