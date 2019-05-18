import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Building4 {


	public static void main(String[] args)  throws Exception, FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage  framePage1,framePage2;

		HtmlElement buildingTable,lectreRoomTable;
		HtmlElement button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

		String s;

		Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());

		//로그인
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
		HtmlForm form = page.getFormByName("");
		form.getInputByName("txtID").setValueAttribute("201532012");
		form.getInputByName("txtPW").setValueAttribute("201532012");
		HtmlPage homepage = form.getInputByName("ibtnLogin").click();
		System.out.println("Login Success");
		/*System.out.println(page.asXml());*/

		//시설물 대여 페이지로
		/*HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx?maincd=0&systemcd=S&seq=100");*/
		// 종합정보시스템 메인페이지에서 시설물대여 시스템페이지로 이동하기
		/*System.out.println("homepage 값 받기"+homepage.asXml());*/ //--> homepage와 page3는 같은 화면을 출력한다.
		/*HtmlPage page3 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMyMain.aspx"); // 로그인 후 종합정보 시스템 페이지
		System.out.println("Page3 값 받기"+page3.asXml());*/
/*
		HtmlPage page11 = (HtmlPage) page3.getByXPath("//frame[@id = 'topFrmae']");
		System.out.println(page11.asXml());
*/

		System.out.println("Login Success");

		/*HtmlForm formSelect = page.getFormByName("");*/
		/*HtmlAnchor formSelect = (HtmlAnchor) page3.getByXPath("//frame[@name='mainFrame']/div[@class='MenuDiv']/table/tbody/tr[1]/td/span[@class='leftmenu2']/a");*/
		/*System.out.println(formSelect.asText());*/
		/*HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLeftMenuOneStop.aspx?sabeon=6noZSllCqeCXeMHtxEMRtddsKhVlFLu8&amp;maincd=&amp;systemcd=");*/

/*		HtmlAnchor first = (HtmlAnchor) homepage.getByXPath("//frame[@name='leftFrame']//div[@class='MenuDiv']/table/tbody/tr[1]/td/span[@class='leftmenu']/a").get(1);
		first.click();*/

		HtmlElement frameset1 = homepage.getBody();
		DomNode node = frameset1.getLastChild().getPreviousSibling();
		HtmlFrame fr1 = (HtmlFrame) node;
		FrameWindow fw1 = (FrameWindow) fr1.getEnclosedWindow();
		HtmlPage p1 = (HtmlPage) fw1.getEnclosedPage();
//      System.out.println("p1 "+p1.asXml());

		HtmlElement frameset2 = p1.getBody();
		DomNode node2 = frameset2.getFirstChild().getNextSibling();
		HtmlFrame fr2 = (HtmlFrame) node2;
		FrameWindow fw2 = (FrameWindow) fr2.getEnclosedWindow();
		HtmlPage p2 = (HtmlPage) fw2.getEnclosedPage();
		System.out.println("p2 "+p2.asXml());

		HtmlElement ff = (HtmlElement) p1.getFirstByXPath("//table/tbody/tr[4]/td/span[@class='leftmenu']/a/span[1]");
		System.out.println(ff.asText());
/*		HtmlAnchor first = (HtmlAnchor)homepage.getByXPath("//form[@id='Left_Menu']/div[@class='MenuDiv']/span[@id='menu']/table/tbody/tr[1]/td[@class='leftmenuMargin1 | color1']/span/a[1]").get(1);

		System.out.print(first.asText());*/

		/*HtmlAnchor servie = homepage.getAnchorByText("[N]시설물대여신청");
		servie.click();*/

