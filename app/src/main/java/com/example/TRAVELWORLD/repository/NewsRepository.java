package com.example.TRAVELWORLD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TRAVELWORLD.entity.News;

/**
 * アノテーションの説明
 * @Repository - リポジトリクラスであることを表す。
 */

/**
 * JpaRepositoryを継承すると、基本的なCRUD用メソッドを自動生成する。
 * ジェネリクスには<Entityクラス, 主キーのデータ型>を記述する。
 */

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

}
