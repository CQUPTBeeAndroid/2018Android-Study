# 苟有恒，何必三更眠五更起

## 网络请求，json解析，异步
- 参考资料：
    * [网络请求HttpUrlConnection](http://www.jianshu.com/p/adcc1740686d)
    * [Android OkHttp3简介和使用详解](https://blog.csdn.net/zhangqiluGrubby/article/details/71480546)
    * [JSON解析](http://blog.chinaunix.net/uid-26935820-id-3213895.html)
    * [GSON解析](http://www.jianshu.com/p/3b8ef7162e69)
    * [HttpUrlConnection与JSON结合](http://blog.csdn.net/u012440207/article/details/24710537)
    * [异步消息处理 handle的使用](http://blog.csdn.net/iispring/article/details/47115879)
    * [Android异步操作的另一种方法](http://blog.csdn.net/guolin_blog/article/details/11711405)
- 作业
    - 基本要求： gank 数据
        * 了解第三方Api的使用，熟悉网络请求部分
        * 用网络拉去数据
        * 拉取数据不用框架
        * 提供资料 [ gank api 干货集中营 ](http://gank.io/api)
    - 提升部分： gank 列表
        * 有基础的自己尽量实现网络请求的封装
        * 或者运用 Retrofit 以及 Okhttp 网络请求
        * 加入上拉加载，下拉刷新


## 服务，地图
- 参考资料
    * [Android Service使用详解](https://www.jianshu.com/p/95ec2a23f300)
    * [高德地图 api 官方网址](http://lbs.amap.com/api/)
    * [高德地图 Android 定位SDK  -> 概述](http://lbs.amap.com/api/android-location-sdk/locationsummary/)
    * [百度地图 api 官方网址](http://lbsyun.baidu.com/)
- 作业:地图
    * 监听系统 GPS 的打开与关闭（尽量）
    * 集成高德地图（推荐），或者使用百度地图
    * 展示地图，定位
    * 路线规划（尽可能）
- 补充：
  Android 手机在重要的事件发生的时候，都会向全局发送一个广播，比如说 网络连接上，有电话打来等，所以监听GPS是否打开可以考虑广播这个实现方案，网上也有源码，就不再赘述

## 优化你的布局
- 参考资料
    * [Material Design 中文版 注意：目录可查看全部](http://design.1sters.com/material_design/material-design/introduction.html)
    * [Android Material Design 兼容库的使用详解](https://www.jianshu.com/p/1e6eed09d48b)
- 作业
    * 在gank的作业上进行修改
    * 选取自己喜欢的设计元素设计 Gank app