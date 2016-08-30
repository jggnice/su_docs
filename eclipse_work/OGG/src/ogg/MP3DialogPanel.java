package ogg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ogg.util.BackgroundPanel;

import java.awt.Color;
import javax.swing.JTextArea;

public class MP3DialogPanel extends BackgroundPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2234208457324693117L;
	public SwitchAction mp3listener = new SwitchAction();
	private static AudioFilePlayer p = new AudioFilePlayer();
	/**
	 * @return the p
	 */
	public static AudioFilePlayer getPlayer()
	{
		return p;
	}
	private JTextField txtTimeinterval;

	public void setTxtTime(int time)
	{
		this.txtTimeinterval.setText("" + time);
	}
	class SwitchAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				p.loopmusicswitch();
			} catch (InterruptedException exception)
			{
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}

		}
	}
	/**
	 * Create the panel.
	 */
	public MP3DialogPanel()
	{
		setLayout(new BorderLayout(0, 0));

		JPanel bpanel = new JPanel();
		bpanel.setSize(800, 600);
		bpanel.setOpaque(false);
		add(bpanel, BorderLayout.CENTER);
		bpanel.setLayout(new BorderLayout(0, 0));
		bpanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		bpanel.add(tabbedPane);
		tabbedPane.setOpaque(false);

		BackgroundPanel panel_1 = new BackgroundPanel();
		tabbedPane.addTab("\u81EA\u5B9A\u4E49", null, panel_1, null);
		panel_1.setOpaque(false);
		BackgroundPanel panel = new BackgroundPanel();
		tabbedPane.addTab("\u6D4B\u8BD5", null, panel, null);
		panel.setOpaque(false);
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(mp3listener);
		btnStart.setBounds(60, 90, 106, 42);
		panel.add(btnStart);

		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(mp3listener);
		btnStop.setBounds(229, 90, 106, 42);
		panel.add(btnStop);
		JButton btnChoose = new JButton("Choose MP3");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					p.chooseFile();
				} catch (IOException exception)
				{
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		panel_1.setLayout(null);
		btnChoose.setBounds(24, 5, 112, 63);
		panel_1.add(btnChoose);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("\u8F93\u5165\u7684\u6570\u5B57\u8981 \u4E0D\u5C0F\u4E8E 30");
		textArea.setBounds(150, 43, 155, 23);
		panel_1.add(textArea);

		txtTimeinterval = new JTextField();
		txtTimeinterval.setText("60");
		txtTimeinterval.setBounds(150, 6, 66, 21);
		panel_1.add(txtTimeinterval);
		txtTimeinterval.setColumns(10);

		JLabel lblTimeinterval = new JLabel(
				"\u5FAA\u73AF\u957F\u5EA6( \u79D2 )");
		lblTimeinterval.setForeground(Color.GREEN);
		lblTimeinterval.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeinterval.setBounds(221, 9, 84, 15);
		panel_1.add(lblTimeinterval);

		JButton btnSubmit = new JButton("\u786E\u8BA4");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int time;

				try
				{
					time = Integer.parseInt(txtTimeinterval.getText());
					if (time >= 30)
						p.setLoopinterval(time);
				} catch (NumberFormatException exception)
				{
					p.setLoopinterval(60);
				}
				try
				{
					p.loopmusicswitch();
					p.loopmusicswitch();
				} catch (InterruptedException exception)
				{
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}

			}
		});
		btnSubmit.setBounds(310, 5, 73, 23);
		panel_1.add(btnSubmit);
	}
}
