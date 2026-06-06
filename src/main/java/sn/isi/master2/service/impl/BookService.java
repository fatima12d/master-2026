package sn.isi.master2.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.entity.Book;
import sn.isi.master2.exception.NotfoundBookException;
import sn.isi.master2.mapper.BookMapper;
import sn.isi.master2.repository.BookRepository;
import sn.isi.master2.service.IBook;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor /*3*/
public class BookService implements IBook {

   /* 2 @Autowired*/
    private final BookRepository bookRepository;



  /* 1  @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    @Override
    public BookDTO save(BookDTO book) {
        log.info("Start create book  services {}",book);
        return BookMapper.toDTO(bookRepository.save(BookMapper.toEntity(book)));
    }

    @Override
    public BookDTO update(int id, BookDTO book) {
        if(getById(id)!=null){
            book.setId(id);
        }
        return  BookMapper.toDTO(bookRepository.save(BookMapper.toEntity(book)));
    }

    @Override
    public void delete(int id) {
        getById(id);
        bookRepository.deleteById(id);;
    }

    @Override
    public BookDTO getById(int id) {
        Optional<Book> book = Optional.of(bookRepository.findById(id).orElseThrow(
                () -> new NotfoundBookException("id nexiste pas")
        ));
        return BookMapper.toDTO(book.get());
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream().map(BookMapper::toDTO).toList();
    }
}
