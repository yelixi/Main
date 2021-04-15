/**
 * Created by 林夕
 * Date 2021/4/10 15:56
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
