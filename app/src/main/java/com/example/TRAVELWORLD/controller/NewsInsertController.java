package com.example.TRAVELWORLD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.TRAVELWORLD.form.NewsInsertForm;
import com.example.TRAVELWORLD.service.NewsService;
import com.example.TRAVELWORLD.entity.News;

/**
 * アノテーションの説明
 * @Controller        - コントローラクラスであることを意味する。
 * @RequestMapping    - リクエストを受けるURLを表す。(/newsInsert)
 * @SessionAttributes - ???
 * @Autowired         - DIコンテナから自動的にインスタンスを取得する。
 * @ModelAttribute    - リクエストを受ける度に対象のクラスをインスタンス化し、自動的にModelに追加する。
 * @GetMapping        - Getリクエスト受信時の処理を表す。(/newsInsert)
 * @PostMapping       - Postリクエスト受信時の処理を表す。(/newsInsert/confirm)
 */

@Controller
@RequestMapping("/newsInsert")
@SessionAttributes("newsInsertForm")
public class NewsInsertController {
  @Autowired
  NewsService newsService;
  
  /**
   * リクエストを受ける度にフォーム情報のインスタンスを生成し、Modelに追加する。
   * @return newsInsertForm NewsInsertForm - フォーム情報インスタンス
   */
  @ModelAttribute
  public NewsInsertForm setUpForm() {
    return new NewsInsertForm();
  }

  /**
   * 新着情報登録画面 表示
   * @return newsInsert String - 新規登録画面のHTML
   */
  @GetMapping
  public String entry() {
    return "newsInsert";
  }

  /**
   * 新着情報登録確認画面 表示
   * <p>
   * newsInsert.html内のth:fieldプロパティを通じて、入力フォーム情報がnewInsertFormオブジェクトに格納される。
   * その後、newsInsertFormは、@SessionAttributeアノテーションによりSessionオブジェクトとして保持される。
   * </p>
   * @param newInsertForm NewsInsertForm - 入力フォーム情報
   * @return newsConfirm String  - 新着情報登録確認画面のHTML
   */
  @PostMapping("/confirm")
  public String confirm(NewsInsertForm newInsertForm) {
    return "newsConfirm";
  }

  /**
   * 新着情報登録
   * <p>
   * ・第１引数 newsInsertFormについて
   * newsInsertFormはセッションオブジェクトとして保持されているため、そこから自動的に取得する。(引数としては必要)
   * 
   * ・第２引数 sessionStatusについて
   * Web処理の状態情報を持つインタフェース。セッションオブジェクトを生成したり追加するときは引数に不要だが、削除するときは必要。
   * </p>
   * 
   * SpringのDIの仕様として、必要なオブジェクト（セッション属性、リクエスト情報、モデル、バインディング情報など）は全て引数で宣言する必要がある。引数で宣言しなければDIから注入されないため注意。
   * </p>
   * @param newsInsertForm NewsInsertForm - 入力フォーム情報
   * @param sessionStatus SessionStatus - ???
   * @return newsComplete String - 新着情報登録完了画面のHTML
   */
  @PostMapping("/complete")
  public String complete(NewsInsertForm newsInsertForm, SessionStatus sessionStatus) {
    int id = 0;
    News news = new News(id, newsInsertForm.getNewsDate(), newsInsertForm.getNewsText());
    newsService.saveAndFlush(news);

    /*
     * セッションオブジェクトを破棄する。
     * このように明示的に破棄しない限り残り続けるため注意。
     */
    sessionStatus.setComplete();

    return "newsComplete";
  }
}
