package com.britel.api.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

  /**
   * Register the application view controllers.
   */
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("Login");
    registry.addViewController("/devices").setViewName("DevicesManagement");
    registry.addViewController("/company_mac_consumption").setViewName("CompanyMacConsumption");
    registry.addViewController("/global_company_consumption").setViewName("GlobalCompanyConsumption");
    registry.addViewController("/global_consumption").setViewName("GlobalConsumption");
    registry.addViewController("/accounts").setViewName("SubscriberAccountsManagement");
  }

}
