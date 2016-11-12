java -classpath src;lib\commons-cli-1.3.1.jar Main
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -h
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login XXX -pass XXX
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass XXX
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a.b
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role XXX -res a.b
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res XXX
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role WRITE -res a
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role WRITE -res a.bc
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main  -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100

echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main  -login jdoe -pass sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX
echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login X -pass X -role READ -res X -ds 2015-01-01 -de 2015-12-31 -vol XXX

echo %ERRORLEVEL%  

java -classpath src;lib\commons-cli-1.3.1.jar Main -login X -pass X -role READ -res X

echo %ERRORLEVEL%  
