package jp.kobe_u.cs.daikibo.RakuLack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.RakuLack.dto.BookshelfForm;
import jp.kobe_u.cs.daikibo.RakuLack.entity.Bookshelf;
import jp.kobe_u.cs.daikibo.RakuLack.repository.BookshelfRepository;

@Service
public class BookshelfService {
    @Autowired
    BookshelfRepository bsRepo;
    
    //本棚を作成する
    public Bookshelf createBookshelf(String uid, BookshelfForm form){
        Bookshelf bs = form.toEntity();
        bs.setUid(uid);
        System.out.println(bs);
        System.out.println(bs.getBsid());

        return bsRepo.save(bs);
    }

    public List<Bookshelf> getBookshelfList(String uid){
        return bsRepo.findByUid(uid);
    }
}
