package sn.isi.master2.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.service.impl.BookService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;


    @PostMapping
    ResponseEntity<BookDTO> save(@RequestBody BookDTO book){
        log.info("Start create book controller {}",book);
       return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.save(book)) ;
    }

    @PutMapping("/{id}")
    BookDTO update(@PathVariable int id,@RequestBody BookDTO book){
        return this.bookService.update(id,book);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        this.bookService.delete(id);
    }

    @GetMapping("/{id}")
    BookDTO getById(@PathVariable int id){
       return  this.bookService.getById(id);
    }

    @GetMapping
    List<BookDTO> getAll(){
        return this.bookService.getAll();
    }



}
