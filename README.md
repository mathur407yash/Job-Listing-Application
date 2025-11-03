💼 JOB LISTING WEB APPLICATION

A full-stack web application built using Spring Boot, Spring Security (OAuth2), MongoDB, and JSP — designed to register, manage, and search job posts efficiently.

🚀 FEATURES

✨ Google OAuth2 Login with Spring Security
📝 Register and manage job listings via simple form UI
🔍 Full-text search across job descriptions and skills using MongoDB Atlas Search
📄 Interactive API documentation with Swagger UI
🧩 JSP-based frontend integrated with Spring MVC
☁️ MongoDB Atlas for cloud data storage

🧠 TECH STACK

Backend: Spring Boot 3.5, Spring Security, Spring Data MongoDB
Frontend: JSP, HTML, CSS
Database: MongoDB Atlas
Authentication: Google OAuth2
Documentation: Swagger + Springdoc OpenAPI
Build Tool: Maven

🗂️ PROJECT STRUCTURE

Joblisting/
├── src/main/java/com/yash/Joblisting/
│ ├── controller/ → MVC & REST Controllers
│ ├── model/ → Data Models (Post.java)
│ ├── Repository/ → MongoDB and Search Repositories
│ ├── SecurityConfig.java → OAuth2 + Security Setup
│ └── JoblistingApplication.java → Main Class
├── src/main/resources/
│ ├── application.properties → DB & OAuth2 Configuration
│ └── /WEB-INF/views/ → JSP Pages (home.jsp, findJob.jsp, registerJob.jsp)
├── pom.xml
└── README.txt

⚙️ SETUP INSTRUCTIONS

Step 1: Clone the Repository

git clone https://github.com/mathur407yash/Job-Listing-System.git  
cd Job-Listing-System


Step 2: Configure MongoDB Atlas

Create a MongoDB cluster on Atlas

Add your connection string to application.properties

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster-url/dbname


Step 3: Setup Google OAuth2 Credentials

Go to Google Cloud Console

Create an OAuth 2.0 Client ID (Web Application)

Add redirect URI:
http://localhost:8080/login/oauth2/code/google

Copy Client ID and Secret to application.properties

Step 4: Run the Application

mvn spring-boot:run


Step 5: Access the App
🌐 Swagger UI → http://localhost:8080/swagger-ui/index.html

🏠 Home Page → http://localhost:8080/home

🖼️ SCREENSHOTS

🪄 Register Job Page → ./screenshots/register-job.png
📘 Swagger UI → ./screenshots/swagger.png


👨‍💻 AUTHOR

Name: Yash Mathur
Role: Java Backend Developer | Exploring AI & Spring Security & Microservices
Email: mathuryash407@gmail.com

GitHub: https://github.com/mathur407yash

Would you like me to now
