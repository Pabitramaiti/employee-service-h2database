@echo off
:loop
curl -s -o NUL -I -w "%%{http_code}" -X GET http://localhost:8080/employee/getEmployees
echo.
REM curl -X GET https://www.google.com
goto loop