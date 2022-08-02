package jp.kobe_u.cs.daikibo.RakuLack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jp.kobe_u.cs.daikibo.RakuLack.dto.BookForm;
import jp.kobe_u.cs.daikibo.RakuLack.entity.Book;
import jp.kobe_u.cs.daikibo.RakuLack.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * あるユーザーが登録している本の一覧を表示する
     * @param uid
     * @param model
     * @return
     */
    @GetMapping("/{uid}")
    public String showBookList(@PathVariable String uid, Model model) {
        List<Book> books = bookService.getBookList(uid);
        model.addAttribute("Books", books);
        model.addAttribute("uid", uid);
        return "book_list";
    }

    /**
     * 本の登録画面を表示する
     * @param uid
     * @param model
     * @return
     */
    @GetMapping("/{uid}/create")
    public String showScreenForCreateBook(@PathVariable String uid, Model model) {
        BookForm form = new BookForm();
        model.addAttribute("BookForm", form);
        model.addAttribute("uid", uid);
        return "register_book";
    }

    /**
     * 登録した本の情報を表示する
     * @param form
     * @param uid
     * @param model
     * @return
     */
    @PostMapping("/{uid}/register")
    public String confirmRegisteredBook(@ModelAttribute(name = "BookForm") BookForm form, @PathVariable String uid, Model model) {
        Book book = bookService.createBook(uid, form);
        model.addAttribute("book", book);
        model.addAttribute("uid", uid);
        return "registered_book";
    }




}
