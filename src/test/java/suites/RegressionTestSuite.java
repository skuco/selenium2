package suites;

import categories.RegressionTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.JsExecutorHighlightTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(RegressionTest.class)
@Suite.SuiteClasses(JsExecutorHighlightTest.class)
public class RegressionTestSuite {
}
