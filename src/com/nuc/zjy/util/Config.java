package com.nuc.zjy.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @项目名称：ticket
 * @类名称：Config
 * @类描述：
 * 
 * @author 赵建银
 * @email 384144795@qq.com
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

	public String getString(String key) {
		return cfg.getProperty(key);
	}

	public int getInt(String key) {
		return Integer.parseInt(cfg.getProperty(key));
	}

	public double getDouble(String key) {
		return Double.parseDouble(getString(key));
	}

}
