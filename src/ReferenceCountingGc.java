/**
 * Created by 林夕
 * Date 2021/3/28 15:59
 */
public class ReferenceCountingGc {

    public Object instance = null;

    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String[] args) {
        testGC();
    }

    public static void testGC(){
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();

        objA.instance = objB;
        objB.instance = objA;

        objA=null;
        objB=null;

        System.gc();
    }
}
