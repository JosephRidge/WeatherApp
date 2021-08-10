# Core Objective :  Fetch weather data fro searched locations using the https://openweathermap.org/current api .api

## Concepts :
 *  Consuming API's
 *  Search feature
 *  Maps Feature ( Add Markers after every Search )
 *  Use of POJO


## Tools :
 * Retrofit
 * Google Maps
 * https://www.jsonschema2pojo.org/ (This will help generate our POJO- Plain Old Java Object)
 * API (provided by https://openweathermap.org/  )

## Key Note : (#NetworkSecurityConfig)
When Dealing with Api's sometimes one is forced to consume an api that is not using a secure protocol (in my case :http)
, the information decimated/ transmitted is not encrypted is called CLEARTEXT TRAFFIC. 
This is not secure/safe it is BEST Practice to Use encrypted / secure endpoints to limit the number of breach points your app will have. 
To solve this we can either edit the Manifest  file by adding USeClearTextTraffic and setting it to true as from Api 28 onwards it is automatically
disabled or BEST A SECURE ENDPOINT !

