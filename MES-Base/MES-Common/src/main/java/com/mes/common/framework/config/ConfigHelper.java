package com.mes.common.framework.config;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import com.mes.common.framework.Constants;
import com.mes.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 资源文件帮助类，加载配置信息
 *
 */
public class ConfigHelper {
	private static final Logger log=LoggerFactory.getLogger(ConfigHelper.class);
	private static Properties properties;
    //容器参数
    private static Properties serverProperties;

    private static Properties kafkaProperties;

    private static String filePath;
    private static String jettyServerfilePath;
    private static String kafkafilePath;

	static {
        System.out.println("["+ DateUtil.getDateTime()+"] Loading config.properties");
        try {
            filePath = getFilePath("config.properties", Constants.Env.BASE_HOME);
			if (filePath != null) {
				//系统参数配置
				properties = loadProperties("config.properties");
			}
			jettyServerfilePath = getFilePath("jettyServer.properties", Constants.Env.BASE_HOME);
			if (jettyServerfilePath != null ){
				//容器参数配置
				serverProperties = loadProperties("jettyServer.properties");
			}

        } catch (Exception e) {
            //ignore
        }



    }


    public static Properties loadProperties(String fileName) {
        Properties prop = new Properties();
        try {
            File file = getFile(fileName, Constants.Env.BASE_HOME);
            if (file != null) {
				InputStream input = new FileInputStream(file);
				prop.load(input);
			}
        } catch (Exception e) {
            log.error("Loading config.properties fails", e);
        }

        return prop;
    }

    /**
	 * 加载系统参数
	 * @param key
	 * @return
	 */
	public static String getJettyParameter(String key){
		return serverProperties.getProperty(key);
	}

	public static String getKafkaParameter(String key){
		try {
			kafkafilePath = getFilePath("kafka.properties", Constants.Env.BASE_HOME);
			if (kafkafilePath != null ){
				//容器参数配置
				if (kafkaProperties == null) {
					kafkaProperties = loadProperties("kafka.properties");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return kafkaProperties.getProperty(key);
	}

    /**
	 * 根据Key  得到config文件中key对应的数据
	 * @param key
	 * @return
     */
	public static String getValue(String key){
		String value = null;
		try {
			value = properties.getProperty(key);
			} catch (Exception e) {
			log.error("key:"+key+" 资源参数加载失败！", e);
		}
		return value;
		
	}

	/**
	 *
	 * @param key
	 * @param value
	 */
	public static void setProperties(String key,String value) {
		try {
			FileInputStream input = new FileInputStream(filePath);
		    SafeProperties safeProp = new SafeProperties();
		    safeProp.load(input);
		    input.close();
		    if (!"".equals(value) && value !=null) { 
		    	// safeProp.addComment("New Comment测试");
			     safeProp.put(key, value);
			}
		    if (key != null) {
		    	if ( value == null || "".equals(value)) {
		    		safeProp.remove(key);
				}
			}
		    FileOutputStream output = new FileOutputStream(filePath);
	        safeProp.store(output, null); 
	        output.close();
		} catch (Exception e) {
			log.error("Visit " + filePath + " for updating "+ key + " value error", e.getMessage());
		}

	}
	
	/**
	 * 删除
	 * @param key
	 */
	public static void removeProperties(String key) {
		try {
			FileInputStream input = new FileInputStream(filePath);
		    SafeProperties safeProp = new SafeProperties();
		    safeProp.load(input);
		    input.close();
		    if (key != null) { 
		    	safeProp.remove(key);
			}
		    FileOutputStream output = new FileOutputStream(filePath);
	        safeProp.store(output, null); 
	        output.close();
		} catch (Exception e) {
			log.error("Visit " + filePath + " for updating "+ key + " value error", e.getMessage());
		}

	}

	public static String getFilePath( String fileName, String propertyName ) throws Exception {
		String filePath = null;
		if ( propertyName != null && ! "".equals( propertyName ) ) {
			filePath = System.getProperty( propertyName );
		}

		if ( filePath == null || "".equals( filePath ) ) {

			URL url = ConfigHelper.class.getClassLoader().getResource(propertyName+fileName );
			if ( url == null ) {
				throw new FileNotFoundException( fileName + " not found!" );
			}
			filePath = url.getPath();
		} else {
			filePath = filePath.endsWith( "/" ) ? filePath.concat( fileName )
					: filePath.concat( "/" ).concat(  fileName );
		}
		return filePath;
	}

	public static File getFile( String fileName, String propertyName ) throws Exception {
		String filePath = null;
		if ( propertyName != null && ! "".equals( propertyName ) ) {
			filePath = System.getProperty( propertyName );
		}
		File file = null;

		if ( filePath == null || "".equals( filePath ) ) {
			URL url = ConfigHelper.class.getClassLoader().getResource(propertyName+fileName );
			if ( url == null ) {
				throw new FileNotFoundException( fileName + " not found!" );
			}
			file = new File( url.getPath() );
		} else {
			filePath = filePath.endsWith( "/" ) ? filePath.concat( fileName )
					: filePath.concat( "/" ).concat(  fileName );
			file = new File( filePath );
		}
		return file;
	}
}
