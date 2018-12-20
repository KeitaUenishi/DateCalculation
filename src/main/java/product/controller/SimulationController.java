package product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import product.domain.Result;
import product.domain.SimulationForm;
import product.service.CalculationService;

/**
 * ���t�v�Z�������V�~�����[�g�����ʂɕR�Â��R���g���[���[�ł��B
 * 
 * @author koujienami
 */
@Controller
@RequestMapping
public class SimulationController {

	/** ���t�v�Z�T�[�r�X */
	@Autowired
	private CalculationService service;

	/**
	 * �����\���������s���܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @return �\������e���v���[�g
	 */
	@GetMapping
	public String index(@ModelAttribute SimulationForm form) {
		return "simulation";
	}

	/**
	 * ���t�v�Z�������ɃV�~�����[�V�������ʂ��ꗗ�\�����܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @param model ���f��
	 * @return �\������e���v���[�g
	 */
	@PostMapping
	public String simulation(@ModelAttribute SimulationForm form, Model model) {
		SimulationForm resultForm = new SimulationForm(form.getBaseDate(), service.search());
		List<Result> results = resultForm.getResults();

		results.stream().forEach(e -> e.setCalculated(service.calculate(form.getBaseDate(), e.getFormula())));

		model.addAttribute("results", results);
		return "simulation";
	}

	/**
	 * �C�ӂ̓��t�v�Z�����폜���܂��B
	 * 
	 * @param form ��ʃt�H�[��
	 * @param model ���f��
	 * @return �\������e���v���[�g
	 */
	@PostMapping(value = "/{dateId}")
	public String delete(@PathVariable String dateId, Model model) {
		service.delete(dateId);
		return "simulation";
	}
}
