package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class AnnotationTransformer implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClasses, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(FrameworkListener.class);
    }
}
