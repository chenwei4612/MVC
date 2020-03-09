package pojo;

public class Cart {
	// 与数据库中的字段对应
	private Integer rid;// 自增主键
	private String uid;//用户的主键id
	private String book;// 书籍的主键id
	private Integer count;// 书籍的数量
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
