package String;

public class shortestpath {
    public static void main(String args[]) {
        String paths = "WNEENESENNN";
        int x = 0;
        int y = 0;
        for (int i = 0; i < paths.length(); i++) {
            char alphabet = paths.charAt(i);
            switch (alphabet) {
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Displacement is: " + (Math.sqrt(x * x + y * y)));
    }
}
