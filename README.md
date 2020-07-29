weixin-pay-v3
============

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/work.trons.library/weixin-pay-v3/badge.svg)](https://maven-badges.herokuapp.com/maven-central/work.trons.library/weixin-pay-v3/)
[![GitHub release](https://img.shields.io/github/release/TRonsbibubibu/weixin-pay-v3.svg)](https://github.com/TRonsbibubibu/weixin-pay-v3/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

微信支付API v3本 JAVA 实现SDK

[微信支付API官方文档](https://pay.weixin.qq.com/wiki/doc/apiv3/wxpay/pages/Overview.shtml)

## 优点
* 使用简单易懂
* 请求敏感信息自动加解密
* 请求自动签名
* 微信支付证书自动加载

## maven
```xml
<dependency>
  <groupId>work.trons.library</groupId>
  <artifactId>weixin-pay-v3</artifactId>
  <version>1.2.0</version>
</dependency>
```



## 实现接口

* 基础支付 
  * PayApi 普通支付（直连模式) ✅
  * PartnerPayApi 普通支付（服务商模式) ✅
  * CombineApi 合单支付 ✅
  * BillApi 账单 ✅
* Ecommerce 电商收付通
  * EcoApplymentApi 商户进件 ✅ 
  * CombineApi 合单支付 ✅
  * EcoSubsidyApi 补差 ✅
  * EcoProfitSharingApi 分账 ✅ 
  * EcoRefundApi 退款 ✅ 
  * EcoBalanceApi 余额查询 ✅ 
  * EcoWithdrawApi 提现 ✅
  * BillApi 账单 ✅
* 商户进件
  * SubMchApi 特约商户进件 ✅ 
* 通用接口
  * SubjectApi 商户开户意愿确认 ✅
  * CommonApi 图片上传 ✅
  * CommonApi 视频上传 ✅
  * ComplaintApi 商业支付投诉 ✅

## 举个栗子
```java
// 不需要传入微信支付证书，PaySetting自动加载支付证书
PaySetting paySetting = PaySetting
        .newBuilder()
        .mchId("mchid")
        .aesKey("aes key from weixin")
        .certificate(new FileInputStream("the path of api cert"))
        .build();

//APP 下单
PayApi payApi = PayApi.with(paySetting);
PayResponse res = payApi.app(PayRequest.builder()
        .mchid("mchid")
        .build());
if (!res.isSuccess()) {
    log.error("Response code {} message {}", res.getCode(), res.getMessage());
}

//接收支付通知
PayCallback callback = payApi.callback(" callback json content ");
callback.getAppid();
// handle response
```