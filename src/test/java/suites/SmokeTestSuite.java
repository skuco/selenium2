package suites;

import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.skipTest;
import tests.staticVsInstanceVariableTest;
import tests.waitTests;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
        staticVsInstanceVariableTest.class,
        waitTests.class,
        skipTest.class
})
public class SmokeTestSuite {
}
