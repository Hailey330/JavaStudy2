package Room;
// 대기방 FRAME
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class RoomFrame extends JFrame {
	public JButton makeB, exitB, sendB, enterB;
//	private JComboBox<String> sortCB;
	public JPanel upP, chatP, chatP1, listP, list1P, list2P, roomP, roomP1, sumP, centerPanel;
//	private JPanel[] sortrm;
	public JTextArea chatarea, usertxt;
	public JTextField chattxt, tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
	private JLabel la1, la2, la3, la4, la5, la6;
//	private String[] com = { "경영지원", "마케팅", "고객관리", "개발", "디자인" };
	private JList<String> entlist, frlist;
	private EtchedBorder eb;
	private JList<DetailPanel> list;
	private DefaultListModel<DetailPanel> model;
	public DefaultListModel<String> userWaitModel;
	public DetailPanel[] dp;
	RoomMake rmake;

	private BufferedReader br;
	private PrintWriter pw;

	public RoomFrame(BufferedReader br, PrintWriter pw) {

		this.br = br;
		this.pw = pw;

		// 상단 버튼
		dp = new DetailPanel[100]; // 방 정보 
		upP = new JPanel(new FlowLayout());
		// 방 만들기
		makeB = new JButton("방 만 들 기");
		makeB.setPreferredSize(new Dimension(400, 30));
		// 방 나가기 
		exitB = new JButton("로 그 아 웃");
		exitB.setPreferredSize(new Dimension(200, 30));

		upP.add(makeB); // 방 만들기 버튼 생성
		upP.add(exitB); // 방 나가기 버튼 생성 

		
		// 게임방 리스트
		roomP = new JPanel(new BorderLayout());
		la4 = new JLabel("게임 ROOM 리스트");
		la4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));

		centerPanel = new JPanel(new GridLayout(100, 2, 10, 10)); // 100개
		for (int i = 0; i < 100; i++) {
			dp[i] = new DetailPanel(br, pw);
			centerPanel.add(dp[i]);
		}
		
		JScrollPane scrollRoomList = new JScrollPane(centerPanel);
		scrollRoomList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollRoomList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollRoomList.getVerticalScrollBar().setValue(scrollRoomList.getVerticalScrollBar().getMaximum());
		
		roomP.add("Center", scrollRoomList);
		roomP.add("North", la4);

		
		// 대기자 채팅
		chatP = new JPanel(new BorderLayout());
		la1 = new JLabel("대기자 채팅방 ");
		la1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		chatarea = new JTextArea();
		chatarea.setEditable(false);
		JScrollPane scroll = new JScrollPane(chatarea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(400, 250));
		scroll.getVerticalScrollBar().setValue(scrollRoomList.getVerticalScrollBar().getMaximum());
		
		chatP1 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // 대기자 채팅 message 창

		chattxt = new JTextField(30);
		sendB = new JButton("보내기");

		chatP1.add(chattxt);
		chatP1.add(sendB);

		chatP.add("Center", scroll);
		chatP.add("South", chatP1);
		chatP.add("North", la1);

		
		// 대기자 목록
		listP = new JPanel(new GridLayout(2, 1, 20, 20));

		list1P = new JPanel(new BorderLayout());
		la2 = new JLabel(" 대기실 인원  ");
		la2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		usertxt = new JTextArea();
		usertxt.setEditable(false);

		JScrollPane scroll1 = new JScrollPane(usertxt);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		list1P.add("North", la2);
		list1P.add("Center", scroll1);

		list2P = new JPanel(new BorderLayout());
		list2P.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		la3 = new JLabel("랭 킹");
		la3.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		frlist = new JList<String>(new DefaultListModel<String>());
		JScrollPane scroll2 = new JScrollPane(frlist);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		list2P.add("North", la3);
		list2P.add("Center", scroll2);

		listP.add(list2P);
		listP.add(list1P);

		// 대기자목록 +대기자채팅
		sumP = new JPanel(new BorderLayout());

		sumP.add("Center", listP);
		sumP.add("South", chatP);

		// 종합
		Container contentPane = this.getContentPane();
		contentPane.add("East", sumP);
		contentPane.add("North", upP);
		contentPane.add("Center", roomP);

		setBounds(400, 200, 1000, 800);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


	}// 생성자

	public void containPanelClear() {

		centerPanel.removeAll();
		for (int i = 0; i < 100; i++) {
			dp[i] = new DetailPanel(br, pw);
			centerPanel.add(dp[i]);
		}

	}

}