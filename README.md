# Personal Blog -- Spring Boot Glassmorphism Blog

Nowoczesna aplikacja blogowa z panelem admina, logowaniem oraz zapisem
artykułów do plików JSON.\
Projekt wykonany jako zadanie z roadmap.sh - **Personal Blog Project**.

------------------------------------------------------------------------

## Features

- CRUD artykułów (Create, Read, Update, Delete)\
- Logowanie administratora (Spring Security)\
- Zapis danych do plików JSON\
- Glassmorphism UI + TailwindCSS\

------------------------------------------------------------------------

## Tech Stack

    - Backend    Java 21, Spring Boot, Spring Security
    - Frontend   Thymeleaf, TailwindCSS
    - Storage    JSON files
    - Build      Maven

------------------------------------------------------------------------

## ▶ Uruchomienie

``` bash
git clone https://github.com/absolutecoder01/personal_blog_backend_app.git
cd personal_blog_backend_app
mvn spring-boot:run
```

### Adresy
     Strona     URL
    ----------- --------------------------------------
    - Homepage   http://localhost:8080/homepage
    - Admin      http://localhost:8080/admin
    - Login      automatycznie przy wejściu do admina

### Dane logowania

    login: admin
    hasło: admin123

------------------------------------------------------------------------

## Struktura

    personal_blog_backend_app/
     ├─ articles/          ← pliki JSON z artykułami
     ├─ src/
     ├─ pom.xml

------------------------------------------------------------------------

## Podgląd

Glassmorphism UI inspirowany nowoczesnymi dashboardami SaaS.

------------------------------------------------------------------------

## Autor

**absolutecoder01**

------------------------------------------------------------------------

