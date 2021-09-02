<h2>Prova técnica Verzel</h2>

Nesta prova foi pedido que fizesse as seguintes funcionalidades:
* Home Page pública com a vitrine de veículos (Não está pública)
* O cadastro de veículos deverá haver um login administrativo (OK)
* Páginas de cadastro seguras, apenas acessadas após login. (OK) 
* TOdas as requisições privadas precisam de um token válido. (OK)
* CRUD do cadastro de veículos (OK)
* Atributos obrigatórios dos veículos são: Id, Nome, Marca, Modelo e Foto; (Menos a foto)
* Back-end com API REST; (OK)
* Todos os dados devem ser persistidos no Banco de Dados, menos as imagens; (Menos a Foto)
* Conter o README explicando o passo a passo da funcionalidade do projeto; (OK)


Para executar o back-end, digite o seguinte comando:

```shell script
cd backend 
mvn clear install
mvn spring-boot:run 
```

Para executar o front-end, digite o seguinte comando:

```shell script
cd frontend 
npm install
npm start
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:3000
```

Foram utilizados as seguintes tecnologias:

* Intellj IDEA Community Edition.
* Java 11.
* Maven.
* Spring Boot
* Spring Security
* JWT
* API REST
* GIT.
* POSTGRESQL
* ReactJS
* React-Admin



