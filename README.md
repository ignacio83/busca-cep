# Introdução
Provê serviços REST para busca de CEP em uma base de dados interna. 

#Tecnologias
Esse projeto utiliza spring-boot, spring-mvc, spring-data, spring-boot-actuator com banco de dados em memória (hsqldb).

#Arquitetura
Arquitetura em 3 camadas (controller, service, repository).

#Como iniciar o projeto
mvn spring-boot:run -Dserver.port=8081

Ajuste o parâmetro server.port para o valor de sua preferência.

#Acessando a aplicação
http://localhost:8081/

A página inicial da aplicação é uma documentação escrita em swagger, os serviços listados podem ser utilizados sem
necessidade dessa interface HTML.

#Healthcheck
http://localhost:8080/health

#CEPs previamente cadastrados
* 01001001 - Praça da Sé
* 01001000 - Praça da Sé
* 01002001 - Rua Direita
* 07914140 - Rua Vergueiro
