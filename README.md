Steps for running validation:

This application is a maven project which means you can build and run all tests by running the following:
mvn clean package
This will compile the code, run all tests and package the application.  There is special output to make it 
easier to find the validation results.
If you would like to provide whatever input you want to this application, you can do this by simply hitting this following
endpoint:
http://localhost:8080/api/rent
Below are steps to be able to do this:
1) build and package the application using maven:
   mvn clean package
2) run the application using the following command:
   mvn spring-boot:run
3) Run a curl command as follows (Windows Command Prompt example for each test case):
   Test 1: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 5, \"discountPercentage\": 101, \"checkoutDate\": \"9/3/15\"}" http://localhost:8080/api/rent
   Test 2: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"LADW\", \"rentalDayCount\": 3, \"discountPercentage\": 10, \"checkoutDate\": \"7/2/20\"}" http://localhost:8080/api/rent
   Test 3: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"CHNS\", \"rentalDayCount\": 5, \"discountPercentage\": 25, \"checkoutDate\": \"7/2/15\"}" http://localhost:8080/api/rent
   Test 4: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKD\", \"rentalDayCount\": 6, \"discountPercentage\": 0, \"checkoutDate\": \"9/3/15\"}" http://localhost:8080/api/rent
   Test 5: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 9, \"discountPercentage\": 0, \"checkoutDate\": \"7/2/15\"}" http://localhost:8080/api/rent
   Test 6: curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 4, \"discountPercentage\": 50, \"checkoutDate\": \"7/2/20\"}" http://localhost:8080/api/rent
4) You should see a response like the following:
   Rental Agreement:
   Tool Code: JAKR
   Tool Type: Jackhammer
   Tool Brand: Ridgid
   Rental Days: 4
   Checkout Date: 07/02/20
   Due Date: 07/06/20
   Daily Rental Charge: $2.99
   Charge Days: 1
   Pre Discount Charge: $2.99
   Discount Percentage: 50%
   Discount Amount: $1.50
   Final Charge: $1.49
5) You can change the parameters in the curl command to whatever you want to test.
