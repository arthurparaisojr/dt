# Desafio Técnico - EICON


### Vaga Programador Java

### Criar uma solução java em formato de API que atenda aos seguintes requisitos para a recepção de pedidos dos clientes:
### Criar um serviço que receba pedidos no formato xml e json com 6 campos: ok

#### número controle - número aleatório informado pelo cliente.
#### data cadastro (opcional) nome - nome do produto
#### valor - valor monetário unitário produto
#### quantidade (opcional) - quantidade de produtos.
#### codigo cliente - identificação numérica do cliente.
#### Critérios aceitação e manipulação do arquivo:
#### O arquivo pode conter 1 ou mais pedidos, limitado a 10.

#### Não poderá aceitar um número de controle já cadastrado. ok
#### Caso a data de cadastro não seja enviada o sistema deve assumir a data atual. ok
#### Caso a quantidade não seja enviada considerar 1. ok
#### Caso a quantidade seja maior que 5 aplicar 5% de desconto no valor total, para quantidades a #### partir de 10 aplicar 10% de desconto no valor total. ok
#### O sistema deve calcular e gravar o valor total do pedido. ok
#### Assumir que já existe 10 clientes cadastrados, com códigos de 1 a 10. ok
#### Criar um serviço onde possa consultar os pedidos enviados pelos clientes.
#### Critérios aceitação:
#### O retorno deve trazer todos os dados do pedido.
### filtros da consulta:
#### número pedido, data cadastro, todos
#### Frameworks:
#### Fica a critério do candidato utilizar ou não, sem restrições de escolha.
### desejável:
#### Injeção de dependência
#### Padrões de projeto
#### Testes unitários
### Obrigatório
#### banco de dados mysql
#### utilizar framework ORM
#### utilizar a linguagem java 1.8
### a solução deve ser publicada no github juntamente com o script de criação das tabelas.
### deve ser enviado o link do repositório da solução para este email.