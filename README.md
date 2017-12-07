# 感谢
我们必须要感谢Gayle Laakmann McDowell。她的[Cracking the Coding Interview](http://amzn.to/2zTpjdP)（以下简称宝典）给程序员们和面试者们搭起了一座沟通的桥梁。
不要以为只有找工作的程序员才读这本书，面试官们也在读！

# 为什么创建此仓库
本仓库是对宝典的补充。宝典本身的设计思路已经非常完善，实现了问题，提示和参考答案的分离。引导程序员们开动大脑，一步一步找到答案。

其中不足的是没有提供裁判系统，缺少测试来验证答案。

# 如何使用
本仓库目前含有两个分支:
- master: 含有测试，问题和答案
- questions: 只含有测试和问题，供训练使用

比如，您可以使用下面的命令查看IsUnique的答案

```git diff questions master -- src/main/java/arraystring/_01_01_IsUnique.java```
