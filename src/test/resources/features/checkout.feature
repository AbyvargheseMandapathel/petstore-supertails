
@tag
Feature: Checkout functionality of Supertails
 Background:
    Given  add items to the shopping cart
    And open the cartPage
    And click the checkout button
    
    
  @tag1
  Scenario: Submit the Checkout form with null values
  
    When click the continue shopping button
    Then the error message should be displayed
   

  @tag2
  Scenario Outline: Submit the Checkout form with valid values
   And enter the valid email <email>
   
   And enter the valid first name <fname>
   And enter the valid last name <lname>
   And enter the valid address <address>
   And enter the valid apartment <apartment>
   And enter the valid city <city>
   And select the state <state>
   And enter the valid pincode <pincode>
   And enter the valid phonenumber <phnno>
   When click the continue shopping button
    Then Navigate to next page

Examples:
  | email            | fname   | lname      | address     | apartment | city | state  | pincode | phnno       |
  | sobha@gmail.com  | sobha   | soniya     |  MainSt     | Apt101    | tvm  | Kerala | 695582  | 8798456326  |
  
@tag2
  Scenario Outline: Submit the Checkout form with invalid values
   And enter the invalid email <email>
   
   And enter the invalid first name <fname>
   And enter the invalid last name <lname>
   And enter the invalid address <address>
   And enter the invalid apartment <apartment>
   And enter the invalid city <city>
   And select the state <state>
   And enter the invalid pincode <pincode>
   And enter the invalid phonenumber <phnno>
   When click the continue shopping button
    Then appropriate error message should be displayed
Examples:
  | email    | fname | lname  | address     | apartment | city | state  | pincode | phnno      |
  | 12345    | 123   | 000    | 123         | 101       | 876  | Kerala | fgdrbh  | 1234567890 |
  

