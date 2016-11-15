package com.icss.modal;

import java.util.List;

public class GoodsBean {
		private int id;
		private int type_id;
		private String type_name;
		private String goods_name;
		private String goods_details;
		private float goods_price;
		private float goods_old_price;
		private int goods_store_amount;
		private int goods_sales;
		private String goods_state;
		private String img1_src;
		private String img2_src;
		private String img3_src;
		private String img4_src;
		private String text;
		private String path;
		
		//子节点都用list的接收,作为父节点的属性
		private List<GoodsBean> children;
		
		
		
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		
		public List<GoodsBean> getChildren() {
			return children;
		}
		public void setChildren(List<GoodsBean> children) {
			this.children = children;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}
		public String getType_name() {
			return type_name;
		}
		public void setType_name(String type_name) {
			this.type_name = type_name;
		}
		public String getGoods_name() {
			return goods_name;
		}
		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}
		public String getGoods_details() {
			return goods_details;
		}
		public void setGoods_details(String goods_details) {
			this.goods_details = goods_details;
		}
		public float getGoods_price() {
			return goods_price;
		}
		public void setGoods_price(float goods_price) {
			this.goods_price = goods_price;
		}
		public float getGoods_old_price() {
			return goods_old_price;
		}
		public void setGoods_old_price(float goods_old_price) {
			this.goods_old_price = goods_old_price;
		}
		public int getGoods_store_amount() {
			return goods_store_amount;
		}
		public void setGoods_store_amount(int goods_store_amount) {
			this.goods_store_amount = goods_store_amount;
		}
		public int getGoods_sales() {
			return goods_sales;
		}
		public void setGoods_sales(int goods_sales) {
			this.goods_sales = goods_sales;
		}
		public String getGoods_state() {
			return goods_state;
		}
		public void setGoods_state(String goods_state) {
			this.goods_state = goods_state;
		}
		public String getImg1_src() {
			return img1_src;
		}
		public void setImg1_src(String img1_src) {
			this.img1_src = img1_src;
		}
		public String getImg2_src() {
			return img2_src;
		}
		public void setImg2_src(String img2_src) {
			this.img2_src = img2_src;
		}
		public String getImg3_src() {
			return img3_src;
		}
		public void setImg3_src(String img3_src) {
			this.img3_src = img3_src;
		}
		public String getImg4_src() {
			return img4_src;
		}
		public void setImg4_src(String img4_src) {
			this.img4_src = img4_src;
		}
		
		
		
}
