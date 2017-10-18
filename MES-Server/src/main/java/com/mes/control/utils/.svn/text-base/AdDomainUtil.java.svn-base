package com.mes.control.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mes.common.framework.Exception.DubboProviderException;
import com.mes.common.framework.config.ConfigHelper;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.IDGenerator;
import com.mes.dubbo.interprovider.control.IDeptProvider;
import com.mes.dubbo.interprovider.control.IUserProvider;
import com.mes.entity.control.Dept;
import com.mes.entity.control.User;
import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 使用ldap服务导入部门、用户信息
 * <p>
 * Created by xiuyou.xu on 2017/8/28.
 */
public class AdDomainUtil implements Job {
    private static Logger logger = LoggerFactory.getLogger(AdDomainUtil.class);

    private static LdapContext context;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        doImport();
    }

    private static void init() throws NamingException {
        if (context == null) {
            Hashtable env = new Hashtable();

            String url = ConfigHelper.getValue("ldap.url"); // LDAP访问地址
            String adminName = ConfigHelper.getValue("ldap.user"); // 注意用户名的写法：domain\User 或
            // User@domain.com
            String adminPassword = ConfigHelper.getValue("ldap.user.passwd"); // 密码

            env.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别
            env.put(Context.SECURITY_PRINCIPAL, adminName); // AD User
            env.put(Context.SECURITY_CREDENTIALS, adminPassword); // AD Password
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
            env.put(Context.PROVIDER_URL, url);

            context = new InitialLdapContext(env, null);
        }
    }

    public static void doImport() {
        // 配置是否从ldap中加载数据
        if (!"true".equals(ConfigHelper.getValue("ldap.load.data"))) {
            return;
        }
        try {
            init();

            logger.debug("开始从AD域中导入部门和用户信息：{}", ConfigHelper.getValue("ldap.dept.branches"));

            String[] branches = ConfigHelper.getValue("ldap.dept.branches").split(">");
            // 根部门的parentId为0
            String parentId = "0";
            for (int i = 0; i < branches.length; i++) {
                String branch = branches[i];
                parentId = importDept(parentId, branch, i == branches.length - 1);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static String importDept(String parentId, String branch, boolean importUser) throws NamingException {
        IDeptProvider deptProvider = (IDeptProvider) ServiceBeanContext.getInstance().getBean("deptProvider");

        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        String searchFilter = "(&(objectClass=organizationalUnit)(|(name=" + branch + ")))";
        String searchBase = ConfigHelper.getValue("ldap.root");

        searchCtls.setReturningAttributes(null);

        // Search for objects using the filter
        NamingEnumeration en = context.search(searchBase, searchFilter, searchCtls);
        String ret = null;
        if (en != null) {
            while (en.hasMoreElements()) {
                SearchResult result = (SearchResult) en.next();
                Dept dept = new Dept();

                Attributes attrs = result.getAttributes();
                if (attrs != null) {
                    try {
                        for (NamingEnumeration ne = attrs.getAll(); ne.hasMore(); ) {
                            Attribute attr = (Attribute) ne.next();
                            String id = attr.getID();
                            List<String> values = Lists.newArrayList();
                            for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
                                values.add(e.next().toString());
                            }
                            String v = String.join(",", values);
                            if ("displayName".equals(id) || (dept.getName() == null && "name".equals(id))) {
                                dept.setName(v);
                            }
                            if ("description".equals(id)) {
                                dept.setDescription(v);
                            }
                        }
                    } catch (NamingException e) {
                        throw e;
                    }
                    dept.setParentId(parentId);
                    dept.setCode(IDGenerator.getID());
                    String id = null;
                    // 根据部门名称查询，防止重复添加
                    if (dept.getName() != null) {
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("name", dept.getName());
                        try {
                            List<Dept> depts = deptProvider.findByMap(map);
                            if (depts != null && !depts.isEmpty()) {
                                id = depts.get(0).getId();
                            }
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                    }

                    // save dept
                    try {
                        if (id == null) {
                            id = deptProvider.save(dept);
                        }
                        if (ret == null) {
                            ret = id;
                        }
                        if (importUser) {
                            importUser(id, dept.getName());
                        }
                    } catch (DubboProviderException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ret;
    }

    public static String getUserEmail(String name) {
        try {
            init();

            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String searchFilter = "(&(objectClass=user)(name=" + name + "))";
            String searchBase = ConfigHelper.getValue("ldap.root");

            searchCtls.setReturningAttributes(null); // 不定制属性，将返回所有的属性集

            // Search for objects using the filter
            NamingEnumeration en = context.search(searchBase, searchFilter, searchCtls);
            if (en != null) {
                while (en.hasMoreElements()) {
                    SearchResult result = (SearchResult) en.next();

                    Attributes attrs = result.getAttributes();
                    if (attrs != null) {
                        try {
                            for (NamingEnumeration ne = attrs.getAll(); ne.hasMore(); ) {
                                Attribute attr = (Attribute) ne.next();
                                String id = attr.getID();
                                List<String> values = Lists.newArrayList();
                                for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
                                    values.add(e.next().toString());
                                }
                                String v = String.join(",", values);
                                if ("mail".equals(id)) {
                                    return v;
                                }
                            }
                        } catch (NamingException e) {
                            throw e;
                        }
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return name + "@hirain.com";
    }

    public static void importUser(String deptId, String name) {
        try {
            init();
            IUserProvider userProvider = (IUserProvider) ServiceBeanContext.getInstance().getBean("userProvider");

            SearchControls searchCtls = new SearchControls();
            searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String searchFilter = "(&(objectClass=user)(department=" + name + "))";
            String searchBase = ConfigHelper.getValue("ldap.root");

            searchCtls.setReturningAttributes(null); // 不定制属性，将返回所有的属性集

            // Search for objects using the filter
            NamingEnumeration en = context.search(searchBase, searchFilter, searchCtls);
            if (en != null) {
                while (en.hasMoreElements()) {
                    SearchResult result = (SearchResult) en.next();
                    User user = new User();

                    Attributes attrs = result.getAttributes();
                    if (attrs != null) {
                        try {
                            for (NamingEnumeration ne = attrs.getAll(); ne.hasMore(); ) {
                                Attribute attr = (Attribute) ne.next();
                                String id = attr.getID();
                                List<String> values = Lists.newArrayList();
                                for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
                                    values.add(e.next().toString());
                                }
                                String v = String.join(",", values);
                                if ("name".equals(id)) {
                                    user.setUsername(v);
                                }
                                if ("displayName".equals(id)) {
                                    user.setName(v);
                                }
                                if ("mobile".equals(id)) {
                                    user.setMobilePhone(v);
                                }
                                if ("telephoneNumber".equals(id)) {
                                    user.setPhone(v);
                                }
                                if ("mail".equals(id)) {
                                    user.setEmail(v);
                                }
                            }
                        } catch (NamingException e) {
                            throw e;
                        }

                        user.setDeptId(deptId);
                        user.setRoleId(ConfigHelper.getValue("ldap.user.default.role.id"));
                        user.setPassword(ConfigHelper.getValue("ldap.user.sys.default.passwd"));
                        // save user
                        try {
                            Map<String, Object> map = Maps.newHashMap();
                            map.put("username", user.getUsername());
                            List<User> users = userProvider.findByMap(map);
                            // 防止重复保存
                            if (users == null || users.isEmpty()) {
                                userProvider.save(user);
                            }
                        } catch (DubboProviderException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * AD域用户验证
     *
     * @param name
     * @param passwd
     * @return
     */
    public static boolean auth(String name, String passwd) {
        try {
            init();

            context.addToEnvironment(Context.SECURITY_PRINCIPAL, getUserEmail(name));
            context.addToEnvironment(Context.SECURITY_CREDENTIALS, passwd);
            context.reconnect(null);
            return true;
        } catch (NamingException e) {
            logger.error("AD域用户[{}]验证失败：{}", name, e.getMessage());
        }
        return false;
    }

    @Test
    public void testAuth() {
        System.out.println(auth("ldapuser", "HirainLDAP12#"));
    }
}
