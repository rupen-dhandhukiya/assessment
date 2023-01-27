
## Architecture Diagram
![image](https://user-images.githubusercontent.com/123449651/214549738-91e5e276-8d66-4d0c-b5c4-ab856092f033.png)

# Frameworks, Tools & Languages
	•	Eclipse
	•	Spring Boot
	•	Java
	•	Swagger UI


# API’s Details

### Service-1: rate-service

rate-service project is used to load json data from external end point service (https://euvatrates.com//rates.json). To communicate external service, it is used feignclient cloud API as proxy interface and the service runs on 8081 port as a separate service (http://localhost:8081/rates_microservice/vat/rates).
##### RateController Rest API
 
   The rest API is used to load the entire json data from external end point service and the loadRatesJsonData() method used to inject the service component to      
   load the json data. Once the response is OK status then the countries and rates list sent as http ResponseEntity
##### RateService Service
 
   The service component is used to inject the rateServiceProxy interface to communicate and load the entire json data. Once data loaded then filtered the data as 
   list of countries and rates by using Jackson API 
##### RateServiceProxy Interface
 
   The proxy interface is used to register the cloud feign rest client by passing service name and URL details to communicate the services

### Service-2: standard-reduced-rates-service

standard-reduced-rates-service project used to load the filtered json data from service1 (http://localhost:8081/rates_microservice/vat/rates). To communicate service1, it is used feignclient cloud API as proxy interface and the service2 runs on 8082 port as a separate services 
(http://localhost:8082/standard-reduced-rates-service//vat/rate/getStandardRates) and (http://localhost:8082/standard-reduced-rates-service//vat/rate/getReducedRates)
##### StandardRateRestController Rest API
 
   The rest API is used to load the list of countries and rates json data from service1 and getHighestThreeCountriesStandardRates() method is used to inject the  
   standardRateRestService service component to get the top highest three countries and standard vat rates data. Once the response is OK status then the countries 
   and rates list sent as http ResponseEntity
##### ReducedRateRestController Rest API
 
   The rest API is used to load the list of countries and rates json data from service1 and getLowestThreeCountriesReducedRates() method is used to inject the  
   reducedRateRestService service component to get the top lowest three countries and reduced vat rates data. Once the response is OK status then the countries 
   and rates list sent as http ResponseEntity
##### StandardRateRestService Service
 
   The service component is used to inject the countriesRatesServiceProxy interface to load the filtered json data and applied business logic to get the top 
   highest countries and standard vat rates
##### ReducedRateRestService Service
 
   The service component is used to inject the countriesRatesServiceProxy interface to load the filtered json data and applied business logic to get the top 
   lowest countries and reduced vat rates
##### CountriesRatesServiceProxy Interface
 
   The proxy interface is used to register the cloud feign rest client by passing service name and URL details to communicate the service1
   
# Steps to Download and Run
  
 - Go to command prompt and navigate to workspace folder and execute below said git command 

	git clone https://github.com/rupen-dhandhukiya/assessment

Below steps to be followed for both projects (rate-service and standard-reduced-rates-service)

 - Go to Command Prompt and navigate to rate-service project workspace and execute below command

	mvn spring-boot:run

 - Go to Command Prompt and navigate to standard-reduced-rates-service project workspace and execute below command

	mvn spring-boot:run

 - Once standard-reduced-rates-service (8082) project server started then go to browser and run the swagger UI to test the requirements 

# Steps to Test the Application

 - Execute the URL : 
	
	http://localhost:8082/swagger-ui/index.html# 
 
