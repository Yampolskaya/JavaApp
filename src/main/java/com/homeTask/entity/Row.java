package com.homeTask.entity;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



@Entity
@Table(name="TEST_TABLE")
@NamedQuery(name="Row.findAll", query="select r from Row r")
public class Row implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
	
	@Column(name = "integer_")
	Integer integer_;
	
    
	@Column(name = "double_")
	Double double_;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_")
	Calendar date_;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_")
    Calendar time_;

    @Column(name = "varchar_")
	String varchar_;
    
    @Column(name = "char_" , columnDefinition = "char")
	String char_;

    @Lob
    @Column(name = "clob_")
	String clob_="";
    
    @Transient
    boolean selected=false;
    
	public Row(){
		super();
		
	}
	public Row(Integer id2,Integer integer_2, double double_2, Calendar date_2, Calendar time_2,
			 String varchar_2, String char_2, String clob_2) {
		this.id=id2;
		this.integer_=integer_2;
		this.double_=double_2;
		this.date_=date_2;
		this.time_=time_2;
		this.varchar_=varchar_2;
		this.char_=char_2;
		this.clob_=clob_2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInteger_() {
		return integer_;
	}
	public void setInteger_(Integer integer_) {
		this.integer_ = integer_;
	}
	public Double getDouble_() {
		return double_;
	}
	public void setDouble_(Double double_) {
		this.double_ = double_;
	}
	
	
	public Calendar getDate_() {
		return date_;
	}
	public void setDate_(Calendar date_) {
		this.date_ = date_;
	}
	
	public Calendar getTime_() {
		return time_;
	}
	public void setTime_(Calendar time_) {
		this.time_ = time_;
	}
	
	public String getVarchar_() {
		return varchar_;
	}
	public void setVarchar_(String varchar_) {
		this.varchar_ = varchar_;
	}
	public String getChar_() {
		return char_;
	}
	public void setChar_(String char_) {
		this.char_ = char_;
	}
	public String getClob_() {
		return clob_;
	}
	public void setClob_(String clob_) {
		this.clob_ = clob_;
	}
    
    
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}
	



}
