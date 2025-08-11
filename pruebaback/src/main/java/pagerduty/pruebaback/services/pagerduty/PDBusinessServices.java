package pagerduty.pruebaback.services.pagerduty;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pagerduty.pruebaback.dtos.CreateBusinessServiceRequest;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;
import pagerduty.pruebaback.dtos.ServiceResponse;
import pagerduty.pruebaback.dtos.ServicesResponse;
import reactor.core.publisher.Mono;

@Service
public class PDBusinessServices {

    private final String BASE_URL = "https://api.pagerduty.com/business_services";
    private final WebClient webClient = WebClient.create();

    public ServicesResponse getBusinessServices(){
        Mono<ServicesResponse> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicesResponse.class);


        return response.block();
    }

    public ServicesResponse createBusinessServices(CreateBusinessServiceRequest request){
        Mono<ServicesResponse> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicesResponse.class);


        return response.block();
    }

    public ServiceResponse getBusinessService(String id){

        String url = UriComponentsBuilder.fromUriString(BASE_URL).pathSegment(id).build().toUriString();

        Mono<ServiceResponse> response = webClient.get()
                .uri(url)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServiceResponse.class);


        return response.block();
    }

    public ServicePD deleteBusinessServices(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);

        return response.block();
    }
}
