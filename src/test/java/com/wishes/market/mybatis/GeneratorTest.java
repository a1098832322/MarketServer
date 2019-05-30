package com.wishes.market.mybatis;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhongyu
 * @Date: 2018/6/3 19:42
 * @Description:
 */
public class GeneratorTest {
    private File configFile;
    //generatorDm
    //generatorPrimary
    private String filename = "generator";

    @Before
    public void before() {
        //读取mybatis参数
        try {
			configFile = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "generator/" + filename + ".xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void test() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
