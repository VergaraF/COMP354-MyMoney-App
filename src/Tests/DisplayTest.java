package Tests;

import static org.junit.Assert.*;

import java.awt.Frame;
import java.awt.Window;

import org.junit.Test;

import View.BankPanel;
import View.FinancePanel;
import View.MainPanel;
import View.RegistrationPanel;

public class DisplayTest 
{
	@Test
    public void test1()
	{
		BankPanel panel = new BankPanel(true);
		panel.setupForPanel();
		double width = panel.getSize().getWidth();
		double height = panel.getSize().getHeight();
		
		assertTrue(width >= 960.0 && height >= 720);
    }
	
	@Test
	public void test2()
	{
		FinancePanel panel = new FinancePanel();
		panel.setupForPanel();
		double width = panel.getSize().getWidth();
		double height = panel.getSize().getHeight();
		
		assertTrue(width >= 960.0 && height >= 720);
    }
	
	@Test
	public void test3()
	{
		MainPanel panel = new MainPanel();
		panel.setupForPanel();
		double width = panel.getSize().getWidth();
		double height = panel.getSize().getHeight();
		
		assertTrue(width >= 960.0 && height >= 720);
    }
	
	@Test
	public void test4()
	{
		RegistrationPanel panel = new RegistrationPanel();
		panel.setupForPanel();
		double width = panel.getSize().getWidth();
		double height = panel.getSize().getHeight();
		
		assertTrue(width >= 960.0 && height >= 720);
    }
}
