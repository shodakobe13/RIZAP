package jp.kobe_u.cs.daikibo.RakuLack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LayoutController {

  @GetMapping("/{uid}/layout/create")
  String layoutForm(@PathVariable String uid, Model model) {
    model.addAttribute("uid", uid);
    return "createlayout1";
  }

  @PostMapping("/{uid}/layout")
  String createLayout(@PathVariable String uid, Model model) {
    return "redirect:/" + uid + "/layout/created";
  }

  @GetMapping("/{uid}/layout/created")
  String createdLayout(@PathVariable String uid, Model model) {
    model.addAttribute("uid", uid);
    return "createdlayout";
  }

  @GetMapping("/{uid}/layout")
  String showLayout(@PathVariable String uid, Model model) {
    model.addAttribute("uid", uid);
    return "showlayout";
  }
}
