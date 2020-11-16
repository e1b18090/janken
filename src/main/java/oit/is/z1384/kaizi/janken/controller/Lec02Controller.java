package oit.is.z1384.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.lang.reflect.Array;

import oit.is.z1384.kaizi.janken.model.Janken;

import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z1384.kaizi.janken.model.User;
import oit.is.z1384.kaizi.janken.model.UserMapper;
import oit.is.z1384.kaizi.janken.model.Entry;


@Controller
public class Lec02Controller {
  @PostMapping("/lec02")
  public String lec02(@RequestParam String name,ModelMap model) {
    name ="Hi "+name;
    model.addAttribute("name",name);
    return "lec02.html";
  }

  /*@GetMapping("/lec02")
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
  */

  /*@Autowired
  private Entry entry;

  @GetMapping("/lec02")
  public String lec03janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);

    return "lec02.html";
  */
  @Autowired
  private UserMapper userMapper;

  private int userid;
  @GetMapping("/lec02")
  @Transactional
  public String lec04(ModelMap model, Principal prin) {
    String loginUser = prin.getName();
    this.entry.adduser(loginUser);
    model.addAttribute("entry", this.entry);
    model.addAttribute("loginUser", loginUser);
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
    ArrayList<Match> matches = matchMapper.selectAllMatches();
    model.addAttribute("matches", matches);
    return "lec02.html";
  }
  }

}
