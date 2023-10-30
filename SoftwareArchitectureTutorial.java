package ruanti2;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class SoftwareArchitectureTutorial extends JFrame {
    private JTextArea resultTextArea;

    public SoftwareArchitectureTutorial() {
        setTitle("经典软件体系结构教学软件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // 创建选择处理方法的下拉框
        String[] methods = {"主程序-子程序", "面向对象", "事件系统", "管道-过滤器"};
        JComboBox<String> methodComboBox = new JComboBox<>(methods);
        methodComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 处理方法选择变化时的逻辑
                String selectedMethod = (String) methodComboBox.getSelectedItem();
                processFile(selectedMethod);
            }
        });

        // 创建结果显示文本区域
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // 创建面板，并添加选择方法的下拉框和结果显示文本区域
        JPanel panel = new JPanel();
        panel.add(new JLabel("选择处理方法："));
        panel.add(methodComboBox);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

//        ImageIcon imageIcon = new ImageIcon("E:\\Temp\\2.png");
//        JLabel imageLabel = new JLabel(imageIcon);
//        add(imageLabel, BorderLayout.SOUTH);
    }


    private void processFile(String method) {
        // 根据选择的处理方法对指定的输入文件进行处理，并将结果显示在界面上
        String result = "";
        String filePath = "E:\\Temp\\input.txt"; // 用户指定的文件路径
        File file = new File(filePath);
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append("\n");
                }
                reader.close();

                if (method.equals("主程序-子程序")) {
                    // 主程序-子程序处理逻辑
                    result = "使用主程序-子程序处理文件：" + content.toString()+"阅读文献:https://blog.csdn.net/weixin_43853097/article/details/110943379?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&utm_relevant_index=1";
                    ImageIcon imageIcon = new ImageIcon("E:\\Temp\\1.png");
                    JLabel imageLabel = new JLabel(imageIcon);
                    add(imageLabel, BorderLayout.SOUTH);
                } else if (method.equals("面向对象")) {
                    // 面向对象处理逻辑
                    result = "使用面向对象处理文件：" + content.toString()+"阅读文献:https://blog.csdn.net/weixin_43853097/article/details/110943379?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&utm_relevant_index=1";
                    ImageIcon imageIcon = new ImageIcon("E:\\Temp\\2.png");
                    JLabel imageLabel = new JLabel(imageIcon);
                    add(imageLabel, BorderLayout.SOUTH);
                } else if (method.equals("事件系统")) {
                    // 事件系统处理逻辑
                    result = "使用事件系统处理文件：" + content.toString()+"E:\\Temp\\3.png"+"阅读文献:https://blog.csdn.net/weixin_43853097/article/details/110943379?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&utm_relevant_index=1";
                    ImageIcon imageIcon = new ImageIcon("E:\\Temp\\3.png");
                    JLabel imageLabel = new JLabel(imageIcon);
                    add(imageLabel, BorderLayout.SOUTH);
                } else if (method.equals("管道-过滤器")) {
                    // 管道-过滤器处理逻辑
                    result = "使用管道-过滤器处理文件：" + content.toString()+"阅读文献:https://blog.csdn.net/weixin_43853097/article/details/110943379?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-110943379-blog-82871259.t5_download_50w&utm_relevant_index=1";
                    ImageIcon imageIcon = new ImageIcon("E:\\Temp\\4.png");
                    JLabel imageLabel = new JLabel(imageIcon);
                    add(imageLabel, BorderLayout.SOUTH);
                }

                // 循环移位处理
                String[] lines = content.toString().split("\n");
                StringBuilder shiftedContent = new StringBuilder();
                for (String l : lines) {
                    String[] words = l.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        StringBuilder shiftedLine = new StringBuilder();
                        for (int j = i; j < words.length; j++) {
                            shiftedLine.append(words[j]);
                            shiftedLine.append(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            shiftedLine.append(words[j]);
                            shiftedLine.append(" ");
                        }
                        shiftedContent.append(shiftedLine.toString().trim());
                        shiftedContent.append("\n");
                    }
                }

                // 更新结果显示文本区域
                resultTextArea.setText(result + "\n\n循环移位后的结果：\n" + shiftedContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            result = "文件不存在";
            resultTextArea.setText(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SoftwareArchitectureTutorial tutorial = new SoftwareArchitectureTutorial();
                tutorial.setVisible(true);
            }
        });
    }
}
