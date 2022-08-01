package jp.kobe_u.cs.daikibo.RakuLack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.RakuLack.entity.Bookshelf;

@Repository
public interface BookshelfRepository extends CrudRepository<Bookshelf, Long>{

    List<Bookshelf> findByUid(String uid);
}
