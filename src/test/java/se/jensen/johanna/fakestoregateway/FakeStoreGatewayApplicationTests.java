package se.jensen.johanna.fakestoregateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.cloud.aws.region.static=eu-north-1")
class FakeStoreGatewayApplicationTests {

  @Test
  void contextLoads() {
  }

}
