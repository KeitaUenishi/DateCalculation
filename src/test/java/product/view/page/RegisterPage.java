package product.view.page;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class RegisterPage {

	@FindBy(id = "registerButton")
	private SelenideElement registerButton;

	@FindBy(id = "backButton")
	private SelenideElement backButton;

	@FindBy(id = "dateId")
	private SelenideElement dateId;

	@FindBy(id = "dateName")
	private SelenideElement dateName;

	@FindBy(id = "adjustmentYear")
	private SelenideElement adjustmentYear;

	@FindBy(id = "adjustmentMonth")
	private SelenideElement adjustmentMonth;

	@FindBy(id = "adjustmentDay")
	private SelenideElement adjustmentDay;

	public String title() {
		return Selenide.title();
	}

	public SimulationPage �V�~�����[�V�����y�[�W�֖߂�() {
		backButton.click();
		return page(SimulationPage.class);
	}

	public RegisterPage ���tID��(String ���tID) {
		dateId.setValue(���tID);
		return page(RegisterPage.class);
	}

	public RegisterPage ���t����(String ���t��) {
		dateName.setValue(���t��);
		return page(RegisterPage.class);
	}

	public RegisterPage �����N��(String �����N) {
		adjustmentYear.setValue(�����N);
		return page(RegisterPage.class);
	}

	public RegisterPage ��������(String ������) {
		adjustmentMonth.setValue(������);
		return page(RegisterPage.class);
	}

	public RegisterPage ��������(String ������) {
		adjustmentDay.setValue(������);
		return page(RegisterPage.class);
	}

	public SimulationPage �ŐV�K�o�^����() {
		registerButton.click();
		return page(SimulationPage.class);
	}
}
