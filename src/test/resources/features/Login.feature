Feature: Login to the website


  @Positive
  Scenario Outline: Successful login with valid credentials
    Given Kullanıcı <deviceName> cihazını kullanarak web sitesini ziyaret eder
    When Sayfa yüklenir
    When I enter valid email and password
    And I click on the Giriş Yap button
    Then I should see the homepage
    Examples:
      | deviceName |
      | Mobile     |
      | Tablet     |
      | Laptop     |


  @Negative1
  Scenario Outline: <TestCaseNumber> - <TestCaseName>
    When I enter email "<email>" and password "<password>"
    And I click on the Giriş Yap button
    Then I should see an error message

    Examples:
      | TestCaseNumber | TestCaseName                                   | email        | password        |
      | TC01           | Log in with invalid email and invalid password | invalidEmail | invalidPassword |
      | TC02           | Log in with invalid email and valid password   | invalidEmail | validPassword   |
      | TC03           | Log in with valid email and invalid password   | validEmail   | invalidPassword |

  @Negative2
  Scenario Outline: <TestCaseNumber> - <TestCaseName>
    When I enter email "<email>" and password "<password>"
    Then I should see an error message for password or mail
    Examples:
      | TestCaseNumber | TestCaseName                               | email      | password      |
      | TC04           | Log in with empty email and valid password | emptyEmail | validPassword |
      | TC05           | Log in with valid email and empty password | validEmail | emptyPassword |

  @RememberMe
  Scenario Outline: Remember Me button functionality for <deviceName>
    Given Kullanıcı <deviceName> cihazını kullanarak web sitesini ziyaret eder
    When Sayfa yüklenir
    When I enter valid email and password
    And I click on the Beni Hatırla checkbox
    And I click on the Giriş Yap button
    Then I should see the homepage
    When I refresh the page
    Then the Beni Hatırla checkbox should be selected
    Examples:
      | deviceName |
      | Mobile     |
      | Tablet     |
      | Laptop     |

  @ForgotPassword
  Scenario: Forgot Password functionality
    When I click on the Şifremi Unuttum button
    Then I should see the Şifre Hatırlatma text