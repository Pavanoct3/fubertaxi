# fubertaxi

Set Up Requirements:
Java 1.7 or above
Apache Tomcat
Jax-RS Jersey 2.16 or above

# Problem Statement:

You are the proprietor of füber, an on call taxi service.
You have a fleet of cabs at your disposal, and each cab has a location, determined by it’s latitude and longitude.
A customer can call one of your taxis by providing their location, and you must assign the nearest taxi to the customer.
Some customers are particular that they only ride around in pink cars, for hipster reasons. You must support this ability.
When the cab is assigned to the customer, it can no longer pick up any other customers
If there are no taxis available, you reject the customer's request.
The customer ends the ride at some location. The cab waits around outside the customer’s house, and is available to be assigned to another customer.

Notes:

You can build this in any programming language of your choice
We expect good unit tests
Unfortunately, you skipped Geography, and believe the earth is flat. The distance between two points can be calculated by Pythagoras’ theorem.


# REST API Listens to XML responses and Produces Plain text response.

To Book a Ride , use the below URI

POST /fubertaxi/webapi/fubertaxi/booktaxi 

Body -
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer>
	<id>2</id>
    <location>
        <lattitude>20.0</lattitude>
        <longitude>200.0</longitude>
    </location>
    <destLocation>
        <lattitude>50.0</lattitude>
        <longitude>500.0</longitude>
    </destLocation>
    <pinkPreferred>false</pinkPreferred>
</customer>


Response - 
SUCCESS!!! Cab Number= 1, location : Lattitude = 10.0, Longitude =100.0

To End a Ride, use the below URi

GET fubertaxi/webapi/fubertaxi/endRide/{customerId}

Response -
Thanks for Riding Fuber! Your Fare details::2.5214077E7 dogecoins



