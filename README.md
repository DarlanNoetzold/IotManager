# IotManager
UMa aplicação para gerenciamento de informações vindas de dispositivos IOT's

## Desenvolvimento:
* Foi usado Java 17 como linguagem base;
* Foi desenvolvido com Spring Boot;
* O Banco utilizado foi o PostgreSQL;
* Mensageiria construída com RabbitMQ;
* Uso do docker para configuração e implantação do projeto;
* Foi usado Python para o script de leitura do Monitor Serial e envio das infomrações para as filas;
* Foram usados dois arduinos, um Arduino Uno e um Mega 2560;
* Nesses arduinos foram carragados um script em C para cappturar as informações dos Sensores;
* Foram usados 4 sensosres, 2 sensores Ultraônicos e 2 sensores de Umidade e Temperatura.

## Projeto:
* Projeto para testar a Eficâcia do SpringBoot com RabbitMq em uma Aplicação IoT;
* O objetivo é analisar a performance com o envio de diversas mensagens de dois dispositivos diferentes;
* Estas mensagens devem se consumidas e salvas no banco de dados, tratando erros e mapeando as falhas;
* Em futuras atualizações é possível adicionar alguma funcionalidade para estes dados, seja visualização ou envio destas informações.


## Como Utilizar:
* Para utilizar basta fazer as conexões como esta nas imagens abaixo:


![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/dcf10655-4719-4786-bfb5-48fcdfded9b8)

![image](https://github.com/DarlanNoetzold/IotManager/assets/41628589/d2ad091f-750c-480d-ba87-f1918abfd85b)

* Lembrando que basta olha no [script que você vai dar upload](https://github.com/DarlanNoetzold/IotManager/blob/main/arduino_getter/arduino_getter.ino) no arduino para ver onde conectar os pinos exatamente;
* Após subir esse script você deve executar um docker compose up no arquivo yml que esta no repositório, ele vai inicializar o RabbitMQ;
* Depois execute a aplicação SpringBoot para consumir as filas do RabbitMQ;
* E por último inicialize o script Pyhton para ler o Monitor Serial e mandar as informações capturadas para as filas respectivas.


⭐️ From [DarlanNoetzold](https://github.com/DarlanNoetzold)
