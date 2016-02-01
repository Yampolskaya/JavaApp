package com.homeTask.service;

import java.util.Collection;
import com.homeTask.entity.Row;

public interface RowService {
	
	public Collection<Row> findAll(); 
	
	public Row save(Row row); 
	 
	public void delete(Row row); 

}
