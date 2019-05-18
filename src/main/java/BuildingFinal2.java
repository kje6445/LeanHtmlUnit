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

	}
}
