package jp.kobe_u.cs.daikibo.RakuLack.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import jp.kobe_u.cs.daikibo.RakuLack.dto.BookForm;
import jp.kobe_u.cs.daikibo.RakuLack.entity.Book;
import jp.kobe_u.cs.daikibo.RakuLack.service.BookService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    /**
     * あるユーザーが登録している本の一覧を表示する
     * @param uid
     * @param model
     * @return
     */
    @GetMapping("/{uid}/book")
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
    @GetMapping("/{uid}/book/create")
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
    @PostMapping("/{uid}/book/register")
    public String confirmRegisteredBook(@ModelAttribute(name = "BookForm") @Valid BookForm form, BindingResult bindingResult, @PathVariable String uid, Model model) {
        if (bindingResult.hasErrors()) {
            return showScreenForCreateBook(uid, model);
        }
        Book book = bookService.createBook(uid, form);
        model.addAttribute("book", book);
        model.addAttribute("uid", uid);
        return "registered_book";
    }




}
