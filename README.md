# Introdução
Provê serviços REST para busca de CEP em uma base de dados interna. 

#Tecnologias
Esse projeto utiliza spring-boot, spring-mvc, spring-data, spring-boot-actuator com banco de dados em memória (hsqldb).

#Arquitetura
* Arquitera em 3 camadas (controller, service, repository).
* O controle transacional é realizado na camada service.

#Como iniciar o projeto
mvn spring-boot:run

#Acessando a aplicação
http://localhost:8080/

A página inicial da aplicação é uma documentação escrita em swagger, os serviços apresentados aqui podem ser utilizados sem
necessidade dessa interface HTML.

#CEPs previamente cadastrados
* 01001-001 - Praça da Sé
* 01001-000 - Praça da Sé
* 01002-001 - Rua Direita
* 07914-140 - Rua Vergueiro
