# sample-dataservice

A sample dataservice running on Wildfly 10 and using Resteasy and JPA/Hibernate. It defines both the datastore model and the model that is being delivered to the frontend, implementing the data mapping with the MapStruct framework.

# Structure of the service layer

![image](/arch_diagram.png)

The service definition contains three REST calls, one of them is compound, meaning that it queries the DB twice and merges the results:

1) The first is clustering all the incident data by city and returns city and count as key-value pairs.

2) The second is returning all records for a selected city, setting it as a parameter in the filter structure. Pagination is implemented on the server-side.

3) The third returns detailed data for a single record by ID

The filter object itself is generic, which means that it could take different values from the event handlers in the frontend and return a filtered result set. In the current state it is set to filter by city when the incidents are clustered in the frontend and a city is selected and by ID when a concrete table row is clicked.

# Data mappings

The first transformation is between the data model in the persistence layer and the model of the REST response. This one is implemented with the MapStruct framework which automates POJO mapping. Then a Jackson serializer is used for the transformation of this entity in the JSON format which the frontend consumes.

# Further iterations

A great possibility would be to aggregate the data from our dataset with some additional dynamic data from a publicly available API. Examples: weather conditions during the time of the incident, statistical data about these exact geo coordinates, Google maps integration
