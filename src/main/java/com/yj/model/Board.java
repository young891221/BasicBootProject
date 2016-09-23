package com.yj.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "board")
public class Board {
	private int id;
	private String group;
	private String title;
	private String image;
	private String content;
	private int viewCount;
	private int status;
	private DateTime insertDate;
	private DateTime updateDate;
	private DateTime deleteDate;
	private Member editorId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "board_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Basic
	@Column(name = "board_group")
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	@Basic
	@Column(name = "board_title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Basic
	@Column(name = "board_image")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Basic
	@Column(name = "board_content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Basic
	@Column(name = "board_view_count")
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	@Basic
	@Column(name = "board_status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Basic
	@Column(name = "board_insert_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(DateTime insertDate) {
		this.insertDate = insertDate;
	}
	@Basic
	@Column(name = "board_update_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}
	@Basic
	@Column(name = "board_delete_date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(DateTime deleteDate) {
		this.deleteDate = deleteDate;
	}
	//@Column(name = "editor_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "editor_id") //name은 자신의 DB칼럼명
	public Member getEditorId() {
		return editorId;
	}
	public void setEditorId(Member editorId) {
		this.editorId = editorId;
	}
	
}
