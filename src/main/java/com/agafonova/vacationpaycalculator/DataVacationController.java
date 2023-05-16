package com.agafonova.vacationpaycalculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataVacationController {

    public double calculateHolidayPay(double salary, int days){
        double vacationPay = salary/29.3 *days;
        return vacationPay;
    }

    @GetMapping("/calculate")
    public String calculateForm(Model model) {
        model.addAttribute("calculate", new DataVacation());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String calculateSubmit(@ModelAttribute DataVacation calculate, Model model) {
        calculate.setVacationPay(calculateHolidayPay(calculate.getSalary(), calculate.getDays()));
        model.addAttribute("calculate", calculate);
        return "result";
    }

}