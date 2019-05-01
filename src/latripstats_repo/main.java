package latripstats_repo;

import java.awt.EventQueue;

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterOverview frame = new MasterOverview();
					frame.setVisible(false);
					StatistikOverview frame1 = new StatistikOverview();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
