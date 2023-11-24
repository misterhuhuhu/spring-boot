package scanner.reflectionslib;


import org.reflections.Reflections;
import org.springframework.stereotype.Service;
import scanner.SampleAnnotation;
import scanner.SampleAnnotationScanner;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReflectionsScannerService implements SampleAnnotationScanner {
    @Override
    public List<String> scanAnnotatedMethods() {
        Reflections reflections = new Reflections("scanner");
        Set<Method> methods = reflections
            .getMethodsAnnotatedWith(SampleAnnotation.class);
        return methods.stream()
            .map(method -> method.getAnnotation(SampleAnnotation.class)
                .name())
            .collect(Collectors.toList());
    }

    @Override
    public List<String> scanAnnotatedClasses() {
        Reflections reflections = new Reflections("scanner");
        Set<Class<?>> types = reflections
            .getTypesAnnotatedWith(SampleAnnotation.class);
        return types.stream()
            .map(clazz -> clazz.getAnnotation(SampleAnnotation.class)
                .name())
            .collect(Collectors.toList());
    }

    @Override
    public boolean supportsMethodScan() {
        return true;
    }

    @Override
    public boolean supportsClassScan() {
        return true;
    }
}
