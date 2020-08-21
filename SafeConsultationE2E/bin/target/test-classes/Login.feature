Feature: Log in to SafeConsultation

	Scenario: A patient creates an account
		Given The User is on the login page
		When The User clicks the patient button
		When The User clicks the signup button
		Then The signup page is open
		When The User types "KoopaQuick" into the create username field
		When The User types "Cantcatchme" into the create password field
		When The User types "19" into the create age field
		When The User types "80" into the create weight field;
		When The User types "48" into the create height field;
		When The User types "O-" into the create blood type field;
		When The User clicks the submit signup button
		Then The User is on the Patient page
		
	Scenario: A patient logs into their account
		Given The User is on the login page
		When The User clicks the patient button
		When The User types "Anna O." into the login username field
		When The User types "Frozen" into the login password field
		When The user clicks the login button
		Then The User is on the Patient Page
		
	Scenario: A doctor creates an account
		Given The User is on the login page
		When The User clicks the doctor button
		When The User clicks the signup button
		Then The signup page is open
		When The User types "drBowser" into the create username field
		When The User types "Baddie123" into the create password field
		When The User types "Cardiologist" into the create specialty field
		When The User clicks the submit signup button
		Then The User is on the Doctor page
		
	Scenario: A doctor logs into their account
		Given The User is on the login page
		When The User clicks the doctor button
		When The User types "drSleep" into the login username field
		When The User types "Overlook..." into the login password field
		When The user clicks the login button
		Then The User is on the Doctor Page