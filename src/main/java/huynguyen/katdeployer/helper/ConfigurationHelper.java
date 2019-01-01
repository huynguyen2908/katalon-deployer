package huynguyen.katdeployer.helper;

import huynguyen.katdeployer.exception.DeployException;
import huynguyen.katdeployer.model.Configuration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationHelper {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationHelper.class);

    public static Configuration readFromPropertyFile(String filePath) throws IOException {
        logger.info("Reading configuration from property file: " + filePath);

        Properties prop = new Properties();
        FileInputStream input = new FileInputStream(filePath);
        prop.load(input);

        Configuration config = new Configuration();
        config.setBuildNumber(Integer.valueOf(prop.getProperty("buidNumber", "0")));
        config.setDeployVersion(prop.getProperty("deployVersion", "3.0.5"));
        config.setMacCodesignKey(prop.getProperty("macCodesignKey"));
        config.setQTestEdition(Boolean.valueOf(prop.getProperty("qTestVersion", "false")));
        config.setQuickRelease(Boolean.valueOf(prop.getProperty("quickRelease", "false")));
        config.setS3AccessKeyId(prop.getProperty("s3AccessKeyId"));
        config.setS3SecretAccessKey(prop.getProperty("s3SecretAccessKey"));
        config.setKatalonFolder(prop.getProperty("katalonFolder"));

        if (!validateConfig(config)) {
            logger.error("Invalid configuration: "  + config.toString());
            throw new IllegalArgumentException("Invalid configuration: " + config.toString());
        } else {
            logger.debug("Configuration for deployment: " + config.toString());
        }
        return config;
    }

    private static boolean validateConfig(Configuration config) {
        return StringUtils.isBlank(config.getDeployVersion()) ||
                StringUtils.isBlank(config.getMacCodesignKey()) ||
                StringUtils.isBlank(config.getS3AccessKeyId()) ||
                StringUtils.isBlank(config.getS3SecretAccessKey()) ||
                StringUtils.isBlank(config.getKatalonFolder());
    }

}
