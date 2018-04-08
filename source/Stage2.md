# Android初试探

以下部分正式进入 Android 学习阶段，还无 Java 基础的同学先把 Java 基础补起来。主要参考书籍为 第一行代码，也可以选择视频学习（慕课网、极客学院）。

## 任务一 认识分析你的第一个项目
- 前言：在我们的项目中，我们会有其项目结构，每一个目录都有其作用，了解他们是作为一个Android程序员最基本的能力。与此同时，Gradle 是android studio引入的构建工具，我们使用它能方便的进行开发，也需要进行了解，但不必深入，后续会深入理解
- 参考资料：
    * [Project目录结构](https://www.cnblogs.com/yuqf/p/5361168.html)
    * [Android Studio项目目录结构介绍](https://appkfz.com/2015/07/07/android-studio-project-struct/)
    * [Android Gradle 基础](http://stormzhang.com/devtools/2014/12/18/android-studio-tutorial4/)
    * [给初学者的Gradle知识](http://stormzhang.com/android/2016/07/02/gradle-for-android-beginners/)

## 任务二 Activity、UI控件
- 前言：Activity作为四大组件之一，是Android的重要组成部分，所以Activity的基础知识是每个开发者必须知道的。控件作为UI最基础的东西，是入门必学的，相信掌握了它你们已经能开发出有界面的android App了
- 学习资料：
    * [Activity 的生命周期](http://blog.csdn.net/android_tutor/article/details/5772285)
    * [基本控件的使用](http://blog.csdn.net/j903829182/article/details/40660275)
    * [四种基本布局的使用](http://blog.csdn.net/j903829182/article/details/40663303)
- 作业：
  - 基本要求：
     * 实现两个Activity的跳转
     * 信息传递
  - 提升部分
     * 限定活动的启动模式
     * 使用EventBus传输数据
     * 使用隐式和显式两种跳转
     * 等等...

## 任务三 ListView、RecyclerView的使用
- 这个作业完成后会有一次综合评定（筛选）
- 前言：ListView顾名思义就是列表View，学习它的Viewholder缓存原理有助于大家了解更多的知识，而RecyclerView的则是更为强大的滚动控件，对于RecyclerView的使用的作为Android程序员的必备技能。而其配合使用的一套组件更是日常开发常见利器。
- 参考资料：
    * [ListView基本使用](http://www.jianshu.com/p/0c4d6cdc4e10)
    * [RecyclerView 教程，全面了解各种使用方法](https://blog.csdn.net/xx326664162/article/details/61199895)
    * [这是一篇Android RecyclerView使用介绍哦](https://www.jianshu.com/p/12ec590f6c76)
- 作业功能要求
    * listview、recyclerview两种列表展示
    * 每个item能触发点击事件
    * 上拉加载
    * 下拉刷新 
    * 圆形图像的运用（CircleImageView）







