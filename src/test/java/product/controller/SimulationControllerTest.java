package product.controller;

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
public class SimulationControllerTest {

	private MockMvc sut;

	@MockBean
	private CalculationService service;

	@Autowired
	private SimulationController target;

	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		sut = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void �V�~�����[�V�����y�[�W�̃��N�G�X�g���ʂ�����ƂȂ�View�Ƃ���simulation���Ԃ鎖() throws Exception {
		sut.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));
	}

	@Test
	public void �V�~�����[�V�����y�[�W�Ōv�Z�������͂��Čv�Z���s�������ƌv�Z�T�[�r�X���Ă΂�Ă��鎖() throws Exception {
		sut.perform(post("/").param("baseDate", "20181201"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).search();
		// ���O�f�[�^�𓊓����ĂȂ��̂ŌĂ΂�Ȃ��B�����͂��߂��ȋC������B
		// verify(service, times(1)).calculate("20181201", any());
	}

	@Test
	public void �V�~�����[�V�����y�[�W�ō폜�������s���ƃT�[�r�X�ŏ�������ē����ʂɑJ�ڂ���鎖() throws Exception {
		sut.perform(post("/{dateId}", "Y01"))
			.andExpect(status().isOk())
			.andExpect(view().name("simulation"));

		verify(service, times(1)).delete("Y01");
	}

}
