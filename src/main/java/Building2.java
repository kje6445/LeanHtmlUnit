/*
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.List;
import java.util.logging.Level;

public class Building2 {
	private String id, pw="";

	String url = "로그인 페이지";//login page

	String url2 = "성적확인 페이지";//grade page(혹시몰라 내부 url은 지움)

	WebClient webClient;

	HtmlPage page, framePage1, lastPage;

	HtmlForm form;

	HtmlElement button, button2, gradeTable;

	List<HtmlElement> list;

	String s;
	protected void setUserInfo(String id, char[] pw){
		this.id=id;
		for(char pww:pw)
			this.pw=this.pw+pww;
	}


	protected String load() throws Exception{
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);//error -> log

		webClient = new WebClient(BrowserVersion.FIREFOX_52);

		//1. 로그인
		page = webClient.getPage(url);
		form = page.getFirstByXPath("//form[@action='login_process.do']");//finding the login form by using XPath
		form.getInputByName("loginName").setValueAttribute(id);//set id
		form.getInputByName("password").setValueAttribute(pw);//set password
		button = page.getFirstByXPath("//a[@tabindex='3']");//find the login button
		page = button.click();
		//webClient.close();

		//2. 성적조회 페이지로
		page = webClient.getPage(url2);
		framePage1 = (HtmlPage)page.getFrameByName("Li01").getEnclosedPage();//find a frame 'Li01'
		button2 = framePage1.getFirstByXPath("//a[@name='button2']");//button '조회'
		framePage1 = button2.click();
		//webClient.close();

		//3.성적 Table 찾기
		lastPage = (HtmlPage)page.getFrameByName("Li02").getEnclosedPage();// Li02(grade table) frame 을 찾는다
		list = (List<HtmlElement>) lastPage.getByXPath("//table[@class='table_default']");//프레임내에 테이블 이름이 같은게 있기때문에 XPath로 찾는다.
		list.remove(0);
		gradeTable = list.get(0);

		s = gradeTable.asText();

		final List<WebWindow> windows = webClient.getWebWindows();//메모리
		for (final WebWindow wd : windows) {
			wd.getJobManager().removeAllJobs();
		}
		webClient.close();
		System.out.println(s);
		return s;
	}
}


*/
