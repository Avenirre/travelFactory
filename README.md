# The JAVA programatic test for Travelfactory #


### The test during  2 hours and the goal is to create webservice with Spring Boot ###
### the resultat must be Jar and source code pushed in this repository. ###



* **Technological context**

The technological context is focused on high performance, an SOA architecture via microservices Restfull and scalability via docker.
This context is implemented with Spring Boot with  Spring Data  and MongoDb databases.

* **Functional Context**

Our business partners send us their catalog of products in CSV format via a sharing directory.
These files have the vendor name and the file's build date (Example: booking-21-12-2016.csv).

Side Travelfactory we first wish to store the contents of CSV files in a MongoDb database.

And we want to consult the catalog of our trading partners using a REST / JSON webservice that will be used by microservices
http: //localhost: 8080/catalog/{vendor}/{date}/{id}
(Example of the url: http://localhost:8080/catalog/booking/21-12-2016/1).

**To do this microservice the following tasks must be performed:**

1.  Creating the spring boot project using (https://start.spring.io/)
 (Use of embedded mongodb is highly recommended)

2.  Creating a worker that scans the shared directory for a CSV file
And start consumption

3.  Consumption of the CSV file and insertion into the MongoDb database

4.  Creating a REST / JSON webservice for consultation http: // localhost: 8080 / catalog / {vendor} / {date} / {id}


You have an **example** of CSV file.


-------------------------------------------------------------

**Example** : Input

In your computer you have csv C:/data/booking-21-12-2016.csv


--------------------------

```
#!python

Id,Name,RoomNumber
2,Palace Hotel,1932
3,Béatrice Impérial Hotel,164
4,Dan Boutique,88
```

--------------------------

**Example** : Ouput

When I call the http://localhost:8080/catalog/booking/21-12-2016/2
the return this


```
#!json

{ 
 "Id":"2",
 "Name":"Palace Hotel",
 "RoomNumber":"1932"
}

```