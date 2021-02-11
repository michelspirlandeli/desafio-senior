
<h1 align="center">
<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAAYFBMVEUHw5r////6/v0Av5MBwpgAwJbG7+T4/PrD7uM9zqy/7eHJ8OXo+POd5dMpyaSB3sfw+vfP8eiQ4s7d9e657N9G0LCq6dpZ1bip6Nh428Ng17wsyqbV8+tw2sCJ4MscxqAvRPNKAAAEmUlEQVR4nO2c3VLjMAyF48TuD5TSQqFAgb7/W5LQFhLreHG3zObIqzPADbnIN7IcWZJVVSaTyWQymUwmk8lkMpn+U/nPH/3yfn3TjP0SvyBfzZx700/ScdTO7bQvrgNH7TZh7De5TEd7tL8PqklOHO2fJ81e8sXRarXX6yXef3M4t1VrkgFH7d61ggzt4dyjUpCYw02Ublsxh1vrdHbB4a5VWkRy6PQRfxVz1O5OIYjkaPWiDwRyTBXGv4jDXenzdcihMELBHPq+IphD33EEcijcexMc6jw9wTEZ+73OVYLjWlt+zji4ZBxcMg4qwbhdIUfYlMHRPBXCcVsGR3iQFBo5/H5RBAd2EIUcYVsGR1W9FrGuquZFGkQjBzKISo5mWwZHF5sUweF3U2GRV8hBztY8C1eHRWi/n3Ong8KVMAjM8LbPzZkTdH6/ih0Etjc0d85NmUlAuIhqIN1jNTWJdBFYJgwTR04Sx4u4Ayhsj//kJQnX0cJa7MFTzcbRk9xHSws1l33vCMQkwyMVLoL0ohhWknj3rd0zAnnvdwhRkvjlNAJBlfTmprf+OEniSCsBshk+Q0iSt7SiMIaSJM/ZHx07ic/afgc+QkqS9UGUcQwfiQxRttIkYe5i0ZHIpC+M4uMFyEciw/gahPHtaQRkjKhI8g5WfifWFh1J3lFX7Ft8JCD5sADJh0S+nojE76Qbr2XqJ8g0HhtJZoKutRw5SW7KtN2oyUlyk9j0JM1bZlmBniS70MNOkl96YydpzxuIZKKOJFWe1kcCtuDzSSiqDqkWDn0kIdFUg0ngo6sdBUmqXesMEhRsjqHLSUjuxP2CTUi65y8mobnPcDnJ/RivDQQu7J1FwnOZ91ISN11y7FyXktSOZVaHuGZ8rk14TJIimclnAQmPl6RJQJ4e2YRl4/oDCfjcyVwq06iO/riKgcArik50Hnev0iRrCQJyxzxrK02CssIyB8NxMDkoQQJn7tzHT1ENS8Ik6CMR71xUTlJ1JBNAAqrwsnZCdoUUkOADh19HIEze3gnZBHWliSIQ7JQaU4AEjRMRpSK+gQqSBF3Nl0kxOhBJgtILjUgdz+lABAn0EWERQpAhCY7R5bUNvqVVxTZBTdr9/rpPkc5F65PAV4yqqbVb/PuXzNIXSY2bm0VNgnbqyIkk2dyc08tNoQNJYuBkE9Xpa3dLC3KyCWz/j3u5mM66Uh0JPmfIxgnSTesoX+Exue0BMRZZFB8LDy5uRJNgzXVAzFRYroRBaFKNZyjsFvIUudFnEMTBvWdhQXsonOSIOfRNd0twzLQZJMFBlWXMEeagqU9nK8XxOvaLnamwxOtK28JKciibdJrkID6HICU5lDm6cXApycFV3PlRxXPYuhpFxsElXwhHdzejCI6ALjTQNQf8LFkn1MkBGk50cqDpbho5qjArwh5wmJhGjm5lFcEhC9BKOeSIUKUcoN6pk0MOeFHKEV241Msx7LdWzDHo7dXM0W8KUM1RfV8U185xalLWznFq5VfPcTRJARzV4ch+o6uOAxXaSL4Eji6UL4OjtUkhHCaTyWQymUwmk8lkMpn+Qh9yGzaB16PStAAAAABJRU5ErkJggg=="><br />
Desafio Senior Sistemas</h1>

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