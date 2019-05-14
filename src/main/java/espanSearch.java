import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.util.List;

public class espanSearch {
	public static void main(String[] args) throws Exception{

		WebClient webClient = new WebClient();

		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getCookieManager().setCookiesEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());

		//ESPN 페이지 접속
		HtmlPage page = (HtmlPage)webClient.getPage("http://espn.go.com/");
		//검색 Form 가져와서 원하는 키워드 세팅 submit 클릭
		HtmlForm form = page.getFormByName("search-box");
		//내가 검색하고 싶은 torres를  form 테그(searchbox)에 입력 받아서 torres를 넣어준다.
		form.<HtmlInput> getInputByName("search-box").setValueAttribute("torres");
		page = form.getElementsByTagName("input").get(3).click(); //input테그는 0부터 시작하며 3이 submit이다.
		//페이지가 1부터 시작하기 때문에 count를 1로 받았다.
		int count = 1;
		for(int i=0; i<5; i++){
			//결과페이지에서 결과 가져오기
			List<DomElement> lilist = page.getElementsByName("li"); //li형을 list로 받는다.
			for(DomElement e: lilist ){
				if(e.getAttribute("class").equals("result")) //li 클래스 이름이 result와 같다면
					System.out.println(count++ + ":" +e.getElementsByTagName("a").get(0).asText()); //a테그의 값을 출력 -> "Can Chelsea win the Prem?"
			}
			//다음페이지 누르기
			List<DomElement> divlist = page.getElementsByName("div"); // li테그 내의 작은 내용 보여주는 것 출력위함 //div형을 list로 받는다.
			for(DomElement e: divlist ){
				if(e.getAttribute("class").equals("controls")){ //div 클래스 가 controls일 때만 결과 값 가져오기
						System.out.println("==next==");
						page = e.getElementsByTagName("a").get(1).click(); // a태그의 작은 글씨 가져오기 //작은 글씨에 들어가는 페이지를 누르면 다음 페이지로 go
				}
			}
		}
		//마지막 페이지 결과 가져오기
		List<DomElement> lilist = page.getElementsByName("li");
		for(DomElement e: lilist ){
			if(e.getAttribute("class").equals("result"))
				System.out.println(count++ + ":" +e.getElementsByTagName("a").get(0).asText());
		}
	}
}
