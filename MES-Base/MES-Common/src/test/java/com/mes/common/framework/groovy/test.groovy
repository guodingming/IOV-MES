package com.mes.common.framework.groovy

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
def hello(name) {
    return "hello $name"
}

// 注意必须加引号，否则会在java调用的时候报错
hello("$theName")



