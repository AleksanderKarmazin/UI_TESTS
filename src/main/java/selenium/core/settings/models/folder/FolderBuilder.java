package selenium.core.settings.models.folder;


import static selenium.core.settings.framework.Utils.crateId;

public class FolderBuilder {
    public static FolderData yandexFolder() {
        FolderData folder = new FolderData(
                "FoID:" + crateId()
        );
        return folder;
    }
}
