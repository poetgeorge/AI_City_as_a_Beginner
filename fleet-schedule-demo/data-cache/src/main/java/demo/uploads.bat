@echo off


REM pause
REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache\target\basic-data-service-1.0.0.BUILD-SNAPSHOT.jar
REM pause
REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache-service\target\data-cache-service-1.0.0.BUILD-SNAPSHOT.jar
REM pause
REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\schedule-service\target\schedule-service-1.0.0.BUILD-SNAPSHOT.jar

pause
curl -H "Content-Type: application/json" localhost:9000/mypoint -d @D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache\src\main\java\demo\mypoint.json
pause
curl -H "Content-Type: application/json" localhost:9000/road -d @D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache\src\main\java\demo\road.json
pause
curl -H "Content-Type: application/json" localhost:9000/vehicle -d @D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache\src\main\java\demo\vehicle.json
pause
curl -H "Content-Type: application/json" localhost:9005/vehiclest -d @D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache-service\src\main\java\demo\vehiclestate.json

pause