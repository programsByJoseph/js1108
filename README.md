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

AI Usage Writeup:
For this project I leveraged Copilot to aid me in the building of this application.  I used it to get answers to technical/code questions, to generate boilerplate code and test classes, and finally some of the more complex logic when I thought it may be useful to point out to me where I may be going wrong in my own logic.

I found that Copilot was extremely useful for instances where I had it write boilerplate code like new classes (without the logical functions) and their getters/setters as well as their corresponding test classes.  I did also find it performed well at writing the actual tests for functions though I would go in and change some of the contents of the tests like the inputs I wanted and the expected outputs.

I also found that I could effectively leverage Copilot to give me solution examples for some issues I ran into.  A good example is the exception handling of bad request bodies sent to the endpoint I created to generate rental agreements.  It had been some time since I had written a Spring Boot controller and the details of handling such a case were a bit fuzzy so I had to implement a solution.  Once I saw its solution I looked at documentation to ensure I understood what the code was trying to do.  What made this useful is it gave me a direction to go when looking at documentation greatly reducing the time it took to find it.  Finally, I did find Copilot to be useful with some more complex logic.  When I first implemented the “charge days” logic for the Ladder class my code was not successful.  I was able to ask Copilot why it was failing and it suggested I didn’t need to make all the checks I was initially checking.  This greatly simplified the result and helped get my logic right.

One challenge I faced with using CoPilot was, ironically, having it write our interactions to the AI_INTERACTION_LOG.md file.  While it had no problem writing an interaction to the file when I specifically asked (right after or before we had an interaction I wanted documented), I did attempt to ask it to write them continually over multiple interactions and it had some problems with this.  It would be successful for a few interactions but I noticed given enough time between interactions it would stop automatically writing them to the file.  To remedy this issue, I kept an eye on its response when we interacted.  If its response didn’t show that it was updating the log file I would ask it to after it finished its response.  After a few times of losing a handful of interactions, I decided to always keep an eye on its responses so I could explicitly ask it to write the interaction if needed.

Another challenge I faced was having Copilot replace some of my code that I did not want it to replace.  Some of the prompts shown in the AI log file resulted in Copilot implementing some code that overwrote some of my code.  Rather than ask it to replace the code it was overriding, I started to change my prompts to tell it to keep the contents of any file I was asking it to change and to simply add its new code.

