import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuildingFinal {
	public static void main(String[] args)  throws Exception {
		HtmlPage framePage1, framePage2;

		HtmlElement buildingTable, lectreRoomTable;
		HtmlElement button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

		String s;

		Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER); //인터넷 익스플로어로 연다

		//로그인
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");
		HtmlForm form = page.getFormByName("");
		form.getInputByName("txtID").setValueAttribute("201532012");
		form.getInputByName("txtPW").setValueAttribute("201532012");
		HtmlPage homepage = form.getInputByName("ibtnLogin").click(); //정보를 입력한 이후에 ibtnLogin 클릭한 페이지로 가는


		//시설물 대여 페이지로 page2로 계속 결과 값을 받도록 한다.
		/*HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx");// 주소값은 value를 통해서 구한다.*/

		//다음 페이지를 이걸로 잡아서 출력하기로 한다. "https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx" 이 주소를 따로 출력하면 잘못된 주소로 나옴
		//내가 생각을 해봤는데 저거 선택 테이블이 제일 마지막부분에 있어서 그 부분만 긁어오게 되니까 그 위의 부분이 안 긁어와지는 것 같음
		//때문에 바로 받는게 아니라 form테그에서 input테그로 시설물대여 페이지를 받은 다음에 그 페이지를 page2로 받는게 좋을 것 같다.

		// 종합정보시스템 메인페이지에서 시설물대여 시스템페이지로 이동하기
		HtmlPage page3 = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMyMain.aspx"); // 로그인 후 종합정보 시스템 페이지
		System.out.println("Login Success");

		HtmlForm formSelect = page.getFormByName("");
		//웹서비스 메뉴바 항목을 클릭한 이후에 시설물대여 신청을 클릭하는 과정으로 구성된다.
		formSelect.getInputByName("OnMenu(0)").click(); //클릭
		/*formSelect.getInputByName("hideProgramName").click(); */// 시설물대여 신청 페이지로 이동 but 코드상에서 input테그로만 구성되어 있고 click버튼이 될지 말지는 미지수
		formSelect .getInputByName("hideProgramName").setValueAttribute("[N]시설물대여 신청");//input 테그에 값을 입력 받아서 들어가기
		HtmlPage Rentpage = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniMainStudnet.aspx"); //-> 메뉴바 오른쪽의 페이지를 print()하는 것 처럼 긁어 받는다.
		System.out.println("Lent Page Move Success");


		//건물 테이블 값 받기
		/*List<DomElement> divlist = page.getElementsByName("div");
		System.out.println("divlist 뽑아내기");
		for(DomElement e: divlist ){
			if(e.getAttribute("class").equals("divBuildList")) //div 클래스 이름이 divBody와 같다면
				System.out.println("->" +e.getElementsByTagName("td").get(0).asText()); //td테그의 값을 출력 -> 승연관 이런식으로 출력 해야됨
			System.out.println("성공");
		}
		System.out.println("Building Table");
*/

//한번 알아보기
		List<DomElement> trlist = page.getElementsByName("tr"); //tr 테그를 list로 받는다.
		System.out.println("trlist 뽑아내기");//--> tr테그의 클래스가 전부 다르기 때문에 따로 뽑아줘야한다.
		for(DomElement e: trlist){
			if(e.getAttribute("class").equals("cssRowStyle")) { //tr 클래스 이름이 cssRowStyle와 같다면
				System.out.println("->" + e.getElementsByTagName("td").get(0).asText()); //td테그의 값을 출력 -> 승연관 이런식으로 출력 해야됨
			}
			else if(e.getAttribute("class").equals("cssAlternatingRowStyle")) { //tr 클래스 이름이 cssAlternatingRowStyle와 같다면
				System.out.println("->" + e.getElementsByTagName("td").get(0).asText()); //td테그의 값을 출력 -> 승연관 이런식으로 출력 해야됨
			}
			System.out.println("성공");
		}
		System.out.println("Building Table2");

		//form테그를 선택을 눌렀을 떄 실행될 수 있게 구현하기
	}
}
