Feature: Responsivlik testleri

  Scenario Outline: Farklı cihazlarda responsivlik testi
    Given Kullanıcı <deviceName> cihazını kullanarak web sitesini ziyaret eder
    When Sayfa yüklenir
    Then Sayfanın responsivliği kontrol edilir <deviceSize>

    Examples:
      | deviceName | deviceSize |
      | Mobile     | 516x802    |
      | Tablet     | 770x965    |
      | Laptop     | 1368x770   |