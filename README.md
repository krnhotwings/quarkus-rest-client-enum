# quarkus-rest-client-enum

## Startup

```sh
quarkus dev
```

## Test


### Hit RestEASY Endpoints

```sh
curl -X GET "http://localhost:8080/resteasy?myEnum=test"
curl -X POST "http://localhost:8080/resteasy" -d "myEnum=test"
```

Both of the above produces expected *lowercase* `MyEnum.TEST` output.

### Hit Rest Client Endpoints

#### Query Param Works

```sh
curl -X GET "http://localhost:8080/restclient?myEnum=test"
```

```
Request: GET https://httpbin.org/get?myEnum=test Headers[User-Agent=Quarkus REST Client], Empty body
```

```
Response: GET https://httpbin.org/get?myEnum=test, Status[200 OK], Headers[Date=Fri, 19 Apr 2024 20:36:34 GMT Content-Type=application/json Content-Length=278 Connection=keep-alive Server=gunicorn/19.9.0 Access-Control-Allow-Origin=* Access-Control-Allow-Credentials=true], Body:
{
  "args": {
    "myEnum": "test"
  },
  "headers": {
    "Host": "httpbin.org",
    "User-Agent"
```

Above return expected lowercase representation of `MyEnum.TEST` enum in both the
request and response.

#### Form Param Fails

```sh
curl -X POST "http://localhost:8080/restclient" -d "myEnum=test"
```

```
Request: POST https://httpbin.org/post Headers[Content-Type=application/x-www-form-urlencoded User-Agent=Quarkus REST Client content-length=11], Body:
myEnum=TEST
```

```
Response: POST https://httpbin.org/post, Status[200 OK], Headers[Date=Fri, 19 Apr 2024 20:38:45 GMT Content-Type=application/json Content-Length=417 Connection=keep-alive Server=gunicorn/19.9.0 Access-Control-Allow-Origin=* Access-Control-Allow-Credentials=true], Body:
{
  "args": {},
  "data": "",
  "files": {},
  "form": {
    "myEnum": "TEST"
  },
  "headers":
```

The above uses the name of the enum itself (from `Enum#name()`?) rather than
`MyEnum#toString()` like in the other examples.

#### Bean Param Test

Additional test for `@RestForm` of an enum inside an `@BeanParam` bean.

```sh
curl -X POST "http://localhost:8080/restclient/bean" -d "myEnum=test"
```
