Feature: Add Place API

Scenario: Verify place added successfully
Given API ADD place Paylod
When user calls "AddPlaceApi" with post request
Then Place should add successfully with STATUS code 200
And "STATUS" in response body is "OK"
And "SCOPE" in response body is "APP"