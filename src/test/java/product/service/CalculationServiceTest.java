package product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import product.domain.DateFormula;

public class CalculationServiceTest {
	
	private CalculationService sut;
	
	@Before
	public void before() throws Exception {
		sut = new CalculationService();
	}
	
	@Test
	public void �����̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20181209�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(0,0,1);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181209");
	}
	
	@Test
	public void �����̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20190108�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(0,1,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20190108");
	}
	
	@Test
	public void ���N�̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20191208�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(1,0,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20191208");
	}
	
	@Test
	public void �O���̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20181207�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(0,0,-1);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181207");
	}
	
	@Test
	public void �O���̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20181108�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(0,-1,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20181108");
	}
	
	@Test
	public void �O�N�̓��t�v�Z���Ɍv�Z���20181208��n���Čv�Z���ʂ�20171208�ɂȂ邱��() throws Exception {
		DateFormula formula = setUpFormula(-1,0,0);
		
		String actual = sut.calculate("20181208", formula);
		
		assertThat(actual).isEqualTo("20171208");
	}
	
	/**
	 * ���t�v�Z���̏����ݒ�B
	 * 
	 * @return �ݒ肳�ꂽ���t�v�Z��
	 */
	private DateFormula setUpFormula(int year, int month, int day) {
		DateFormula formula = new DateFormula();
		formula.setAdjustmentYear(year);
		formula.setAdjustmentMonth(month);
		formula.setAdjustmentDay(day);
		return formula;
	}
}
