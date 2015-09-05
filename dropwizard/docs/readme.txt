#########
Execution
#########

1) Run following to compile and build the project:

mvn clean package

2) Execute following to run application:

java -jar target/dropwizard-0.1.jar server app.yaml

3) Use Ctrl + C to stop application.

########
REST API
########

1) API call below records a profile view of user identified by <targetUserId>. User identified by <viewingUserId> is considered as viewer of that profile.

PUT http://<address>/userProfiles/<targetUserId>/views/<viewingUserId>

Example request:

PUT http://localhost:9090/userProfiles/1/views/2
PUT http://localhost:9090/userProfiles/1/views/3
PUT http://localhost:9090/userProfiles/1/views/4

2) API call below returns all profile views of user identifier by <targetUserId>.

GET http://<address>/userProfiles/<targetUserId>/views

Example request:

GET http://localhost:9090/userProfiles/1/views

Example response:

[
    {
        "userId": 4,
        "timestamp": "2015-09-03 17:09:21"
    },
    {
        "userId": 3,
        "timestamp": "2015-09-03 17:09:14"
    },
    {
        "userId": 2,
        "timestamp": "2015-09-03 17:09:04"
    }
]
