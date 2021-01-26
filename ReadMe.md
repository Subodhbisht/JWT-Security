## Get Authrization Token
```
curl -i \
	--header "Content-type: application/json" 
	--request POST 
	--data '{"username":"user", "password":"password"}' 
	http://localhost:8080/auth
```
HTTP response
```
HTTP/1.1 200 
Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWJvZGgiLCJleHAiOjE2MTE2Nzg4ODEsImlhdCI6MTYxMTY3ODgyMX0.7WFqgE0TwkmotmmE0v7rIDSUCFdd4hvgvN-Jf2kU-wHuLV59MntWScVgSljGFFwWzhB7_i9UMPfGKnJVUtnoRA
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Transfer-Encoding: chunked
Date: Tue, 26 Jan 2021 16:33:41 GMT

Token successfully generated
```