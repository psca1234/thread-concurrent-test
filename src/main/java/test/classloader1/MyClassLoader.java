package test.classloader1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Description: java类作用描述
 * @Author: pansc
 * @CreateDate: 2019/1/30 11:24
 * @UpdateUser: pansc
 * @UpdateDate: 2019/1/30 11:24
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class MyClassLoader extends ClassLoader {
    private final String DEFUALT_CLASS_DIR = "E:\\工作文件夹\\classloader1";
    private String classLoaderPath = DEFUALT_CLASS_DIR;
    private String classLoaderName;

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public String getClassLoaderPath() {
        return classLoaderPath;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderPath(String classLoaderPath) {
        this.classLoaderPath = classLoaderPath;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath= name.replace(".", "/");
        File classFile = new File(classLoaderPath, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("The class" + name + "\tis not found under path\t" + this.classLoaderPath);
        }
        byte[] bytes = changeFileToArray(classFile);
        if (bytes == null || bytes.length == 0) {
            throw new ClassNotFoundException("load the class " + name + " failed");
        }
        return super.defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] changeFileToArray(File file) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[1024];
            int count;
            while ((count = fis.read(bytes)) != -1) {
                outputStream.write(bytes, 0, count);
            }
            outputStream.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
