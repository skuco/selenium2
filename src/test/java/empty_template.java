import org.junit.Before;
import org.junit.Test;

public class empty_template extends initialSetup{

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void name_of_the_test(){
    }

}
