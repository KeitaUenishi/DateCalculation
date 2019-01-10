package product.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import product.service.CalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class RegisterControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private RegisterController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void �V�K�o�^�y�[�W�̃��N�G�X�g���ʂ�����ƂȂ�View�Ƃ���register���Ԃ鎖() throws Exception {
		sut.perform(get("/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œo�^�������s���ƃT�[�r�X�ŏ�������ăV�~�����[�V������ʂɑJ�ڂ���鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "TEST").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).register(any());
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��tID��NULL�̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��tID����̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��tID���󔒂̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", " ").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��tID��6���ȏ�̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "1234567").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��t����NULL�̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "TEST"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��t������̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "TEST").param("dateName", ""))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��t�����󔒂̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "TEST").param("dateName", " "))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

	@Test
	public void �V�K�o�^�y�[�W�œ��t����32���ȏ�̏�Ԃœo�^�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/register").param("dateId", "TEST").param("dateName", "123456789012345678901234567890123"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"));
	}

}
