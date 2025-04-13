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

### User Endpoints:
- POST /api/users/register`: Register a new user.
- GET /api/books`: Get all available books.
  `GET /api/books/search?title={title}`: Search books by title.
- GET /api/books/search?author={author}`: Search books by author.
- POST /api/rent/{bookId}`: Rent a book.
- POST /api/return/{bookId}`: Return a rented book.

### Admin Endpoints (secured):
- POST /api/admin/books`: Add a new book.
- PUT /api/admin/books/{bookId}`: Update book details.
- DELETE /api/admin/books/{bookId}`: Remove a book.

## Setup Instructions

1. **Clone the repository:**
   ```bash
  - git clone https://github.com/Lily-Evan/library-management-system.git

  
