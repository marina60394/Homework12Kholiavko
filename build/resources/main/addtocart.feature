Feature: Customer uses site
         As a Customer,
         I want to add product as signed in user
Scenario: Use Home Links
          Given The user opens site sees Home Page
          When He clicks to Sign In link sees Login Page
          When He writes login 'marina60394@gmail.com' and password '65582012marina' data sees My Account Page
          When He clicks to T-Shirt category and sees T-Shirt Page
          When He clicks to product 'Faded Short Sleeve T-shirts' sees Product Page
          Then Breadcrumb on Product Page is 'Women Tops T-shirts Faded Short Sleeve T-shirts'
            When He clicks to button Add to Cart
                      When He clicks to Proceed to Checkout
                      When He clicks to increase quantity
                      Then Total Price is the result of multiply quantity and price
                      When He deletes product
                      Then He sees cart is Empty
                      Then User closes browser
