package product.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import product.domain.DateFormula;

@RunWith(SpringRunner.class)
@MybatisTest
@TestPropertySource(locations = "classpath:test.properties")
public class DateFormulaRepositoryTest {

	@Autowired
	private DateFormulaRepository sut;

	@Test
	public void ����_�S�����Č��ʂ����X�g�Ŏ擾�o���鎖() throws Exception {
		List<DateFormula> actual = sut.select();

		assertThat(actual.size()).isEqualTo(2);
	}

	@Test
	public void ����_1�����Č��ʂ��L�[�ɕR�Â�1�������擾�o���鎖() throws Exception {
		DateFormula actual = sut.selectPK("Y01");

		assertThat(actual.getDateId()).isEqualTo("Y01");
		assertThat(actual.getDateName()).isEqualTo("���N");
		assertThat(actual.getAdjustmentYear()).isEqualTo(1);
		assertThat(actual.getAdjustmentMonth()).isEqualTo(0);
		assertThat(actual.getAdjustmentDay()).isEqualTo(0);
	}

	@Test
	public void ���݂��Ȃ��f�[�^����������ƌ��ʂ�NULL�ƂȂ鎖() throws Exception {
		DateFormula actual = sut.selectPK("EmptyData");

		// TODO:�T�[�r�X���ŏC�����ANull��Ԃ��Ȃ��悤�ɂ���ׂ��B
		assertThat(actual).isNull();
	}

	@Test
	public void NULL�Ō�������ƌ��ʂ�NULL�ƂȂ鎖() throws Exception {
		DateFormula actual = sut.selectPK(null);

		// TODO:�T�[�r�X���ŏC�����ANull��Ԃ��Ȃ��悤�ɂ���ׂ��B
		assertThat(actual).isNull();
	}

	@Test
	public void �V�K�o�^���o���鎖() throws Exception {
		DateFormula formula = createFormula("D01", "����", 0, 0, 1);

		sut.insert(formula);
		DateFormula actual = sut.selectPK("D01");

		assertThat(actual.getDateId()).isEqualTo("D01");
	}

	@Test
	public void �L�[�ɕR�Â�1���̍X�V���o���鎖() throws Exception {
		DateFormula formula = createFormula("Y01", "���X�N", 2, 0, 0);

		sut.update(formula);
		DateFormula actual = sut.selectPK("Y01");

		assertThat(actual.getDateId()).isEqualTo("Y01");
		assertThat(actual.getDateName()).isEqualTo("���X�N");
		assertThat(actual.getAdjustmentYear()).isEqualTo(2);
		assertThat(actual.getAdjustmentMonth()).isEqualTo(0);
		assertThat(actual.getAdjustmentDay()).isEqualTo(0);
	}

	@Test
	public void �L�[�ɕR�Â�1���̍폜���o���鎖() throws Exception {
		sut.deletePK("Y01");
		List<DateFormula> actual = sut.select();

		assertThat(actual.size()).isEqualTo(1);
	}

	@Test
	public void ���ɑ��݂���L�[�œo�^���悤�Ƃ����DuplicateKeyException�ƂȂ鎖() throws Exception {
		DateFormula formula = createFormula("Y01", "���X�N", 2, 0, 0);

		assertThatThrownBy(() -> {
			sut.insert(formula);
		}).isInstanceOf(DuplicateKeyException.class);
	}

	@Test
	public void NULL�œo�^���悤�Ƃ����DataIntegrityViolationException�ƂȂ鎖() throws Exception {
		assertThatThrownBy(() -> {
			sut.insert(null);
		}).isInstanceOf(DataIntegrityViolationException.class);
	}

	private DateFormula createFormula(String ���tID, String ���t��, int �����N, int ������, int ������) {
		DateFormula formula = new DateFormula();
		formula.setDateId(���tID);
		formula.setDateName(���t��);
		formula.setAdjustmentYear(�����N);
		formula.setAdjustmentMonth(������);
		formula.setAdjustmentDay(������);
		return formula;
	}
}
