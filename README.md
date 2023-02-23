# Global Exception Handler

This is a global exception handler for the API.

### Business Exception

This exception is thrown when the business logic is not satisfied.

```json
{
  "type": "https://example.com/business-exception",
  "title": "Business Exception",
  "status": 400,
  "detail": "Product already exists",
  "instance": "/api/products",
  "timestamp": "2023-02-23 17:07:39"
}
```

### NotFound Exception

This exception is thrown when the resource is not found.

```json
{
  "type": "https://example.com/not-found-exception",
  "title": "Not Found Exception",
  "status": 404,
  "detail": "Product not found by id",
  "instance": "/api/products/%7Bid%7D",
  "timestamp": "2023-02-23 17:08:01"
}
```

### Internal Server Error Exception

This exception is thrown when the server is not able to process the request.

```json
{
  "type": "https://example.com/internal-server-exception",
  "title": "Internal Server Exception",
  "status": 500,
  "detail": "Failed to convert value of type 'java.lang.String' to required type 'int'; For input string: \"name\"",
  "instance": "/api/products",
  "timestamp": "2023-02-23 17:09:03"
}
```