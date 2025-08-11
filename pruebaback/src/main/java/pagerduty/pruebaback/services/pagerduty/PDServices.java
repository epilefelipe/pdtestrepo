package pagerduty.pruebaback.services.pagerduty;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pagerduty.pruebaback.dtos.CreateServiceRequest;
import pagerduty.pruebaback.dtos.CreateServiceResponse;
import pagerduty.pruebaback.dtos.ServiceResponse;
import pagerduty.pruebaback.dtos.ServicesResponse;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;
import reactor.core.publisher.Mono;

@Service
public class PDServices {

    private final String BASE_URL = "https://api.pagerduty.com/services";
    private final WebClient webClient = WebClient.create();

    public ServicesResponse getServices(){
        Mono<ServicesResponse> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicesResponse.class);


        return response.block();
    }

    public CreateServiceResponse createService(CreateServiceRequest  request){
        Mono<CreateServiceResponse> response = webClient.post()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(Mono.just(request), CreateServiceResponse.class)
                .retrieve()
                .bodyToMono(CreateServiceResponse.class);


        return response.block();
    }

    public ServiceResponse getService(String id){

        String url = UriComponentsBuilder.fromUriString(BASE_URL).pathSegment(id).build().toUriString();

        Mono<ServiceResponse> response = webClient.get()
                .uri(url)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServiceResponse.class);


        return response.block();
    }

    public ServicePD deleteService(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);

        return response.block();
    }



}
