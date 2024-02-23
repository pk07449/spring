# Running : 

each module(authorization-server and resource-server) needs to run in a different terminal window: `mvn clean spring-boot:run`

or the main class can be run from any IDE.


We have configured the authorization server to run at port 8081 and the resource server to run at port 8989. For all the examples below curl is used, but the client can be any application.
Let’s try first to access one of the enpoints in the resource server:

curl localhost:8989/foo
{
    "error": "unauthorized",
    "error_description": "Full authentication is required to access this resource"
}


Let’s obtain a token and try again.
Client credentials grant:
curl -X POST --user my-trusted-client:mysecret localhost:8081/oauth/token -d 'grant_type=client_credentials&client_id=my-trusted-client' -H "Accept: application/json"
Response:
{
  "access_token": "3670fea1-eab3-4981-b80a-e5c57203b20e",
  "token_type": "bearer",
  "expires_in": 51,
  "scope": "read write trust"
}


We can now use the token for accessing the protected endpoint:
curl -v localhost:8989/foo -H "Authorization: Bearer 6bb86f18-e69e-4c2b-8fbf-85d7d5b800a4"
foo


Note : Client credentials grant does not support a refresh token.