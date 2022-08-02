package jp.kobe_u.cs.daikibo.RakuLack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    // タイトル画面を表示
    @PostMapping("/main")
    String showIndex(@RequestParam("userid") String userid, Model model) {
        model.addAttribute("uid", userid);
        return "{uid}/menu";
    }
}
