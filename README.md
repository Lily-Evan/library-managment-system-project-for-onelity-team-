# 📚 Library Management System

A simple **Library Management System** built with **Java**, **Spring Boot**, and **SQL Database** (MySQL/PostgreSQL).  
This RESTful API allows users to **register**, **search**, **rent**, and **return** books, while **admins** can manage the library's collection.

---

## ✨ Features

### 👤 User Features:
- 🔐 **Register**: Users can register with username & password.
- 📖 **View Books**: See all available books.
- 🔍 **Search**: Look up books by title or author.
- 📚 **Rent**: Rent a book if it is available.
- ↩️ **Return**: Return a book that was rented.

### 🛠️ Admin Features:
- ➕ **Add Book**: Add new books to the collection.
- ✏️ **Update Book**: Edit book info (title, author).
- ❌ **Delete Book**: Remove books from the library.

### 🔐 Authentication & Authorization:
- **Users** can: view, search, rent, and return books.
- **Admins** can: manage the entire book catalog.

---

## 🧰 Technologies Used

- ☕ **Java** – Programming language
- ⚙️ **Spring Boot** – Backend framework
- 🛢️ **Spring Data JPA** – ORM for DB access
- 🔐 **Spring Security** – Authentication & authorization
- 🗃️ **PostgreSQL / MySQL** – Primary database
- 💾 **H2** – Optional for in-memory testing

---

## 📌 API Endpoints

Base URL: `http://localhost:8080`

### 🔑 Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Login and receive JWT |

### 📚 Book Endpoints (requires authentication)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/books` | Get all books |
| `GET` | `/api/books/search?query={titleOrAuthor}` | Search books |
| `POST` | `/api/books/{id}/borrow` | Rent a book |
| `POST` | `/api/books/{id}/return` | Return a book |

### 🛠️ Admin Endpoints (requires `ADMIN` role)
| Method | Endpoint | Description |
|--------|----------|-------------|
|POST` | /api/admin/books` | Add a new book |
| PUT` | /api/admin/books/{id}` | Update book |
| DELETE` | `/api/admin/books/{id}` | Delete book |

---

## 🧪 Test Accounts

| Role | Email | Password |
|------|-------|----------|
| Admin | admin@library.com` | admin` |
| User  | user@library.com`  | user`  |

---

## 🛠️ Setup Instructions

### 🔧 Database Setup (PostgreSQL example)

1. Install PostgreSQL
2. Create the database:
   ```sql
   CREATE DATABASE library_db;

   
