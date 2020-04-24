package suites;

import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SkipTest;
import tests.StaticVsInstanceVariableTest;
import tests.WaitTests;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
        StaticVsInstanceVariableTest.class,
        WaitTests.class,
        SkipTest.class
})
public class SmokeTestSuite {
}
