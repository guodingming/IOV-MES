@title console

@REM *************************************************************************
@REM This script is used to start console.
@REM 
@REM System will load all jar-packages in 'lib' directory
@REM *************************************************************************


@REM call setEnv.cmd here
@call "setEnv.cmd" %*
@echo .

@set JAVA_OPTIONS="-Dpaas.classpath=../lib"
@echo %JAVA_OPTIONS%


@REM Set debug options
set DEBUG_PORT=5089
set JAVA_DEBUG=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=%DEBUG_PORT%,server=y,suspend=n
java -cp ../resources;../lib/IOV-StartUp-1.0.jar %JAVA_OPTIONS% %JAVA_DEBUG% StartUp console
@pause
