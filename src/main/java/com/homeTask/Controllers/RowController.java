package com.homeTask.Controllers;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.homeTask.entity.Row;
import com.homeTask.service.RowService;

@Component
public class RowController {
	
	@Qualifier()
private RowService rowService ;
	 private List<Row> rows;
	
	    Integer id;
	    Integer integer_;
		Double double_;
		Date date_;
		Date time_;
		String varchar_;
		String char_;
		String clob_;
		
		String name_button;
		boolean refresh=true;
		Locale locale;
		
		boolean showModalPanel;
		TimeZone timeZone=TimeZone.getDefault();
		
		
		


		public String doSave(){
			GregorianCalendar time=null;
			GregorianCalendar date=null;
			if(time_!=null){
			time=new GregorianCalendar();
			time.setTime(time_);
			}
			if(date_!=null){
			date=new GregorianCalendar();
			date.setTime(date_);
			}
             Row row= new Row(id, integer_, double_, date, time, varchar_, char_ , clob_);
             
            
             rowService.save(row);
             refresh=true;
            
             return "refresh";
         }
		
		public void doRefresh() {
		 refresh=true;
			}
		public String doRefreshString() {
			 refresh=true;
			 System.out.println(locale);
			 return "refresh";
				}
		public String doEdit() {
			int i=0;
			Row d=new Row();
			setName_button("Add");
			for(Row r:getRows()){
				
	        	   if(r.getSelected()){
	        	   i++;
	        	   d=r;
	        	  }
	           }
			  if(i>1){
				  System.out.println(i);
				  setShowModalPanel(true);
				  return null;  
			  }
			  if(i==1){
				  setName_button("Save");
			  }
			  setParametrs(d);
			return "Edit";
			}
		
		private void setParametrs(Row d) {
			
			this.id=d.getId();
			this.integer_=d.getInteger_();
			this.double_=d.getDouble_();
			if(d.getId()!=null){
			this.date_=d.getDate_().getTime();
			this.time_=d.getTime_().getTime();
			} else {
				this.date_=null;
				this.time_=null;		
			}
			this.varchar_=d.getVarchar_();
			this.char_=d.getChar_();
			this.clob_=d.getClob_();
			
		}
		
		

		public  void closeModalPanel() {
			 setShowModalPanel(false);
			}
		
		public  void doDelete() {
			 
	           for(Row r:rows){
	        
	        	   if(r.getSelected()){
	        		  
	        	   rowService.delete(r);
	        	  }
	           }
	           refresh=true;
				}
		
	 public RowService getRowService() {
		return rowService;
	}
	public void setRowService(RowService rowService) {
		this.rowService = rowService;
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
	public Date getDate_() {
		return date_;
	}
	public void setDate_(Date date_) {
		this.date_ = date_;
	}
	public Date getTime_() {
		return time_;
	}
	public void setTime_(Date time_) {
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
	
	
	public List<Row> getRows() {
		
	if(refresh){
		rows=(List<Row>)rowService.findAll();
		refresh=false;
	} 
	
		return rows;
	}
	public void setRows(List<Row> rows) {
		
		this.rows = rows;
	}
	
	public Locale getLocale() {
		locale=FacesContext.getCurrentInstance().getViewRoot().getLocale();
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getName_button() {
		return name_button;
	}
	public void setName_button(String name_button) {
		this.name_button = name_button;
	}
	public boolean getShowModalPanel() {
		return showModalPanel;
	}
	public void setShowModalPanel(boolean showModalPanel) {
		this.showModalPanel = showModalPanel;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
}
