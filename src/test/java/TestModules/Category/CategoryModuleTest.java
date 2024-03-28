package TestModules.Category;

import TestModules.Base.BaseTest;
import Pages.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CategoryModuleTest extends BaseTest {

    @Test(dataProvider = "CategoryItems")
    void categoryRedirection(String category){
        HomePage home = new HomePage(super.driver);
        home.chooseCategory(category);
        assertEquals(home.getCategoryTitle(),category,"Its not the right Category");
    }
    @DataProvider
    public Object [] CategoryItems () {
        Object [] category = new Object [7];
        category [0]= "Computers";
        category [1]= "Electronics";
        category [2]= "Apparel";
        category [3]= "Digital downloads";
        category [4]= "Books";
        category [5]= "Jewelry";
        category [6]= "Gift Cards";
        return category;
    }
}
