@echo off



REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache\target\basic-data-service-1.0.0.BUILD-SNAPSHOT.jar

REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\data-cache-service\target\data-cache-service-1.0.0.BUILD-SNAPSHOT.jar

REM java -jar D:\myja\AI_City_as_a_Beginner\fleet-schedule-demo\schedule-service\target\schedule-service-1.0.0.BUILD-SNAPSHOT.jar

pause
curl -H "Content-Type: application/json" localhost:9000/mypoint -d @mypoint.json
pause
curl -H "Content-Type: application/json" localhost:9000/road -d @road.json
pause
curl -H "Content-Type: application/json" localhost:9000/vehicle -d @vehicle.json
pause
curl -H "Content-Type: application/json" localhost:9005/vehiclest -d @vehiclestate.json

pause