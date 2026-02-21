# SpringBoot-RabbitMQ-Order-System
A practical implementation of **asynchronous communication** using **Spring Boot** and **RabbitMQ**. The system processes orders **without blocking the client request** using **event-driven architecture**.

---

## 📌 Overview

This project demonstrates a basic **event-driven flow** using **Spring Boot** and **RabbitMQ**.

- Customers can create orders using a REST API.
- Orders are immediately sent to RabbitMQ as messages (events).
- A consumer reads the messages asynchronously and processes them.
- Client receives an immediate response without waiting for processing.

This demo shows the **core idea of asynchronous communication and event-driven architecture** before scaling to multiple microservices like Payment or Notification services.

---

## 🏗 Flow

Client ---> Order Service ---> returns "Order Received" immediately
|
| publishes OrderPlaced event
v
Consumer (simulating Payment & Notification)
processes order asynchronously

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- RabbitMQ
- Maven
- REST API

---

## 🐰 Installing RabbitMQ For Windows (Step-by-Step Guide)
RabbitMQ requires Erlang to be installed first.

### 1️⃣ Install Erlang
   1. Go to the official Erlang website: https://www.erlang.org/downloads
   2. Download the latest Windows installer.
   3. Install it normally.
   4. Set environment variable:
      - Variable Name: ERLANG_HOME
      - Value:
           ```bash
           C:\Program Files\Erlang OTP\erl-XX.X
           ```
   5. Open CMD and verify:
         ```bash
         erl
         ```
         If Erlang shell opens successfully → Installation is correct.

### 2️⃣ Install RabbitMQ
   1. Go to official RabbitMQ website: https://www.rabbitmq.com/docs/download
   2. Download the Windows installer.
   3. Install normally.
   4. Add RabbitMQ sbin folder to PATH:

      Example:
         ```bash
         C:\Program Files\RabbitMQ Server\rabbitmq_server-3.xx.x\sbin
         ```

### 3️⃣ Enable Management Plugin
   1. Open CMD as Administrator:
         ```bash
         rabbitmq-plugins enable rabbitmq_management
         ```
   2. Restart the service:
         ```bash
         net stop RabbitMQ
         net start RabbitMQ
         ```
### 4️⃣ Access RabbitMQ Dashboard
   1. Open your browser:
         ```bash
         http://localhost:15672
         ```
   2. Default credentials:
         ```bash
          username: guest
          password: guest
         ```
       If the dashboard appears successfully → RabbitMQ is ready 🎉

---

## 🚀 Running the Demo

1. Start RabbitMQ
2. Run your Spring Boot application
3. Test endpoint:
    ```bash
    POST /orders
    Content-Type: application/json
     
    {
       "productName": "Book",
       "productPrice": "20",
       "productQuantity": "2"
    }
    ```
    - Response:
        ```bash
        {
           "order": {
              "productName": "Book",
              "productPrice": "20",
              "productQuantity": "2"
           },
           "orderStatus": "Placed",
           "message": "Your order has been placed successfully"
        }
      ```
   - Consumer prints the message asynchronously:
       ```bash
       Consumer received OrderResponseDTO{...}
        ```
     
---

## 🔥 What This Demo Shows

- Asynchronous message publishing using RabbitMQ
- Event-driven concept
- Immediate response to client
- How consumers process messages independently
