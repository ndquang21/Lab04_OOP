package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DVD;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DVD jungleDVD = new DVD(0, "Jungle", null, 0, null, 0);
		DVD cinderellaDVD = new DVD(0, "Cinderella", null, 0, null, 0);
		
		swapTitle(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	
//	public static void changeTitle(DVD dvd, String title) {
//		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
//		dvd = new DVD(oldTitle);
//	}
	
	public static void swapTitle(DVD dvd1, DVD dvd2) {
	    String tempTitle = dvd1.getTitle();
	    dvd1.setTitle(dvd2.getTitle());
	    dvd2.setTitle(tempTitle);
	}


}
