package scanner.jandexlib;


import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationTarget;
import org.jboss.jandex.DotName;
import org.jboss.jandex.Index;
import org.jboss.jandex.IndexReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import scanner.SampleAnnotationScanner;
import scanner.UnexpectedScanException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JandexScannerService implements SampleAnnotationScanner {
    @Value("classpath:META-INF/jandex.idx")
    private Resource appFile;

    @Override
    public List<String> scanAnnotatedMethods() {
        try {
            final IndexReader reader = new IndexReader(appFile.getInputStream());
            Index jandexFile = reader.read();
            final List<AnnotationInstance> appAnnotationList = jandexFile
                .getAnnotations(DotName
                    .createSimple("scanner.SampleAnnotation"));
            List<String> annotatedMethods = new ArrayList<>();
            for (AnnotationInstance annotationInstance : appAnnotationList) {
                if (annotationInstance.target()
                    .kind() == AnnotationTarget.Kind.METHOD) {
                    annotatedMethods.add(annotationInstance.value("name")
                        .value()
                        .toString());
                }
            }
            return Collections.unmodifiableList(annotatedMethods);
        } catch (IOException e) {
            throw new UnexpectedScanException(e);
        }
    }

    @Override
    public List<String> scanAnnotatedClasses() {
        try {
            final IndexReader reader = new IndexReader(appFile.getInputStream());
            Index jandexFile = reader.read();
            final List<AnnotationInstance> appAnnotationList = jandexFile
                .getAnnotations(DotName
                    .createSimple("scanner.SampleAnnotation"));
            List<String> annotatedClasses = new ArrayList<>();
            for (AnnotationInstance annotationInstance : appAnnotationList) {
                if (annotationInstance.target()
                    .kind() == AnnotationTarget.Kind.CLASS) {
                    annotatedClasses.add(annotationInstance.value("name")
                        .value()
                        .toString());
                }
            }
            return Collections.unmodifiableList(annotatedClasses);
        } catch (IOException e) {
            throw new UnexpectedScanException(e);
        }
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
