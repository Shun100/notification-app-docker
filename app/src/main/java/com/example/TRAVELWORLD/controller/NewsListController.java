package com.example.TRAVELWORLD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TRAVELWORLD.service.NewsService;

/**
 * アノテーションの説明
 * @Controlelr - コントローラクラスであることを表す。
 * @RequestMapping - URLを指定する。
 * @GetMapping - GETリクエスト受信時の処理であることを表す。
 */

@Controller
@RequestMapping("/")
public class NewsListController {
  @Autowired
  private NewsService newsService;

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("newsList", newsService.findAll());
    return "index";
  }
}
