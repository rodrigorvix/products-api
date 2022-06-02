<h1 align="center">
    Products-API-Ecommerce
</h1>


# ℹ️ Sobre

<p>
Projeto de construção de um e-commerce utilizando o conceito de microserviços. 
</p>
  <br>

# 🛠 Tecnologias

As seguintes tecnologias foram utilizadas na construção do projeto:
  
- Maven
- Java 11
- Spring Boot
- Spring Data
- Spring JPA
- Lombok
- MySQL
- Docker
  <br><br>

# 🚀 Como executar

Clone o projeto e acesse a pasta.

```
$ git clone https://github.com/rodrigorvix/products-api.git
$ cd products-api
```

# ℹ️ Rotas

Segue abaixo os endpoints disponíveis no projeto.


<details><summary><b>Rotas de produtos (Clique aqui)</b></summary>

1 - POST - http://localhost:8080/v1/products

```
{
	"name":"Camisa",
	"description":"Camisa branca ...",
	"price":88.00
}
```
2- GET - http://localhost:8080/v1/products

```

```

3 - PATCH - http://localhost:8080/v1/products{product_id}

```
{
	"name":"Produto3",
	"description":"Desecrição do produto 2 att...",
	"price":200.00
}
```

4 - DELETE - http://localhost:8080/v1/products/{product_id}

```

```
5 - GET BY ID - http://localhost:8080/v1/products/{product_id}

```

```
</details>
