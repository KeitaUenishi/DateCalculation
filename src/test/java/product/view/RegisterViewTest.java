package product.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
}
