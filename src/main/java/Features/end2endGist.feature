@end2end
Feature: tests for creating, edit, delete and see all a gist

  @createpublicGist
  Scenario: create public Gist with credential
    Given open browser and go to gist page "https://gist.github.com/"
    When user on gist page
    Then user click signin
    And user input username "shopeetestRahman"
    And user input password "shopeetestrahman2020"
    Then user click button signin
    And open url "https://gist.github.com/"
    Then user input gist description "createpublictest"
    And user input filename "createpublick.xml"
    And user input content "createpublic"
    Then user click button create public gist

 @editexistingGist
  Scenario: edit existing gist
    Given user on gist
    When user click button edit
    Then user input gist description "createpublictest"
    And user input filename "createpublick.xml"
    And user input content "createpublic"
    Then user click button update public gist
    
  @deleteexistingGist
  Scenario: delete existing gist
    Given user on gist
    When user click button delete
    Then user click button confirm delete
    And user on list gist
    
  @mylistGist
  Scenario: see my all gist
    Given user on list gist
    When user click icon profile
    Then user click your gist menu 