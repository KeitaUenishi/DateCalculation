package product.view.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SimulationPage {

	private static final String URL = "http://localhost:8090/";

	@FindBy(id = "baseDate")
	private SelenideElement baseDate;

	@FindBy(id = "simulationButton")
	private SelenideElement simulationButton;

	@FindBy(id = "registerButton")
	private SelenideElement registerButton;

	public static SimulationPage open() {
		return Selenide.open(URL, SimulationPage.class);
	}

	public String title() {
		return Selenide.title();
	}

	public SimulationPage �v�Z�����(String �v�Z���) {
		baseDate.setValue(�v�Z���);
		return page(SimulationPage.class);
	}

	public SimulationPage �ŃV�~�����[�V��������() {
		simulationButton.click();
		return page(SimulationPage.class);
	}

	public RegisterPage �V�K�o�^��ʂ֑J�ڂ���() {
		registerButton.click();
		return page(RegisterPage.class);
	}

	public SelenideElement ��������() {
		return $(By.cssSelector(".uk-table tbody"));
	}

}
