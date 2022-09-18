@CancelBooking
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Verifying Adactin login with valid credentials, Entering Details, by selecting Hotel, providing personal & payment details and Cancel booking
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
    When User should cancel the booking order id
    Then User should verify succes msg after cancelling the booking order id "The booking has been cancelled."

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children | firstName | lastName | billingAddress |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 22/09/2022  | 23/09/2022   | 1 - One | 0 - None | Bala      | E        | Chennai        |

  Scenario Outline: Verifying Adactin login with valid credentials and cancel booking with existing orderid
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should cancel the booking with existing order id
      
      | J8GE15NG7D |
      | 259GO894Y5 |
      | GRW50R8911 |
      | OLNRTQF794 |
      | MB9O78U71C |
    Then User should verify succes msg after cancelling the booking with existing order id "The booking has been cancelled."

    Examples: 
      | userName     | password |
      | Sivasankaran | Siva1983 |
