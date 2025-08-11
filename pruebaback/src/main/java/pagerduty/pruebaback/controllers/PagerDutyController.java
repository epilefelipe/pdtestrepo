package pagerduty.pruebaback.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pagerduty.pruebaback.dtos.*;
import pagerduty.pruebaback.services.pagerduty.PDBusinessServices;
import pagerduty.pruebaback.services.pagerduty.PDServices;

@RestController
@RequestMapping("/api/v1/pd")
@RequiredArgsConstructor
public class PagerDutyController {

    private final PDServices pdServices;
    private final PDBusinessServices pdBusinessServices;

    @GetMapping("/services")
    public ServicesResponse getAllServices(){
        return pdServices.getServices();
    }

    @GetMapping("/services/{id}")
    public ServiceResponse getService(@PathVariable String id){
        return pdServices.getService(id);
    }

    @PostMapping("/services")
    public CreateServiceResponse createService(@RequestBody @Valid CreateServiceRequest request){
        return pdServices.createService(request);
    }

    @GetMapping("/business_services")
    public ServicesResponse getAllBusinessServices(){
        return pdBusinessServices.getBusinessServices();
    }

    @GetMapping("/business_services/{id}")
    public ServiceResponse getBusinessService(@PathVariable String id){
        return pdBusinessServices.getBusinessService(id);
    }

    @PostMapping("/business_services")
    public ServicesResponse createBusinessService(@RequestBody @Valid CreateBusinessServiceRequest request){
        return pdBusinessServices.createBusinessServices(request);
    }

    @GetMapping("/service_dependencies")
    public ServicesResponse getAllServiceDependencies(){
        return pdServices.getServices();
    }

    @GetMapping("/service_dependencies/{id}")
    public ServiceResponse getServiceDependency(@PathVariable String id){
        return pdServices.getService(id);
    }

    @PostMapping("/service_dependencies")
    public CreateServiceResponse createServiceDependency(@RequestBody @Valid CreateServiceRequest request){
        return pdServices.createService(request);
    }

    @GetMapping("/escalation_policies")
    public ServicesResponse getAllEscalationPolicies(){
        return pdServices.getServices();
    }

    @GetMapping("/escalation_policies/{id}")
    public ServiceResponse getEscalationPolicy(@PathVariable String id){
        return pdServices.getService(id);
    }

    @PostMapping("/escalation_policies")
    public CreateServiceResponse createEscalationPolicy(@RequestBody @Valid CreateServiceRequest request){
        return pdServices.createService(request);
    }

    @GetMapping("/users")
    public ServicesResponse getAllUsers(){
        return pdServices.getServices();
    }

    @GetMapping("/users/{id}")
    public ServiceResponse getUser(@PathVariable String id){
        return pdServices.getService(id);
    }

    @PostMapping("/users")
    public CreateServiceResponse createUser(@RequestBody @Valid CreateServiceRequest request){
        return pdServices.createService(request);
    }
}
