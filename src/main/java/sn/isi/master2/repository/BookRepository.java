package sn.isi.master2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.master2.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
