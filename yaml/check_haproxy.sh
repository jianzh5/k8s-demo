#!/bin/bash

if [ $(ps -C haproxy --no-header | wc -l) -eq 0 ]; then    ###判断haproxy是否已经启动
    systemctl start haproxy                                ###如果没有启动，则启动haproxy程序
fi
sleep 2                                                    ###睡眠两秒钟，等待haproxy完全启动
if [ $(ps -C haproxy --no-header | wc -l) -eq 0 ]; then    ###判断haproxy是否已经启动
    systemctl stop keepalived                              ###如果haproxy没有启动起来，则将keepalived停掉，则VIP自动漂移到另外一台haproxy机器,实现了对haproxy的高可用
fi