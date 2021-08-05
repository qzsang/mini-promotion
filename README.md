# mini-promotion
简单的高可扩展的促销引擎

### 结构解读
在org.example.promotion包下
```
└── core    核心功能
└── extension    为基础扩展代 (基础通用层插件化)
└── application    业务应用扩展 (应用层插件化)
```
### 代码学习
- 分支V1 演示了促销引擎的核心和集成
- 分支V2 在V1的基础上进行了扩展：加上组合条件，使促销活动能新增任意的排列组合条件
- 在PromotionApplicationTests中可以看代码调用情况。

### 用例
https://github.com/qzsang/mini-promotion/blob/master/src/test/java/case1/PromotionApplicationTests.java

### PPT
https://github.com/qzsang/mini-promotion/blob/master/doc/%E4%BB%8E%E4%BF%83%E9%94%80%E5%BC%95%E6%93%8E%E5%88%B0%E5%BE%AE%E5%86%85%E6%A0%B8%E6%9E%B6%E6%9E%84%E5%88%86%E4%BA%AB.pptx
