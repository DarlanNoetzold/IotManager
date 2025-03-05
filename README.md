# IotManager
An application for managing information from IoT devices

## Development:
* Java 17 was used as the base language;
* It was developed with Spring Boot;
* The database used was PostgreSQL;
* Messaging built with RabbitMQ;
* Docker was used to configure and deploy the project;
* Python was used for the script to read the Serial Monitor and send the information to the queues;
* Two Arduinos were used, an Arduino Uno and a Mega 2560;
* A C script was loaded onto these Arduinos to capture information from the Sensors;
* 4 sensors were used, 2 Ultraonic sensors and 2 Humidity and Temperature sensors.

## Project:
* Project to test the effectiveness of SpringBoot with RabbitMq in an IoT application;
* The goal is to analyze the performance of sending several messages from two different devices; * These messages must be consumed and saved in the database, handling errors and mapping failures;
* In future updates it is possible to add some functionality to this data, whether viewing or sending this information.

## How to Use:
* To use, simply make the connections as shown in the images below:

![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/dcf10655-4719-4786-bfb5-48fcdfded9b8)

![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/d2ad091f-750c-480d-ba87-f1918abfd85b)

* Remember that you just need to look at the [script you are going to upload](https://github.com/DarlanNoetzold/IotManager/blob/main/arduino_getter/arduino_getter.ino) on the Arduino to see exactly where to connect the pins; * After uploading this script, you must run a docker compose up on the [yml file](https://github.com/DarlanNoetzold/IotManager/blob/main/docker-compose.yml) that is in the repository, it will initialize RabbitMQ;
* Then run the SpringBoot application to consume the RabbitMQ queues;
* And finally, initialize the [Python script](https://github.com/DarlanNoetzold/IotManager/blob/main/main_serial.py) to read the Serial Monitor and send the captured information to the respective queues. * This way you will see this information on the Serial Monitor of each Arduino:

![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/ca2bc540-2fe3-47d3-acf0-b4acbb5f1066)

* And you will see this information being sent to their specific queues and being consumed by SpringBoot, to be saved in this bank:

![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/2cfe675c-cc23-45aa-aa0f-e01d40dabdce)

---

⭐️ From [DarlanNoetzold](https://github.com/DarlanNoetzold)
