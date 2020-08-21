Feature: Doctor sees a patient

	Background: A doctor logs into their account
		Given The User is on the login page
		When The User clicks the doctor button
		When The User types "" into the login username field
		When The User types "" into the login password field
		When The user clicks the login button
		Then The User is on the Doctor Page
		
	Scenario: A doctor wants to update an appointment
	#	Given The User is on the doctor page
		When The User clicks the appointment tab button
		Then The appointments tab is open
		When The User clicks the more info button
		Then The update appointment popup appears
		When The User clicks cancel appointment
		Then The appointments tab is open
		Then Appointment "" has status cancelled
		
	Scenario: A doctor wants to view patient information
		#Given The User is on the doctor page
		When The User clicks the patient tab button
		Then The patient tab is open
		Then the first patient is ""
		
	Scenario: A doctor wants to update their specialty
		#Given The User is on the doctor page
		When the User clicks the account information tab button
		When The User types "" into the specialty field
		When The User click the update button
		Then The User's specialty is ""
