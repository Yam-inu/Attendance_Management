// package com.example.mynavi.sql;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class SqlConnect {
  public static void main(String[] args) {
    try (Connection db = DriverManager.getConnection(
      "jdbc:mysql://localhost/sample?serverTimezone=JST&useUnicode=true&characterEncoding=UTF-8&useSSL=true", "root", "toor")) {
      System.out.println("接続しました。");
    } catch (SQLException e) {
      System.out.println("接続エラー：" + e.getMessage());
    }
  }
}