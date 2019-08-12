package marco.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext(new String[]{"application.xml"});

        IPayService iPayService = (IPayService)classPathXmlApplicationContext.getBean("payService");
        String result = iPayService.pay("Test");
        System.out.println(result);
    }
}