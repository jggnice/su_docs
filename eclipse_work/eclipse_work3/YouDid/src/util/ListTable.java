package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class ListTable extends JPanel {

	JPanel panel;
	public ListTable() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonpanel = new JPanel();
		panel.add(buttonpanel, BorderLayout.SOUTH);
		
		JButton btnFirstpage = new JButton("FirstPage");
		btnFirstpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFisrtPage();
				
			}
		});
		buttonpanel.add(btnFirstpage);
		
		JButton btnPrevoiuspage = new JButton("PrevoiusPage");
		btnPrevoiuspage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectPreviousPage();
				
			}
		});
		buttonpanel.add(btnPrevoiuspage);
		
		JButton btnNextpage = new JButton("NextPage");
		btnNextpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectNextPage();
				
			}
		});
		buttonpanel.add(btnNextpage);
		
		JButton btnEndpage = new JButton("EndPage");
		btnEndpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectLastPage();
				
			}
		});
		buttonpanel.add(btnEndpage);		
		
		JPanel FreshAndPrint = new JPanel();
		panel.add(FreshAndPrint, BorderLayout.NORTH);
		
		JButton btnListhead = new JButton("点我刷新");
		btnListhead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				makeRefresh();
			}
		});
		FreshAndPrint.add(btnListhead);		
		btnPrintlist = new JButton("点我打印");
		FreshAndPrint.add(btnPrintlist);
	}
	
	
	public void selectFisrtPage()
	{
		startline = 1;
		selectlist(amount,startline);
		addtionalAction();
		//System.out.println(getTotal()+","+startline);
	}
	public void selectLastPage()
	{
		startline = (getTotal() - getTotal() % amount + 1);
		if(startline==0) startline++;
		//System.out.println(getTotal()+","+startline);
		selectlist(amount,startline);
		addtionalAction();
	}
	public void selectNextPage()
	{
		startline += amount;
		if(startline > getTotal() - getTotal() % amount + 1 )
		startline =  (getTotal() - getTotal() % amount) + 1 ;
		if(startline==0) startline++;
		//System.out.println(getTotal()+","+startline);
		selectlist(amount,startline);
		addtionalAction();
	}
	public void selectPreviousPage()
	{
			
		startline -= amount;		
		if(startline < 1 ) startline = 1;		
		selectlist(amount,startline);
		addtionalAction();
	}
	public void makeRefresh()
	{
		selectFisrtPage();
	}
	public void addRowsTable(JPanel p1)
	{
		this.panel.add(p1, BorderLayout.CENTER);
	}
	public JButton getPrintButton()
	{
		return this.btnPrintlist;
	}
	//DIFFERENT GET LIST
	protected abstract void selectlist(int am,int st);
	//DIFFERENT
	protected abstract void addtionalAction();
	//DIFFERENT TOTAL
	protected abstract int getTotal();
	// METHOD OF REFRESH
	
	
	protected int startline = 1;
	private JButton btnPrintlist;
	public final static int amount = 5;
}
