@Avansas
Feature: ToDo list

  Scenario: Add the first item to the TODO list
    Given Kullanıcı "https://www.avansas.com/" sitesine gider.
    When Avansas.com da arama alanına "kalem" yazılarak ara butonu tıklanır.
    And Kategori listesinden "Kurşun Kalemler" kategorisi tıklanır.
    And Sıralama fonksiyonundan ada göre sırala seçilir.
    And Gelen ürün listesinde adında "Bic Evolution" içeren kaç ürün olduğu tespit edilir.
    Then Ürün adeti tespit edilir ve 0 dan fazla ise test başarılıdır, 0 ise başarısızdır.