package selenium.core.settings.pages;

public class HomePage extends BasicPage {
    public HeaderPage getHeader() {
        return initPage(HeaderPage.class);
    }
}
