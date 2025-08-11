package pagerduty.pruebaback.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pagerduty.pruebaback.services.UserService;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtSecurityConfig jwtSecurityConfig;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String path = request.getServletPath();

        if(path.startsWith("/api/v1 ")){
            filterChain.doFilter(request, response);
            return;
        }


        String token = jwtSecurityConfig.getTokenRequest(request);

        if(token == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token not found");
            return;
        }

        if(!jwtSecurityConfig.verifyToken(token)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Expired or invalid Token");
            return;
        }


        String email = jwtSecurityConfig.getSubject(token);
        var userFound = userService.findUserByEmail(email);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userFound, null);

        authenticationToken.setDetails(new WebAuthenticationDetails(request));


        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        filterChain.doFilter(request, response);

    }
}