/*		System.out.println(homepage.asXml());*/
/*		HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMainOneStop.aspx");

		HtmlPage page3 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMainOnestop.aspx?1=1&amp;maincd=O");
		HtmlAnchor first = (HtmlAnchor)homepage.getByXPath("//form[@id='Left_Menu']")*/;

		//웹서비스 메뉴바 항목을 클릭한 이후에 시설물대여 신청을 클릭하는 과정으로 구성된다.
		/*ormSelect.getInputByName("OnMenu(0)").click(); //클릭
		*//*formSelect.getInputByName("hideProgramName").click(); *//*// 시설물대여 신청 페이지로 이동 but 코드상에서 input테그로만 구성되어 있고 click버튼이 될지 말지는 미지수
		formSelect .getInputByName("hideProgramName").setValueAttribute("[N]시설물대여 신청");//input 테그에 값을 입력 받아서 들어가기
		HtmlPage Rentpage = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMainStudnet.aspx"); //-> 메뉴바 오른쪽의 페이지를 print()하는 것 처럼 긁어 받는다.
		System.out.println("Lent Page Move Success");
		System.out.println("Lent Page");*/
		/* Thread.sleep(3_000);*/

		//건물 조회 table 찾기
		/*framePage2 = (HtmlPage)page.getFrameByName("mainFrame").getEnclosedPage();//find a frame 'rightFrame'*/
//			framePage1 = (HtmlPage)page.getFrameByName("contentFrame").getEnclosedPage();//find a frame 'rightFrame'
		/*System.out.println("Building Table");*/
	/*	HtmlPage work;
		work = page2.getFrameByName("mainFrame").getEnclosingPage();*/
		/*List<?> list;
		list= (List<?>)work.getByXPath("/table[@class='gridForm']/");//프레임내에 테이블 이름이 같은게 있기때문에 XPath로 찾는다.*/

/*		HtmlElement son;
		son= (HtmlElement) Rentpage.getByXPath("//div[@id='divBuildList']//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[1]").get(0);
		System.out.println(son.asText());*/
		/*list= (List<?>)work.getByXPath("//div[@id='upContents']/div[@id='divContainer']/div[@id='divBody']/div[@id='divBuildList']/table[@class='gridForm']")*/
		/*List<DomElement> classs = page2.getElementsByName("tr");*/
	/*	List<DomElement> trs = page2.getElementsByName("tr"); // -- 11개 있음
		*//*HtmlOption o = ((HtmlSelect)classs.get(0)).getOption(11);*//*

		for(DomElement e : trs){
			*//*if(e.getAttribute("class").indexOf("row")>0){*//*
			List<HtmlElement> tds = e.getElementsByTagName("td");
			char f=0, t=0;
			System.out.print(tds.get(0).asText()+"+"+tds.get(1).asText());
			*//*}*//*
		}*/
/*
		list.remove(0);
		buildingTable = list.get(0);

		s = buildingTable.asText();
*/

/*		final List<WebWindow> windows = webClient.getWebWindows();//메모리
		for (final WebWindow wd : windows) {
			System.out.println(wd);
			System.out.println("역");
			wd.getJobManager().removeAllJobs();
			System.out.println(wd);
		}
		System.out.println(s);*/
		System.out.println("Building Table List Success");



		//건물 선택 해 강의실 조회하기
		//승연관
	/*(HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/").get(0);*/
		//*button1 = page2.getByXPath("//a[@id='gv건물목록_ctl02_btnSelect']");//button '선택'*//*
		//지금 버튼이 클릭되지 않고 있음
/*		button1 = (HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]").get(0);//button '선택'*/
	/*	button1 = (HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']//td[2]/a[@id='gv건물목록_ctl02_btnSelect']");
		page2 = button1.click();*/
		//a[@class='specified_string']/@href
		/*List<HtmlElement> Roomlist;
		Roomlist= page2.getByXPath("//div[@class='divBuildingRoomList']/table[@class='gridForm']");*/
		/*button1.click("css=a[href*=javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')][id='gv건물목록_ctl02_btnSelect']");*/
		/*page2.find(By.linkTest("선택")).click();*/


/*		room=(HtmlElement) page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']//td[2]/a[@id='gv건물목록_ctl02_btnSelect']");*/
		/*room=(HtmlPage) page2.("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/a[@id='gv건물목록_ctl02_btnSelect']");*/
		/*HtmlAnchor room = page2.getAnchorByHref("javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')");*/
		/*room  =  page2.getElementById("gv건물목록_ctl02_btnSelect").attributes_;*/

