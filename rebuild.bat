@echo off
echo Membersihkan dan rebuild project...
call gradlew clean
call gradlew build
echo.
echo Selesai! Sekarang buka Android Studio dan lakukan Sync Project with Gradle Files.
pause

