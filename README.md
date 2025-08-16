 Microservices-applikation – Produkt & Ordertjänst

 Projektöversikt
Detta projekt är en distribuerad applikation byggd med **Spring Boot**, **MySQL** och **REST API** i en mikrotjänst-arkitektur. Applikationen består av två tjänster:

- `ProductService`: Hanterar CRUD-operationer för produkter.
- `OrderService`: Hanterar ordrar och kommunicerar med `ProductService` för att hämta produktinformation.

Varje tjänst använder en egen MySQL-databas och körs lokalt i utvecklingsmiljö via profiler (`local`).

 Notering: Applikationen har tidigare varit distribuerad på AWS Elastic Beanstalk och testad med Postman via riktiga URL:er, vilket kan ses i bifogade skärmdumpar. På grund av höga kostnader för AWS valde vi dock att stoppa miljön och istället genomföra slutliga tester lokalt via `localhost`.

---

 Tekniker
- Java 17
- Spring Boot
- Spring Data JPA
- WebClient (för REST-kommunikation mellan tjänster)
- MySQL
- Postman

---

 Så här kör du tjänsterna lokalt

 1. Starta MySQL
- Skapa två databaser:
  - `products_db`
  - `orders_db`
- Användare: `root`
- Lösenord: `Mysql123`

 2. Kör ProductService
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```
Port: **8081**

### 3. Kör OrderService
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```
Port: **8082**

---

 API-specifikation

 ProductService

 `GET /api/products`
Hämtar alla produkter.

 `POST /api/products`
Skapar en ny produkt.
```json
{
  "name": "iPhone 14",
  "price": 14999,
  "quantity": 20
}
```

---

 OrderService

 `GET /api/orders`
Hämtar alla ordrar.

 `POST /api/orders`
Skapar en ny order och hämtar produktinfo från `ProductService`.
```json
{
  "productId": 1,
  "quantity": 2
}
```

---

 Postman

En färdig Postman Collection med samtliga anrop finns bifogad i projektet:  
**`collection.postman_collection.json`**

---

 Projektstruktur

```
.
├── orderservice/
│   ├── src/...
│   ├── pom.xml
│   └── application-local.properties
├── productservice/
│   ├── src/...
│   ├── pom.xml
│   └── application-local.properties
├── collection.postman_collection.json
├── NOTE_TO_TEACHER.md
└── README.md
```

---

 Testmiljö

- Projektet körs endast lokalt i denna version.
- Deployment till AWS Elastic Beanstalk utelämnas enligt instruktion.
- Jar-filer finns genererade i respektive `target/`-mapp.

---

 👤 Gruppmedlem

- **Ali Asgari** – ansvarig för både `ProductService` och `OrderService`.