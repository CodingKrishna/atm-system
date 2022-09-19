# Shortest Path Finder Application

This application is to Find the shortest path from source to destination in a matrix that satisfies given constraints.

# Assumption and base considerations during application start.
	1) Preparing grid of 4*4 and corresponding edges.
	2) Default values 0 and allowed edge is 1.
	3) Creating default robots with predefined configurations(need to enhance to make it as api)
	4) Using spring web-flux 
	5) some of other approaches and logics can be improved in this app same i declared with TODO's.
	6) call findshortestpath api to get out put.

# note 
The work is still in progress for satisfying all the constraints. 

## How to run:

 1. Run application with command mvn spring-boot:run
   Or
 2. Import into IDE and Run ShortestPathFinderApplication.java

## Rest End-Points: 

1.  Find the shortest path from (0,0) to given destination location 
	http://localhost:8080/api/findshortestpath?robotId=1&destX=2&destY=0
	Sample output
	
	```
	[
	    {
	        "x": 0,
	        "y": 0,
	        "distanceFromSource": 0
	    },
	    {
	        "x": 0,
	        "y": 1,
	        "distanceFromSource": 1
	    },
	    {
	        "x": 0,
	        "y": 2,
	        "distanceFromSource": 2
	    },
	    {
	        "x": 1,
	        "y": 2,
	        "distanceFromSource": 3
	    }
	]
	```
	
2. Add User:

   POST URL: localhost:8080/users
   
   Request Body:
   
   { "id": 1, "name": "XYZ", "email": "xyz@gmail.com"}

3. Get User By Id:

   GET URL: localhost:8080/users/{id}

4. Get users:

   GET URL: localhost:8080/users

# Sequence

![Alt text](./FindShortestPathHandler_findPath.svg)
<img src="./FindShortestPathHandler_findPath.svg"> 