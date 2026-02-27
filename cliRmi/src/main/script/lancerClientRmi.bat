set M2_REPOSITORY=C:\Users\d2fde\.m2\repository
REM set CP="./servRmi-api-0.0.1-SNAPSHOT.jar;./cliRmi-0.0.1-SNAPSHOT.jar"
set CP="%M2_REPOSITORY%/tp/servRmi-api/0.0.1-SNAPSHOT/servRmi-api-0.0.1-SNAPSHOT.jar;%M2_REPOSITORY%/tp/cliRmi/0.0.1-SNAPSHOT/cliRmi-0.0.1-SNAPSHOT.jar"
set REMOTE_HOST=localhost
REM set REMOTE_HOST=192.168.0.200
java -cp %CP% tp.client.MiniBankSimpleClient %REMOTE_HOST%
pause