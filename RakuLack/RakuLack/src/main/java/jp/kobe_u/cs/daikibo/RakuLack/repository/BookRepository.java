package jp.kobe_u.cs.daikibo.RakuLack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.RakuLack.entity.Book;

/**
 * 本レポジトリ
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    boolean existsByTitle(String title);
    List<Book> findByUid(String uid);
}
