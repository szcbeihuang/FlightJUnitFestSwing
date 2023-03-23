package org.example;


import static org.junit.Assert.*;
/*
 * 何海江 for JUnit Fest-Swing GUI测试
 */
import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class HSearchPriceTest {
    DialogFixture jfDlg; //测试对应的对话框。
    HSearchPrice hif; //被测对象，能够获取该对象的值。
    @Before
    public void setUp() throws Exception {
        hif = new HSearchPrice(null);
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
    public void testPriceForAddFlight() {
        setValues("hhhh","120");
        assertEquals(false,hif.GetValidSearch());

    }
    @Test
    public void testPriceForAddFlight2() {
        setValues("99","120");
        assertEquals(false,hif.GetValidSearch());
    }
    @Test
    public void testPriceForAddFlight3() {
        setValues("100","hhhh");
        assertEquals(false,hif.GetValidSearch());
    }
    @Test
    public void testPriceForAddFlight4() {
        setValues("100","100000");
        assertEquals(false,hif.GetValidSearch());
    }
    @Test
    public void testPriceForAddFlight5() {
        setValues("120","100");
        assertEquals(false,hif.GetValidSearch());
    }
    @Test
    public void testPriceForAddFlight6() {
        setValues("100","120");
        assertEquals(true,hif.GetValidSearch());
    }
    public void setValues(String fMinPrice, String fMaxPrice) {
        jfDlg.textBox("txtMinPrice").setText(fMinPrice);
        jfDlg.textBox("txtMaxPrice").setText(fMaxPrice);
        jfDlg.button("btnOKFest").click();
    }
}

