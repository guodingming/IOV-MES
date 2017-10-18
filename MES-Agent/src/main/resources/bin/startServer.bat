@title mes-agent

@ECHO OFF
@REM *************************************************************************
@REM This script is used to start mes-agent.
@REM 
@REM System will load all jar-packages in 'lib' directory
@REM *************************************************************************


@REM call setEnv.cmd here
:: @call "setEnv.cmd" %*
:: @echo .

@set JAVA_OPTIONS=-Xmx512m -Xms512m -Dpaas.classpath=../lib
:: @echo %JAVA_OPTIONS%


@REM Set debug options
set DEBUG_PORT=5082
set JAVA_DEBUG=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=%DEBUG_PORT%,server=y,suspend=n
java -cp ../resources;../lib/MES-StartUp-1.0.jar %JAVA_OPTIONS% %JAVA_DEBUG% com.mes.common.main.StartUp mes-agent
@pause
