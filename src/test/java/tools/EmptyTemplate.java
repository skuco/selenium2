package tools;

import org.junit.Before;
import org.junit.Test;

public class EmptyTemplate extends InitialSetup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "change_me.php");
    }

    @Test
    public void name_of_the_test(){
    }

}
