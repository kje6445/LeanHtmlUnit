import java.util.logging.Level;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlStrong;
/**
 * Naver 주식정보를 가지고 오는 HtmlUnit code 입니다. <br />
 *
 * @author 따땅콩
 */

public class NaverStock {
	// 주식정보 코드
	public static String code = "005930"; // 네이버 삼성전자 코드 값 입니다.

	public static void main(String[] args) throws Exception {
		String url = "http://finance.naver.com/item/sise.nhn?code=" + code;  // 네이버 주식 사이트 URL 입니다.

		WebClient webClient = new WebClient();
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); // 중간 로그를 보이지 않도록 함
		webClient.getOptions().setThrowExceptionOnScriptError(false); // 자바 script 오류시 처리 하도록 수정

		HtmlPage page = webClient.getPage(url);  // 네이버로 부터 페이지 정보를 읽어옴

		HtmlStrong strong = (HtmlStrong) page.getFirstByXPath("//strong[@id='_nowVal']");  // 네이버 주식 페이지 중 현재가 부분 선택
		System.out.println(strong.asText());  // 현재가 출력

		webClient.close(); // 네이버와 연결 종료
	}

}

