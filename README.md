# 🛒 Catálogo de Vendas Online (E-commerce)

> **Status:** 🚧 Em desenvolvimento 

---

## 📋 Descrição do Projeto

Aplicação **back-end completa** para gerenciamento de um **catálogo de vendas online**, com arquitetura orientada ao domínio, autenticação segura e foco em **escalabilidade e boas práticas de engenharia de software**.

O sistema possibilita o **cadastro, listagem e gerenciamento de produtos**, além do **acesso autenticado ao painel administrativo** via **JWT (JSON Web Token)**.

---

## 🚀 Tecnologias e Ferramentas

**Backend:**

* Java 17+
* Spring Boot
* Spring Security (autenticação JWT)
* Spring Data JPA / Hibernate
* Flyway (controle de versão do banco)
* JUnit 5 & Mockito (testes automatizados)


**Banco de Dados:**

* MySQL

**Outras Ferramentas:**

* Postman (testes de API)

---

## 🧠 Principais Funcionalidades

✅ Autenticação e autorização via **JWT**
✅ Painel administrativo com **controle de acesso seguro**
✅ CRUD completo de **produtos e categorias**
✅ **DTOs** para desacoplamento entre camadas
✅ Versionamento de banco com **Flyway**
✅ Testes unitários e de integração com **JUnit5 / Mockito**
✅ Deploy automatizado no **Railway**

---

## ⚙️ Estrutura da Arquitetura

O projeto segue uma **arquitetura orientada ao domínio (DDD simplificada)**:

```
src/
 ├── main/
 │   ├── java/com/seuprojeto/ecommerce/
 │   │   ├── controller/
 │   │   ├── dto/
 │   │   ├── entity/
 │   │   ├── repository/
 │   │   ├── service/
 │   │   └── security/
 │   └── resources/
 │       ├── application.properties
 │       └── db/migration/ (Flyway scripts)
 └── test/
     └── java/com/seuprojeto/ecommerce/
```

---

## 🧩 Endpoints Principais (exemplo)

| Método | Endpoint         | Descrição                   | Autenticação |
| ------ | ---------------- | --------------------------- | ------------ |
| POST   | `/auth/login`    | Autenticação de usuário     | ❌            |
| GET    | `/produtos`      | Listar produtos disponíveis | ❌            |
| POST   | `/produtos`      | Cadastrar novo produto      | ✅ Admin      |
| PUT    | `/produtos/{id}` | Atualizar produto existente | ✅ Admin      |
| DELETE | `/produtos/{id}` | Remover produto             | ✅ Admin      |

---

## 🧪 Testes

Os testes são realizados com **JUnit5** e **Mockito**, cobrindo:

* Serviços e regras de negócio
* Validações e exceções
* Integração com repositórios

Para rodar os testes:

```bash
./mvnw test
```

---

## 🧑‍💻 Como Executar Localmente

```bash
# Clonar repositório
git clone https://github.com/seuusuario/ecommerce-catalogo.git

# Entrar na pasta
cd ecommerce-catalogo

# Executar a aplicação
./mvnw spring-boot:run
```

Acesse em:
👉 `http://localhost:8080`

---

## 📚 Aprendizados e Boas Práticas

Durante o desenvolvimento, foram aplicadas diversas boas práticas:

* **SOLID e Clean Code**
* **Camadas bem definidas e desacopladas**
* **Validação e tratamento de exceções personalizados**
* **Documentação de endpoints com Postman**

---

## 🧾 Licença

Este projeto está sob a licença MIT.
Sinta-se à vontade para usar e contribuir! 🤝

---

### 📸 (Opcional)

Adicione aqui **prints da interface**, **coleções do Postman** ou **diagrama da arquitetura** para enriquecer o README.
