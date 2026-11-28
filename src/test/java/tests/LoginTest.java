package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithStandardUserAndSecretSauce(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productsPage.pageTitleVisible());
        assertEquals(productsPage.getTitleText(),"Products");

        // осуществляется также проверка по URL
        assertEquals(productsPage.currentUrl(),"https://www.saucedemo.com/inventory.html");

    }
    @Test
    public void loginWithInvalidUsernameAndPassword(){
        loginPage.open();
        loginPage.login("1234","1234");
        assertTrue(loginPage.errorIsVisible());
        assertEquals(loginPage.errorText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidUsername(){
        loginPage.open();
        loginPage.login("1234","secret_sauce");
        assertTrue(loginPage.errorIsVisible());
        assertEquals(loginPage.errorText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        assertTrue(loginPage.errorIsVisible());
        assertEquals(loginPage.errorText(),"Epic sadface: Password is required");
    }

    @Test
    public void emptyUsernameAndPassword(){
        loginPage.open();
        loginPage.login("","");
        assertTrue(loginPage.errorIsVisible());
        assertEquals(loginPage.errorText(),"Epic sadface: Username is required");
    }
}
