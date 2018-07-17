package assignment.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public abstract class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new SimpleCORSFilter()};
    }
}

