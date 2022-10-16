package selenium.core.settings.models.file;

import static selenium.core.settings.framework.Utils.crateId;

public class FileBuilder {
    public static FileData yandexFile() {
        FileData file = new FileData(
                "F_ID"  + crateId()
        );
        return file;
    }

}
