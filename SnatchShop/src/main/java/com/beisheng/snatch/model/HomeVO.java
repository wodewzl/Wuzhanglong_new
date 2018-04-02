package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/3/8.
 */

public class HomeVO extends BaseVO{

    /**
     * data : {"multi_adv":[{"adv_image":"http://qmfq.baonongkang.cn/upload/image_collection/1520932803.jpg","adv_title":"s1","adv_url":"http://www.baidu.com","jump_type":"2"},
     * {"adv_image":"http://qmfq.baonongkang.cn/upload/image_collection/1520932832.png","adv_title":"s2","adv_url":"2222","jump_type":"1"}],"single_adv":{"adv_image":"http://qmfq.baonongkang
     * .cn/upload/image_collection/1522658987.jpg","adv_title":"心相印","adv_url":"thinkpad","jump_type":"1"},"nav_list":[{"nav_title":"商品分类","nav_icon":"http://qmfq.baonongkang
     * .cn/upload/common/1520850337.png","nav_url":""},{"nav_title":"优选商品","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850320.png","nav_url":""},{"nav_title":"每日任务",
     * "nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850328.png","nav_url":""},{"nav_title":"邀一得二","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850307.png","nav_url":""}],
     * "record_list":[{"pid":"13","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g"},{"pid":"17",
     * "goods_name":"100元三网通用话费充值卡","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了100元三网通用话费充值卡"},{"pid":"7","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅",
     * "nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅"},{"pid":"5","goods_name":"海尔（Haier）60升电热水器 5倍增容速热遥控预约
     * 一级能效节能抑菌专利2.0安全防电墙EC6003-G6","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了海尔（Haier）60升电热水器 5倍增容速热遥控预约 一级能效节能抑菌专利2.0安全防电墙EC6003-G6"},{"pid":"2",
     * "goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","nickname":"疯抢用户10005","is_true":"1","prise_desc":"恭喜疯抢用户10005获得了14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1"}],"order1_list":[{"id":"8",
     * "goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000",
     * "remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire
     * 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0",
     * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带",
     * "total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"14",
     * "goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq
     * .baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"4000","percent":"0",
     * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"19","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000",
     * "remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}],"order2_list":[{"id":"19","goods_name":"中国黄金
     * 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"4000",
     * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000",
     * "remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000",
     * "remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表
     * 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0",
     * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"10","goods_name":"雷霆世纪The fire 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用",
     * "total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"9","goods_name":"Apple
     * iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800",
     * "percent":"4","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"}],"order3_list":[{"id":"8","goods_name":"ThinkPad 联想 E570系列
     * 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},
     * {"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000",
     * "remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad
     * Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},
     * {"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0",
     * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000",
     * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅",
     * "total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"19","goods_name":"中国黄金
     * 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}],"order4_list":[{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000",
     * "remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire
     * 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq
     * .baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000",
     * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑",
     * "total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"14","goods_name":"菜百首饰
     * 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},
     * {"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0",
     * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"19","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000",
     * "remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}],"page":"1","count":"1"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * multi_adv : [{"adv_image":"http://qmfq.baonongkang.cn/upload/image_collection/1520932803.jpg","adv_title":"s1","adv_url":"http://www.baidu.com","jump_type":"2"},{"adv_image":"http://qmfq
         * .baonongkang.cn/upload/image_collection/1520932832.png","adv_title":"s2","adv_url":"2222","jump_type":"1"}]
         * single_adv : {"adv_image":"http://qmfq.baonongkang.cn/upload/image_collection/1522658987.jpg","adv_title":"心相印","adv_url":"thinkpad","jump_type":"1"}
         * nav_list : [{"nav_title":"商品分类","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850337.png","nav_url":""},{"nav_title":"优选商品","nav_icon":"http://qmfq.baonongkang
         * .cn/upload/common/1520850320.png","nav_url":""},{"nav_title":"每日任务","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850328.png","nav_url":""},{"nav_title":"邀一得二",
         * "nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850307.png","nav_url":""}]
         * record_list : [{"pid":"13","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g"},{"pid":"17",
         * "goods_name":"100元三网通用话费充值卡","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了100元三网通用话费充值卡"},{"pid":"7","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅",
         * "nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅"},{"pid":"5","goods_name":"海尔（Haier）60升电热水器 5倍增容速热遥控预约
         * 一级能效节能抑菌专利2.0安全防电墙EC6003-G6","nickname":"lhb","is_true":"1","prise_desc":"恭喜lhb获得了海尔（Haier）60升电热水器 5倍增容速热遥控预约 一级能效节能抑菌专利2.0安全防电墙EC6003-G6"},{"pid":"2",
         * "goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","nickname":"疯抢用户10005","is_true":"1","prise_desc":"恭喜疯抢用户10005获得了14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1"}]
         * order1_list : [{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000",
         * "remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire
         * 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款
         * M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0",
         * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅",
         * "total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"19",
         * "goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}]
         * order2_list : [{"id":"19","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000",
         * "remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"16","goods_name":"夏普电视机",
         * "total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条
         * 10g","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"12",
         * "goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"10","goods_name":"雷霆世纪The fire
         * 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000",
         * "remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列
         * 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"}]
         * order3_list : [{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800","percent":"4","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000",
         * "remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire
         * 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款
         * M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0",
         * "goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"16","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"18","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅",
         * "total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"19",
         * "goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}]
         * order4_list : [{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq
         * .baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"10","goods_name":"雷霆世纪The fire 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000",
         * "remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"16","goods_name":"夏普电视机",
         * "total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G
         * WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"4800",
         * "percent":"4","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g",
         * "total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"18",
         * "goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000",
         * "percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"19","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g",
         * "total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"}]
         * page : 1
         * count : 1
         */

