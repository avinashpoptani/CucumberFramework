#1. Authentication for the user upon login
#2. If authentication was successful - send a request to the group aggregation service to return the groups names
#belonging to the user.
#3. Also in charge of inserting new groups and group members to the DB



Feature: Admin API Functionality


  Scenario Outline: Inserting a new group after successful authentication(with different user and password combination) and then validation of the newly created group
#    Given user has access to db
#    Then user create a new user in db
    When the user is authorized
    Then fetch the group Names
  ##  And validate response statuscode is 200
    And validate the following fields in response
      |field1|field2|
      |value1|value2|
#    Then create the new <group> with <values>
#    And validate response statuscode is 200
#    Then fetch the group Names belonging to <user> from group aggregation service
#    And validate response statuscode is 200
    And validate the following fields in response
      |field1|field2|field3|
      |value1|value2|value3|
    Examples:
      |user|
      |value|

  Scenario Outline: Inserting multiple new groups after successful authentication and then validation
  of the newly created group
#    Given user has access to db
#    Then user ctreate a new user in db
#    When the user submits a login request with new <user>
#    Then validate response statuscode is 200
    And validate the following fields in response
      |field1|field2|
      |value1|value2|
#    Then fetch the group Names belonging to <user> from group aggregation service
#    And validate response statuscode is 200
    And validate the following fields in response
      |field1|field2|
      |value1|value2|
#    Then create the new <group> with <values>
#    And validate response statuscode is 200
#    Then fetch the group Names belonging to <user> from group aggregation service
#    And validate response statuscode is 200
    And validate the following fields in response
      |field1|field2|field3|
      |value1|value2|value3|
    Examples:
      |user|
      |value|

  Scenario Outline: Unable to  with incorrect username , password combination
#    Given user has access to db
#    Then user ctreate a new <user> in db
#    When the user submits a login request with  <loginUser> and <password>
#    Then validate response statuscode is 400
    Examples:
      | user  |loginUser|password|
      | value |loginUser|password|

  Scenario: user creation with Incorrect username - less than 6,greater than 15 user,special character user
  6-16 characters.(Validations can be done on API only but as we are inserting data from db we should have check at db as well)

  Scenario: user creation Incorrect passwword - less than 6, greater than 16 length,without special character/number,
  without capital letter and see correspponding error message((Validations can be done on API only but as we are inserting data from db we should have check at db as well))


  Scenario : user should not be able to see the group created from other user


