package jp.kobe_u.cs.daikibo.RakuLack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobe_u.cs.daikibo.RakuLack.form.UidForm;

@Controller
public class MainController {
    // タイトル画面を表示
    @GetMapping("/")
    String showIndex(Model model) {
        UidForm uform = new UidForm();
        model.addAttribute("uidform", uform);
        return "login";
    }

    @PostMapping("/login")
    String handleLogin(Model model, @ModelAttribute UidForm form) {
        String uid = form.getUid();
        return "redirect:" + uid + "/menu";
    }

    @GetMapping("/{uid}/menu")
    String showMenu(@PathVariable String uid, Model model) {
        model.addAttribute("uid", uid);
        return "menu";
    }
}
