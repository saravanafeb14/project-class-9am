package org.base;

import java.io.IOException;

public class AdactinHotel extends BaseExcel {

	public static String readPath = "C:\\Users\\ELCOT\\eclipse-workspace\\BaseExcel\\data\\Data.xlsx";

	public static String writePath = "C:\\Users\\ELCOT\\eclipse-workspace\\BaseExcel\\data\\Orderno.xlsx";

	public static void main(String[] args) throws IOException {

		BaseExcel b = new BaseExcel();

		b.browserLanch();
		b.geturl(b.getdatafromexcel(readPath, "datas", 0, 0));
		b.send(b.locatorbyid("username"), b.getdatafromexcel(readPath, "datas", 1, 0));
		b.send(b.locatorbyid("password"), b.getdatafromexcel(readPath, "datas", 1, 1));
		b.locatorbyid("login").click();

		b.selectbyid(b.locatorbyid("location"), b.getdatafromexcel(readPath, "datas", 2, 0));
		b.selectbyid(b.locatorbyid("hotels"), b.getdatafromexcel(readPath, "datas", 3, 0));
		b.selectbyid(b.locatorbyid("room_type"),b.getdatafromexcel(readPath, "datas", 4, 0));
		b.selectbyid(b.locatorbyid("room_nos"),b.getdatafromexcel(readPath, "datas", 5, 0));
		b.selectbyid(b.locatorbyid("adult_room"),b.getdatafromexcel(readPath, "datas", 8, 0));
		b.selectbyid(b.locatorbyid("child_room"),b.getdatafromexcel(readPath, "datas", 9, 0));
		b.locatorbyid("Submit").click();
		
		b.locatorbyid("radiobutton_0").click();
		b.locatorbyid("continue").click();
		
		b.send(b.locatorbyid("first_name"), b.getdatafromexcel(readPath, "datas", 10, 0));
		b.send(b.locatorbyid("last_name"), b.getdatafromexcel(readPath, "datas", 11, 0));
		b.send(b.locatorbyid("address"), b.getdatafromexcel(readPath, "datas", 12, 0));
		b.send(b.locatorbyid("cc_num"), b.getdatafromexcel(readPath, "datas", 13, 0));
		b.selectbyid(b.locatorbyid("cc_type"),b.getdatafromexcel(readPath, "datas", 14, 0));
		b.selectbyid(b.locatorbyid("cc_exp_month"),b.getdatafromexcel(readPath, "datas", 15, 0));
		b.selectbyid(b.locatorbyid("cc_exp_year"),b.getdatafromexcel(readPath, "datas", 16, 0));
		b.send(b.locatorbyid("cc_cvv"), b.getdatafromexcel(readPath, "datas", 17, 0));
		b.locatorbyid("book_now").click();
		
		b.writedatatoexcel(writePath, "datas", 0, 0, b.locatorbyid("order_no").getAttribute("value"));
	
	}

}
