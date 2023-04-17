@tag
Feature: Test case 01

  @tag2
  Scenario Outline: open new tab
    Given I launch browser <url>
    When I click on open Tab btn
    Then I open new tab and go back

    Examples: 
      | url | 
      | https://rahulshettyacademy.com/AutomationPractice/ |   
      
