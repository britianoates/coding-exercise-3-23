Britian Oates coding exercise


## Requirements:
Interview coding ASSIGNMENT--

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

• Solve using Spring Boot  
• Create a RESTful endpoint  
• Make up a data set to best demonstrate your solution  
• Check solution into GitHub



## Solution:

There is a POST endpoint called /calculate-points. It takes in a JSON array of transactions, which include customerId, date, and amount. For each customerId the response will contain that customer's total points earned. There will also be a collection of monthly points earned that shows how many points were earned in that month. 

curl --location 'localhost:8080/calculate-points' \
--header 'Content-Type: application/json' \
--data '[
{"customerId":1,"date":"2023-01-01","amount":124},
{"customerId":1,"date":"2023-01-02","amount":176},
{"customerId":1,"date":"2023-01-03","amount":79},
{"customerId":1,"date":"2023-01-04","amount":175},
{"customerId":1,"date":"2023-01-17","amount":184},
{"customerId":1,"date":"2023-01-18","amount":187},
{"customerId":1,"date":"2023-01-25","amount":90},
{"customerId":1,"date":"2023-01-26","amount":119},
{"customerId":1,"date":"2023-01-27","amount":187},
{"customerId":1,"date":"2023-01-28","amount":195},
{"customerId":1,"date":"2023-01-29","amount":65},
{"customerId":1,"date":"2023-02-07","amount":41},
{"customerId":1,"date":"2023-02-08","amount":84},
{"customerId":1,"date":"2023-02-09","amount":59},
{"customerId":1,"date":"2023-02-16","amount":118},
{"customerId":1,"date":"2023-02-17","amount":80},
{"customerId":1,"date":"2023-02-18","amount":58},
{"customerId":1,"date":"2023-02-25","amount":163},
{"customerId":1,"date":"2023-02-26","amount":143},
{"customerId":1,"date":"2023-02-27","amount":119},
{"customerId":1,"date":"2023-03-07","amount":123},
{"customerId":1,"date":"2023-03-08","amount":120},
{"customerId":1,"date":"2023-03-16","amount":180},
{"customerId":1,"date":"2023-03-17","amount":19},
{"customerId":1,"date":"2023-03-18","amount":145},
{"customerId":1,"date":"2023-03-19","amount":80},
{"customerId":1,"date":"2023-03-20","amount":74},
{"customerId":2,"date":"2023-01-04","amount":65},
{"customerId":2,"date":"2023-01-05","amount":21},
{"customerId":2,"date":"2023-01-06","amount":177},
{"customerId":2,"date":"2023-01-17","amount":142},
{"customerId":2,"date":"2023-01-18","amount":158},
{"customerId":2,"date":"2023-01-19","amount":194},
{"customerId":2,"date":"2023-01-20","amount":180},
{"customerId":2,"date":"2023-01-28","amount":193},
{"customerId":2,"date":"2023-01-29","amount":112},
{"customerId":2,"date":"2023-01-30","amount":184},
{"customerId":2,"date":"2023-01-31","amount":49},
{"customerId":2,"date":"2023-02-07","amount":170},
{"customerId":2,"date":"2023-02-08","amount":113},
{"customerId":2,"date":"2023-02-09","amount":188},
{"customerId":2,"date":"2023-02-10","amount":146},
{"customerId":2,"date":"2023-02-17","amount":95},
{"customerId":2,"date":"2023-02-18","amount":63},
{"customerId":2,"date":"2023-02-19","amount":40},
{"customerId":2,"date":"2023-02-20","amount":136},
{"customerId":2,"date":"2023-02-28","amount":124},
{"customerId":2,"date":"2023-03-01","amount":81},
{"customerId":2,"date":"2023-03-02","amount":129},
{"customerId":2,"date":"2023-03-03","amount":116},
{"customerId":2,"date":"2023-03-04","amount":61},
{"customerId":2,"date":"2023-03-12","amount":21},
{"customerId":2,"date":"2023-03-13","amount":75},
{"customerId":2,"date":"2023-03-14","amount":38},
{"customerId":2,"date":"2023-03-21","amount":87},
{"customerId":2,"date":"2023-03-22","amount":107},
{"customerId":2,"date":"2023-03-23","amount":51}

]'

## Response:
[
    {
        "customerId": 1,
        "totalPoints": 2735,
        "monthlyEarnedPoints": [
            {
                "amount": 1578,
                "month": "JANUARY"
            },
            {
                "amount": 567,
                "month": "FEBRUARY"
            },
            {
                "amount": 590,
                "month": "MARCH"
            }
        ]
    },
    {
        "customerId": 2,
        "totalPoints": 2766,
        "monthlyEarnedPoints": [
            {
                "amount": 1495,
                "month": "JANUARY"
            },
            {
                "amount": 912,
                "month": "FEBRUARY"
            },
            {
                "amount": 359,
                "month": "MARCH"
            }
        ]
    }
]



## Possible enhancements:
*The monthly earned points could be given a year value to handle more than 12 months worth of data.  
*The calculation in the controller to group customers and their monthly totals could be more elegant. The lookups for existing objects or adding new ones could be handled by a grouping method but as I explored that option it seemed harder to read.
