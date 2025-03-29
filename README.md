# 🗃️ Android Room Database Example

This repository contains a simple implementation of local data persistence in Android using [Room](https://developer.android.com/training/data-storage/room), a Jetpack library that provides an abstraction layer over SQLite.

This project is a **practical companion** to my Medium article:

📖 **[Simplifying Android Data Persistence with Room](https://guilhermevcs.medium.com/simplifying-android-data-persistence-with-room-14bc3e1fcf09)**

---

## 📌 About the Project

This is a basic Android app that demonstrates how to configure and use Room for storing data locally with minimal boilerplate. It covers the essential components:

- **Entity** – defines the data model.
- **DAO** – provides methods to interact with the database.
- **Database** – holds the database instance.
- **Application class** – initializes Room as a singleton.
- **MainActivity** – demonstrates inserting data into the database.

The example uses an `Airport` entity with fields like `id`, `iataCode`, `name`, and `passenger`.

---

## 🧱 Tech Stack

- Kotlin
- Jetpack Compose
- Room (version `2.6.1`)
- Kotlin Symbol Processing (KSP)
- Coroutines for asynchronous database operations

---
