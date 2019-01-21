package com.example.haodong.butterknife.compiler;

import com.example.haodong.butterknife.annotation.BindView;
import com.google.auto.service.AutoService;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * @Auther linghailong
 * created at 2019/1/21
 * @duscribe:
 */
@AutoService(Processor.class)
public class ButterKnifeProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        /*process 表示的是有注解都会进来 */
        return false;
    }

    /*1. 指定处理的最高版本*/
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /*2. 指定需要处理注解*/
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        // 需要解析的自定义注解 BindView  OnClick
        annotations.add(BindView.class);
        return annotations;
    }

}
