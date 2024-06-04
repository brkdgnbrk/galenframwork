package utils;
import lombok.Data;
import pages.LoginPage;
import pages.NarposHomePage;


@Data
public class Pages {

    private LoginPage loginPage;
    private NarposHomePage narposHomePage;

    public Pages() {
        loginPage = new LoginPage();
        narposHomePage=new NarposHomePage();

    }

}
