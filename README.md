
<h1 align="center">Desafio Senior Sistemas</h1>

## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- java 8
- spring date JPA
- mysql
- lombok
- swagger

## 🎲 Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

```shell
cd "diretorio de sua preferencia"
git clone https://github.com/michelspirlandeli/desafio-senior
```

## 🚀 Construção

Para construir o projeto com o Maven, executar os comando abaixo:

```shell
mvn clean install
mvn clean package
```

O comando irá baixar todas as dependências do projeto e criar um diretório *target* com os artefatos construídos, que incluem o arquivo jar do projeto. Além disso, serão executados os testes unitários, e se algum falhar, o Maven exibirá essa informação no console.
## Docker 

Subir a base de dados em mysql

```shell
docker-compose up
```
## ✅ Swagger

- API REST disponível em: http://localhost:8090/swagger-ui.html

## ✅ Author

**Michel Spirlandeli**

## ✅ License

Copyright © 2021 [Michel Spirlandeli](https://github.com/michelspirlandeli)
Released under the [MIT license](https://github.com/michelspirlandeli/desafio-senior/blob/main/LICENSE).
