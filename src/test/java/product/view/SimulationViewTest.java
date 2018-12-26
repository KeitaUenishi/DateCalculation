package product.view;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;

import product.view.page.RegisterPage;
import product.view.page.SimulationPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class SimulationViewTest {

	private SimulationPage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		page = SimulationPage.open();
	}

	@Test
	public void �V�~�����[�V������ʂŌv�Z�����20181201�����Č��ʂ��ꗗ�Ŏ擾�ł��鎖() {
		SimulationPage actual = page.�v�Z�����("20181201").�ŃV�~�����[�V��������();

		actual.��������().shouldBe(visible);
	}

	@Test
	public void �V�~�����[�V������ʂ���V�K�o�^��ʂ֑J�ڂł��鎖() throws Exception {
		RegisterPage actual = page.�V�K�o�^��ʂ֑J�ڂ���();

		assertThat(actual.title()).isEqualTo("�v�Z���o�^");
	}
}
