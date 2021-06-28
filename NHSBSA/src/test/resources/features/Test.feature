Feature: Person from Wales need know to what help he can get with NHS costs

	@test
  Scenario: Person from Wales need to know what help he can get with NHS costs
    Given I go to url https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start
    When I am a person from 'Wales' and I enter my dob "20" "10" "1970" and click next button
    Then I put my circumstances into the Checker tool
    And  I should get a result of whether I will get help or not
    
   @test
  Scenario: Person from Wales need to know what help he can get with NHS costs with 'No' partner
  	Given I access url https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start
    When I am a person from 'Wales' and I enter my dob "30" "11" "1980" and click next
    Then I put my circumstances into the Checker tool with no partner
    And  I should get a result of whether I will get help?