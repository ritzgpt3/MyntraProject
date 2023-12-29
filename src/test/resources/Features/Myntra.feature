Feature: Testing functionality of Myntra site

Scenario: Verify when user selects particular brand name then all results must appear of that brand.
	Given Enter Flats in search component
	When User clicks on a particular brand checkbox
	Then All results populated must be of selected brand
	
Scenario: Verify when user clicks on price range checkbox then populated all results must be in selected price range
	 Given Search for Sneakers
	 When User clicks on price range checkbox
	 Then All results populated must be in selected price range
	 
Scenario: Verify when user selects a product then that product should have product details
	Given Enter Flats in search component
	When User selects a product
	Then Product must contain product details
	
Scenario: Verify when user clicks on giftcard and select an occasion then giftcard must appear related to selected occasion
	Given Click on profile icon and select giftcard option
	When User select an occasion
	Then Giftcard should appear related to the selected occasion
	
Scenario: Verify when user clicks on Youtube icon then it must redirect the page to youtube website.
	Given Open myntra site and scroll down
	When User clicks on youtube icon
	Then Verify if it is YouTube website
	
Scenario: Verify when user clicks on instagram icon then user should be able to interact with instagram Page 
	Given Open myntra site and scroll down
	When User clicks on instagram icon
	Then User should be able to interact with instagram Page
	
Scenario: Verify when users selects a product then that product must have appropriate size guide chart
	Given Click on men shirts
	When User selects a shirt product
	Then Product must have appropriate size guide chart
	
Scenario: Verify when user checks PhonePe faqs then questions must be relevant to PhonePe
	Given Open myntra and scroll to FAQ option
	When User checks PhonePe faqs
	Then Questions must be relevant to PhonePe

Scenario: Verify when user clicks on promotional banner then it should redirect to product results
	Given Open myntradiv[data-reactid="906"]
	When User clicks on promotional banner
	Then It should redirect to product results
	
Scenario: Verify the functionality of BreadCrumb Navigation
	Given Enter Flats in search component
	When User selects a product
	Then All links in breadcrumbs must be interactable
	
Scenario: Verify when user cliks on a blog content then it should be interactable
	Given Open myntra and select blog option
	When User clicks on a blog content
	Then Blog content should be interactable
	
Scenario: Verify Low To High Price Selection Functionality
	Given Open myntra and search for Jordan
	When User clicks selects low to high price option from dropdown
	Then Populated products should be in order of low to high price range
	
#----------------------------------------------------------------------------------------------------------------

Scenario: Verify when user searches 
Given Enter Levis in Search Component
When User clicks on search magnifier
Then All results populated must contain word Levis in it.

Scenario: Verify the functionality of Go to cart
Given Enter Women T-Shirt in Search Component
When User clicks on search magnifier
Then The Result Shopping Bag Contains Tshirt

Scenario: Verify the functionality of pincode text box with Invalid input
Given Enter Women T-Shirt in Search Component
When User Enters Pincode
Then The Result Display Error Message For Invalid Input.

Scenario: Verify The Functionality Of Brand CheckBox
Given Enter Watches in Search Field
When Click On Watch Product
Then The Result Watch Brand Should Be Fastrack

Scenario: Verify The Functionality Of Delivery Pincode With Valid Input()
Given Enter Women T-Shirt in Search Component
When click Women T-Shirt Product
Then The Result Display Delievery Date and time Message For Valid Input

Scenario: Verify The Functionality Of Add To Cart Button
Given Enter Product Name in Search Component
When Click On selected Product
Then The Result Display selected product added in Shopping Bag

Scenario: Verify The Functionality Of Shopping Bag If Cart Is Empty
Given Select Shopping Bag
When Click On shopping Bag
Then The Result Display Error Message If Cart Is Empty