package sn.isi.master2.service;

import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.entity.Book;

import java.util.List;

public interface IBook {
 BookDTO save(BookDTO book);
 BookDTO update(int id,BookDTO book);
 void  delete(int id);
 BookDTO getById(int id);
 List<BookDTO> getAll();
}
