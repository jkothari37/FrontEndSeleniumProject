import io.qameta.allure.Description;
import listneres.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FeaturedDropDownGridCategoryPage;
import pageobjects.FeaturedTileFilteringPage;


    public class FeaturedTileFiltering extends BaseTest {


        public static String baseURL = "http://www.smartclient.com/smartgwt/showcase";

        @Test(groups = "regression",priority = 5)
        @Description("Exercise 1 : Test The Search functionality by Filling some Fields")
        public void testAnimalSearchContainsTwelevePlusItems() throws Exception {
            driver.get(baseURL + "/#featured_tile_filtering");
            FeaturedTileFilteringPage featuredTileFilteringPage = new FeaturedTileFilteringPage(driver);
            featuredTileFilteringPage.clickIAgree();
            featuredTileFilteringPage.setAnimal("a");
            featuredTileFilteringPage.setMaxLifeSpan(40);
            featuredTileFilteringPage.sortBy("Life Span");
            featuredTileFilteringPage.checkAscending();
            int actualCount = featuredTileFilteringPage.getResultsCount();
            System.out.println("Actual Count: " + actualCount);
            Assert.assertTrue(actualCount > 12,"Actual Result Count is : " + actualCount);
        }

        @Test(groups = "regression",priority = 6)
        @Description("Exercise 2 : Test The Search functionality by setting some values")
        public void testSelectFromDropDownAsPerCriteria() throws Exception {
            driver.get(baseURL + "/#featured_dropdown_grid_category");
            FeaturedDropDownGridCategoryPage featuredDropDownGridCategoryPage = new FeaturedDropDownGridCategoryPage(driver);
            featuredDropDownGridCategoryPage.selectRowAsPerCriteria("Exercise","Ea",1.1);
            Thread.sleep(5000);
        }

    }



