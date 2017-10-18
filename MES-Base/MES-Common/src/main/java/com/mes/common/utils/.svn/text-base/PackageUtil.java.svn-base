package com.mes.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * Created by xiuyou.xu on 2017/8/2.
 */
public class PackageUtil {
    public static void main(String[] args) throws Exception {
        String packageName = "com.wang.vo.request.hotel";
        // List<String> classNames = getClassName(packageName);
        List<String> classNames = getClassName(packageName, false);
        if (classNames != null) {
            for (String className : classNames) {
                System.out.println(className);
            }
        }
    }

    /**
     * 获取某包下（包括该包的所有子包）所有类
     *
     * @param packageName 包名
     * @return 类的完整名称
     */
    public static List<String> getClassName(String packageName) {
        return getClassName(packageName, true);
    }

    /**
     * 获取某包下所有类
     *
     * @param packageName  包名
     * @param childPackage 是否遍历子包
     * @return 类的完整名称
     */
    public static List<String> getClassName(String packageName, boolean childPackage) {
        List<String> fileNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if (url != null) {
            String type = url.getProtocol();
            if (type.equals("file")) {
                fileNames = getClassNameByFile(url.getPath(), null, childPackage);
            } else if (type.equals("jar")) {
                fileNames = getClassNameByJar(url.getPath(), childPackage);
            }
        } else {
            fileNames = getClassNameByJars(((URLClassLoader) loader).getURLs(), packagePath, childPackage);
        }
        return fileNames;
    }

    /**
     * 从项目文件获取某包下所有类
     *
     * @param filePath     文件路径
     * @param className    类名集合
     * @param childPackage 是否遍历子包
     * @return 类的完整名称
     */
    private static List<String> getClassNameByFile(String filePath, List<String> className, boolean childPackage) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                if (childPackage) {
                    myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
                }
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                    childFilePath = childFilePath.replace("\\", ".");
                    myClassName.add(childFilePath);
                }
            }
        }

        return myClassName;
    }

    /**
     * 从jar获取某包下所有类
     *
     * @param jarPath      jar文件路径
     * @param childPackage 是否遍历子包
     * @return 类的完整名称
     */
    private static List<String> getClassNameByJar(String jarPath, boolean childPackage) {
        List<String> myClassName = new ArrayList<String>();
        String[] jarInfo = jarPath.split("!");
        String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
        String packagePath = jarInfo[1].substring(1);
        try {
            JarFile jarFile = new JarFile(jarFilePath);
            Enumeration<JarEntry> entrys = jarFile.entries();
            while (entrys.hasMoreElements()) {
                JarEntry jarEntry = entrys.nextElement();
                String entryName = jarEntry.getName();
                if (entryName.endsWith(".class")) {
                    if (childPackage) {
                        if (entryName.startsWith(packagePath)) {
                            entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                            myClassName.add(entryName);
                        }
                    } else {
                        int index = entryName.lastIndexOf("/");
                        String myPackagePath;
                        if (index != -1) {
                            myPackagePath = entryName.substring(0, index);
                        } else {
                            myPackagePath = entryName;
                        }
                        if (myPackagePath.equals(packagePath)) {
                            entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
                            myClassName.add(entryName);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myClassName;
    }

    /**
     * 从所有jar中搜索该包，并获取该包下所有类
     *
     * @param urls         URL集合
     * @param packagePath  包路径
     * @param childPackage 是否遍历子包
     * @return 类的完整名称
     */
    private static List<String> getClassNameByJars(URL[] urls, String packagePath, boolean childPackage) {
        List<String> myClassName = new ArrayList<String>();
        if (urls != null) {
            for (int i = 0; i < urls.length; i++) {
                URL url = urls[i];
                String urlPath = url.getPath();
                // 不必搜索classes文件夹
                if (urlPath.endsWith("classes/")) {
                    continue;
                }
                String jarPath = urlPath + "!/" + packagePath;
                myClassName.addAll(getClassNameByJar(jarPath, childPackage));
            }
        }
        return myClassName;
    }

    /**
     * 列出jar文件中所有的class名称
     *
     * @param path
     * @return
     */
    public static List<String> listClasses(String path) {
        List<String> ret = Lists.newArrayList();
        try (JarFile jarFile = new JarFile(path)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().toLowerCase().endsWith(".class")) {
                    ret.add(entry.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 列出所有jar文件中所有的class名称
     *
     * @param jars
     * @return
     */
    public static List<String> listClasses(List<String> jars) {
        List<String> ret = Lists.newArrayList();
        for (String path : jars) {
            ret.addAll(listClasses(path));
        }

        return ret;
    }

    /**
     * 列出所有jar文件中每个类对应的方法列表
     *
     * @param jars
     * @return
     */
    public static Map<Class, List<Method>> getMethods(List<String> jars) {
        Map<Class, List<Method>> ret = Maps.newHashMap();

        URL[] urls = new URL[jars.size()];
        for (int i = 0; i < jars.size(); i++) {
            try {
                urls[i] = new File(jars.get(i)).toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        URLClassLoader cl = new URLClassLoader(urls);
        List<String> classes = listClasses(jars);
        try {
            if (classes != null && !classes.isEmpty()) {
                for (String cls : classes) {
                    cls = cls.substring(0, cls.length() - 6);
                    cls = cls.replaceAll("/", ".");
                    Class c = Class.forName(cls, false, cl);
                    Method[] methods = c.getDeclaredMethods();
                    if (methods != null && methods.length > 0) {
                        ret.put(c, Arrays.stream(methods).filter(method -> {
                            return !method.getName().startsWith("lambda$");
                        }).filter(method -> {
                            Class<?>[] sc = method.getReturnType().getInterfaces();
                            return sc != null && sc.length > 0;
                        }).collect(Collectors.toList()));
                    } else {
                        ret.put(c, Lists.newArrayList());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 从多个jar文件中找到给定类的子类
     *
     * @param jars  多个jar文件路径
     * @param clazz 给定的父类
     * @return
     */
    public static Class getImpl(List<String> jars, String clazz) {
        URL[] urls = new URL[jars.size()];
        for (int i = 0; i < jars.size(); i++) {
            try {
                urls[i] = new File(jars.get(i)).toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        URLClassLoader cl = new URLClassLoader(urls);
        List<String> classes = listClasses(jars);
        try {
            if (classes != null && !classes.isEmpty()) {
                Class superClass = Class.forName(clazz);
                for (String cls : classes) {
                    cls = cls.substring(0, cls.length() - 6);
                    cls = cls.replaceAll("/", ".");
                    Class c = Class.forName(cls, false, cl);
                    if (superClass.isAssignableFrom(c)) {
                        return c;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}