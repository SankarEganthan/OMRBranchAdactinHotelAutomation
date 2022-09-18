@Login
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Verifying Adactin login with valid credentials
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify success msg after login "Hello Sivasankaran!"

    Examples: 
      | userName     | password |
      | Sivasankaran | Siva1983 |

  Scenario Outline: Verifying Adactin login with valid credentials with Enter
    Given User is on the adactin page
    When User should perform login "<userName>", "<password>" with Enter key
    Then User should verify success msg after login "Hello Sivasankaran!"

    Examples: 
      | userName     | password |
      | Sivasankaran | Siva1983 |

  Scenario Outline: Verifying Adactin login with Invalid credentials
    Given User is on the adactin page
    When User should perform login "<userName>" and "<password>"
    Then User should verify after login error contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password |
      | Skgdsh   | Sdukug   |
