# SpringBoot-RabbitMQ-Order-System
A practical implementation of asynchronous microservices communication using Spring Boot and RabbitMQ. The system processes orders without blocking the client request using event-driven architecture.

---

## 🐰 Installing RabbitMQ (Step-by-Step Guide)
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
         [rabbitmq-plugins enable rabbitmq_management](http://localhost:15672)
         ```
   2. Default credentials:
         ```bash
          username: guest
          password: guest
         ```
       If the dashboard appears successfully → RabbitMQ is ready 🎉

---
