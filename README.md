# 🌟 UTS LOGIN COMPOSE: PAKET C  

Aplikasi **Form Login + Remember Me** dibuat menggunakan **Jetpack Compose** sebagai tugas UTS Mata Kuliah *Mobile Programming*.  
Aplikasi ini menampilkan implementasi **navigasi multi-screen**, **penyimpanan data sederhana (DataStore)**, dan **fitur Remember Me** menggunakan Kotlin.

---

## 📱 Fitur Aplikasi

### 1. Splash / Welcome Screen
- Menampilkan logo dan nama aplikasi.
- Mengecek apakah ada data login (username) tersimpan di DataStore.
- Jika data login ditemukan → langsung menuju **Dashboard**.
- Jika tidak → tampilkan tombol **Masuk** untuk ke layar login.

### 2. Form Login
- Input **username** dan **password**.
- Checkbox **“Ingat saya”** untuk menyimpan username ke storage.
- Tombol **Login** untuk masuk ke Dashboard.
- Tombol hanya berfungsi jika login benar dengan: username = mhs dan password = 123
- Jika username/password salah → muncul pesan error.
- Kolom password memiliki tombol **👁️ untuk menampilkan/menyembunyikan password**.

### 3. Dashboard
- Menampilkan teks sambutan: Selamat datang, <username>
- Tombol **Hapus Data Login / Keluar** untuk menghapus data dari DataStore dan kembali ke layar Login.

---

## ⚙️ Teknologi yang Digunakan

| Komponen | Teknologi |
|-----------|------------|
| Bahasa Pemrograman | Kotlin |
| Framework UI | Jetpack Compose (Material 3) |
| Navigation | androidx.navigation.compose |
| Penyimpanan Data | DataStore Preferences |
| IDE | Android Studio |
| Min SDK | 24 |
| Target SDK | 34 |
| Compose Compiler | 1.5.3 |

---

## 🧩 Struktur Proyek

```bash
UTSLoginCompose/
├── app/
│   ├── src/main/
│   │   ├── java/id/antasari/uts_mp_230104040212/
│   │   │   ├── MainActivity.kt
│   │   │   ├── data/
│   │   │   │   └── DataStoreManager.kt
│   │   │   ├── navigation/
│   │   │   │   └── NavGraph.kt
│   │   │   └── ui/
│   │   │       ├── screens/
│   │   │       │   ├── SplashScreen.kt
│   │   │       │   ├── LoginScreen.kt
│   │   │       │   └── DashboardScreen.kt
│   │   │       └── theme/
│   │   │           ├── Color.kt
│   │   │           ├── Theme.kt
│   │   │           └── Type.kt
│   │   └── res/
│   │       ├── drawable/
│   │       │   └── logo.png
│   │       └── values/
│   │           ├── colors.xml
│   │           ├── themes.xml
│   │           └── strings.xml
│   └── build.gradle.kts
└── README.md
```
