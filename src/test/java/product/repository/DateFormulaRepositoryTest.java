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
	public void 検索_全件して結果をリストで取得出来る事() throws Exception {
		List<DateFormula> actual = sut.select();

		assertThat(actual.size()).isEqualTo(2);
	}

	@Test
	public void 検索_1件して結果がキーに紐づく1件だけ取得出来る事() throws Exception {
		DateFormula actual = sut.selectPK("Y01");

		assertThat(actual.getDateId()).isEqualTo("Y01");
		assertThat(actual.getDateName()).isEqualTo("翌年");
		assertThat(actual.getAdjustmentYear()).isEqualTo(1);
		assertThat(actual.getAdjustmentMonth()).isEqualTo(0);
		assertThat(actual.getAdjustmentDay()).isEqualTo(0);
	}

	@Test
	public void 存在しないデータを検索すると結果がNULLとなる事() throws Exception {
		DateFormula actual = sut.selectPK("EmptyData");

		// TODO:サービス側で修正し、Nullを返さないようにするべき。
		assertThat(actual).isNull();
	}

	@Test
	public void NULLで検索すると結果がNULLとなる事() throws Exception {
		DateFormula actual = sut.selectPK(null);

		// TODO:サービス側で修正し、Nullを返さないようにするべき。
		assertThat(actual).isNull();
	}

	@Test
	public void 新規登録が出来る事() throws Exception {
		DateFormula formula = createFormula("D01", "翌日", 0, 0, 1);

		sut.insert(formula);
		DateFormula actual = sut.selectPK("D01");

		assertThat(actual.getDateId()).isEqualTo("D01");
	}

	@Test
	public void キーに紐づく1件の更新が出来る事() throws Exception {
		DateFormula formula = createFormula("Y01", "翌々年", 2, 0, 0);

		sut.update(formula);
		DateFormula actual = sut.selectPK("Y01");

		assertThat(actual.getDateId()).isEqualTo("Y01");
		assertThat(actual.getDateName()).isEqualTo("翌々年");
		assertThat(actual.getAdjustmentYear()).isEqualTo(2);
		assertThat(actual.getAdjustmentMonth()).isEqualTo(0);
		assertThat(actual.getAdjustmentDay()).isEqualTo(0);
	}

	@Test
	public void キーに紐づく1件の削除が出来る事() throws Exception {
		sut.deletePK("Y01");
		List<DateFormula> actual = sut.select();

		assertThat(actual.size()).isEqualTo(1);
	}

	@Test
	public void 既に存在するキーで登録しようとするとDuplicateKeyExceptionとなる事() throws Exception {
		DateFormula formula = createFormula("Y01", "翌々年", 2, 0, 0);

		assertThatThrownBy(() -> {
			sut.insert(formula);
		}).isInstanceOf(DuplicateKeyException.class);
	}

	@Test
	public void NULLで登録しようとするとDataIntegrityViolationExceptionとなる事() throws Exception {
		assertThatThrownBy(() -> {
			sut.insert(null);
		}).isInstanceOf(DataIntegrityViolationException.class);
	}

	private DateFormula createFormula(String 日付ID, String 日付名, int 加減年, int 加減月, int 加減日) {
		DateFormula formula = new DateFormula();
		formula.setDateId(日付ID);
		formula.setDateName(日付名);
		formula.setAdjustmentYear(加減年);
		formula.setAdjustmentMonth(加減月);
		formula.setAdjustmentDay(加減日);
		return formula;
	}
}
