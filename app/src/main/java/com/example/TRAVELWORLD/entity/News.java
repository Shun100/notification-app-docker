package com.example.TRAVELWORLD.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アノテーションの説明
 * @Data - Setter, Getter, toString, equalsメソッドを自動生成する。
 * @Entity - エンティティであることを表す。
 * @AllArgsConstructor - 引数ありのコンストラクタを自動生成する。
 * @NoArgsConstructor - 引数なしのコンストラクタを自動生成する。
 * @GeneratedValue - 主キー用にauto incrementを設定する。
 * @Id - 主キーであることを表す。
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private int id;
  private Date newsDate;
  private String newsText;
}
