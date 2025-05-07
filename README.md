```
# Smart Home Appliance Control System

This is a Spring Boot application simulating a Smart Home system capable of managing appliances such as **Light**, **Fan**, and **Air Conditioner**. It exposes RESTful APIs to initialize, control, and monitor the appliances.

## Features

- Initialize and register appliances
- Turn appliances ON/OFF
- Set fan speed (0 = off, 1, 2)
- View appliance statuses
- Scheduled yearly system update (January 1st, 1:00 AM)
- Input validation and friendly error messages
- Swagger UI for API testing and documentation

## Technologies

- Java 17+
- Spring Boot
- Spring Web
- Swagger/OpenAPI (springdoc-openapi)
- Maven

## Getting Started

### Clone the Repository

```

git clone [https://github.com/your-username/HomeApplianceSystem.git](https://github.com/your-username/HomeApplianceSystem.git)
cd HomeApplianceSystem

```

### Build and Run

```

mvn clean install
mvn spring-boot\:run

```

## Usage Flow

1. **Initialize Appliances**  
   Before using any appliance, initialize them using the `/init` API by passing a list of appliance names.

2. **Use Appliance Control APIs**  
   After initialization, use the ON/OFF or speed-setting endpoints to control the devices.

3. **Check Status**  
   Use the `/status` API to get the status of all registered appliances.

---

## API Endpoints

Base URL: `/api/appliances`

| Endpoint              | Method | Description                        |
|-----------------------|--------|------------------------------------|
| `/init`               | POST   | Register appliances (`["LIGHT", "FAN", "AC"]`) |
| `/light/on`           | POST   | Turn Light ON                      |
| `/light/off`          | POST   | Turn Light OFF                     |
| `/fan/speed?speed=1`  | POST   | Set Fan speed (0, 1, 2)            |
| `/ac/on`              | POST   | Turn Air Conditioner ON            |
| `/ac/off`             | POST   | Turn Air Conditioner OFF           |
| `/status`             | GET    | Get status of all appliances       |

---

## Sample Requests

### Initialize

```

POST /api/appliances/init
Body: \["LIGHT", "FAN", "AC"]

```

### Invalid Appliance

```

POST /api/appliances/init
Body: \["WASHER"]
Response: {"error":"WASHER Appliance is not found"}

```

### Get All Appliance Status

```

GET /api/appliances/status
Response:
\[
"Light is ON",
"Fan speed: 2",
"Air Conditioner mode: on"
]

```

---

## Swagger UI

API documentation is available at:

http://localhost:8080/swagger-ui/index.html

---

## Scheduler

A system update job runs automatically every January 1st at 1:00 AM and turns off all appliances as part of maintenance.

---

## Future Enhancements

- Appliance state persistence with database
- User login/authentication (e.g., TOTP)
- Integration with real IoT devices
