package sn.isi.master2.mapper;

import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.entity.Book;

public class BookMapper {

  public static BookDTO toDTO (Book book){

    return  BookDTO.builder().
              id(book.getId()).
              titre(book.getTitle()).
              auteur(book.getAuteur()).
              price(book.getPrix()).
              disponible(book.isAvailable())
              .build();
   }


   public static Book toEntity (BookDTO bookDTO){
      return Book.builder().
              id(bookDTO.getId()).
              title(bookDTO.getTitre()).
              auteur(bookDTO.getAuteur()).
              prix(bookDTO.getPrice()).
              available(bookDTO.isDisponible()).
              build();

   }
}
