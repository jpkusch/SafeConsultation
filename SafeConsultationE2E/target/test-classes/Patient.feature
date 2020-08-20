Feature: Patient gets treatment

	Background: the patient is logged in
		Given The User is on the login page
		When The User clicks the patient button
		When The User types "" into the login username field
		When The User types "" into the login password field
		When The user clicks the login button
		Then The User is on the Patient Page
		
	Scenario: A patient wants to make an appointment
		Given The User is on the Patient Page
		When The User clicks the doctor tab button
		Then The doctor tab is open
		When The User clicks the make an appointment button
		When The make appointment popup appears
		When The User types "" into the symptoms field
		When The User clicks the submit make appointment button
		Then The appointments tab is open
		
	Scenario: A patient wants to update their appointment
		Given The User is on the Patient Page
		When The User clicks the appointment tab button
		Then The appointments tab is open
		When The User clicks the more info button
		Then The update appointment popup appears
		When The User clicks cancel appointment
		Then The appointments tab is open
		Then Appointment "" has status cancelled
		
	Scenario: A patient wants to update their information
		Given The User is on the Patient Page
		When The User clicks the account information tab
		Then The account info tab is open
		When The User types "" into the blood type field
		When The User clicks the update button
		Then The User's blood type is ""