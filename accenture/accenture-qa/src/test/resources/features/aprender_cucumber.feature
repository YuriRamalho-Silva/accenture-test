
Feature: : Buy laptops
		#As a father of Max, Annie, and noah
		#I Want to order a new laptop for my child
		#So I can get some rest while she plays


	Scenario: : Should buy a new laptop
		Given my kids wants a new laptop
		And add some new "MacBook air"
		And insert the credit details name: "Percy Clayton", country: "Portugal", city: "Lisbon", card: "375567668884617", month: "Month: 02", year: "2030"
		Then back to home
		And add some new "MacBook Pro"
		And insert the credit details name: "Percy Clayton", country: "United States", city: "Jacksonville", card: "4411732769254916", month: "4", year: "2029"
		Then back to home
		And add some new "2017 Dell 15.6 Inch"
		And insert the credit details name: "Percy Clayton", country: "Portugal", city: "Jacksonville", but forgot the credit card parameters
		Then an alert appears
		And card details are requested
		Then back to home
		And close the application



 