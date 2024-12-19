# spring-REST
spring restful services

webservices:
# SOAP
1. SOAP protocol, XML mediatype,secure.
2. complex design 
    - WSDL (webservice descriptor language)
    - Wsdl2Java - input into java pojo class
    - pojo - stub object (implementation class for interface)
    - call the method
# REST
1. HTTP,HTTPS , XML,JSON,TEXT,HTML any mediatype
2. secure ( token based JWT , OAUTH)
3. Easy Design
    -  create method and define type
    - define the URL with which user will access it

# 3 layer / tier architecture

web layer- service layer - Database
endpoints- business logic - DAO connection

controller - expose endpoints restful services
dao /repo - database
service - core logic
dto -request and response format for the restful webservice
entity- data table structure for repo
util - dto to entity or entity to dto conversion

Double- wrapper - consumes more memory
double- primitive - 8 bytes