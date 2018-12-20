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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import product.service.CalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest
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
		sut.perform(post("/update/{dateId}", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).update(any());
	}
}
