
# Personal Blog

Personal Blog to prosty blog stworzony w **Spring Boot** z frontendem w **HTML + TailwindCSS**.  
Blog posiada dwie sekcje:

- **Guest Section** – dostępna dla wszystkich:
    - Strona główna z listą artykułów
    - Strona pojedynczego artykułu
- **Admin Section** – dostępna tylko dla administratora:
    - Dashboard do zarządzania artykułami
    - Dodawanie nowych artykułów
    - Edycja istniejących artykułów
    - Usuwanie artykułów

---

## Funkcjonalności

- Wyświetlanie listy artykułów
- Wyświetlanie treści artykułów z datą publikacji
- Formularze dodawania i edycji artykułów
- Proste logowanie administratora (możliwość włączenia Spring Security później)
- Zapis artykułów w plikach JSON w katalogu `articles/`

---

## Struktura projektu

```
src/
  main/
    java/
      com.example.blog/
        controller/       # kontrolery dla guest i admin
        service/          # logika biznesowa bloga
        model/            # obiekty: Article, User
        storage/          # zapis/odczyt plików JSON
    resources/
      templates/           # widoki HTML (Thymeleaf)
        guest/
        admin/
      static/              # CSS, Tailwind, obrazy
articles/                 # pliki JSON z artykułami
```

---

## Instalacja i uruchomienie

1. Sklonuj repozytorium
2. Zainstaluj JDK 17+ i Maven
3. Uruchom projekt w IDE lub w terminalu:

```bash
mvn spring-boot:run
```

5. Otwórz przeglądarkę i przejdź na:

- `/` – strona główna bloga
- `/article/{id}` – strona pojedynczego artykułu
- `/admin` – panel administratora (wymaga logowania)

---

## Technologie

- Java 17+
- Spring Boot 3+
- Thymeleaf (templating HTML)
- TailwindCSS (frontend)
- JSON (przechowywanie artykułów)

---

## Paleta kolorów bloga

- **Primary Dark**: slate-900 (#213448)
- **Primary**: slate-600 (#547792)
- **Accent**: slate-300 (#94B4C1)
- **Background**: stone-100 / stone-200 (#EAE0CF)

---
