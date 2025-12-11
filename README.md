# study

小学生数学测试系统（Java 控制台版）

## 功能简介
- 选择难度（简单/中等/困难）决定题目数字范围。
- 自定义题目数量（5-30 道）。
- 随机生成加、减、乘、除混合运算，自动避免除法出现余数。
- 逐题即时反馈，结束后显示总成绩。

## 运行方法
在仓库根目录执行以下命令编译并运行：

```bash
javac -d out $(find src -name "*.java")
java -cp out com.example.mathquiz.MathQuizApp
```

按照提示输入难度和题目数量，即可开始测试。
