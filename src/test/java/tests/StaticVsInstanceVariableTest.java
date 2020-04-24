package tests;

import categories.SmokeTest;
import org.junit.*;
import org.junit.experimental.categories.Category;

public class StaticVsInstanceVariableTest {
    static int staticNumber;
    int instanceNumber = 0;

    @BeforeClass
    public static void mainSetUp() {
        System.out.println("### Main SetUp ###");
        staticNumber = 0;
        System.out.println("Static number: " + staticNumber);
    }

    @Before
    public void setUp(){
        System.out.println("Test SetUp");
    }

    @Category(SmokeTest.class)
    @Test
    public void testA(){
        System.out.println("Test A");
        staticNumber++;
        System.out.println("Static Number: " + staticNumber);
        instanceNumber++;
        System.out.println("Instance Number: " + instanceNumber);
    }
    @Test
    public void testB(){
        System.out.println("Test B");
        staticNumber = 10;
        System.out.println("Static Number: " + staticNumber);
        instanceNumber = 20;
        System.out.println("Instance Number: " + instanceNumber);
    }
    @Test
    public void testC(){
        System.out.println("Test C");
        staticNumber--;
        System.out.println("Static Number: " + staticNumber);
        instanceNumber--;
        System.out.println("Instance Number: " + instanceNumber);
    }

    @After
    public void tearDown() {
        System.out.println("Test Tear Down");
    }

    @AfterClass
    public static void mainTearDown() {
        System.out.println("### Main TearDown ###");
    }

}
