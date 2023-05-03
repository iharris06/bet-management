package com.zonabets.betmanagement.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zonabets.betmanagement.exception.EntityNotFoundException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (EntityNotFoundException e) {
            setResponse(response, "User does not exist", HttpServletResponse.SC_NOT_FOUND);
        } catch (JWTVerificationException e) {
            setResponse(response, "JWT NOT VALID", HttpServletResponse.SC_FORBIDDEN);
        } catch (RuntimeException e) {
            setResponse(response, "BAD REQUEST", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void setResponse(HttpServletResponse response, String message, int status) throws IOException {
        response.setStatus(status);
        response.getWriter().write(message);
        response.getWriter().flush();
    }

}
