package product.view.page;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class UpdatePage {

	@FindBy(id = "updateButton")
	private SelenideElement updateButton;

	@FindBy(id = "backButton")
	private SelenideElement backButton;

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

	public UpdatePage ���t����(String ���t��) {
		dateName.setValue(���t��);
		return page(UpdatePage.class);
	}

	public UpdatePage �����N��(String �����N) {
		adjustmentYear.setValue(�����N);
		return page(UpdatePage.class);
	}

	public UpdatePage ��������(String ������) {
		adjustmentMonth.setValue(������);
		return page(UpdatePage.class);
	}

	public UpdatePage ��������(String ������) {
		adjustmentDay.setValue(������);
		return page(UpdatePage.class);
	}

	public SimulationPage �ōX�V����() {
		updateButton.click();
		return page(SimulationPage.class);
	}
}
