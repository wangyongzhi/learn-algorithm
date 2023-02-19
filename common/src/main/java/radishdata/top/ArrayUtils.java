package radishdata.top;

/**
 * @author wangyongzhi
 * @date 2023-02-19
 */
public final class ArrayUtils {


    public static void print(int[] arr) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
                continue;
            }
            sb.append(arr[i]).append(",");
        }

        String s = sb.toString();
        System.out.println(s);

    }



    public static void print(char[] arr) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
                continue;
            }
            sb.append(arr[i]).append(",");
        }

        String s = sb.toString();
        System.out.println(s);

    }
}
