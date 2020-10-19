package oit.is.z1384.kaizi.janken.controller;

import oit.is.z1384.kaizi.janken.model.Janken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lec02Controller {
  @PostMapping("/lec02")
  public String lec02(@RequestParam String name,ModelMap model) {
    name ="Hi "+name;
    model.addAttribute("name",name);
    return "lec02.html";
  }

@GetMapping("/lec02")
  public String lec02janken(@RequestParam Integer hand, ModelMap model) {
    String Hand;
    String CPU="相手の手 Gu";
    String kekka;
    int result=Janken.playjanken(hand);
    if(result == 0){
      Hand="あなたの手 Gu";
      kekka="Aiko";
      model.addAttribute("Hand",Hand);
      model.addAttribute("CPU",CPU);
      model.addAttribute("kekka",kekka);
    }
    if(result == 1){
      Hand="あなたの手 Choki";
      kekka="You Lose!";
      model.addAttribute("Hand",Hand);
      model.addAttribute("CPU",CPU);
      model.addAttribute("kekka",kekka);
    }
    if(result == 2){
      Hand="あなたの手 Pa";
      kekka="You Win!";
      model.addAttribute("Hand",Hand);
      model.addAttribute("CPU",CPU);
      model.addAttribute("kekka",kekka);
    }
    return "lec02.html";
  }

}
