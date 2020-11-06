import java.io.*;
import java.net.URL;
import java.util.*;

// 生成md中语句，为了方便使用
public class GenerateMd {

    private static final String prefixName = "C:\\Users\\xiaohshi\\Desktop\\leetcode\\src\\main\\java\\";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        // 获取包的物理路径
        File dir = new File(prefixName + name);
        if (!dir.exists()) {
            System.out.println("输入错误");
            return;
        }
        File[] files = dir.listFiles();
        Map<Integer, File> map = new HashMap<>();
        for (File file : files) {
            String fileName = file.getName();
            int num = Integer.parseInt(fileName.substring(8, fileName.lastIndexOf(".")));
            map.put(num, file);
        }
        List<Integer> nums = new ArrayList<>(map.keySet());
        Collections.sort(nums);
        for (int num : nums) {
            File file = map.get(num);
            String flag = num + ". ";
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String content;
            while ((content = buffer.readLine()) != null) {
                if (content.contains(flag)) {
                    String res = "###### [leetcode" + num + " " + content.substring(flag.length())
                            + "](https://github.com/xiaohshi/leetcode/blob/master/src/main/java/"
                            + name + "/LeetCode" + num + ".java)";
                    System.out.println(res);
                    break;
                }
            }
        }
    }
}