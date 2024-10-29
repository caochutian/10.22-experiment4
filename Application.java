import java.io.*;// 导入输入输出流的相关类
public class AveragePriceCalculator {
    public static void main(String[] args) { // 定义商品列表文件的路径
        String filePath = "D:/作业/Java_homework/商品列表.txt"; // 替换为实际的文件路径
        double total = 0.0;// 用于存储价格总和
        int count = 0;// 用于计数价格的数量
        // 使用 UTF-8 编码读取文件
        //BufferedReader：用于读取字符输入流，提供缓冲功能以提高效率。
        //InputStreamReader：将字节流转换为字符流，并可以指定字符编码（如 UTF-8）
        //FileInputStream：用于从文件中读取字节。
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;// 用于存储每一行的内容
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                // 如果该行包含“元”，表示有价格信息
                if (line.contains("元")) {
                    // 提取“元”前面的4个字符作为价格字符串
                    String priceStr = line.substring(line.indexOf("元") - 4, line.indexOf("元"));
                    // 将价格字符串转换为 double 类型
                    double price = Double.parseDouble(priceStr);
                    total += price;// 累加价格
                    count++;// 商品数量加1
                }
            }
        } catch (IOException e) {// 输出异常信息
            e.printStackTrace();
        }
        // 计算平均价格，如果没有价格则避免除以零
        double average =count > 0 ? total / count : 0;//等于if(count>0){}

         // 使用 UTF-8 编码追加写入文件
         //BufferedWriter：用于写入字符输出流，提供缓冲功能以提高写入效率。
         //OutputStreamWriter：将字符流写入字节流，并可以指定字符编码。
         //FileOutputStream：用于向文件中写入字节（可以选择是否追加内容,true为追加，false为重写）。
        
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true),"UTF-8"))) {
            // 将平均价格写入文件
            writer.write("\n平均价格: " + average + "元");
        } catch (IOException e) {// 输出异常信息
            e.printStackTrace();
        }
    }
}