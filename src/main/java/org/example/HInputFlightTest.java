package org.example;

import static org.junit.Assert.*;
/*
 * 何海江 for JUnit Fest-Swing GUI测试
 */
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class HInputFlightTest {
	DialogFixture jfDlg; //测试对应的对话框。
	HInputFlight hif; //被测对象，能够获取该对象的值。
	@Before
	public void setUp() throws Exception {
		hif = new HInputFlight(null,"测试：输入航班的相关数据");
		jfDlg = new DialogFixture( hif );
		jfDlg.show();
	}

	@After
	public void tearDown() throws Exception {
		hif.dispose();
		jfDlg.cleanUp();
	}

	public void test() {
		fail("Not yet implemented");
	}

	//测试增加一个航班的座位数目
	//使用的测试技术：条件覆盖
	@Test
	public void testSeatForAddFlight() {
		setValues("93687","YE4002","Hguohang","800.5","126.0");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight2() {
		setValues("93687","YE4002","Hguohang","800.5","98");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight3() {
		setValues("93687","YE4002","Hguohang","800.5","298");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight4() {
		setValues("93687","YE4002","Hguohang","800.5","128");
		assertEquals(true,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight5() {
		setValues("93687","YE4002","Hguohang","kk","128");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight6() {
		setValues("93687","YE4002","Hguohang","1","128");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight7() {
		setValues("93687","YE4002","Hguohang","18800","128");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testSeatForAddFlight8() {
		setValues("93687","YE4002","Hguohang","800.5","128");
		assertEquals(true,hif.GetValidFlight());
	}
	@Test
	public void testCompanyForAddFlight() {
		setValues("93687","YE4002","H1","800.5","128");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testCompanyForAddFlight2() {
		setValues("93687","YE4002","@guohangsfsdfsdfewffsesfdefssfwedwe","800.5","128");
		assertEquals(false,hif.GetValidFlight());
	}
	@Test
	public void testCompanyForAddFlight3() {
		setValues("93687","YE4002","H111111","800.5","128");
		assertEquals(true,hif.GetValidFlight());
	}
	public void setValues(String id, String name, String company, String price, String seat) {
		jfDlg.textBox("txtIDFest").setText(id);
		jfDlg.textBox("txtFnameFest").setText(name);
		jfDlg.textBox("txtCompanyFest").setText(company);
		jfDlg.textBox("txtPriceFest").setText(price);
		jfDlg.textBox("txtSeatFest").setText(seat);
		jfDlg.button("btnOKFest").click();
	}
}
