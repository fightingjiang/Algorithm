package 注解;

import java.lang.reflect.Field;

public class AnnoTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<CAnno> cAnnoClass = CAnno.class;
        CAnno annoTest = cAnnoClass.newInstance();
        System.out.println(annoTest.name);
        if(cAnnoClass.isAnnotationPresent(Component.class)){
            Field name1 = cAnnoClass.getField("name");
            if(name1.isAnnotationPresent(Autowired.class)){
                String name = name1.getAnnotation(Autowired.class).name();
                annoTest.name = name;
            }
        }
        System.out.println(annoTest.name);
    }
}
