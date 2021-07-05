package events;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNgListeners implements IAnnotationTransformer,IRetryAnalyzer, ISuiteListener{

	int maxcount = 1;

	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
	}

	public boolean retry(ITestResult result) {
		if (!result.isSuccess() & maxcount < 3) {
			maxcount++;
			return true;
		}
		return false;
	}


}
























