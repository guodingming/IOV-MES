package com.mes.common.framework.groovy;

import com.google.common.collect.Maps;
import com.mes.common.function.FunctionParameter;
import groovy.lang.GroovyClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import java.io.*;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
public class GroovyUtil {
    private static Logger logger = LoggerFactory.getLogger(GroovyUtil.class);

    private static ScriptEngineManager manager = new ScriptEngineManager();

    /**
     * 依次以传入的参数作为key-value创建一个map
     *
     * @param kvs 依次排列的key-value对
     * @return
     */
    public static Map<String, Object> buildMap(Object... kvs) {
        Map<String, Object> result = Maps.newHashMap();
        for (int i = 0; i < kvs.length - 1; i += 2) {
            result.put(kvs[i].toString(), kvs[i + 1]);
        }
        return result;
    }

    /**
     * 执行一段文本表示的脚本片段，得到返回值
     *
     * @param script 脚本片段，如：return "hello $name!"
     * @param params 脚本中使用的变量名称和值的映射，如：{"name":"Jack"}
     * @return
     */
    public static Object evalScript(String script, Map<String, Object> params) throws ScriptException {
        ScriptEngine engine = manager.getEngineByName("groovy");
        if (params == null) {
            params = buildMap();
        }
        Bindings bindings = new SimpleBindings(params);
        return engine.eval(script, bindings);
    }

    /**
     * 执行一段文本表示的脚本片段，得到返回值
     *
     * @param script    脚本片段
     * @param parameter 传入脚本的参数内容，名称为parameter。脚本返回值放入该参数的responseMap属性中
     * @return
     */
    public static Object evalScript(String script, FunctionParameter parameter) throws ScriptException {
        ScriptEngine engine = manager.getEngineByName("groovy");
        Map<String, Object> params = Maps.newHashMap();
        params.put("parameter", parameter);
        Bindings bindings = new SimpleBindings(params);
        return engine.eval(script, bindings);
    }

    /**
     * 执行一个脚本文件，得到返回值
     *
     * @param file   脚本文件路径
     * @param params 脚本中使用的变量名称和值的映射
     * @return
     */
    public static Object runScriptFile(String file, Map<String, Object> params) throws ScriptException, FileNotFoundException {
        logger.debug("run script file: " + file);
        Reader reader = new FileReader(new File(file));
        ScriptEngine engine = manager.getEngineByName("groovy");
        if (params == null) {
            params = buildMap();
        }
        Bindings bindings = new SimpleBindings(params);
        return engine.eval(reader, bindings);
    }

    /**
     * 调用脚本片段中的一个函数
     *
     * @param script 脚本片段
     * @param fn     函数名称
     * @param params 脚本中使用的变量名称和值的映射
     * @param args   函数需要的参数
     * @return
     */
    public static Object invokeFnInScript(String script, String fn, Map<String, Object> params, Object... args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = manager.getEngineByName("groovy");
        if (params == null) {
            params = buildMap();
        }
        Bindings bindings = new SimpleBindings(params);
        engine.eval(script, bindings);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(fn, args);
    }

    /**
     * 调用一个脚本文件中定义的函数
     *
     * @param file   脚本文件
     * @param fn     函数名称
     * @param params 脚本中使用的变量名称和值的映射
     * @param args   函数需要的参数
     * @return
     */
    public static Object invokeFnInFile(String file, String fn, Map<String, Object> params, Object... args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngine engine = manager.getEngineByName("groovy");
        if (params == null) {
            params = buildMap();
        }
        Bindings bindings = new SimpleBindings(params);
        engine.eval(new FileReader(new File(file)), bindings);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(fn, args);
    }

    /**
     * 从文件中加载groovy class
     *
     * @param file 脚本文件
     * @return
     */
    public static Class loadClassFromFile(String file) {
        GroovyClassLoader cl = new GroovyClassLoader(GroovyUtil.class.getClassLoader());
        try {
            return cl.parseClass(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从文本中加载groovy class
     *
     * @param text 脚本片段
     * @return
     */
    public static Class loadClassFromText(String text) {
        GroovyClassLoader cl = new GroovyClassLoader(GroovyUtil.class.getClassLoader());
        return cl.parseClass(text);
    }
}
