package client;

import library.MyLibraryAutoConfig;
import library.MyLibraryClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootConfiguration
public class MyStarterClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyLibraryAutoConfig.class
        );

        MyLibraryClass myLibraryClassByClass = context.getBean(MyLibraryClass.class);
        myLibraryClassByClass.printInfo();

        MyLibraryClass myLibraryClass = (MyLibraryClass) context.getBean("myLibraryClass");
        myLibraryClass.printInfo();
    }
}