package org.example;

import org.fest.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/*
 * 何海江 for JUnit Fest-Swing GUI测试
 */

public class HSearchByCompanyNameTest {
    DialogFixture jfDlg; //测试对应的对话框。
    HSearchByCompanyName hif; //被测对象，能够获取该对象的值。
    @Before
    public void setUp() throws Exception {
        hif = new HSearchByCompanyName(null);
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

    @Test
    public void testPriceForAddFlight() {
        setValues("Hty678");
        assertEquals(true,hif.GetValidSearch());

    }
    @Test
    public void testPriceForAddFlight2() {
        setValues("TY80");
        assertEquals(false,hif.GetValidSearch());
    }

    public void setValues(String m_strCompany) {
        jfDlg.textBox("txtCompanyName").setText(m_strCompany);
        jfDlg.button("btnSearch").click();
    }
}

