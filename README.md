# 🚀 AI Product Finder Backend

AI Product Finder Backend is a Spring Boot REST API that powers the AI Product Finder platform. It provides AI-powered product recommendations, authentication, wishlist management, search history tracking, product comparison, and admin analytics.

---

# 🔗 Project Links

### 🌐 Live Application
https://ai-product-finder-frontend.vercel.app

### 💻 Frontend Repository
https://github.com/LavanyaSriChava/ai-product-finder-frontend

### ⚙️ Backend Repository
https://github.com/LavanyaSriChava/ai-product-finder-Backend

---

# ✨ Features

## 🤖 AI Product Recommendation
- Public AI-powered product search
- Natural language query support
- OpenRouter AI integration
- Smart product recommendations

## ⚖️ Product Comparison
- Compare two products using AI
- Feature-by-feature comparison
- Recommendation verdict generation

## 🔐 Authentication & Authorization
- User Registration
- User Login
- JWT Authentication
- Stateless Security
- Role-Based Access Control

## ❤️ Wishlist Management
- Add products to wishlist
- Remove products from wishlist
- View saved wishlist items
- User-specific data management

## 📜 Search History
- Automatically stores searches for authenticated users
- View previous searches
- Delete individual searches
- Clear complete history

## 👨‍💼 Admin Dashboard
- Admin-only access
- Platform monitoring
- Search analytics
- User insights

## 🛡️ Security Features
- Spring Security
- JWT Token Validation
- Protected API Endpoints
- Secure Password Encryption using BCrypt

---

# 🏗️ Tech Stack

## Backend Framework
- Java 21
- Spring Boot 3
- Spring MVC

## Security
- Spring Security
- JWT Authentication
- BCrypt Password Encoder

## Database
- PostgreSQL
- Spring Data JPA
- Hibernate ORM

## AI Integration
- OpenRouter API
- Large Language Models (LLMs)

## API Development
- RESTful APIs
- DTO Pattern
- Exception Handling

## Documentation
- Swagger/OpenAPI

## Build Tool
- Maven

## Deployment
- Railway

---

# 📂 Project Structure

```text
src
├── controller
├── service
│   └── impl
├── repository
├── entity
├── dto
├── security
├── exception
├── enums
└── config
```

---

# 🔐 User Roles

## Guest User
- Search products using AI

## Registered User
- Search products
- Save Wishlist
- Access Search History

## Admin
- All User Features
- Access Analytics Dashboard

---

# 📡 Main API Endpoints

## Authentication

```http
POST /api/auth/register
POST /api/auth/login
```

## AI Search

```http
POST /api/ai/search
POST /api/ai/compare
```

## Wishlist

```http
GET    /api/wishlist
POST   /api/wishlist
DELETE /api/wishlist/{id}
```

## Search History

```http
GET    /api/search-history
DELETE /api/search-history/{id}
DELETE /api/search-history/clear
```

## Admin

```http
GET /api/admin/dashboard
```

---

# 🚀 Deployment

### Frontend
- Vercel

### Backend
- Railway

### Database
- PostgreSQL

---

# 👨‍💻 Author

**Lavanya Chava**

GitHub:
https://github.com/LavanyaSriChava

LinkedIn:
https://linkedin.com/in/lavanya-sri-chava-6b57a02a9

---

⭐ If you found this project interesting, consider giving it a star.
