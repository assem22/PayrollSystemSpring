package kz.iitu.payrollSystemSpring.Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("SalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Changed salary info: " + salaryChangeEvent.getEmployee());
    }
}
