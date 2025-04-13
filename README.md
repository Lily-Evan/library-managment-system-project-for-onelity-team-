# library-managment-system-project-for-onelity-team-


# Library Management System

A simple Library Management System built using Java, Spring Boot, and SQL Database (MySQL/PostgreSQL). This system allows users to register, search, rent, and return books, while admins can manage the library's book collection.

## Features

### User Features:
- **Registration**: Users can register to the library by providing a username and password.
- **View Books**: Users can view all available books.
- **Search Books**: Users can search for books by title or author.
- **Rent Books**: Users can rent books if they are available.
- **Return Books**: Users can return books that they have rented.

### Admin Features:
- **Add Book**: Admins can add new books to the library.
- **Update Book Info**: Admins can update book details (title, author).
- **Remove Book**: Admins can remove books from the library.

### Authentication & Authorization:
- **Users**: Can only view, search, rent, and return books.
- **Admins**: Can manage the books in the library.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building the REST API.
- **Spring Data JPA**: ORM framework to interact with the database.
- **Spring Security**: For managing user authentication and authorization.
- **SQL Database**: MySQL/PostgreSQL for storing user and book information.
- **H2 Database (optional)**: For local development/testing.

## API Endpoints

The API will be available at http://localhost:8080 with these endpoints:

Authentication:


POST /api/auth/register - Register new user

POST /api/auth/login - Login user

Books (requires authentication):


GET /api/books - Get all books

GET /api/books/search?query={query} - Search books

POST /api/books/{id}/borrow - Borrow a book

POST /api/books/{id}/return - Return a book

Admin endpoints (requires ADMIN role):


POST /api/admin/books - Add new book

PUT /api/admin/books/{id} - Update book

DELETE /api/admin/books/{id} - Delete book



Admin: admin@library.com / admin

User: user@library.com / user

## Setup Instructions

1. **Clone the repository:**

  - git clone https://github.com/Lily-Evan/library-management-system.git

  
