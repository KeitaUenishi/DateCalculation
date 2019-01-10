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
public class UpdateControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private UpdateController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void �X�V�y�[�W�̃��N�G�X�g���ʂ�����ƂȂ�T�[�r�X�̌������Ă΂��View�Ƃ���update���Ԃ鎖() throws Exception {
		sut.perform(get("/update/{dateId}", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));

		verify(service, times(1)).search("Y01");
	}

	@Test
	public void �X�V�y�[�W�ōX�V�������s���ƃT�[�r�X�ŏ�������ăV�~�����[�V������ʂɑJ�ڂ���鎖() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", "�e�X�g���t��"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).update(any());
	}

	@Test
	public void �X�V�y�[�W�œ��t����NULL�̏�ԂōX�V�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void �X�V�y�[�W�œ��t������̏�ԂōX�V�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", ""))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void �X�V�y�[�W�œ��t�����󔒂̏�ԂōX�V�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", " "))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}

	@Test
	public void �X�V�y�[�W�œ��t����32���ȏ�̏�ԂōX�V�������s���Ɨ�O��񂪓�������Ԃŉ�ʂ��Ԃ鎖() throws Exception {
		sut.perform(post("/update/{dateId}", "Y01").param("dateId", "Y01").param("dateName", "123456789012345678901234567890123"))
			.andExpect(status().isOk())
			.andExpect(view().name("update"));
	}
}
