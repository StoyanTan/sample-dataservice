# sample-dataservice

A sample dataservice running on Wildfly 10 and using Resteasy and JPA/Hibernate. It defines both the datastore model and the model that is being delivered to the frontend, implementing the data mapping with the MapStruct framework.

# Structure of the service layer

Right now the service definition is allowing for two REST calls, one that is fetching all the data (pagination is implemented on service level, but not in the Angular component) and one which is filtering the data according to a filter criteria.

The filter object itself is generic, which means that it could take any value from the event handlers in the frontend and return a filtered result set. The initial idea is to filter by city once the incidents are clustered in the frontend and drawn as a d3-diagram.

# Data mappings

The first transformation is between the data model in the persistence layer and the model of the REST response. This one is implemented with the MapStruct framework which automates POJO mapping. Then a Jackson serializer is used for the transformation of this entity in the JSON format which the frontend consumes.

# Further iterations

It is possible to define a selector by ID for displaying a single incident including a twitter widget. The dataset has its origin in the twitter feed of Manila's traffic authority, so this would be the natural extension, plus all the data is already being loaded in the application, but not rendered in the Angular component.

Another possibility is to aggregate the data with some additional dynamic data from a publicly available API (not done yet because it is mainly a frontend focused task). 
