echo Group#1
java -classpath src;lib\commons-cli-1.3.1.jar Main
echo Error level %ERRORLEVEL% - expected 0

java -classpath src;lib\commons-cli-1.3.1.jar Main -h
echo Error level %ERRORLEVEL% - expected 0

echo Group#2
java -classpath src;lib\commons-cli-1.3.1.jar Main -login XXX -pass XXX
echo Error level %ERRORLEVEL% - expected 1

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass XXX
echo Error level %ERRORLEVEL% - expected 2  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ
echo Error level %ERRORLEVEL% - expected 0  

echo Group#3
java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a
echo Error level %ERRORLEVEL% - expected 0  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a.b
echo Error level %ERRORLEVEL% - expected 0  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role XXX -res a.b
echo Error level %ERRORLEVEL% - expected 3 

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res XXX
echo Error level %ERRORLEVEL% - expected 4 

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role WRITE -res a
echo Error level %ERRORLEVEL% - expected 4 

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role WRITE -res a.bc
echo Error level %ERRORLEVEL% - expected 4  

echo Group#4
java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100
echo Error level %ERRORLEVEL% - expected 0  

java -classpath src;lib\commons-cli-1.3.1.jar Main  -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100
echo Error level %ERRORLEVEL% - expected 5  

java -classpath src;lib\commons-cli-1.3.1.jar Main  -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX
echo Error level %ERRORLEVEL% - expected 5  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login X -pass X -role READ -res X -ds 2015-01-01 -de 2015-12-31 -vol XXX
echo Error level %ERRORLEVEL% - expected 1  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login X -pass X -role READ -res X
echo Error level %ERRORLEVEL% - expected 1  

pause
