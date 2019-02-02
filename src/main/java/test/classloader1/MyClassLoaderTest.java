package test.classloader1;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/30 12:19
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/30 12:19
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MyClassLoaderTest {
    public static void main(String[] args)throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("MyClassLoader");

        Class<?> clazz =myClassLoader.loadClass("test.classloader1.SimpleObject");

        System.out.println(clazz);

        System.out.println(clazz.getClassLoader());

        System.out.println(clazz.getClassLoader().getParent());
    }
}
