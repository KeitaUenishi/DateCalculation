package product.view;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

public class SimulationViewTest {

	@BeforeClass
	public static void setUp() {
		// �^�C���A�E�g�̎��Ԃ�5000�~���b�ɂ���(�f�t�H���g:4000�~���b)
		Configuration.timeout = 5000;

		// �x�[�XURL��ύX���� (�f�t�H���g:http://localhost:8090)
		Configuration.baseUrl = "http://localhost:8090/";

		// �e�X�g���s��Ƀu���E�U���J�����܂܂ɂ��Ȃ�
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		open("http://localhost:8090/");
	}

	@Test
	public void �V�~�����[�V������ʂŌv�Z�@������20181201�����Č��ʂ��ꗗ�Ŏ擾�ł��鎖() {
		$(By.id("baseDate")).setValue("20181201");
		$(By.id("simulation")).click();

		$(By.cssSelector(".uk-table tbody")).shouldBe(visible);
	}

}
