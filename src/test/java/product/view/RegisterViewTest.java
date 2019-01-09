package product.view;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeborne.selenide.Configuration;

import product.view.page.RegisterPage;
import product.view.page.SimulationPage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestPropertySource(locations = "classpath:test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterViewTest {

	private RegisterPage page;

	@BeforeClass
	public static void setUp() {
		Configuration.holdBrowserOpen = false;
	}

	@Before
	public void setUpTest() {
		page = SimulationPage.open().�V�K�o�^��ʂ֑J�ڂ���();
	}

	@Test
	public void No1_�V�K�o�^��ʂ���V�~���[���[�V������ʂ֖߂�鎖() {
		SimulationPage actual = page.�V�~�����[�V�����y�[�W�֖߂�();

		assertThat(actual.title()).isEqualTo("�v�Z���ʊm�F");
	}

	@Test
	public void No2_�V�K�o�^��ʂŐV�K�o�^�ł��鎖() throws Exception {
		SimulationPage simulationPage = page.���tID��("Y02").���t����("�O�N").�����N��("-1").��������("0").��������("0").�ŐV�K�o�^����();
		SimulationPage actual = simulationPage.�v�Z�����("20181201").�ŃV�~�����[�V��������();

		actual.��������().shouldBe(visible);
		assertThat(actual.�������ʂ̌���()).isEqualTo(3);
	}
}
