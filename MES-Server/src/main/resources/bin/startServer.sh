#!/bin/sh
#
# start cloud service
#
###EOF

prog=mes-server
export JAVA_HOME=/opt/jdk1.8.0_101
export DEPLOY_PATH=$(cd `dirname $0`/..; pwd)
export DEBUG_PORT=5084

if [ ! -d $JAVA_HOME ];then
    echo "please set right JAVA_HOME in this file"
    exit 0
fi

if [ ! -d $DEPLOY_PATH ];then
    echo "please set right DEPLOY_PATH in this file"
    exit 0
fi

function usage(){
cat << EOF
Usage: startServer.sh --port <port>  [options]

Options:
    --help | -h Print usage information.
    --port | -p Set java debug port, default value(5084).
EOF

exit $1
}

while [ $# -gt 0 ]; do
    case "$1" in
        -h|--help) usage 0 ;;
        -p|--port) shift; DEBUG_PORT=$1 ;;
        *) shift ;; # ignore
    esac
    shift
done


export JAVA_OPTIONS="-Xmx512m -Xms256m"
export CLASSPATH=${CLASSPATH}:${DEPLOY_PATH}/lib/MES-StartUp-1.0.jar:${DEPLOY_PATH}/resources

export JAVA_DEBUG="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=n"

${JAVA_HOME}/bin/java ${JAVA_OPTIONS} ${JAVA_DEBUG} \
-Dcom.dc.install_path=${DEPLOY_PATH}/resources \
-Dpaas.classpath=${DEPLOY_PATH}/lib com.mes.common.main.StartUp $prog &
