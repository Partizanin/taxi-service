package hw11.service;

import hw11.service.utils.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin_Spring.
 * Date: 16.01.2016.
 * Time: 16:17.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class UtilsTest {

    private Utils utils;

    @Before
    public void setUp() throws Exception {
        utils = new Utils();
    }

    @Test
    public void testIdCheckImpl() throws Exception {
        Assert.assertEquals(utils.idCheck("123123000984199"), "true");
        Assert.assertEquals(utils.idCheck("123213;;';."), ";;';.");
        Assert.assertEquals(utils.idCheck("123123+"), "+");

    }

    @Test
    public void testLanguageCheck() throws Exception {
        Assert.assertEquals(utils.loginCheck("asdasdфывфывффівфівф"),"asdasd");
        Assert.assertEquals(utils.loginCheck("asdasdфывфывффівфівф123123"),"123123");
        Assert.assertEquals(utils.loginCheck("asdasdфывфывффівфівф!`?-="),"!`?-=");

    }

    @Test
    public void testNumberCheck() throws Exception {
        Assert.assertEquals(utils.phoneNumberCheck("+380634401004"), "true");
        Assert.assertEquals(utils.phoneNumberCheck("380634401004"), "true");
        Assert.assertNotEquals(utils.phoneNumberCheck("+38063422401004"),"true");

    }

    @Test
    public void testPassCheck() throws Exception {
        Assert.assertEquals(utils.passwordCheck("123AAbvафы"),"true");
        Assert.assertEquals(utils.passwordCheck("`asdioj`-0wkzcopsadjF"), "true");

    }

    @Test
    public void testGetUkrChars() throws Exception {
        ArrayList<Character> characters = new ArrayList<>();
        String chars = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

        ArrayList<Character> ukrChars = (ArrayList<Character>) utils.getUkrCharacters();

        StringBuilder testChars = new StringBuilder();

        ukrChars.forEach(testChars::append);
        Assert.assertEquals(testChars.toString(),chars);
    }
}