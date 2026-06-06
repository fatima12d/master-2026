package sn.isi.master2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.dto.MembreDto;
import sn.isi.master2.repository.MembreRepository;
import sn.isi.master2.service.impl.MembreService;

import java.util.List;

@RestController
@RequestMapping("/api/membre")
@Slf4j
@RequiredArgsConstructor
public class MembreController {
    private final MembreService membreService;

    @PostMapping
    ResponseEntity<MembreDto> save(@RequestBody MembreDto membreDto){
        log.info("Start create membre controller {}",membreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.membreService.save(membreDto)) ;
    }

    @PutMapping("/{id}")
    MembreDto update(@PathVariable int id,@RequestBody MembreDto membreDto){
        return this.membreService.update(id,membreDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        this.membreService.delete(id);
    }

    @GetMapping("/{id}")
    MembreDto getById(@PathVariable int id){
        return  this.membreService.getById(id);
    }

    @GetMapping
    List<MembreDto> getAll(){
        return this.membreService.getAll();
    }

}
