set M2_REPOSITORY=C:\Users\didier\.m2\repository
set CP="./servRmi-api-0.0.1-SNAPSHOT.jar;./servRmi-impl-0.0.1-SNAPSHOT.jar"
REM set CP="%M2_REPOSITORY%/tp/servRmi-api/0.0.1-SNAPSHOT/servRmi-api-0.0.1-SNAPSHOT.jar;%M2_REPOSITORY%/tp/servRmi-impl/0.0.1-SNAPSHOT/servRmi-impl-0.0.1-SNAPSHOT.jar"
java -cp %CP% tp.serveur.app.AppServMiniBank
pause