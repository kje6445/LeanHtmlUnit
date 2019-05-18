import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildingFinal2 {

	public static void main(String[] args)  throws Exception{
		HtmlPage framePage1,framePage2;

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


		//로그인이후에 시설물 대여 페이지 -> homepage로 정의했다.

		//frame 안으로 진입하기.

		//바로 아래의 공식 top 부분에 진입
/*		HtmlPage packageListPage = (HtmlPage) homepage.getFrames().get(0).getEnclosedPage(); --> frame "topFrame"에 진입
		packageListPage.getAnchors().get(1).click();

		System.out.println(packageListPage.asXml());*/

		HtmlPage packageListPage = (HtmlPage) homepage.getFrames().get(1).getEnclosedPage(); //2번째 frame "mainFrame"에 진입
		HtmlPage packageListPage2 =(HtmlPage) packageListPage.getFrames().get(0).getEnclosedPage(); // frame "leftFrame"에 진입
		/*packageListPage2.getAnchors().get(0).click();*/
		/*	packageListPage.getAnchors().get(0).click();*/
		/*List<?> divs = packageListPage2.getByXPath("//div");
		HtmlDivision div = (HtmlDivision) packageListPage2.getElementById("//span[@class='leftmenu2']");
		System.out.println(div.asText());*/
		/*System.out.println(packageListPage2.asXml());*/

		/*HtmlAnchor link = null;
		for(HtmlAnchor anchor : link){
			String str = anchor.asText();
			if(anchor.asText().equals("[N]시설물대여 신청"));
				link = anchor;
		}

		HtmlPage pp = link.click();*/

	/*	HtmlAnchor link = packageListPage2.getFirstByXPath("//span[@class='leftmenu2']");
		HtmlPage pagefinal = link.click();

		System.out.print(pagefinal.asText());
*/





		// 문제 발생 frame 안으로 진입 불가
		/*HtmlForm webService1 = homepage.getFormByName("Left_Menu");*/

	/*	HtmlSubmitInput button = (HtmlSubmitInput) webService1.getInputsByName("a");
		HtmlTextInput textField = webService1.getInputByName("");

		HtmlPage webService2 = button.click();
		System.out.println(webService2.asText());*/

		/*List<?> divs = homepage.getByXPath("//div"); // div로 시작되는거 전부 입력 받기
		for(int i=0; i<3; i++){
			System.out.println(divs.get(i));
		}*/
		//HtmlDivision div = (HtmlDivision) page.getByXPath("//div[@class='MenuDiv']")); //그 중 div의 클래스 이름이 MenuDiv인 것 받기.
		//System.out.println(div.asText());

	}
}
