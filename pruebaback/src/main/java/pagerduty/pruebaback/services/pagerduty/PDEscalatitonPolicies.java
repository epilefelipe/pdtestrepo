package pagerduty.pruebaback.services.pagerduty;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pagerduty.pruebaback.dtos.ServiceResponse;
import pagerduty.pruebaback.dtos.ServicesResponse;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;
import reactor.core.publisher.Mono;

public class PDEscalatitonPolicies {

    private final String BASE_URL = "https://api.pagerduty.com/escalation_policies";
    private final WebClient webClient = WebClient.create();

    public ServicesResponse getEscalationPolicies(){
        Mono<ServicesResponse> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicesResponse.class);


        return response.block();
    }

    public ServicePD createEscalationPolicy(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);


        return response.block();
    }

    public ServiceResponse getEscalationPolicy(String id){

        String url = UriComponentsBuilder.fromUriString(BASE_URL).pathSegment(id).build().toUriString();

        Mono<ServiceResponse> response = webClient.get()
                .uri(url)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServiceResponse.class);


        return response.block();
    }

    public ServicePD deleteEscalationPolicy(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL
                )
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);

        return response.block();
    }
}
