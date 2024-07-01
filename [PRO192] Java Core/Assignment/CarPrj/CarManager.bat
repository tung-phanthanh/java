@echo off
setlocal

REM Set the path to the JDK bin directory
set JAVA_HOME="C:\Program Files\Java\jdk1.8.0_181"
set PATH=%JAVA_HOME%\bin;%PATH%

REM Navigate to the directory containing the Java source files
cd /d "%~dp0"

REM Compile the Java source files
echo Compiling Java files...
javac -d build/classes src/Classes/Com/*.java src/Classes/CarManager.java

REM Check if compilation succeeded
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

REM Run the CarManager main class
echo Running CarManager...
java -cp build/classes Classes.CarManager

REM Pause the script to keep the window open
pause

endlocal