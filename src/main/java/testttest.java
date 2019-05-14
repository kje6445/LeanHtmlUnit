import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.util.List;

public class testttest {
	public static void main(String[] args) throws Exception{
		final String[] team ={"Aresnal","Aston Villa","Cardiff City","Chelsea","Crystal Palace","Everton",
				               "Fullham","Hull City","Manchester City","Manchester United","Newcastle United",
								"Norwich City","Southampton","Stoke City","Sunderland","Swansea City",
								"Tottenham Hotspur","West Bromwich Albion","West Ham United"};
		int index=15;

		WebClient webClient = new WebClient();

		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getCookieManager().setCookiesEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());

		HtmlPage page = (HtmlPage)webClient.getPage("http://espnfc.com/team/fixtures");
		List<DomElement> selects = page.getElementsByName("select");
		HtmlOption o =((HtmlSelect)selects.get(0)).getOption(index);
		page =((HtmlSelect)selects.get(0)).setSelectedAttribute(o,true);

		List<DomElement> trs = page.getElementsByName("tr");

		for(DomElement e : trs){
			if(e.getAttribute("class").indexOf("row") > 0){
				List<HtmlElement> tds = e.getElementsByTagName("td");
				char f =0,s=0;
				System.out.print("["+tds.get(0).asText() + "]"+tds.get(1).asText()+" "+tds.get(2).asText()+" "+tds.get(3).asText()+" "+tds.get(4).asText());

				if(tds.get(3).asText().indexOf('-') >0){
					f = tds.get(3).asText().charAt(0);
					s = tds.get(3).asText().charAt(2);

				}
			}
		}
	}
}
