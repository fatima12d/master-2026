package sn.isi.master2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.isi.master2.dto.MembreDto;
import sn.isi.master2.entity.Book;
import sn.isi.master2.entity.Membre;
import sn.isi.master2.exception.NotfoundBookException;
import sn.isi.master2.mapper.BookMapper;
import sn.isi.master2.mapper.MembreMapper;
import sn.isi.master2.repository.MembreRepository;
import sn.isi.master2.service.IMembre;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MembreService implements IMembre {

    private final MembreRepository membreRepository;
    @Override
    public MembreDto save(MembreDto membreDto) {
        log.info("Start create Membre  services {}",membreDto);
        return MembreMapper.toDTO(membreRepository.save(MembreMapper.toEntity(membreDto)));
    }

    @Override
    public MembreDto update(int id, MembreDto membreDto) {
        if(getById(id)!=null){
            membreDto.setId(id);
        }
        return  MembreMapper.toDTO(membreRepository.save(MembreMapper.toEntity(membreDto)));
    }

    @Override
    public void delete(int id) {
        getById(id);
        membreRepository.deleteById(id);

    }

    @Override
    public MembreDto getById(int id) {
        Optional<Membre> membre = Optional.of(membreRepository.findById(id).orElseThrow(
                () -> new NotfoundBookException("id nexiste pas")
        ));
        return MembreMapper.toDTO(membre.get());
    }

    @Override
    public List<MembreDto> getAll() {
      return   membreRepository.findAll().stream().map(MembreMapper::toDTO).toList();
    }
}
