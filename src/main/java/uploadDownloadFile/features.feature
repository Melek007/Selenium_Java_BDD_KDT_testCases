@tag
Feature: Upload Download

  @tag1
  Scenario Outline: Convert File
    Given I Launch browser
    And I Navigate to <url>
    When I Upload <filePath>
    And I Convert file
    Then I Download file

    Examples: 
      | url  | filePath |
      | https://altoconvertpdftojpg.com/ | C:\\Users\\melek\\Downloads\\TestPdf.pdf\\ |
