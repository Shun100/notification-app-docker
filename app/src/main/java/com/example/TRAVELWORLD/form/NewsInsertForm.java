package com.example.TRAVELWORLD.form;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 * アノテーションの説明
 * @Date - Setter, Getterなどを自動生成する。
 */

@Data
public class NewsInsertForm implements Serializable {
  private Date newsDate;
  private String newsText;
}
