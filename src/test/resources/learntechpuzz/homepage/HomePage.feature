@focus
Feature: learntechpuzz Submit Feedback
Verify if user is able to submit feedback

  Scenario: Submit Feedback
    Given User is on Home Page
     When User navigate to Feedback Page
      And User enter the following data and click on Submit button
      | firstName | lastName | email          | mobile     | comments | 
      | Guest     | User     | guest@mail.com | 9677042707 | Thanks learntechpuzz, I could able to run this pipeline. !!! | 
     Then Success message is displayed
