package com.example.TRAVELWORLD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TRAVELWORLD.entity.News;
import com.example.TRAVELWORLD.repository.NewsRepository;

/**
 * アノテーションの説明
 * @Service - サービスクラスであることを表す。
 * @Autowired - DIコンテナからインスタンスを取得する。
 */

@Service
public class NewsServiceImpl implements NewsService {
  // DIコンテナから自動的にインスタンスを取得する。
  @Autowired
  private NewsRepository newsRepository;

  /**
   * 新着情報一覧取得
   * @return newsList List<News> - 新着情報一覧
   */
  @Override
  public List<News> findAll() {
    return newsRepository.findAll();
  }

  /**
   * 新着情報登録
   * @param news News - 新着情報
   * @return isSaved boolean - 登録可否
   */
  @Override
  public boolean saveAndFlush(News news) {
    try {
      newsRepository.saveAndFlush(news);
      return true;
    } catch (Exception e) {
      return false;
    }
  } 
}
