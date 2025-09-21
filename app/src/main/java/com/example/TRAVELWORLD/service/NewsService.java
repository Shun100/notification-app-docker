package com.example.TRAVELWORLD.service;

import java.util.List;
import com.example.TRAVELWORLD.entity.News;

public interface NewsService {
  /**
   * 新着情報一覧取得
   * @return newsList List<News> - 新着情報一覧
   */
  List<News> findAll();
  
  /**
   * 新着情報登録
   * @param news News - 新着情報
   * @return isSaved boolean - 登録成否
   */
  boolean saveAndFlush(News news);
}
