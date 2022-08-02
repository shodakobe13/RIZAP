package jp.kobe_u.cs.daikibo.RakuLack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.RakuLack.dto.BookForm;
import jp.kobe_u.cs.daikibo.RakuLack.entity.Book;
import jp.kobe_u.cs.daikibo.RakuLack.exception.AppException;
import jp.kobe_u.cs.daikibo.RakuLack.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;

    /**
     * 本データを作成する
     * @param book
     * @return
     */
    public Book createBook(String uid, BookForm form) {
        String title = form.title;
        Book book = new Book(null, uid, title, form.width, form.height, form.length);
        if (bookRepo.existsByTitle(title)) {
            throw new AppException(AppException.BOOK_NOT_FOUND, title + " already exists.");
        }
        return bookRepo.save(book);
    }


    /**
     * あるユーザーが登録した本一覧を取得する
     * @param uid
     * @return
     */
    public List<Book> getBookList(String uid) {
        List<Book> books = bookRepo.findByUid(uid);
        return books;
    }

}
