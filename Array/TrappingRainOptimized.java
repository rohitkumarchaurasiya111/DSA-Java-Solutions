package Array;

public class TrappingRainOptimized {
    public static void main(String args[]) {
        int arr[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        int RightMax[] = new int[arr.length];
        int LeftMax[] = new int[arr.length];

        // LeftMax is Auxuliary Array or Helping Array which helps in further
        // Programmin;
        LeftMax[0] = arr[0];
        for (int i = 1; i < LeftMax.length; i++) {
            if (LeftMax[i - 1] < arr[i]) {
                LeftMax[i] = arr[i];
            } else {
                LeftMax[i] = LeftMax[i - 1];
            }
        }

        RightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (RightMax[i + 1] < arr[i]) {
                RightMax[i] = arr[i];
            } else {
                RightMax[i] = RightMax[i + 1];
            }
        }

        int height = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Math.min(LeftMax[i], RightMax[i]);
            height += min - arr[i];
        }
        System.out.println("The Volume of Water Trapped is " + height);
    }
}
