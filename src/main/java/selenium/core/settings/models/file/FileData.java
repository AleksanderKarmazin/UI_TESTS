package selenium.core.settings.models.file;

public class FileData {
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileData(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;
}
