package org.example.camunda.process.solution.facade;

import io.camunda.zeebe.client.ZeebeClient;
import org.example.camunda.process.solution.dto.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/samplecrm")
public class SampleCrmController {

  private static final Logger LOG = LoggerFactory.getLogger(SampleCrmController.class);
  private final ZeebeClient zeebe;

  public SampleCrmController(ZeebeClient zeebe) {
    this.zeebe = zeebe;
  }

  @PostMapping("/updateOrder")
  public void updateOrder(@RequestBody OrderDetail orderDetail) {
    LOG.info("Updating order details to CRM for orderId - {}", orderDetail.getOrderId());
    var messageName = "Message_receive_crm_ack";
    var correlationKey = orderDetail.getOrderId();
    new Thread(
            new Runnable() {

              @Override
              public void run() {
                try {
                  LOG.info("Mimic system processing for 30 sec");

                  Thread.sleep(30000);

                  LOG.info(
                      "Publishing message `{}` with correlation key `{}`",
                      messageName,
                      correlationKey);

                  zeebe
                      .newPublishMessageCommand()
                      .messageName(messageName)
                      .correlationKey(correlationKey)
                      .send();
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
              }
            })
        .start();
  }
}
