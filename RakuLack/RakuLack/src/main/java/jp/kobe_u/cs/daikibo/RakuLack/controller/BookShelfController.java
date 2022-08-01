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

import jp.kobe_u.cs.daikibo.RakuLack.dto.BookshelfForm;
import jp.kobe_u.cs.daikibo.RakuLack.entity.Bookshelf;
import jp.kobe_u.cs.daikibo.RakuLack.service.BookshelfService;

@Controller
@RequestMapping("/")
public class BookShelfController {
    @Autowired
    BookshelfService bsService;

    @GetMapping("/{uid}/bookshelf")
    String showBookshelf(@PathVariable String uid, Model model){
        BookshelfForm bsForm = new BookshelfForm();
        model.addAttribute("BookshelfForm", bsForm);
        List<Bookshelf> list = bsService.getBookshelfList(uid);
        model.addAttribute("BookshelfList", list);

        return "bookshelf";
    }

    @PostMapping("/{uid}/bookshelf/check")
    String checkBookshelfForm(@PathVariable String uid, @ModelAttribute(name="BookshelfForm") BookshelfForm form, Model model){
        model.addAttribute("BookshelfForm", form);
        return "bookshelfcheck";
    }

    @PostMapping("/{uid}/bookshelf/register")
    String registerBookshelf(@PathVariable String uid, @ModelAttribute(name="BookshelfForm") BookshelfForm form, Model model){
        Bookshelf bs = bsService.createBookshelf(uid, form);
        model.addAttribute("BookshelfForm", bs);
        return "bookshelfregistered";
    }

}
