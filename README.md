# Java IO及相关技术学习项目

这是一个综合性的Java学习项目，涵盖了算法、设计模式、并发编程、网络编程等多个方面的内容。

## 项目概述

本项目是用于学习和实践Java相关技术的代码集合，包括但不限于：
- 常见数据结构与算法实现
- 设计模式的Java实现
- 并发编程示例
- 网络编程示例
- Java IO操作示例
- 其他Java特性演示

## 技术栈

- Java 11
- Maven
- Netty (网络编程框架)
- Fastjson (JSON处理)
- MySQL (数据库连接)
- Logback (日志框架)
- JMH (性能测试工具)
- Google Guava (工具库)
- Apache Commons系列工具包

## 项目结构

```
src/main/java/com/oswizar/io/
├── algorithm/           # 算法实现
│   ├── array/           # 数组相关算法
│   ├── backtrack/       # 回溯算法
│   ├── bitoperation/    # 位运算
│   ├── dynamicprogramming/ # 动态规划
│   ├── linkedlist/      # 链表相关算法
│   ├── number/          # 数字相关算法
│   ├── recursion/       # 递归算法
│   ├── search/          # 搜索算法
│   ├── slidingwindow/   # 滑动窗口算法
│   ├── stack/           # 栈相关算法
│   ├── string/          # 字符串相关算法
│   └── tree/            # 树相关算法
├── designpattern/       # 设计模式实现
│   ├── abstractfactory/ # 抽象工厂模式
│   ├── adapter/         # 适配器模式
│   ├── chain/           # 责任链模式
│   ├── decorator/       # 装饰器模式
│   ├── factorymethod/   # 工厂方法模式
│   ├── proxy/           # 代理模式
│   ├── simplefactory/   # 简单工厂模式
│   └── singleton/       # 单例模式
├── concurrency/         # 并发编程示例
├── network/             # 网络编程示例
│   ├── bio/             # BIO编程示例
│   ├── nio/             # NIO编程示例
│   └── netty/           # Netty框架示例
├── sample/              # 各类Java特性演示
└── util/               # 工具类
```

## 主要内容

### 算法部分
实现了常见的数据结构和算法题目，如：
- 数组相关：移动零、合并区间、盛最多水的容器等
- 链表相关：反转链表、环形链表、合并有序链表等
- 字符串相关：罗马数字转整数、字符串转整数等
- 树相关算法
- 回溯算法
- 动态规划等

### 设计模式
包含了20多种常见的设计模式的Java实现，如单例模式、工厂模式、装饰器模式、代理模式等。

### 并发编程
提供了多线程相关的示例代码，包括线程同步、锁机制、线程池等。

### 网络编程
包含BIO、NIO以及Netty框架的使用示例。

### Java特性演示
展示了各种Java特性的使用方法，如Lambda表达式、Stream API、反射、注解等。

## 如何运行

1. 克隆项目到本地
2. 使用IDE导入Maven项目
3. 编译并运行相应的类文件

## 学习建议

建议按照以下顺序学习：

1. 从sample包开始，熟悉基础Java特性
2. 学习algorithm包中的算法实现
3. 理解designpattern包中的设计模式
4. 掌握concurrency包中的并发编程技巧
5. 学习network包中的网络编程知识

## 贡献

欢迎提交Issue或Pull Request来改进代码或添加新的示例。