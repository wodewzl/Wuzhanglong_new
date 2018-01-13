package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/12.
 */

public class OrderVO extends BaseVO implements Serializable {
    private OrderVO datas;
    private OrderVO data;
    private List<OrderVO> order_list;
    private String order_id;
    private String order_status;
    private String order_no;
    private String out_trade_no;
    private String user_name;
    private String receiver_mobile;
    private String receiver_province_name;
    private String receiver_city_name;
    private String receiver_district_name;
    private String create_time;
    private String order_money;
    private String is_evaluate;
    private String type;//
    private List<OrderVO> order_item_list;
    private String order_goods_id;
    private String goods_id;
    private String goods_name;
    private String price;
    private String num;
    private String refund_status;
    private String refund_type;
    private String refund_require_money;
    private String refund_reason;
    private String pic_cover_small;
    private List<OrderVO> member_operation;
    private String no;
    private String color;
    private String name;
    private String page_count;

    public String getPage_count() {
        return page_count;
    }

    public void setPage_count(String page_count) {
        this.page_count = page_count;
    }

    public OrderVO getDatas() {
        return datas;
    }

    public void setDatas(OrderVO datas) {
        this.datas = datas;
    }

    public OrderVO getData() {
        return data;
    }

    public void setData(OrderVO data) {
        this.data = data;
    }

    public List<OrderVO> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<OrderVO> order_list) {
        this.order_list = order_list;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getReceiver_mobile() {
        return receiver_mobile;
    }

    public void setReceiver_mobile(String receiver_mobile) {
        this.receiver_mobile = receiver_mobile;
    }

    public String getReceiver_province_name() {
        return receiver_province_name;
    }

    public void setReceiver_province_name(String receiver_province_name) {
        this.receiver_province_name = receiver_province_name;
    }

    public String getReceiver_city_name() {
        return receiver_city_name;
    }

    public void setReceiver_city_name(String receiver_city_name) {
        this.receiver_city_name = receiver_city_name;
    }

    public String getReceiver_district_name() {
        return receiver_district_name;
    }

    public void setReceiver_district_name(String receiver_district_name) {
        this.receiver_district_name = receiver_district_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    public String getIs_evaluate() {
        return is_evaluate;
    }

    public void setIs_evaluate(String is_evaluate) {
        this.is_evaluate = is_evaluate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrderVO> getOrder_item_list() {
        return order_item_list;
    }

    public void setOrder_item_list(List<OrderVO> order_item_list) {
        this.order_item_list = order_item_list;
    }

    public String getOrder_goods_id() {
        return order_goods_id;
    }

    public void setOrder_goods_id(String order_goods_id) {
        this.order_goods_id = order_goods_id;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefund_type() {
        return refund_type;
    }

    public void setRefund_type(String refund_type) {
        this.refund_type = refund_type;
    }

    public String getRefund_require_money() {
        return refund_require_money;
    }

    public void setRefund_require_money(String refund_require_money) {
        this.refund_require_money = refund_require_money;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public String getPic_cover_small() {
        return pic_cover_small;
    }

    public void setPic_cover_small(String pic_cover_small) {
        this.pic_cover_small = pic_cover_small;
    }

    public List<OrderVO> getMember_operation() {
        return member_operation;
    }

    public void setMember_operation(List<OrderVO> member_operation) {
        this.member_operation = member_operation;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
