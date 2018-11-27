package product.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import product.domain.DateFormula;
import product.mapper.DateFormulaRepository;

/**
 * ���t�v�Z�Ɋւ�鏈�����s���T�[�r�X�ł��B
 * 
 * @author koujienami
 */
@Service
public class CalculationService {

	/** ���t�v�Z�����|�W�g�� */
	@Autowired
	private DateFormulaRepository repository;

	/**
	 * ���t�v�Z���̈ꗗ��S���������Ď擾���܂��B
	 * 
	 * @return ���t�v�Z���̑S��
	 */
	public List<DateFormula> search() {
		return repository.select();
	}

	/**
	 * ���t�v�Z����o�^���܂��B
	 * 
	 * @param formula �o�^������t�v�Z��
	 */
	@Transactional
	public void register(DateFormula formula) {
		repository.insert(formula);
	}

	/**
	 * ���t�v�Z���s���܂��B<br/>
	 * �v�Z������x�[�X�ɁA���t�v�Z���̉����l�Ɋ�Â��Čv�Z���s���܂��B<br/>
	 * �v�Z��̏����́uyyyyMMdd�v�̕�����ƂȂ�܂��B
	 * 
	 * @param baseDate �v�Z���
	 * @param formula ���t�v�Z��
	 * @return �v�Z����
	 */
	public String calculate(String baseDate, DateFormula formula) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate =
			date.plusYears(formula.getAdjustmentYear()).plusMonths(formula.getAdjustmentMonth()).plusDays(formula.getAdjustmentDay());
		return calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
}
