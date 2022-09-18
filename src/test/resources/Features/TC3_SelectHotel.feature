@SelectHotel
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Verifying Adactin login with valid credentials, Entering Details and by selecting Hotel
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify msg after Search Hotel "Select Hotel"
    And User should select Hotel Name
    And User should verify success msg after selecting Hotel "Book A Hotel"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 03/03/23    | 04/03/23     | 1 - One | 0 - None |

  Scenario Outline: Verifying Adactin login with valid credentials, Entering Details and without selecting Hotel
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify msg after Search Hotel "Select Hotel"
    And User should continue without selecting any Hotel Name
    And User should verify without selecting any hotel name error msg "Please Select a Hotel"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 03/03/23    | 04/03/23     | 1 - One | 0 - None |
