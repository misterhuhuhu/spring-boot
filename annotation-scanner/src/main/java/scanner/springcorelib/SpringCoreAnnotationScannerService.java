package scanner.springcorelib;


import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import scanner.SampleAnnotatedClass;
import scanner.SampleAnnotation;
import scanner.SampleAnnotationScanner;
import scanner.ScanNotSupportedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpringCoreAnnotationScannerService implements SampleAnnotationScanner {
    @Override
    public List<String> scanAnnotatedMethods() {
        Class<?> userClass = ClassUtils.getUserClass(SampleAnnotatedClass.class);
        List<String> annotatedMethods = Arrays.stream(userClass.getMethods())
            .filter(method -> AnnotationUtils
                .getAnnotation(method, SampleAnnotation.class) != null)
            .map(method -> method.getAnnotation(SampleAnnotation.class)
                .name())
            .collect(Collectors.toList());

        return annotatedMethods;
    }

    @Override
    public List<String> scanAnnotatedClasses() {
        throw new ScanNotSupportedException();
    }

    @Override
    public boolean supportsMethodScan() {
        return true;
    }

    @Override
    public boolean supportsClassScan() {
        return false;
    }
}
