package com.usst.ten.sc;

import com.usst.ten.sc.graphql.GraphQLErrorAdapter;
import com.usst.ten.sc.graphql.Mutation;
import com.usst.ten.sc.graphql.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@ComponentScan({"com.usst.ten.sc.entity", "com.usst.ten.sc.repository",
        "com.usst.ten.sc.graphql", "com.usst.ten.sc.controller"})
public class ScApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScApplication.class, args);
    }

    @Bean
    public Query query() {
        return null;
    }

    @Bean
    public Mutation mutation() {
        return null;
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }
}
