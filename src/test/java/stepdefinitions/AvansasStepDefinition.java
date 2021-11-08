package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AvansasStepDefinition {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    @Given("Kullanıcı {string} sitesine gider.")
    public void kullanıcı_sitesine_girer(String avansasUrl) {
        Driver.getDriver().get(avansasUrl);
    }

    @When("Avansas.com da arama alanına {string} yazılarak ara butonu tıklanır.")
    public void avansasComDaAramaAlanınaYazılarakAraButonuTıklanır(String aranacakUrunIsmi) {
        homePage.searchWithText(aranacakUrunIsmi);
    }

    @And("Kategori listesinden {string} kategorisi tıklanır.")
    public void kategoriListesindenKategorisiTıklanır(String secilecekKategoriIsmi) {
        homePage.selectACategoryName(secilecekKategoriIsmi);
    }

    @And("Sıralama fonksiyonundan ada göre sırala seçilir.")
    public void sıralamaFonksiyonundanAdaGöreSıralaSeçilir() {
        productPage.sortByNameA_Z();
    }

    @And("Gelen ürün listesinde adında {string} içeren kaç ürün olduğu tespit edilir.")
    public void gelenÜrünListesindeAdındaIçerenKaçÜrünOlduğuTespitEdilir(String aramaSonuclarındaIstenenUrunIsmi) {
        System.out.println("Urun Sayisi "+ productPage.findProductQuantity(aramaSonuclarındaIstenenUrunIsmi)+"'dir");
    }

    @Then("Ürün adeti tespit edilir ve {int} dan fazla ise test başarılıdır, {int} ise başarısızdır.")
    public void ürünAdetiTespitEdilirVeDanFazlaIseTestBaşarılıdırIseBaşarısızdır(int arananUrunMinimummiktari1, int arananUrunMinimummiktari2) {
        Assert.assertTrue("Test Başarısız; Urun Sayisi 0'dir",productPage.findProductQuantity("Bic Evolution")>arananUrunMinimummiktari1);
        System.out.println("Test Başarılıdır");
    }
}