//		HtmlPage page3 = room.getHrefAttribute();
		/*room.getHrefAttribute().startsWith("javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')");*/
		/*page2.getAnchorByHref("")*/

/*		HtmlAnchor room = (HtmlAnchor) page2.getByXPath("//div[@id='divBuildList']//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/a[1]").get(0);
		room.click();*/

	/*	HtmlAnchor anchor;
		anchor = (HtmlAnchor) page2.getElementById(String.valueOf(page2.<Object>getByXPath("//div[@id='divBuildList']//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/a[1]").get(0)));
		anchor.click();*/

		/*HtmlAnchor fbLink =  Rentpage.getAnchorByHref("javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')");// 제대로 받아지지만 값이 넘어오지 않음
		*//*HtmlAnchor fbLink = (HtmlAnchor) page2.getElementById("gv건물목록_ctl02_btnSelect");*//*
		*//*HtmlAnchor fbLink =  page2.getElementById("gv건물목록_ctl02_btnSelect");*//*
		System.out.println(fbLink.asXml()); //제대로 값이 받아짐
		HtmlPage page4 =fbLink.click();

		System.out.println(page4.asXml());*/
		/*HtmlPage page3;*/
		/*fbLink.setHref("javascript:__doPostBack('gv건물목록$ctl02$btnSelect','')");*/
		/*HtmlPage page3 = fbLink.click();*/ //-> click()은 input 테그에서 사용된다.
		//fbLink과 값이 같으면 배열 출력
/*		List<?> titles;
		titles = page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td/a)");
		for(Object aaa: titles){
			HtmlAnchor title =(HtmlAnchor) aaa;
			System.out.println(title.getTextContent());
		}*/
		/*aHtmlAnchor title = ();*/
		/*System.out.println(page3.asXml());*/
	/*	HtmlAnchor please = (HtmlAnchor)page2.getByXPath("//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]/a[@id='gv건물목록_ctl02_btnSelect']").get(1);
		please.click();
		System.out.println(please.asXml());*/
	/*	System.out.println(page2.asXml());*/
		/*System.out.println(page2.asText());*/
		// 문제가 되는 것은 Table이름이 gridForm 으로 같다는 것이다.
		// 승연관 건물 클릭 잘 되고 있나 확인하는 코드 -> .get(0)이 승연관의 값을 받는다.

/*		HtmlElement Room = (HtmlElement)page3.getByXPath("//div[@id='divBuildngRoomList']//table[@class='gridForm']/tbody/tr[@class='cssRowStyle']/td[2]").get(0);
		System.out.println(Room.asText());*/

/*		System.out.println(Room.toArray());*/
		/*System.out.println(Room.asText());*/

		/**/
		//승연관 강의실 조회하기

/*		//일만관"
		button2 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl03_btnSelect']");//button '선택'
		page2 = button2.click();

		//월당관
		button3 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl04_btnSelect']");//button '선택'
		page2 = button3.click();

		//열림관
		button4 = page2.getFirstByXPath("//a[@id='gv건물목록_ctl05_btnSelect']");//button '선택'
		page2 = button4.click();*/

		//나눔관
		/*	button5 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl06_btnSelect']");//button '선택'
			framePage1 = button5.click();*/

		//이천환관
		/*	button6 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl07_btnSelect']");//button '선택'
			framePage1 = button6.click();*/

		//새천년관
		/*	button7 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl08_btnSelect']");//button '선택'
			framePage1 = button7.click();*/

		//성미가엘성당
	/*		button8 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl09_btnSelect']");//button '선택'
			framePage1 = button8.click();*/

		//미가엘관
/*			button9 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl10_btnSelect']");//button '선택'
			framePage1 = button9.click();*/

		//운동장
/*			button10 = framePage1.getFirstByXPath("//a[@id='gv건물목록_ctl11_btnSelect']");//button '선택'
			framePage1 = button10.click();*/



		webClient.close();
		/*System.out.println(s);*/
		//*return s;*/
	}
}


