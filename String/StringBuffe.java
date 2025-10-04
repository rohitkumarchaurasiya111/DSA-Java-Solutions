package String;
public class StringBuffe {
    public static void main(String args[]){
        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer.capacity());
        buffer.append("Hello");
        System.out.println(buffer);
        System.out.println(buffer.capacity());
        buffer.ensureCapacity(50);
        System.out.println(buffer.capacity());
    }
}
