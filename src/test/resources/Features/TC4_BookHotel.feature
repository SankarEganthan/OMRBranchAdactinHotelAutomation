@BookHotel
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Verifying Adactin login with valid credentials, Entering Details, by selecting Hotel and providing personal & payment details
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify msg after Search Hotel "Select Hotel"
    And User should select Hotel Name
    And User should verify success msg after selecting Hotel "Book A Hotel"
    When User should enter the personal and payment details "<firstName>", "<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvvNumber |
      | 1617181918181900 | American Express | January     |       2022 |       111 |
      | 1617181918181900 | VISA             | February    |       2022 |       112 |
      | 1617181918181900 | Master Card      | March       |       2022 |       113 |
      | 1617181918181900 | Other            | April       |       2022 |       114 |
    Then User should verify success msg after submitting the personal and payment details "Booking Confirmation"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children | firstName | lastName | billingAddress |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 22/09/2022  | 23/09/2022   | 1 - One | 0 - None | Bala      | E        | Chennai        |

  Scenario Outline: Verifying Adactin login with valid credentials, Entering Details, by selecting Hotel and without providing personal & payment details
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify msg after Search Hotel "Select Hotel"
    And User should select Hotel Name
    And User should verify success msg after selecting Hotel "Book A Hotel"
    When User should submit without entering the personal and payment details
    Then User should verify error msg after submitting without the personal and payment details "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 22/09/2022  | 23/09/2022   | 1 - One | 0 - None |
