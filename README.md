# Trip Buddy - Android MVVM Clean Architecture with Jetpack Compose

This is a **Kotlin-based Android project** demonstrating the use of **MVVM Clean Architecture** and **Jetpack Compose** for building a scalable and maintainable Android application.

## 📽️ Demo
<img src="./github/demo.gif" alt="Demo Animation" width="300">

## 🚀 Features
- **MVVM Clean Architecture:** Separation of concerns with distinct layers for UI, Domain, and Data.
- **Jetpack Compose:** Modern declarative UI toolkit for Android.
- **State Management:** Using `StateFlow` and `MutableStateFlow`.
- **Dependency Injection:** Implemented using **Hilt**.
- **Coroutines & Flow:** For asynchronous data handling.
- **LiveData & StateFlow:** For reactive UI updates.
- **Navigation Component:** Managing in-app navigation.

---

## 📦 Project Structure
The project follows **MVVM Clean Architecture**:

```plaintext
app
├── data                # Data layer (Repository, Local, Remote, Models)
│   └── repository
│   └── datasource
│   └── model
│
├── domain              # Domain layer (Use Cases, Repository Interfaces)
│   └── model
│   └── usecase
│   └── repository
│
├── presentation        # Presentation layer (UI Components, ViewModel)
│   └── ui
│   └── viewmodel
│
├── core                # Core utilities and shared resources
│   └── di
│   └── utils
│
└── build.gradle        # Project dependencies and plugins
```

---

## 📦 Technologies Used
- **Kotlin**
- **Jetpack Compose**
- **Hilt (DI)**
- **StateFlow & MutableStateFlow**
- **Coroutines & Flow**
- **Navigation Component**
- **Room Database**


---

## 🎯 Future Improvements
- Add **dark mode** support.
- Implement **remote data synchronization**.

---

## 📄 License
This project is licensed under the **MIT License**.

---

🌟 **Contributions are welcome!** Feel free to submit issues or pull requests.

