package TestModules.Search;

import TestModules.Base.BaseTest;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchModuleTest extends BaseTest {
    @Test
    public void validSearch(){
        SearchPage searchPage = new SearchPage(super.driver);
        searchPage.enterProductNameToSearch("computer");
        searchPage.search();
        Assert.assertTrue(foundProductNameInTitles("computer"));
    }
    @Test
    public void invalidSearch(){
        SearchPage searchPage = new SearchPage(super.driver);
        searchPage.enterProductNameToSearch("Test");
        searchPage.search();
        Assert.assertTrue(searchPage.isNoResultMSG());
    }
    @Test(dataProvider = "PopularTags")
    public void popularTags(String tag){
        SearchPage searchPage = new SearchPage(super.driver);
        searchPage.chooseTag(tag);
        //TODO ass assertion
    }
    @DataProvider
    public Object[] PopularTags() {
        Object[] tag = new Object[15];
        tag[0] = "apparel";
        tag[1] = "awesome";
        tag[2] = "book";
        tag[3] = "camera";
        tag[4] = "cell";
        tag[5] = "compact";
        tag[6] = "computer";
        tag[7] = "cool";
        tag[8] = "digital";
        tag[9] = "game";
        tag[10] = "jeans";
        tag[11] = "jewelry";
        tag[12] = "nice";
        tag[13] = "shirt";
        tag[14] = "shoes";
        return tag;
    }
    public Boolean foundProductNameInTitles(String productName){
        List<String> titles = homePage.getTheTitlesOfSearchResults();
        for(String title: titles){
            if(title.toLowerCase().contains(productName))
                return true;
        }
        return false;
    }
}
