package huynguyen.katdeployer.core;

import huynguyen.katdeployer.model.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Deployer {
    private Configuration deployConfig;

    public void deploy(Configuration deployConfig) {
        this.deployConfig = deployConfig;
    }

    private void updateVersion() throws IOException {
        File aboutMappingsFile = new File(getKatalonSourceDir(), "/com.kms.katalon/about.mappings");
        List<String> lines = FileUtils.readLines(aboutMappingsFile, "UTF-8");
        lines = lines.stream()
                .map(line -> {
                    if (line.startsWith("1=")) {
                        String versionLine = "1=" + deployConfig.getDeployVersion();
                        return versionLine;
                    } else {
                        return line;
                    }
                })
                .collect(Collectors.toList());
        FileUtils.writeLines(aboutMappingsFile, lines);
    }

    private void updateBuildNumber() throws IOException {
        File buildNumberPropFile = new File(getKatalonSourceDir(), "/source/com.kms.katalon/buildNumber.properties");
        if (buildNumberPropFile.exists()) {
            buildNumberPropFile.createNewFile();
        }
        String content = "buildNumber0=" + deployConfig.getBuildNumber();
        FileUtils.writeStringToFile(buildNumberPropFile, content, "UTF-8");
    }

    private void startServer9999() throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh mvn -Djetty.port=9999 jetty:run");
        builder.directory(new File(getKatalonSourceDir(), "com.kms.katalon.repo"));
        Process process = builder.start();
        long start = System.currentTimeMillis();
        while (!isPortInUse(9999) && System.currentTimeMillis() - start < TimeUnit.MINUTES.toMillis(5)) {

        }
    }

    private void startServer33333() throws IOException {

    }

    private boolean isPortInUse(int port) {
        boolean result = false;
        try {
            (new Socket("127.0.0.1", port)).close();
            result = false;
        } catch (IOException e) {
            result = true;
        }
        return result;
    }

    private File getKatalonSourceDir() {
        String katalonDir = deployConfig.getKatalonFolder();
        return new File(katalonDir, "/source");
    };



}
