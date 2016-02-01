package com.homeTask.pack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.homeTask.entity.Row;
import com.homeTask.service.RowService;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RowPersistenceTests {


	

	
	@Autowired
	private RowService RowService;


	

	@Test
	public void testGetAllCustomers() {
		Collection<Row> listCustomers = RowService.findAll();
		assertFalse(listCustomers.isEmpty());
	}
	
	@Test
	public void testSaveRow() {
		Row row = new Row(11, 11, 1.12,new GregorianCalendar(), new GregorianCalendar(), "TEST", "T", "TEST");
		RowService.save(row);
		List<Row> listCustomers = (List<Row>)RowService.findAll();
		assertFalse(listCustomers.isEmpty());
		Row row2 = listCustomers.get(0);
		assertEquals(row.getId(), row2.getId());		
	}
	
	@Test
	public void testdeleteRow() {
		Row row = new Row(11, 11, 1.12, new GregorianCalendar(), new GregorianCalendar(), "TEST", "T", "TEST");
		RowService.save(row);
		List<Row> listRow = (List<Row>)RowService.findAll();
		assertFalse(listRow.isEmpty());
		
		Row row2 = listRow.get(0);
		RowService.delete(row2);
		List<Row> listRow2 = (List<Row>)RowService.findAll();
		assertTrue(listRow2.isEmpty());
	}
	

	

}
