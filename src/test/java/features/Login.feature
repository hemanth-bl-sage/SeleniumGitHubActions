Feature: LoginFeature
  This feature is responsible for testing all the scenarios for login of the application

  Scenario: Check login with correct companyId, userId and password
    And I see application is launched
    Then I click on Login link
    When I enter companyId, userId and password
      |companyId              |userId |password   |
      |Retainage-new-main_00  |Admin  |Aa123456!  |
    Then I click on sign in
    Then I should be successfully logged into Homepage