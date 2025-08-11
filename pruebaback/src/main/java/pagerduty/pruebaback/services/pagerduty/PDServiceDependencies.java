package pagerduty.pruebaback.services.pagerduty;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;
import pagerduty.pruebaback.dtos.ServiceResponse;
import pagerduty.pruebaback.dtos.ServicesResponse;
import reactor.core.publisher.Mono;

public class PDServiceDependencies {

    private final String BASE_URL = "https://api.pagerduty.com/business_services";
    private final WebClient webClient = WebClient.create();

    public ServicesResponse getTeams(){
        Mono<ServicesResponse> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicesResponse.class);


        return response.block();
    }

    public ServicePD createTeam(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);


        return response.block();
    }

    public ServiceResponse getTeam(String id){

        String url = UriComponentsBuilder.fromUriString(BASE_URL).pathSegment(id).build().toUriString();

        Mono<ServiceResponse> response = webClient.get()
                .uri(url)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServiceResponse.class);


        return response.block();
    }

    public ServicePD deleteTeam(){
        Mono<ServicePD> response = webClient.get()
                .uri(BASE_URL)
                .header("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu")
                .retrieve()
                .bodyToMono(ServicePD.class);

        return response.block();
    }
}
