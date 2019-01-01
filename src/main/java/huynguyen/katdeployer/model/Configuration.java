package huynguyen.katdeployer.model;

public class Configuration {
    private String deployVersion;

    private int buildNumber;

    private String macCodesignKey;

    private String s3AccessKeyId;

    private String s3SecretAccessKey;

    private boolean isQTestEdition;

    private boolean isQuickRelease;

    private String katalonFolder;

    public String getDeployVersion() {
        return deployVersion;
    }

    public void setDeployVersion(String deployVersion) {
        this.deployVersion = deployVersion;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getMacCodesignKey() {
        return macCodesignKey;
    }

    public void setMacCodesignKey(String macCodesignKey) {
        this.macCodesignKey = macCodesignKey;
    }

    public String getS3AccessKeyId() {
        return s3AccessKeyId;
    }

    public void setS3AccessKeyId(String s3AccessKeyId) {
        this.s3AccessKeyId = s3AccessKeyId;
    }

    public String getS3SecretAccessKey() {
        return s3SecretAccessKey;
    }

    public void setS3SecretAccessKey(String s3SecretAccessKey) {
        this.s3SecretAccessKey = s3SecretAccessKey;
    }

    public boolean isQTestEdition() {
        return isQTestEdition;
    }

    public void setQTestEdition(boolean QTestEdition) {
        isQTestEdition = QTestEdition;
    }

    public boolean isQuickRelease() {
        return isQuickRelease;
    }

    public void setQuickRelease(boolean quickRelease) {
        isQuickRelease = quickRelease;
    }

    public String getKatalonFolder() {
        return katalonFolder;
    }

    public void setKatalonFolder(String katalonFolder) {
        this.katalonFolder = katalonFolder;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "deployVersion='" + deployVersion + '\'' +
                ", buildNumber=" + buildNumber +
                ", macCodesignKey='" + macCodesignKey + '\'' +
                ", s3AccessKeyId='" + s3AccessKeyId + '\'' +
                ", s3SecretAccessKey='" + s3SecretAccessKey + '\'' +
                ", isQTestEdition=" + isQTestEdition +
                ", isQuickRelease=" + isQuickRelease +
                ", katalonFolder='" + katalonFolder + '\'' +
                '}';
    }
}
