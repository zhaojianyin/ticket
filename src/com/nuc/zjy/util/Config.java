package com.nuc.zjy.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @项目名称：ticket
 * @类名称：Config
 * @类描述：加载配置文件
 * 
 * @author 赵建银
 * @date 2017-7-8
 * @time 上午11:01:58
 * @version 1.0
 */
public class Config {
	private Properties cfg = new Properties();

	public Config(String file) {
		try {
			cfg.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取key对应的String类型的value值
	 * 
	 * @param key
	 *            匹配文件中的key
	 * @return 返回对应的值
	 */
	public String getString(String key) {
		return cfg.getProperty(key);
	}

	/**
	 * 获取key对应的int类型的value值
	 * 
	 * @param key
	 *            匹配文件中的key
	 * @return 返回对应的值
	 */
	public int getInt(String key) {
		return Integer.parseInt(cfg.getProperty(key));
	}

	/**
	 * 获取key对应的Double类型的value值
	 * 
	 * @param key
	 *            匹配文件中的key
	 * @return 返回对应的值
	 */
	public double getDouble(String key) {
		return Double.parseDouble(getString(key));
	}

}
