import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Login {
	public static void main(String[] args) {
		/*IdPw idPw = new IdPw();*/
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);

		try {
			webClient.getOptions().setUseInsecureSSL(true);
			webClient.setAjaxController(new NicelyResynchronizingAjaxController());
			HtmlPage page = webClient.getPage("https://forest.skhu.ac.kr/Gate/UniLogin.aspx");

			HtmlForm form = page.getFormByName("");
			form.getInputByName("txtID").setValueAttribute("201532012");
			form.getInputByName("txtPW").setValueAttribute("201532012");

			HtmlPage homepage = form.getInputByName("ibtnLogin").click();
//            System.out.println("===========================TEST 1===========================");
//            System.out.println(page.asText());

			HtmlPage page2 = webClient.getPage("https://forest.skhu.ac.kr/Gate/SAM/Lesson/G/SSEG20P.aspx ");// ->
			System.out.println(page2.asText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			webClient.close();
		}
	}
}