@SearchHotel
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Verifying Adactin login with valid credentials and Entering Details
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify msg after Search Hotel "Select Hotel"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 03/03/23    | 04/03/23     | 1 - One | 0 - None |

  Scenario Outline: Verifying Adactin login with valid credentials and Entering only mandatory details
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the mandatory details "<location>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>" and "<adults>"
    Then User should verify msg after Search Hotel "Select Hotel"

    Examples: 
      | userName     | password | location | noOfRooms | checkInDate | checkOutDate | adults  |
      | Sivasankaran | Siva1983 | Sydney   | 1 - One   | 03/03/23    | 04/03/23     | 1 - One |

  Scenario Outline: Verifying Adactin login with valid credentials and Entering Details with greater check in date
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should enter the details "<location>", "<hotels>", "<roomType>", "<noOfRooms>", "<checkInDate>", "<checkOutDate>", "<adults>" and "<children>"
    Then User should verify date error msg after Search Hotel "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName     | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adults  | children |
      | Sivasankaran | Siva1983 | Sydney   | Hotel Creek | Standard | 1 - One   | 05/03/23    | 04/03/23     | 1 - One | 0 - None |

  Scenario Outline: Verifying Adactin login with valid credentials and Entering with out filling details
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"
    When User should not enter the details
    Then User should verify select location error msg after Search Hotel "Please Select a Location"

    Examples: 
      | userName     | password |
      | Sivasankaran | Siva1983 |
