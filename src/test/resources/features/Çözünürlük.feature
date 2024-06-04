Feature: Responsivlik testleri

  Scenario Outline: Farklı cihazlarda responsivlik testi
    Given Kullanıcı <deviceName> cihazını kullanarak web sitesini ziyaret eder
    When Sayfa yüklenir
    Then Sayfanın responsivliği kontrol edilir <deviceSize>

    Examples:
      | deviceName | deviceSize |
      | Mobile     | 400x800    |
      | Tablet     | 768x1024   |
      | Laptop     | 1366x768   |