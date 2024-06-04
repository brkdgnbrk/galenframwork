Feature: Masa İşlemleri

  Background: Scenario: Successful login with valid credentials
    When I enter valid email and password
    And I click on the Giriş Yap button
    Then I should see the homepage



  @EndToEndTest
  Scenario: Masa işlemleri adımları
    When I click on the SATIŞLAR button
    And I click on the Masa 11 button
    And I enter the Lahana Çorbası
    And I enter the Pazı Yemeği
    And I click on the ÖDEME AL button
    And I enter İskonto 50 TL
    And I click on the Kaydet button
    And I pay 50 Tl in cash
    And I pay the remaining amount by credit card
    Then I should see the table payment confirmation