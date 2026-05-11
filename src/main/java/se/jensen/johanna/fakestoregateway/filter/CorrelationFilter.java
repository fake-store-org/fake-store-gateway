package se.jensen.johanna.fakestoregateway.filter;

import java.util.UUID;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CorrelationFilter implements GlobalFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    String rawId = exchange.getRequest().getHeaders()
        .getFirst("X-Correlation-ID");
    final String correlationId = rawId != null ? rawId : UUID.randomUUID().toString();

    ServerWebExchange mutated = exchange.mutate()
        .request(r -> r.header("X-Correlation-ID", correlationId))
        .build();
    return chain.filter(mutated);
  }
}
