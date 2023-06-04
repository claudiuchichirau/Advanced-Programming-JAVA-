package laborator_12;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class JavaClassAnalyzer {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide the path to the .class file.");
            return;
        }

        String classFilePath = args[0];
        Class<?> clazz = loadClass(classFilePath);
        if (clazz != null) {
            analyzeClass(clazz);
            invokeTestMethods(clazz);
        }
    }

    private static Class<?> loadClass(String classFilePath) throws Exception {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file://" + classFilePath)});
        String className = extractClassName(classFilePath);
        return classLoader.loadClass(className);
    }

    private static String extractClassName(String classFilePath) {
        String fileName = classFilePath.substring(classFilePath.lastIndexOf('/') + 1);
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    private static void analyzeClass(Class<?> clazz) {
        String packageName = clazz.getPackage() != null ? clazz.getPackage().getName() : "default package";
        System.out.println("Class Name: " + clazz.getSimpleName());
        System.out.println("Package: " + packageName);

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(" - " + method.getName());
        }
    }

    private static void invokeTestMethods(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().getSimpleName().equals("Test")) {
                    if (method.getParameterCount() == 0) {
                        System.out.println("Invoking test method: " + method.getName());
                        method.invoke(null); // Invoke static method
                    } else {
                        System.out.println("Skipping test method with parameters: " + method.getName());
                    }
                }
            }
        }
    }
}
