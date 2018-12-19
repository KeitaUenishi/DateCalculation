package product.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import product.domain.DateFormula;

@RunWith(Enclosed.class)
public class CalculationServiceTest {

	@RunWith(Parameterized.class)
	public static class ���t�v�Z {

		private String ���;
		private int �����N;
		private int ������;
		private int ������;
		private String ���Ғl;

		@Parameters(name = "{index} ���:{0}, �����N:{1}, ������:{2}, ������:{3}, ���Ғl:{4}")
		public static Object[][] params() {
			return new Object[][] {
				// ���ׂĖ��w��
				{"20181201", 0, 0, 0, "20181201"},
				// ���ׂĎw��
				{"20181201", 1, 1, 1, "20200102"},
				// ���̉��Z�œ����̐؂�̂�
				{"20181031", 0, 1, 0, "20181130"},
				// �N���܂���
				{"20181202", 0, 13, 0, "20200102"},
				{"20181202", 0, 0, 365, "20191202"},
				// ����
				{"20181201", 0, 0, 1, "20181202"},
				// �O��
				{"20181201", 0, 0, -1, "20181130"},
				// ����
				{"20181101", 0, 1, 0, "20181201"},
				// �O��
				{"20181201", 0, -1, 0, "20181101"},
				// ���N
				{"20181201", 1, 0, 0, "20191201"},
				// �O�N
				{"20181201", -1, 0, 0, "20171201"},
			};
		}

		public ���t�v�Z(String ���, int �����N, int ������, int ������, String ���Ғl) {
			this.��� = ���;
			this.�����N = �����N;
			this.������ = ������;
			this.������ = ������;
			this.���Ғl = ���Ғl;
		}

		@Test
		public void test() throws Exception {
			DateFormula formula = setUpFormula(�����N, ������, ������);

			CalculationService sut = new CalculationService();
			String actual = sut.calculate(���, formula);

			assertThat(actual).isEqualTo(���Ғl);
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
}
