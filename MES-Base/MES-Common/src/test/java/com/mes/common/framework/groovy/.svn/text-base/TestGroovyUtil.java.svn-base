package com.mes.common.framework.groovy;

import com.google.common.collect.Maps;
import com.mes.common.function.FunctionParameter;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by xiuyou.xu on 2017/6/28.
 */
public class TestGroovyUtil {
    @Test
    public void testEvalScript() throws ScriptException {
        Object o = GroovyUtil.evalScript("\"hello $name!\"", GroovyUtil.buildMap("name", "Jack"));
        System.out.println(o);
    }

    @Test
    public void testInvokeJava() throws ScriptException {
        Object o = GroovyUtil.evalScript("import com.mes.common.utils.FileUtils;return FileUtils.getExt(new File(\"d:/deps.txt\"))", GroovyUtil.buildMap());
        System.out.println(o);
    }

    /**
     * d:/test.grovy
     * <pre>
     * def hello(name) {
     *     return "hello $name"
     * }
     *
     * // 注意必须加引号，否则会在java调用的时候报错
     * hello("$theName")
     * </pre>
     */
    @Test
    public void testRunScriptFile() throws ScriptException, FileNotFoundException {
        Object o = GroovyUtil.runScriptFile("d:/test.groovy", GroovyUtil.buildMap("theName", "Jack"));
        System.out.println(o);
    }

    @Test
    public void testRunScriptFile2() throws ScriptException, FileNotFoundException {
        FunctionParameter parameter = new FunctionParameter();
        Map<String, Object> req = Maps.newHashMap();
        req.put("abc", "def");
        parameter.setRequestMap(req);
        Object o = GroovyUtil.runScriptFile("D:\\workspace\\IOV-MES\\MES-Function\\src\\main\\java\\com\\mes\\groovy\\myservice.groovy", GroovyUtil.buildMap("parameter", parameter));
        System.out.println(o);
    }

    @Test
    public void testInvokeFnInFile() throws NoSuchMethodException, ScriptException, FileNotFoundException {
        Object o = GroovyUtil.invokeFnInFile("d:/test.groovy", "hello", GroovyUtil.buildMap("theName", "Tom"), "Jack");
        System.out.println(o);
    }

    @Test
    public void testInvokeFnInFile2() throws NoSuchMethodException, ScriptException, FileNotFoundException {
        Object o = GroovyUtil.runScriptFile("D:\\workspace\\IOV-MES\\MES-Server\\src\\main\\java\\com\\mes\\control\\groovy\\byteop\\byte-op-6.groovy",  GroovyUtil.buildMap("content", "30021256A00"));
        System.out.println(o);
    }
}
