
# Store

Uma API simples e concisa para o gerenciamento de uma tabela de produtos. O projeto foi desenvolvido com Java Spring e implementa um CRUD completo, validação de dados, tratamento de exceções e uma querry customizada.

## Funcionalidades Principais

- CRUD (Create, read, update and delete) completo
- Validação de dados com Bean Validation
- Tratamento de exceções global
- Busca parcial
- Banco de dados embutido (em memória)


## Tecnologias

**Front-end:** Html, JavaScript

**Back-end:** Java 17, Spring boot 3, JPA/Hibernate, H2 Data Base, Maven, Hibernate Validator

## Execução do Projeto

**Pré-requisitos**

- Java 17 (JDK)
- Maven 3.x
    
## Rodando localmente

1. Clone o projeto

```bash
git clone https://github.com/Lucaspmntl/Store-API.git
cd Store-API
```

2. Execute a aplicação com o Maven - a aplicação iniciará na porta 8080

```bash
./mvnw spring-boot:run
```

3. Acessando o H2
<img width="1919" height="965" alt="image" src="https://github.com/user-attachments/assets/e0a8db71-6859-4798-acca-d933f6d50689" />

Com a aplicação rodando, você pode acessar o console do H2 para inspecionar os dados diretamente no seu navegador:

- URL: http://localhost:8080/h2-console
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:storedb\
- User Name: sa
- Password: (deixe em branco)

**Nota:** _O projeto está configurado para popular o banco com dados iniciais (import.sql) para facilitar os testes dos endpoints GET._

## Documentação da API


#### _Recurso: Produto (/product)_

| Método   | EndPoint       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `GET` | `/product` | Lista todos os produtos cadastrados. |
| `GET` | `/product?name={nome}` | Busca parcial por produtos que contenham {nome}. |
| `GET` | `/product/{id}` | Busca um produto específico pelo seu Id. |
| `POST` | `/product/register` | Cria um novo produto no sistema. |
| `PUT` | `/product/{id}` | Atualiza um produto existente (implementa a lógica de PATCH). |
| `DELETE` | `/product/{id}` | Exclui um produto do sistema pelo seu Id. |
    
**_1. Listar produtos / busca parcial_**

    O endPoint **GET /product** é unificado. Sem parâmetros, ele lista todos. Com o parâmetro name, ele filtra.

- _GET /product_ - (Lista todos) 
- _GET /product?name=mouse_ - (busca por "mouse")

**_2. Buscar por Id_**
- _GET /product/3_ - (Busca o produto registrado com o id 3)

**_3. Criar produto_**
- _POST /product/register_ - (Cria um novo produto)

Corpo da requisição (json - ProductMinDTO)
```json
{ 
    "name": "Teclado Mecânico Gamer",
    "description": "Teclado mecânico ABNT2, switch Gateron marrom, com iluminação.",
    "price": 349.90,
    "quantity": 25
}
```

Resposta de sucesso (201 CREATED)
```json
{
    "message": "Produto registrado com sucesso!",
    "id": 39,
    "status": 201
}
```

**_3. Atualizar produto_**
- _PUT /product/2_ - (Atualiza o produto registrado com o Id 2)
Corpo da requisição (json - UpdateProductDTO): Envie apenas os campos que deseja alterar
```json
{
    "price": 329.00,
    "quantity": 20
}
```

Resposta de sucesso (200 OK)
```json
{
    "message": "Produto atualizado com sucesso!",
    "updatedProduct": {
        "id": 1,
        "description": "Mouse ergonômico...",
        "price": 329.00,
        "name": "Mouse Sem Fio PRO",
        "quantity": 20
    },
    "status": 200
}
```

**_4. Excluir produto_**
- _DELETE /product/6_ - (Deleta o produto com o Id 6)

Resposta de sucesso (200 OK)
```json
{
    "message": "Mouse Sem Fio PRO excluído com sucesso!",
    "status": 200
}
```

**_5. Visão geral_**
![Example](https://github.com/user-attachments/assets/caa0c900-57f0-4c08-86aa-67ce647435ec)



## Tratamento de erros
A API utliza-se de um Global Exception Handler para manipular as exceções e retornar respostas claras em casos de erro.

**Exemplo: Erro de validação**
> Caso haja uma tentativa de registrar um novo produto com os campos inválidos (nome vazio ou preço negativo):

**_Requisição: POST product/register_**
```json
{
    "name": "",
    "price": -10
}
```
_Resposta (400 BAD REQUEST)_
```json
{
    "message": "Erro de validação, verifique os campos enviados.",
    "status": 400,
    "errors": [
        {
            "field": "price",
            "message": "O valor deve ser positivo!",
            "rejectedValue": -10
        },
        {
            "field": "name",
            "message": "O nome deve ser preenchido!",
            "rejectedValue": ""
        }
    ]
}
```
**Exemplo: Recurso não encontrado**
> Caso haja uma tentativa de buscar um produto que ainda não registrado:
_Resposta (404 NOT FOUND)_
```json
Produto com id 999 não encontrado.
```
