#!/bin/sh
#
# stop cloud service
#
###EOF 

prog=mes-restful

pid=`ps ax|grep $prog | grep java | grep -v grep|awk '{print $1}'`
if [ ! "$pid" ];then
  echo "$prog is not running"
else
  echo -e "stop $prog : $pid"
  kill -9 $pid
fi

exit 0

