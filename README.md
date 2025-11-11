# Tool Rental Application

## Steps for Running Validation

This application is a Maven project. You can build and run all tests by running:

```sh
mvn clean package
```

This will compile the code, run all tests, and package the application. There is special output to make it easier to find the validation results.

If you would like to provide custom input to this application, you can do so by hitting the following endpoint:

```
http://localhost:8080/api/rent
```

### How to Run

1. **Build and package the application using Maven:**
   ```sh
   mvn clean package
   ```
2. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
3. **Send requests using curl (Windows Command Prompt examples):**

#### Example Requests

```sh
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 5, \"discountPercentage\": 101, \"checkoutDate\": \"9/3/15\"}" http://localhost:8080/api/rent
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"LADW\", \"rentalDayCount\": 3, \"discountPercentage\": 10, \"checkoutDate\": \"7/2/20\"}" http://localhost:8080/api/rent
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"CHNS\", \"rentalDayCount\": 5, \"discountPercentage\": 25, \"checkoutDate\": \"7/2/15\"}" http://localhost:8080/api/rent
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKD\", \"rentalDayCount\": 6, \"discountPercentage\": 0, \"checkoutDate\": \"9/3/15\"}" http://localhost:8080/api/rent
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 9, \"discountPercentage\": 0, \"checkoutDate\": \"7/2/15\"}" http://localhost:8080/api/rent
curl -X POST -H "Content-Type: application/json" -d "{\"toolCode\": \"JAKR\", \"rentalDayCount\": 4, \"discountPercentage\": 50, \"checkoutDate\": \"7/2/20\"}" http://localhost:8080/api/rent
```

4. **You should see a response like the following:**

```
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
```

5. You can change the parameters in the curl command to whatever you want to test.

---

## Notes

- This application runs with Java, Maven, and Spring Boot.
- The rental agreement is an object that generates the rental agreement details based on the input provided by the user.
- It contains a method to print the rental agreement to the command line in the format specified by the exercise requirements.
- This is automatically done when the application is run and the endpoint specified above is hit or the tests are run.
- When the tests are run, there will be output to make it easy for the viewer to see the results. The tests being output are validation for the exercise requirements.
