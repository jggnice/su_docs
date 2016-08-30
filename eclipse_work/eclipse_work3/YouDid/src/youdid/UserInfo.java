package youdid;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import util.InfoModify;
import util.InfoPanel;

@SuppressWarnings("serial")
public class UserInfo extends JPanel 
{

	private InfoPanel p1 = new InfoPanel();
	private InfoModify2 p2 = new InfoModify2();
	/**
	 * Create the panel.
	 */
	public UserInfo() {
		
		setLayout(new BorderLayout(0, 0));		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4E2A\u4EBA\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		panel_1.add(p1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_2.add(p2, BorderLayout.CENTER);

	}
	protected void additionalAction()
	{
		this.getInfoPanel().RefreshInfo(LogMain.getCurrentUser());
	}
	public InfoPanel getInfoPanel()
	{
		return this.p1;
	}
	public InfoModify getInfoModify()
	{
		return this.p2;
	}

}
@SuppressWarnings("serial")
class InfoModify2 extends InfoModify 
{

	@Override
	public void additional() 
	{
		LogMain.ofun.additionalAction();
	}
}