        private SingleAdvBean single_adv;
        private String page;
        private String count;
        private List<MultiAdvBean> multi_adv;
        private List<NavListBean> nav_list;
        private List<RecordListBean> record_list;
        private List<Order1ListBean> order1_list;
        private List<Order2ListBean> order2_list;
        private List<Order3ListBean> order3_list;
        private List<Order4ListBean> order4_list;

        public SingleAdvBean getSingle_adv() {
            return single_adv;
        }

        public void setSingle_adv(SingleAdvBean single_adv) {
            this.single_adv = single_adv;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<MultiAdvBean> getMulti_adv() {
            return multi_adv;
        }

        public void setMulti_adv(List<MultiAdvBean> multi_adv) {
            this.multi_adv = multi_adv;
        }

        public List<NavListBean> getNav_list() {
            return nav_list;
        }

        public void setNav_list(List<NavListBean> nav_list) {
            this.nav_list = nav_list;
        }

        public List<RecordListBean> getRecord_list() {
            return record_list;
        }

        public void setRecord_list(List<RecordListBean> record_list) {
            this.record_list = record_list;
        }

        public List<Order1ListBean> getOrder1_list() {
            return order1_list;
        }

        public void setOrder1_list(List<Order1ListBean> order1_list) {
            this.order1_list = order1_list;
        }

        public List<Order2ListBean> getOrder2_list() {
            return order2_list;
        }

        public void setOrder2_list(List<Order2ListBean> order2_list) {
            this.order2_list = order2_list;
        }

        public List<Order3ListBean> getOrder3_list() {
            return order3_list;
        }

        public void setOrder3_list(List<Order3ListBean> order3_list) {
            this.order3_list = order3_list;
        }

        public List<Order4ListBean> getOrder4_list() {
            return order4_list;
        }

        public void setOrder4_list(List<Order4ListBean> order4_list) {
            this.order4_list = order4_list;
        }

        public static class SingleAdvBean {
            /**
             * adv_image : http://qmfq.baonongkang.cn/upload/image_collection/1522658987.jpg
             * adv_title : 心相印
             * adv_url : thinkpad
             * jump_type : 1
             */

            private String adv_image;
            private String adv_title;
            private String adv_url;
            private String jump_type;

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getAdv_url() {
                return adv_url;
            }

            public void setAdv_url(String adv_url) {
                this.adv_url = adv_url;
            }

            public String getJump_type() {
                return jump_type;
            }

            public void setJump_type(String jump_type) {
                this.jump_type = jump_type;
            }
        }

        public static class MultiAdvBean {
            /**
             * adv_image : http://qmfq.baonongkang.cn/upload/image_collection/1520932803.jpg
             * adv_title : s1
             * adv_url : http://www.baidu.com
             * jump_type : 2
             */

            private String adv_image;
            private String adv_title;
            private String adv_url;
            private String jump_type;

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getAdv_url() {
                return adv_url;
            }

            public void setAdv_url(String adv_url) {
                this.adv_url = adv_url;
            }

            public String getJump_type() {
                return jump_type;
            }

            public void setJump_type(String jump_type) {
                this.jump_type = jump_type;
            }
        }

        public static class NavListBean {
            /**
             * nav_title : 商品分类
             * nav_icon : http://qmfq.baonongkang.cn/upload/common/1520850337.png
             * nav_url :
             */

            private String nav_title;
            private String nav_icon;
            private String nav_url;

            public String getNav_title() {
                return nav_title;
            }

            public void setNav_title(String nav_title) {
                this.nav_title = nav_title;
            }

            public String getNav_icon() {
                return nav_icon;
            }

            public void setNav_icon(String nav_icon) {
                this.nav_icon = nav_icon;
            }

            public String getNav_url() {
                return nav_url;
            }

            public void setNav_url(String nav_url) {
                this.nav_url = nav_url;
            }
        }

        public static class RecordListBean {
            /**
             * pid : 13
             * goods_name : 中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g
             * nickname : lhb
             * is_true : 1
             * prise_desc : 恭喜lhb获得了中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g
             */

            private String pid;
            private String goods_name;
            private String nickname;
            private String is_true;
            private String prise_desc;

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getIs_true() {
                return is_true;
            }

            public void setIs_true(String is_true) {
                this.is_true = is_true;
            }

            public String getPrise_desc() {
                return prise_desc;
            }

            public void setPrise_desc(String prise_desc) {
                this.prise_desc = prise_desc;
            }
        }

        public static class Order1ListBean {
            /**
             * id : 8
             * goods_name : ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑
             * total_count : 5000
             * remain_count : 4800
             * percent : 4
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg
             */

            private String id;
            private String goods_name;
            private String total_count;
            private String remain_count;
            private String percent;
            private String goods_image;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }

        public static class Order2ListBean {
            /**
             * id : 19
             * goods_name : 中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g
             * total_count : 1000
             * remain_count : 1000
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg
             */

            private String id;
            private String goods_name;
            private String total_count;
            private String remain_count;
            private String percent;
            private String goods_image;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }

        public static class Order3ListBean {
            /**
             * id : 8
             * goods_name : ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑
             * total_count : 5000
             * remain_count : 4800
             * percent : 4
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg
             */

            private String id;
            private String goods_name;
            private String total_count;
            private String remain_count;
            private String percent;
            private String goods_image;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }

        public static class Order4ListBean {
            /**
             * id : 12
             * goods_name : 美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带
             * total_count : 10000
             * remain_count : 10000
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg
             */

            private String id;
            private String goods_name;
            private String total_count;
            private String remain_count;
            private String percent;
            private String goods_image;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }
    }
}
