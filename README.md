# 🌐 Java Enterprise Edition - Full Technical Training
### Developer: Mallu200 | Program: X-Workz Java-EE
### Project: AquaLink Manager (Enterprise Utility Platform)

This repository is a professional archive of my transition from standalone logic to **Enterprise-Grade Distributed Systems**. It documents my mastery of the Java EE ecosystem, focusing on the development of the "AquaLink Manager" platform.

---

## 🏗️ Technical Roadmap (Modules)
I have categorized my enterprise training into the following core competencies, following a decoupled architectural approach:

### 1. The Web Layer (Request Orchestration)
* **Servlets & Lifecycle**: Implementation of `HttpServlet`, `doGet`, `doPost`, and `ServletConfig`.
* **Dynamic Views**: `JSP` (JavaServer Pages), `JSTL` (JSP Standard Tag Library), and Expression Language (`EL`).
* **Session Management**: Handling state across requests using `HttpSession` and `Cookies`.
* **Flow Control**: `RequestDispatcher` (Forward vs. Include) and Response Redirects.

### 2. The Dependency Injection Layer (CDI)
* **Weld Container**: Managed bean lifecycles and scope management (`@RequestScoped`, `@ApplicationScoped`).
* **Inversion of Control**: Using `@Inject` to decouple Controllers from Business Logic.
* **Configuration**: Metadata handling via `beans.xml` and Jandex index discovery.

### 3. The Persistence & Transaction Layer (ORM, JPA & JTA)
* **Hibernate Core**: `Entity Mapping`, `Session Management`, and XML/Annotation Configuration.
* **JPA Standards**: `EntityManager`, `Persistence Context`, and `@Entity` mapping.
* **Transaction Management**: Implementing **JTA** for Atomic, Consistent, Isolated, and Durable (ACID) transactions.
* **Database Sync**: `hbm2ddl` strategies (Create/Update) and SQL Schema synchronization.

---

## 🏛️ Enterprise Specifications (Jakarta EE)
This project is built using industry-standard specifications to ensure scalability, portability, and enterprise compliance:

* **Java Servlet API (JSR 369)**: For robust HTTP request processing and web container management.
* **Contexts and Dependency Injection (CDI - JSR 365)**: Using **Weld** to manage the lifecycle of enterprise beans.
* **Java Persistence API (JPA - JSR 338)**: Utilizing **Hibernate** as the provider for Object-Relational Mapping (ORM).
* **Java Transaction API (JTA - JSR 907)**: For managing distributed transactions and ensuring data integrity across the repository layer.
* **Bean Validation (JSR 380)**: Implementing **Hibernate Validator** for metadata-driven data integrity and server-side constraints.
* **JavaServer Pages (JSR 245)**: For creating high-performance, platform-independent dynamic web content.

---

## 🛡️ Capstone Project: AquaLink Manager
The **"aqua-link-manager"** project is the culmination of the Java EE modules. It is a production-grade **Water Connection Management System** featuring:



* **Layered Architecture**: `Controller` -> `Service` -> `Repository` -> `Database`.
* **Transaction Integrity**: Secure data writes using JTA-compliant transaction boundaries.
* **Data Transfer**: Clean `DTO` patterns for mapping Request data to Entities.
* **Validation**: Enterprise data sanitization using JSR 380 standards.
* **Persistence**: Full CRUD integration with **MySQL 8.0** using JPA and centralized Resource Providers.

---

## 🛠️ Skills & Tools Demonstrated
* **Database**: MySQL Workbench, JDBC Drivers, SQL Constraints.
* **Design Patterns**: MVC (Model-View-Controller), Singleton, DAO, and DTO.
* **Server**: Apache Tomcat 9.0 configuration and deployment.
* **Build Tool**: Maven (`pom.xml` dependency and lifecycle management).
* **Logging**: Real-time SOP and Error tracking via Tomcat server logs.



---

## 📂 Project Structure
```text
aqua-link-manager/
├── src/main/java/com/xworkz/aqualink/
│   ├── controller/    # Servlet Orchestration & Web Flow
│   ├── service/       # Business Logic & Validation
│   ├── repository/    # JPA-based Data Access & JTA Transactions
│   ├── entity/        # Hibernate Mapping Classes
│   └── dto/           # Request/Response Data Transfer Objects
├── src/main/resources/
│   └── META-INF/      # persistence.xml (DB Config)
└── src/main/webapp/
    ├── WEB-INF/       # beans.xml (CDI) & web.xml
    └── views/         # JSP/JSTL Presentation Layer
